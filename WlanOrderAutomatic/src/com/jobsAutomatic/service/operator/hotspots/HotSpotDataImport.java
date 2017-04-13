package com.jobsAutomatic.service.operator.hotspots;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.jobsAutomatic.service.modle.HotspotImportDto;
import com.jobsAutomatic.service.modle.Ssid;
import com.jobsAutomatic.service.modle.SubCoverType;
import com.jobsAutomatic.service.modle.UpdateSql;
import com.jobsAutomatic.service.modle.Vendor;
import com.jobsAutomatic.service.modle.old.AC;
import com.jobsAutomatic.service.modle.old.Hotspot;
import com.jobsAutomatic.service.modle.old.HotspotIpAlloc;
import com.jobsAutomatic.service.modle.old.HotspotVlan;
import com.jobsAutomatic.service.modle.old.ImpVendor;
import com.jobsAutomatic.service.modle.old.Interface;
import com.jobsAutomatic.service.modle.old.PrimaryHotspot;
import com.jobsAutomatic.service.modle.old.SSID;
import com.jobsAutomatic.service.modle.old.WlanWorkOrder;
import com.jobsAutomatic.service.modle.old.coverType;
import com.jobsAutomatic.service.operator.DBOperator;
import com.jobsAutomatic.service.readExcle.ImportMsg;
import com.jobsAutomatic.service.util.IdUtils;
import com.jobsAutomatic.service.util.Util;



/*
 * 热点信息现网校验和入库
 */
public class HotSpotDataImport extends DBOperator {

	public ImportMsg saveImportData(List<HotspotImportDto> list, ImportMsg importMsg) {
		String sql = "";
		Util util;
		List<UpdateSql> listu;
		for (HotspotImportDto dto : list) {// 遍历链表中的热点
			// 根据vip级别添加热点名称后缀
			String hotspotName = dto.getHotspotName();
			String vip = "";
			if (null != dto.getVip())
				vip = dto.getVip().toString();
			String vipName = "";
			if ("2".equals(vip)) {
				vipName = "(VIP)";
			} else if ("3".equals(vip)) {
				vipName = "(VVIP)";
			}
			hotspotName += vipName;
			hotspotName = hotspotName.replaceAll("\\(VIP\\)", vipName).replaceAll("\\(VVIP\\)", vipName)
					.replaceAll("(\\(VVIP\\))+", vipName).replaceAll("(\\(VIP\\))+", vipName);
			dto.setHotspotName(hotspotName);

			boolean isUpdate = false;
			// 判断热点是否存在，若存在则更新热点信息，若不存在则新建插入
			RowMapper<Hotspot> rowMapper = new BeanPropertyRowMapper<Hotspot>(Hotspot.class);
			Hotspot hotspot;
			System.out.println("dto.getNasId()"+dto.getNasId());
			try {
				hotspot = jdbcTemplate.queryForObject("select * from prm_wlan_hotspot where NAS_ID =?", rowMapper,
						dto.getNasId());
				isUpdate = true;
				System.out.println("热点已经存在，将执行更新操作");
			} catch (EmptyResultDataAccessException eh) {
				hotspot = new Hotspot();
				hotspot.setHOTSPOT_ID(IdUtils.GeneratorUUID());
				System.out.println("热点不存在，将执行插入操作");
			}
			System.out.println("获取hotspot完成");

			// 判断覆盖类型是否存在
			if (StringUtils.isNotBlank(dto.getCoverType()) && StringUtils.isNotBlank(dto.getSubCoverType())) {
				RowMapper<SubCoverType> subCoverType = new BeanPropertyRowMapper<SubCoverType>(SubCoverType.class);
				SubCoverType sct;
				try {
					sct = jdbcTemplate.queryForObject(
							"SELECT T1.* FROM RM_COVERAGE_SUB_TYPE T1,RM_COVERAGE_TYPE T2 WHERE T1.PARENT_COVER_TYPE = T2.UUID AND T1.NAME = ? AND T2.NAME = ?",
							subCoverType, dto.getSubCoverType(), dto.getCoverType());
					System.out.println("覆盖类型不为空");
					hotspot.setSubCoverType(sct);
					hotspot.setCoverType(new coverType(sct.getParentType()));
				} catch (EmptyResultDataAccessException e) {
					sct = null;
					System.out.println("覆盖类型在数据字典中未找到");
					importMsg.appendMessage(getFailureMsg("覆盖类型没有在数据字典中找到", dto.getRow()));
					importMsg.countFail();
					continue;
				}
			}

			// 判断设备厂商是否存在
			if (StringUtils.isNotBlank(dto.getVendor())) {
				RowMapper<Vendor> vendorType = new BeanPropertyRowMapper<Vendor>(Vendor.class);
				Vendor vendor;
				try {
					vendor = jdbcTemplate.queryForObject("select * from res.RM_VENDOR where NAME_CN =?", vendorType,
							dto.getVendor());
					System.out.println("设备厂商存在");
					hotspot.setVendor(vendor);
				} catch (EmptyResultDataAccessException e) {
					if (!isUpdate) {
						System.out.println("设备厂商没有在数据字典中找到");
						importMsg.appendMessage(getFailureMsg("设备厂商没有在数据字典中找到", dto.getRow()));
						importMsg.countFail();
						continue;
					}
				}
			}

			// 判断代为厂商是否存在
			if (StringUtils.isNotBlank(dto.getImpVendor())) {
				RowMapper<ImpVendor> impVendorType = new BeanPropertyRowMapper<ImpVendor>(ImpVendor.class);
				ImpVendor impVendor;
				try {
					if (StringUtils.isNotBlank(dto.getCity())) {
						impVendor = jdbcTemplate.queryForObject(
								"SELECT * FROM RM_IMP_VENDOR where NAME= ? AND APANAGE = ?", impVendorType,
								dto.getImpVendor(), dto.getCity());
					} else {
						impVendor = jdbcTemplate.queryForObject("SELECT * FROM RM_IMP_VENDOR where NAME= ?",
								impVendorType, dto.getImpVendor());
					}
					hotspot.setImpVendor(impVendor);
					System.out.println("代维厂商存在");
				} catch (EmptyResultDataAccessException e) {
					System.out.println("代维厂商没有在数据字典中找到");
					importMsg.appendMessage(getFailureMsg("代维厂商没有在数据字典中找到", dto.getRow()));
					importMsg.countFail();
					continue;
				}
			}

			// 判断集成厂商是否存在
			if (StringUtils.isNotBlank(dto.getMaintVendor())) {
				RowMapper<ImpVendor> impVendorType = new BeanPropertyRowMapper<ImpVendor>(ImpVendor.class);
				ImpVendor impVendor;
				try {
					if (StringUtils.isNotBlank(dto.getCity())) {
						impVendor = jdbcTemplate.queryForObject(
								"SELECT * FROM RM_IMP_VENDOR where NAME= ? AND APANAGE = ?", impVendorType,
								dto.getMaintVendor(), dto.getCity());
					} else {
						impVendor = jdbcTemplate.queryForObject("SELECT * FROM RM_IMP_VENDOR where NAME= ?",
								impVendorType, dto.getMaintVendor());
					}
					System.out.println("集成厂商存在");
					hotspot.setMaintVendor(impVendor);
				} catch (EmptyResultDataAccessException e) {
					System.out.println("集成厂商没有在数据字典中找到");
					importMsg.appendMessage(getFailureMsg("集成厂商没有在数据字典中找到", dto.getRow()));
					importMsg.countFail();
					continue;
				}
			}

			// 判断逻辑热点是否存在
			if (StringUtils.isNotBlank(dto.getPrimaryHotspotName())) {
				RowMapper<PrimaryHotspot> phType = new BeanPropertyRowMapper<PrimaryHotspot>(PrimaryHotspot.class);
				PrimaryHotspot ph;
				try {
					if (StringUtils.isNotBlank(dto.getDistrict())) {
						ph = jdbcTemplate.queryForObject(
								"SELECT * FROM PRM_WLAN_PRIMARY_HOTSPOT where HOTSPOT_NAME = ? and DISTRICT = ?",
								phType, dto.getPrimaryHotspotName(), dto.getDistrict());
					} else {
						ph = jdbcTemplate.queryForObject(
								"SELECT * FROM PRM_WLAN_PRIMARY_HOTSPOT where HOTSPOT_NAME = ?", phType,
								dto.getPrimaryHotspotName());
					}
					System.out.println("逻辑热点存在");
				} catch (EmptyResultDataAccessException e) {
					System.out.println("逻辑热点不存在");
					ph = new PrimaryHotspot();
					ph.setHotspotId(IdUtils.GeneratorUUID());
					ph.setDistrict(dto.getDistrict());
					ph.setHotspotName(dto.getPrimaryHotspotName());
					jdbcTemplate.update(
							"insert into RES.PRM_WLAN_PRIMARY_HOTSPOT (HOTSPOT_ID, HOTSPOT_NAME, DISTRICT) values (?,?,?)",
							ph.getHotspotId(), dto.getPrimaryHotspotName(), dto.getDistrict());
				}
				hotspot.setPrimaryHotspot(ph);
			}

			// 判断热点名称是否以" "开头？
			if (null != dto.getHotspotName() && dto.getHotspotName().startsWith("null")) {
				hotspotName = hotspot.getHOTSPOT_NAME() + vipName;
				hotspotName = hotspotName.replaceAll("\\(VIP\\)", vipName).replaceAll("\\(VVIP\\)", vipName)
						.replaceAll("(\\(VVIP\\))+", vipName).replaceAll("(\\(VIP\\))+", vipName);
				hotspot.setHOTSPOT_NAME(hotspotName);
			} else
				hotspot.setHOTSPOT_NAME(dto.getHotspotName());

			// hotSpot模板注入
			hotspot.setNAS_ID(dto.getNasId());
			hotspot.setCity(dto.getCity());
			hotspot.setDistrict(dto.getDistrict());
			hotspot.setLocation(dto.getLocation());
			hotspot.setVip(dto.getVip());
			hotspot.setSwitchNumber(dto.getSwitchNumber());
			hotspot.setApNumber(dto.getApNumber());
			hotspot.setLatitude(dto.getLatitude());
			hotspot.setLongtitude(dto.getLongtitude());
			hotspot.setBandwith(dto.getBandwith());
			hotspot.setTransType(dto.getTransType());
			hotspot.setRing(dto.getRing());
			hotspot.setTransCardLoc(dto.getTransCardLoc());
			hotspot.setDf(dto.getDf());
			hotspot.setCoverageScope(dto.getCoverageScope());
			hotspot.setCombineMode(dto.getCombineMode());
			hotspot.setCoverageMode(dto.getCoverageMode());
			hotspot.setRemark(dto.getRemark());
			hotspot.setLandMarks(dto.getLandMarks());
			hotspot.setCeLlid(dto.getCeLlid());
			hotspot.setLaCid(dto.getLaCid());
			hotspot.setHotspotLevel(dto.getHotspotLevel());
			hotspot.setWlanServiceType(dto.getWlanServiceType());
			hotspot.setProjectNum(dto.getProjectNum());
			hotspot.setCooService(dto.getCooService());
			hotspot.setProjectCompleteDate(dto.getProjectCompleteDate());
			hotspot.setProjectAcceptDate(dto.getProjectAcceptDate());
			hotspot.setProjectApplyDate(dto.getProjectApplyDate());
			hotspot.setIsVi(dto.getIsVi());

			// 不是更新的话，插入操作者
			if (!isUpdate) {
				hotspot.setEntryStaff(dto.getEntryStaff());
			}

			// 导入数据库
			String ImpVendorUuid;
			String MaintVendorUuid;
			try {
				ImpVendorUuid = hotspot.getImpVendor().getUuid();
			} catch (NullPointerException e) {
				ImpVendorUuid = null;
			}
			try {
				MaintVendorUuid = hotspot.getMaintVendor().getUuid();
			} catch (NullPointerException e) {
				MaintVendorUuid = null;
			}
			try {
				if (!isUpdate) {
					if (StringUtils.isBlank(hotspot.getHOTSPOT_NAME())) {
						importMsg.appendMessage(getFailureMsg("热点名称为空", dto.getRow()));
						importMsg.countFail();
						continue;
					} else {
						try {
							jdbcTemplate.update(
									"insert into RES.PRM_WLAN_HOTSPOT (HOTSPOT_ID,PRIMARY_HOTSPOT_ID,HOTSPOT_TYPE,HOTSPOT_NAME,NAS_ID,LOCATION,PROVINCE,CITY,DISTRICT,SWITCH_NUMBER,IS_VIP,LONGTITUDE,LATITUDE,PROJECT_NO,IMP_VENDOR,TRANS_TYPE,TRANS_CARD_LOC,DF,RING,MAINT_VENDOR,COVERAGE_TYPE,COVERAGE_SUB_TYPE,COVERAGE_SCOPE,AP_NUMBER,REMARK,BANDWITH,COVERAGE_MODE,COMBINE_MODE,ENTRY_DATE,ENTRY_STAFF,AUDITOR,AUDIT_STATUS,DEVICE_VENDOR,LANDMARKS,CELL_ID,LAC_ID,HP_THICK_TYPE,WLAN_SERVICE_TYPE,PROJECT_NUM,IS_COO_SERVICE,PROJECT_COMPLETE_DATE,PROJECT_ACCEPT_DATE,PROJECT_APPLY_DATE,IS_VI)values(?,?,?,?,?,?,'上海',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,0,?,?,?,?,?,?,?,?,to_date(?,'SYYYY-MM-DD HH24:MI:SS'),to_date(?,'SYYYY-MM-DD HH24:MI:SS'),to_date(?,'SYYYY-MM-DD HH24:MI:SS'),?)",
									hotspot.getHOTSPOT_ID(), hotspot.getPrimaryHotspot().getHotspotId(),
									hotspot.getHotspotType(), hotspot.getHOTSPOT_NAME(), hotspot.getNAS_ID(),
									hotspot.getLocation(), hotspot.getCity(), hotspot.getDistrict(),
									hotspot.getSwitchNumber(), hotspot.getIsVip(), hotspot.getLongtitude(),
									hotspot.getLatitude(), hotspot.getProjectNo(), ImpVendorUuid,
									hotspot.getTransType(), hotspot.getTransCardLoc(), hotspot.getDf(),
									hotspot.getRing(), MaintVendorUuid, hotspot.getCoverType().getID(),
									hotspot.getSubCoverType().getId(), hotspot.getCoverageScope(),
									hotspot.getApNumber(), hotspot.getRemark(), hotspot.getBandwith(),
									hotspot.getCoverageMode(), hotspot.getCombineMode(), hotspot.getEntryStaff(),
									hotspot.getAuditor(), hotspot.getVendor().getName(), hotspot.getLandMarks(),
									hotspot.getCeLlid(), hotspot.getLaCid(), hotspot.getHotspotLevel(),
									hotspot.getWlanServiceType(), hotspot.getProjectNum(), hotspot.getCooService(),
									hotspot.getProjectCompleteDate(), hotspot.getProjectAcceptDate(),
									hotspot.getProjectApplyDate(), hotspot.getIsVi());
							System.out.println("插入数据库成功");
						} catch (Exception e) {
							System.out.println("热点入库异常：" + e);
							System.out.println(hotspot.getHOTSPOT_ID() + ","
									+ hotspot.getPrimaryHotspot().getHotspotId() + "," + hotspot.getHotspotType() + ","
									+ hotspot.getHOTSPOT_NAME() + "," + hotspot.getNAS_ID() + ","
									+ hotspot.getLocation() + "," + hotspot.getCity() + "," + hotspot.getDistrict()
									+ "," + hotspot.getSwitchNumber() + "," + hotspot.getIsVip() + ","
									+ hotspot.getLongtitude() + "," + hotspot.getLatitude() + ","
									+ hotspot.getProjectNo() + "," + ImpVendorUuid + "," + hotspot.getTransType() + ","
									+ hotspot.getTransCardLoc() + "," + hotspot.getDf() + "," + hotspot.getRing() + ","
									+ MaintVendorUuid + "," + hotspot.getCoverType().getID() + ","
									+ hotspot.getSubCoverType().getId() + "," + hotspot.getCoverageScope() + ","
									+ hotspot.getApNumber() + "," + hotspot.getRemark() + "," + hotspot.getBandwith()
									+ "," + hotspot.getCoverageMode() + "," + hotspot.getCombineMode() + ","
									+ hotspot.getEntryStaff() + "," + hotspot.getAuditor() + ","
									+ hotspot.getVendor().getName() + "," + hotspot.getLandMarks() + ","
									+ hotspot.getCeLlid() + "," + hotspot.getLaCid() + "," + hotspot.getHotspotLevel()
									+ "," + hotspot.getWlanServiceType() + "," + hotspot.getProjectNum() + ","
									+ hotspot.getCooService() + "," + hotspot.getProjectCompleteDate() + ","
									+ hotspot.getProjectAcceptDate() + "," + hotspot.getProjectApplyDate() + ","
									+ hotspot.getIsVi());
							e.printStackTrace();
						}
						// System.out.println(hotspot.getHOTSPOT_ID()+","+hotspot.getPrimaryHotspot().getHotspotId()+","+hotspot.getHotspotType()+","+hotspot.getHOTSPOT_NAME()+","+hotspot.getNAS_ID()+","+hotspot.getLocation()+","+hotspot.getCity()+","+hotspot.getDistrict()+","+hotspot.getSwitchNumber()+","+hotspot.getIsVip()+","+hotspot.getLongtitude()+","+hotspot.getLatitude()+","+hotspot.getProjectNo()+","+ImpVendorUuid+","+hotspot.getTransType()+","+hotspot.getTransCardLoc()+","+hotspot.getDf()+","+hotspot.getRing()+","+MaintVendorUuid+","+hotspot.getCoverType().getID()+","+hotspot.getSubCoverType().getId()+","+hotspot.getCoverageScope()+","+hotspot.getApNumber()+","+hotspot.getRemark()+","+hotspot.getBandwith()+","+hotspot.getCoverageMode()+","+hotspot.getCombineMode()+","+hotspot.getEntryStaff()+","+hotspot.getAuditor()+","+hotspot.getVendor().getName()+","+hotspot.getLandMarks()+","+hotspot.getCeLlid()+","+hotspot.getLaCid()+","+hotspot.getHotspotLevel()+","+hotspot.getWlanServiceType()+","+hotspot.getProjectNum()+","+hotspot.getCooService()+","+hotspot.getProjectCompleteDate()+","+hotspot.getProjectAcceptDate()+","+hotspot.getProjectApplyDate()+","+hotspot.getIsVi());
					}
				} else if (StringUtils.isNotBlank(dto.getNasId())) {
					sql = "update RES.PRM_WLAN_HOTSPOT set ";
					util = new Util();
					listu = new ArrayList<UpdateSql>();
					listu.add(util.getUpdateSql("PRIMARY_HOTSPOT_ID", hotspot.getPrimaryHotspot().getHotspotId(),
							"VARCHAR"));
					listu.add(util.getUpdateSql("HOTSPOT_TYPE", hotspot.getHotspotType(), "VARCHAR"));
					listu.add(util.getUpdateSql("HOTSPOT_NAME", hotspot.getHOTSPOT_NAME(), "VARCHAR"));
					listu.add(util.getUpdateSql("NAS_ID", hotspot.getNAS_ID(), "VARCHAR"));
					listu.add(util.getUpdateSql("LOCATION", hotspot.getLocation(), "VARCHAR"));
					listu.add(util.getUpdateSql("PROVINCE", hotspot.getProvince(), "VARCHAR"));
					listu.add(util.getUpdateSql("CITY", hotspot.getCity(), "VARCHAR"));
					listu.add(util.getUpdateSql("DISTRICT", hotspot.getDistrict(), "VARCHAR"));
					listu.add(util.getUpdateSql("SWITCH_NUMBER", hotspot.getSwitchNumber(), "DECIMAL"));
					listu.add(util.getUpdateSql("IS_VIP", hotspot.getIsVip(), "DECIMAL"));
					listu.add(util.getUpdateSql("LONGTITUDE", hotspot.getLongtitude(), "DECIMAL"));
					listu.add(util.getUpdateSql("LATITUDE", hotspot.getLatitude(), "DECIMAL"));
					listu.add(util.getUpdateSql("PROJECT_NO", hotspot.getProjectNo(), "VARCHAR"));
					listu.add(util.getUpdateSql("IMP_VENDOR", ImpVendorUuid, "VARCHAR"));
					listu.add(util.getUpdateSql("TRANS_TYPE", hotspot.getTransType(), "DECIMAL"));
					listu.add(util.getUpdateSql("TRANS_CARD_LOC", hotspot.getTransCardLoc(), "VARCHAR"));
					listu.add(util.getUpdateSql("DF", hotspot.getDf(), "VARCHAR"));
					listu.add(util.getUpdateSql("RING", hotspot.getRing(), "VARCHAR"));
					listu.add(util.getUpdateSql("MAINT_VENDOR", MaintVendorUuid, "VARCHAR"));
					listu.add(util.getUpdateSql("COVERAGE_TYPE", hotspot.getCoverType().getID(), "VARCHAR"));
					listu.add(util.getUpdateSql("COVERAGE_SUB_TYPE", hotspot.getSubCoverType().getId(), "VARCHAR"));
					listu.add(util.getUpdateSql("COVERAGE_SCOPE", hotspot.getCoverageScope(), "VARCHAR"));
					listu.add(util.getUpdateSql("AP_NUMBER", hotspot.getApNumber(), "DECIMAL"));
					listu.add(util.getUpdateSql("PROJECT_STATUS", hotspot.getProjectStatus(), "DECIMAL"));
					listu.add(util.getUpdateSql("REMARK", hotspot.getRemark(), "VARCHAR"));
					listu.add(util.getUpdateSql("BANDWITH", hotspot.getBandwith(), "DECIMAL"));
					listu.add(util.getUpdateSql("COVERAGE_MODE", hotspot.getCoverageMode(), "DECIMAL"));
					listu.add(util.getUpdateSql("COMBINE_MODE", hotspot.getCombineMode(), "DECIMAL"));
					listu.add(util.getUpdateSql("ENTRY_DATE", hotspot.getEntryDate(), "DATE"));
					listu.add(util.getUpdateSql("ENTRY_STAFF", hotspot.getEntryStaff(), "DECIMAL"));
					listu.add(util.getUpdateSql("AUDITOR", hotspot.getAuditor(), "DECIMAL"));
					listu.add(util.getUpdateSql("AUDIT_STATUS", hotspot.getAuditStatus(), "DECIMAL"));
					listu.add(util.getUpdateSql("AUDIT_DATE", hotspot.getAuditDate(), "DATE"));
					listu.add(util.getUpdateSql("AUDIT_FIN_DATE", hotspot.getAuditFinDate(), "DATE"));
					listu.add(util.getUpdateSql("MANAGE_STATUS", hotspot.getManageStatus(), "DECIMAL"));
					listu.add(util.getUpdateSql("DEVICE_VENDOR", hotspot.getVendor().getName(), "VARCHAR"));
					listu.add(util.getUpdateSql("LANDMARKS", hotspot.getLandMarks(), "VARCHAR"));
					listu.add(util.getUpdateSql("CELL_ID", hotspot.getCeLlid(), "VARCHAR"));
					listu.add(util.getUpdateSql("LAC_ID", hotspot.getLaCid(), "VARCHAR"));
					listu.add(util.getUpdateSql("HP_THICK_TYPE", hotspot.getHotspotLevel(), "DECIMAL"));
					listu.add(util.getUpdateSql("WLAN_SERVICE_TYPE", hotspot.getWlanServiceType(), "VARCHAR"));
					listu.add(util.getUpdateSql("PROJECT_NUM", hotspot.getProjectNum(), "VARCHAR"));
					listu.add(util.getUpdateSql("IS_COO_SERVICE", hotspot.getCooService(), "DECIMAL"));
					listu.add(util.getUpdateSql("PROJECT_COMPLETE_DATE", hotspot.getProjectCompleteDate(), "DATE"));
					listu.add(util.getUpdateSql("PROJECT_ACCEPT_DATE", hotspot.getProjectAcceptDate(), "DATE"));
					listu.add(util.getUpdateSql("PROJECT_APPLY_DATE", hotspot.getProjectApplyDate(), "DATE"));
					listu.add(util.getUpdateSql("IS_VI", hotspot.getIsVi(), "DECIMAL"));
					sql = util.getUpdate(sql, listu);
					sql += " where HOTSPOT_ID =?";
					System.out.println(sql);
					int result = jdbcTemplate.update(sql, hotspot.getHOTSPOT_ID());
					System.out.println("成功更新条数：" + result);
				}
			} catch (Exception e) {
				System.out.println("保存基本数据发生异常" + e);
				importMsg.appendMessage(getFailureMsg("保存基本数据发生异常", dto.getRow()));
				importMsg.countFail();
				continue;
			}

			// 热点IP地址段信息表
			HotspotIpAlloc hia = null;
			if (!StringUtils.isBlank(dto.getIpAddrSegment())) {
				if (!isUpdate) {
					hia = new HotspotIpAlloc();
					try {
						jdbcTemplate.update(
								"insert into RES.PRM_WLAN_HOTSPOT_IP_ALLOC (GATEWAY,HOTSPOT_ID,SW_ADDR_FROM,SW_ADDR_TO,AP_ADDR_FROM,AP_ADDR_TO,IP_ADDR_SEGMENT,NET_ADDR_FROM_NUM,NET_ADDR_TO_NUM,SW_ADDR_FROM_NUM,SW_ADDR_TO_NUM,AP_ADDR_FROM_NUM,AP_ADDR_TO_NUM)values(?,?,?,?,?,?,?,?,?,?,?,?,?)",
								hia.getGateway(), hotspot.getHOTSPOT_ID(), hia.getSwAddrFrom(), hia.getApAddrTo(),
								hia.getApAddrFrom(), hia.getApAddrTo(), hia.getIpAddrSegment(), hia.getNetAddrFromNum(),
								hia.getNetAddrToNum(), hia.getSwAddrFromNum(), hia.getSwAddrToNum(),
								hia.getApAddrFromNum(), hia.getApAddrToNum());
					} catch (Exception e) {
						System.out.println("插入热点IP地址段信息表失败：" + e);
					}
				} else if (!StringUtils.isBlank(hotspot.getHOTSPOT_ID())) {
					RowMapper<HotspotIpAlloc> hotspotipallType = new BeanPropertyRowMapper<HotspotIpAlloc>(
							HotspotIpAlloc.class);
					try {
						if (!StringUtils.isBlank(dto.getGateway())) {
							hia = jdbcTemplate.queryForObject(
									"SELECT * FROM PRM_WLAN_HOTSPOT_IP_ALLOC where HOTSPOT_ID =? and GATEWAY=?",
									hotspotipallType, hotspot.getHOTSPOT_ID(), dto.getGateway());
						} else {
							hia = jdbcTemplate.queryForObject(
									"SELECT * FROM PRM_WLAN_HOTSPOT_IP_ALLOC where HOTSPOT_ID =?", hotspotipallType,
									hotspot.getHOTSPOT_ID());
						}
					} catch (EmptyResultDataAccessException e) {
						e.printStackTrace();
						hia = null;
					}
					if (hia != null) {
						sql = "update RES.PRM_WLAN_HOTSPOT_IP_ALLOC set ";
						util = new Util();
						listu = new ArrayList<UpdateSql>();
						try {
							listu.add(util.getUpdateSql("SW_ADDR_FROM", hia.getSwAddrFrom(), "VARCHAR"));
							listu.add(util.getUpdateSql("SW_ADDR_TO", hia.getSwAddrTo(), "VARCHAR"));
							listu.add(util.getUpdateSql("AP_ADDR_FROM", hia.getApAddrFrom(), "VARCHAR"));
							listu.add(util.getUpdateSql("AP_ADDR_TO", hia.getApAddrTo(), "VARCHAR"));
							listu.add(util.getUpdateSql("IP_ADDR_SEGMENT", hia.getIpAddrSegment(), "VARCHAR"));
							listu.add(util.getUpdateSql("NET_ADDR_FROM_NUM", hia.getNetAddrFromNum(), "DECIMAL"));
							listu.add(util.getUpdateSql("NET_ADDR_TO_NUM", hia.getNetAddrToNum(), "DECIMAL"));
							listu.add(util.getUpdateSql("SW_ADDR_FROM_NUM", hia.getSwAddrFromNum(), "DECIMAL"));
							listu.add(util.getUpdateSql("SW_ADDR_TO_NUM", hia.getSwAddrToNum(), "DECIMAL"));
							listu.add(util.getUpdateSql("AP_ADDR_FROM_NUM", hia.getApAddrFromNum(), "DECIMAL"));
							listu.add(util.getUpdateSql("AP_ADDR_TO_NUM", hia.getApAddrToNum(), "DECIMAL"));
							sql = util.getUpdate(sql, listu);
							sql += " where GATEWAY = ? and HOTSPOT_ID = ?";
							System.out.println("ipall更新语句:" + sql);

							jdbcTemplate.update(sql, dto.getGateway(), hotspot.getHOTSPOT_ID());
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						try {
							if (!StringUtils.isBlank(dto.getGateway())) {
								hia = jdbcTemplate.queryForObject(
										"SELECT * FROM PRM_WLAN_HOTSPOT_IP_ALLOC where HOTSPOT_ID =? and GATEWAY=?",
										hotspotipallType, hotspot.getHOTSPOT_ID(), dto.getGateway());
							} else {
								hia = jdbcTemplate.queryForObject(
										"SELECT * FROM PRM_WLAN_HOTSPOT_IP_ALLOC where HOTSPOT_ID =?", hotspotipallType,
										hotspot.getHOTSPOT_ID());
							}
						} catch (EmptyResultDataAccessException e) {
							e.printStackTrace();
							hia = null;
						}
					}
				}
			}
			// 热点与 核心交换机 VLAN 关系表
			HotspotVlan hvlan = null;
			try {
				if (!isUpdate) {
					hvlan = new HotspotVlan();
					setHotspotVlan(dto, hotspot, hvlan);
					if (hvlan.getInf() != null) {
						jdbcTemplate.update(
								" insert into RES.PRM_HOTSPOT_VLAN (HOTSPOT_ID, SWITCH_ID, SWITCH_PORT_ID,VLAN) values(?,?,?,?)",
								hotspot.getHOTSPOT_ID(), hvlan.getInf().getDevice().getDEVICE_ID(),
								hvlan.getInf().getID(), hvlan.getVlan());
					}
				} else {
					RowMapper<HotspotVlan> vlanType = new BeanPropertyRowMapper<HotspotVlan>(HotspotVlan.class);
					try {
						hvlan = jdbcTemplate.queryForObject("select * from RES.PRM_HOTSPOT_VLAN where HOTSPOT_ID = ?",
								vlanType, hotspot.getHOTSPOT_ID());
					} catch (EmptyResultDataAccessException em) {
						hvlan = null;
					}
					if (hvlan != null) {
						setHotspotVlan(dto, hotspot, hvlan);
						sql = "update RES.PRM_HOTSPOT_VLAN set ";
						util = new Util();
						listu = new ArrayList<UpdateSql>();
						listu.add(util.getUpdateSql("SWITCH_ID", hvlan.getInf().getDEVICE_ID(), "VARCHAR"));
						listu.add(util.getUpdateSql("SWITCH_PORT_ID", hvlan.getInf().getID(), "VARCHAR"));
						listu.add(util.getUpdateSql("VLAN", hvlan.getVlan(), "VARCHAR"));
						sql = util.getUpdate(sql, listu);
						sql += " where HOTSPOT_ID = ?";
						jdbcTemplate.update(sql, hotspot.getHOTSPOT_ID());
					} else {
						hvlan = new HotspotVlan();
						setHotspotVlan(dto, hotspot, hvlan);
							if (hvlan.getInf() != null) {
								jdbcTemplate.update(
										" insert into RES.PRM_HOTSPOT_VLAN (HOTSPOT_ID, SWITCH_ID, SWITCH_PORT_ID,VLAN) values(?,?,?,?)",
										hotspot.getHOTSPOT_ID(), hvlan.getInf().getDevice().getDEVICE_ID(),
										hvlan.getInf().getID(), hvlan.getVlan());
							}
						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// ssid
			if (StringUtils.isNotBlank(dto.getSsids())) {
				String[] ssidNames = dto.getSsids().split("/");
				Set<SSID> ssidSet = new HashSet<SSID>();
				RowMapper<Ssid> ssidType = new BeanPropertyRowMapper<Ssid>(Ssid.class);

				for (String name : ssidNames) {
					SSID ssid;
					Ssid sSID;
					try {
						sSID = jdbcTemplate.queryForObject("select * from RES.RM_SSID where NAME = ?", ssidType, name);
						System.out.println("看看ssid：" + sSID.getUuid() + "," + name + "," + sSID.getBusinessType());
						ssid = new SSID();
						ssid.setId(sSID.getUuid());
						ssid.setBusinessType(sSID.getBusinessType());
						ssid.setName(name);
					} catch (EmptyResultDataAccessException em) {
						ssid = null;
					}
					if (ssid == null) {
						ssid = new SSID();
						ssid.setId(IdUtils.GeneratorUUID());
						ssid.setName(name);
						ssid.setBusinessType("集团业务");
						jdbcTemplate.update(
								" insert into RES.RM_SSID (UUID, BUSINESS_TYPE, NAME,REMARK) values (?,?,?,?)",
								ssid.getId(), ssid.getBusinessType(), ssid.getName(), ssid.getRemark());
					}
					ssidSet.add(ssid);
				}
				try {
					if (isUpdate) {
						jdbcTemplate.update("delete RES.PRM_HOTSPOT_SSID  where HOTSPOT_ID = ?",
								hotspot.getHOTSPOT_ID());
					}
					for (SSID ssid : ssidSet) {
						System.out
								.println(hotspot.getHOTSPOT_ID() + "," + ssid.getId() + "," + IdUtils.GeneratorUUID());
						jdbcTemplate.update("insert into RES.PRM_HOTSPOT_SSID (ID, HOTSPOT_ID, SSID_ID) values(?,?,?)",
								IdUtils.GeneratorUUID(), hotspot.getHOTSPOT_ID(), ssid.getId());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//
			System.out.println("acname:" + dto.getAcs());
			if (StringUtils.isNotBlank(dto.getAcs())) {
				RowMapper<AC> acType = new BeanPropertyRowMapper<AC>(AC.class);
				String[] acNames = dto.getAcs().replace("-", "/").split("/");
				String set = "(";
				for (String acl : acNames) {
					System.out.println(acl);
					set += "'" + acl + "',";
				}
				set = set.substring(0, set.length() - 1) + ")";
				System.out.println("看看set：" + set);
				sql = "select t1.device_id,t1.sys_name,t1.alias,t4.name as rm_vendor_name,t4.name_cn as rm_vendor_name_cn,t1.device_type,t1.model,t1.ip_addr,t1.city,t1.district,t1.serial_number,t1.sys_version,t1.project_status,t1.entry_staff,t1.auditor,t1.audit_status,t1.manage_status,t2.max_ap_num_permitted,t2.max_sta_num_permitted,t3.id as room_id,t3.room as room_name,t2.service_type,t1.read_community,t1.write_community,t1.shelf_location,t1.remark,t1.audit_date,t1.audit_fin_date,t2.nas_id,t2.nas_ip,t2.manage_type from prm_device t1,prm_device_ac t2,rm_room t3,rm_vendor t4 where t1.device_id = t2.device_id and t1.vendor = t4.name  and t1.room = t3.id(+) and t1.alias in "
						+ set;
				try {
					List<AC> acList = jdbcTemplate.query(sql, acType);
					if (isUpdate) {
						jdbcTemplate.update("delete RES.PRM_HOTSPOT_AC  where HOTSPOT_ID = ?", hotspot.getHOTSPOT_ID());
					}
					for (AC ac : acList) {
						System.out.println("Ac");
						System.out.println(ac.getDEVICE_ID());
						jdbcTemplate.update("insert into RES.PRM_HOTSPOT_AC (ID, HOTSPOT_ID, AC_ID) values(?,?,?)",
								IdUtils.GeneratorUUID(), hotspot.getHOTSPOT_ID(), ac.getDEVICE_ID());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (StringUtils.isNotBlank(dto.getWorkOrderId()) && hotspot != null) {
				WlanWorkOrder order;
				RowMapper<WlanWorkOrder> wlanworkType = new BeanPropertyRowMapper<WlanWorkOrder>(WlanWorkOrder.class);
				try {
					order = jdbcTemplate.queryForObject(
							"select * from  PRM_WLAN_WORK_ORDER where NAS_ID = ? and ORDER_NO = ?", wlanworkType,
							hotspot.getNAS_ID(), dto.getWorkOrderId());
				} catch (EmptyResultDataAccessException em) {
					order = null;
				}
				try {
					String date;
					if (order == null) {
						WlanWorkOrder workOrder = new WlanWorkOrder();
						workOrder.setHotspot(hotspot);
						workOrder.setOperateDept(dto.getOperateDept());
						workOrder.setOperateTime(dto.getOperateTime());
						workOrder.setOperator(dto.getOperator());
						workOrder.setOrderNo(dto.getWorkOrderId());
						workOrder.setOrderTitle(dto.getWorkOrderTheme());
						workOrder.setOrderType(dto.getWorkOrderType());
						date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(workOrder.getOperateTime());
						jdbcTemplate.update(
								"insert into PRM_WLAN_WORK_ORDER (NAS_ID,ORDER_NO,ORDER_TITLE,ORDER_TYPE,OPERATOR,OPERATE_DEPT,OPERATE_TIME)values(?,?,?,?,?,?,to_date(?,'SYYYY-MM-DD HH24:MI:SS'))",
								hotspot.getNAS_ID(), workOrder.getOrderNo(), workOrder.getOrderTitle(),
								workOrder.getOrderType(), workOrder.getOperator(), workOrder.getOperateDept(), date);
						workOrder = null;
					} else {
						WlanWorkOrder workOrder = new WlanWorkOrder();
						workOrder.setHotspot(hotspot);
						workOrder.setOperateDept(dto.getOperateDept());
						workOrder.setOperateTime(dto.getOperateTime());
						workOrder.setOperator(dto.getOperator());
						workOrder.setOrderNo(dto.getWorkOrderId());
						workOrder.setOrderTitle(dto.getWorkOrderTheme());
						workOrder.setOrderType(dto.getWorkOrderType());
						sql = "update RES.PRM_WLAN_WORK_ORDER set ";
						util = new Util();
						listu = new ArrayList<UpdateSql>();
						listu.add(util.getUpdateSql("ORDER_TITLE", workOrder.getOrderTitle(), "VARCHAR"));
						listu.add(util.getUpdateSql("ORDER_TYPE", workOrder.getOrderType(), "DECIMAL"));
						listu.add(util.getUpdateSql("OPERATOR", workOrder.getOperator(), "VARCHAR"));
						listu.add(util.getUpdateSql("OPERATE_DEPT", workOrder.getOperateDept(), "VARCHAR"));
						listu.add(util.getUpdateSql("OPERATE_TIME", workOrder.getOperateTime(), "DATE"));
						sql = util.getUpdate(sql, listu);
						sql += " where NAS_ID = ? and ORDER_NO = ?";
						System.out.println("ipall更新语句:" + sql);
						jdbcTemplate.update(sql, hotspot.getNAS_ID(), workOrder.getOrderNo());
						order = null;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			hotspot = null;
			importMsg.countSuccess(); // 累加导入成功记录数
		}
		return importMsg;
	}
	
    private void setHotspotVlan(HotspotImportDto dto, Hotspot hotspot, HotspotVlan hvlan) {
        hvlan.setHotspot(hotspot);
        hvlan.setVlan(dto.getVlan());
        RowMapper<Interface> Interface = new BeanPropertyRowMapper<Interface>(Interface.class);
        Interface inf;
        try{
         inf = jdbcTemplate.queryForObject(
				" select  * from  prm_interface where IF_NAME = ? and device_id = ( select device_id from prm_device where sys_name = ? )", Interface,
				dto.getCoreSwitchPort(),dto.getCoreSwitchName());
        }catch(EmptyResultDataAccessException e){
        	inf =null;
        }
        hvlan.setInf(inf);
    }
}
