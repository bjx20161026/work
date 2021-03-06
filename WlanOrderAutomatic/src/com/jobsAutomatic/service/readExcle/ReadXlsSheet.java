package com.jobsAutomatic.service.readExcle;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import com.jobsAutomatic.service.modle.ApImportDto;
import com.jobsAutomatic.service.modle.HotspotImportDto;
import com.jobsAutomatic.service.modle.SwitchDto;
import com.jobsAutomatic.service.modle.WorkJob;

public class ReadXlsSheet {
	
	
	protected WorkJob setWorkJob(HSSFWorkbook hssfWorkbook) {
		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
		HSSFRow hssfRow = hssfSheet.getRow(2);
		WorkJob workJob = new WorkJob();
		workJob.setWorkjob_id(getValue(hssfRow.getCell(0)));
		workJob.setTitle(getValue(hssfRow.getCell(1)));
		workJob.setWorker(getValue(hssfRow.getCell(2)));
		workJob.setDepartment(getValue(hssfRow.getCell(3)));
		workJob.setSend_time(getValue(hssfRow.getCell(4)));
		workJob.setHandle_time(getValue(hssfRow.getCell(5)));
		workJob.setLocation(getValue(hssfRow.getCell(6)));
		workJob.setArea(getValue(hssfRow.getCell(7)));
		workJob.setStatement("待入网");
		workJob.setIssucced(0);
		return workJob;
	}
	
	protected String getSheetName(HSSFWorkbook hssfWorkbook, int i) {
		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(i);
		return hssfSheet.getSheetName();
	}

	protected List<HotspotImportDto> setHotSpot(HSSFWorkbook hssfWorkbook, ImportMsg importMsg) {
		String[] districts = { "宝山", "长宁", "崇明", "奉贤", "虹口", "黄浦", "嘉定", "金山", "静安", "卢湾", "南汇", "普陀", "浦东新区", "青浦",
				"松江", "徐汇", "杨浦", "闸北", "闵行" };
		String[] cities = { "东区", "西区", "南区", "北区", "宝山", "崇明", "奉贤", "嘉定", "金山", "南汇", "青浦", "松江", "闵行" };
		List<HotspotImportDto> aryLis1 = new ArrayList<HotspotImportDto>();
		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(1);
		int rowcnt = hssfSheet.getLastRowNum();// 行数
		System.out.println("热点行数" + rowcnt);
		int columncnt = 50;// 列数
		IpScopeFieldHandler iphandler = new IpScopeFieldHandler();
		for (int i = 3; i <= rowcnt; i++) {
			HotspotImportDto dto = new HotspotImportDto();
			HSSFRow hssfRow = hssfSheet.getRow(i);
			boolean isContinue = false;
			isContinue = true;
			for (int j = 0; j < columncnt; j++) {
				switch (j) {
				case 0:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage("第" + i + "行" + j + "列逻辑热点名称不能为空");
						isContinue = false;
						break;
					}
					dto.setPrimaryHotspotName(getValue(hssfRow.getCell(j)));// 逻辑热点名称
					break;
				case 1:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage("第" + i + "行" + j + "列热点地址不能为空");
						isContinue = false;
						break;
					}
					dto.setLocation(getValue(hssfRow.getCell(j)));// 热点地址
					break;
				case 2:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage("第" + i + "行" + j + "列物理热点名称不能为空");
						isContinue = false;
						break;
					}
					dto.setHotspotName(getValue(hssfRow.getCell(j)));// 物理热点名称
					break;
				case 3:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage("第" + i + "行" + j + "列行政区域不能为空");
						isContinue = false;
						break;
					}
					if (!isContainsElement(districts, getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage("第" + i + "行" + j
								+ "列行政区域不在[宝山,长宁,崇明,奉贤,虹口,黄浦,嘉定,金山,静安,卢湾,南汇,普陀,浦东新区,青浦,松江,徐汇,杨浦,闸北,闵行]范围内");
						isContinue = false;
						break;
					}
					dto.setDistrict(getValue(hssfRow.getCell(j)));// 行政区域
					break;
				case 4:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage("第" + i + "行" + j + "列所属分公司不能为空");
						isContinue = false;
						break;
					}
					if (!(StringUtils.isBlank(getValue(hssfRow.getCell(j))))
							&& !isContainsElement(cities, getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage(
								"第" + i + "行" + j + "列所属分公司不在[东区,西区,南区,北区,宝山,崇明,奉贤,嘉定,金山,南汇,青浦,松江,闵行]范围内");
						isContinue = false;
						break;
					}
					dto.setCity(getValue(hssfRow.getCell(j)));// 所属分公司
					break;
				case 5:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage("第" + i + "行" + j + "列覆盖场景不能为空");
						isContinue = false;
						break;
					}
					dto.setCoverType(getValue(hssfRow.getCell(j)));// 覆盖场景
					break;
				case 6:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage("第" + i + "行" + j + "列覆盖子场景不能为空");
						isContinue = false;
						break;
					}
					dto.setSubCoverType(getValue(hssfRow.getCell(j)));// 覆盖子场景
					break;
				case 7:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						dto.setLongtitude(0);
					} else {
						try {
							dto.setLongtitude(Float.parseFloat(getValue(hssfRow.getCell(j))));// 热点的经度
						} catch (Exception e) {
							importMsg.appendMessage("第" + i + "行" + j + "列热点的经度数字格式不正确");
							isContinue = false;
							break;
						}
					}
					break;
				case 8:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						dto.setLatitude(0);
					} else {
						try {
							dto.setLatitude(Float.parseFloat(getValue(hssfRow.getCell(j))));// 热点的维度
						} catch (Exception e) {
							importMsg.appendMessage("第" + i + "行" + j + "列热点的维度数字格式不正确");
							isContinue = false;
							break;
						}
					}
					break;
				case 9:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage("第" + i + "行" + j + "列AP数量不能为空");
						isContinue = false;
						break;
					}
					if (isIntValue(getValue(hssfRow.getCell(j)))) {
						try {
							dto.setApNumber(Integer.parseInt(getValue(hssfRow.getCell(j))));// AP数量
						} catch (Exception e) {
							importMsg.appendMessage("第" + i + "行" + j + "列AP数量数字格式不正确");
							isContinue = false;
							break;
						}
					}
					break;
				case 10:
					dto.setAcs(getValue(hssfRow.getCell(j)));// 所属AC
					break;
					/*
					 * 
					 */
				case 11:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					dto.setSpareAC(getValue(hssfRow.getCell(j)));
				case 12:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					if (isIntValue(getValue(hssfRow.getCell(j)))) {
						try {
							dto.setBandwith(Integer.parseInt(getValue(hssfRow.getCell(j))));// 热点带宽(MBps)
							// System.out.println("我是想看一下这个热点带宽的值"+Integer.parseInt(getValue(hssfRow.getCell(j))));
						} catch (Exception e) {
							importMsg.appendMessage("第" + i + "行" + j + "列热点带宽(MBps)数字格式不正确");
							isContinue = false;
							break;
						}
					}
					break;
				case 13:
					dto.setNasId(getValue(hssfRow.getCell(j)));// NAS-ID
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage("第" + i + "行" + j + "列NAS_ID不能为空");
						isContinue = false;
					} else if (!Pattern.matches("\\d{4}\\.\\d{4}\\.210\\.00\\.460", getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行" + j + "列NAS_ID格式不对");
					}
					break;
				case 14:
					dto.setSsids(getValue(hssfRow.getCell(j)));// SSID
					break;
				case 15:
					dto.setVlan(getValue(hssfRow.getCell(j)));// VLAN
					break;
				case 16:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					dto.setRing(getValue(hssfRow.getCell(j)));// 所属环
					break;
				case 17:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage("第" + i + "行" + j + "列传输类型不能为空");
						isContinue = false;
						break;
					}
					int number = 0;
					if ("其他".equals(getValue(hssfRow.getCell(j)))) {
						number = 0;
					} else if ("MSTP".equals(getValue(hssfRow.getCell(j)))) {
						number = 1;
					} else if ("GPON".equals(getValue(hssfRow.getCell(j)))) {
						number = 2;
					} else if ("PTN".equals(getValue(hssfRow.getCell(j)))) {
						number = 3;
					} else if ("E1".equals(getValue(hssfRow.getCell(j)))) {
						number = 4;
					} else if ("SDH".equals(getValue(hssfRow.getCell(j)))) {
						number = 5;
					} else if ("MSAP".equals(getValue(hssfRow.getCell(j)))) {
						number = 6;
					} else if ("以太网".equals(getValue(hssfRow.getCell(j)))) {
						number = 7;
					} else {
						importMsg.appendMessage("第" + i + "行" + j + "列传输类型不在[其他,MSTP,GPON,PTN,E1,SDH]范围内");
						isContinue = false;
						break;
					}
					dto.setTransType(number);// 传输类型
					break;
				case 18:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					dto.setTransCardLoc(getValue(hssfRow.getCell(j)));// 传输单板板位
					break;
				case 19:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					dto.setCoreSwitchName(getValue(hssfRow.getCell(j)));// 汇聚交换机名称
					break;
				case 20:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					dto.setCoreSwitchPort(getValue(hssfRow.getCell(j)));// 汇聚交换机端口
					break;
				case 21:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					dto.setDf(getValue(hssfRow.getCell(j)));// 网络配线架
					break;
				case 22:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage("第" + i + "行" + j + "列VIP级别不能为空");
						isContinue = false;
						break;
					}
					int name = 1;
					if ("普通".equals(getValue(hssfRow.getCell(j)))) {
						name = 1;
					} else if ("VIP".equals(getValue(hssfRow.getCell(j)))) {
						name = 2;
					} else if ("VVIP".equals(getValue(hssfRow.getCell(j)))) {
						name = 3;
					} else {
						importMsg.appendMessage("第" + i + "行" + j + "列VIP级别不在[普通,VIP,VVIP]范围内");
						isContinue = false;
						break;
					}
					dto.setVip(name);// VIP级别
					break;
				case 23:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					dto.setCoverageScope(getValue(hssfRow.getCell(j)));// 覆盖范围
					break;
				/*
				 * case 23: int index = 0; if
				 * ("室内".equals(getValue(hssfRow.getCell(j)))) { index = 1; }
				 * else if ("室外".equals(getValue(hssfRow.getCell(j)))) { index =
				 * 2; } else if ("室内/室外".equals(getValue(hssfRow.getCell(j)))) {
				 * index = 3; } dto.setCoverageMode(index);// 覆盖模式 break; case
				 * 24: int num = 0; if
				 * ("独立".equals(getValue(hssfRow.getCell(j)))) { num = 1; } else
				 * if ("3G合路".equals(getValue(hssfRow.getCell(j)))) { num = 2; }
				 * else if ("2G合路".equals(getValue(hssfRow.getCell(j)))) { num =
				 * 3; } else if ("2G/3G合路".equals(getValue(hssfRow.getCell(j))))
				 * { num = 4; } dto.setCombineMode(num);// 合路模式 break;
				 */
				case 24:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					dto.setGateway(getValue(hssfRow.getCell(j)));// 网关地址
					break;
				case 25:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					if (StringUtils.isNotBlank(getValue(hssfRow.getCell(j)))) {// 热点交换机地址
						iphandler.handler(getValue(hssfRow.getCell(j)));
						if (iphandler.isStatus()) {
							dto.setSwAddrFrom(iphandler.getReturnValue()[0]);
							dto.setSwAddrTo(iphandler.getReturnValue()[1]);
						}
					}
					break;
//				case 25:
//					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
//						// System.out.println(getValue(hssfRow.getCell(j)));
//						break;
//					if (StringUtils.isNotBlank(getValue(hssfRow.getCell(j)))) {// AP地址
//						iphandler.handler(getValue(hssfRow.getCell(j)));
//						if (iphandler.isStatus()) {
//							dto.setApAddrFrom(iphandler.getReturnValue()[0]);
//							dto.setApAddrTo(iphandler.getReturnValue()[1]);
//						}
//					}
//					break;
					/*
					 * 
					 */
				case 26:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					if (StringUtils.isNotBlank(getValue(hssfRow.getCell(j)))) {// IP地址范围
						iphandler.handler(getValue(hssfRow.getCell(j)));
						if (iphandler.isStatus()) {
							dto.setNetAddrFrom(iphandler.getReturnValue()[0]);
							dto.setNetAddrTo(iphandler.getReturnValue()[1]);
						}
					}
					break;
				case 27:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					if (isIntValue(getValue(hssfRow.getCell(j)))) {
						try {
							dto.setMask(Integer.parseInt(getValue(hssfRow.getCell(j))));// 网段掩码
						} catch (Exception e) {
							importMsg.appendMessage("第" + i + "行" + j + "列网段掩码数字格式不正确");
							isContinue = false;
							break;
						}
					}
					break;
				case 28:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage("第" + i + "行" + j + "列交换机数量不能为空");
						isContinue = false;
						break;
					}
					if (isIntValue(getValue(hssfRow.getCell(j)))) {
						try {
							dto.setSwitchNumber(Integer.parseInt(getValue(hssfRow.getCell(j))));// 交换机数量
						} catch (Exception e) {
							importMsg.appendMessage("第" + i + "行" + j + "列交换机数量数字格式不正确");
							isContinue = false;
							break;
						}
					}
					break;
				case 29:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					dto.setVendor(getValue(hssfRow.getCell(j)));// 设备厂商
					break;
				case 30:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					dto.setImpVendor(getValue(hssfRow.getCell(j)));// 集成厂商
					break;
				case 31:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					dto.setMaintVendor(getValue(hssfRow.getCell(j)));// 代维厂商
					break;
				case 32:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					dto.setRemark(getValue(hssfRow.getCell(j)));// 备注
					break;
				case 33:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					dto.setLandMarks(getValue(hssfRow.getCell(j)));// 周围地标建筑
					break;
				case 34:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					dto.setCeLlid(getValue(hssfRow.getCell(j)));// 蜂窝网小区识别码
					break;
				case 35:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					dto.setLaCid(getValue(hssfRow.getCell(j)));// 位置区编码
					break;
				case 36:
//					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
//						importMsg.appendMessage("第" + i + "行" + j + "列工单号不能为空");
//						isContinue = false;
//						break;
//					}
					dto.setWorkOrderId(getValue(hssfRow.getCell(j)));// 工单号
					break;
				case 37:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage("第" + i + "行" + j + "列工单主题不能为空");
						isContinue = false;
						break;
					}
					dto.setWorkOrderTheme(getValue(hssfRow.getCell(j)));// 工单主题
					break;
				case 38:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage("第" + i + "行" + j + "列工单类型不能为空");
						isContinue = false;
						break;
					}
					int type = 0;
					if ("入网".equals(getValue(hssfRow.getCell(j)))) {
						type = 1;
					} else if ("退网".equals(getValue(hssfRow.getCell(j)))) {
						type = 2;
					} else if ("变更".equals(getValue(hssfRow.getCell(j)))) {
						type = 3;
					} else if ("新入网".equals(getValue(hssfRow.getCell(j)))) {
						type = 4;
					} else if ("割接".equals(getValue(hssfRow.getCell(j)))) {
						type = 5;
					} else if ("重接".equals(getValue(hssfRow.getCell(j)))) {
						type = 6;
					} else if ("补接".equals(getValue(hssfRow.getCell(j)))) {
						type = 7;
					} else if ("扩容".equals(getValue(hssfRow.getCell(j)))) {
						type = 8;
					} else {
						importMsg.appendMessage("第" + i + "行" + j + "列工单类型填写错误");
						isContinue = false;
						break;
					}
					dto.setWorkOrderType(type);// 工单类型
					break;
				case 39:
//					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
//						importMsg.appendMessage("第" + i + "行" + j + "列操作人不能为空");
//						isContinue = false;
//						break;
//					}
					dto.setOperator(getValue(hssfRow.getCell(j)));// 操作人
					break;
				case 40:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage("第" + i + "行" + j + "列操作部门不能为空");
						isContinue = false;
						break;
					}
					dto.setOperateDept(getValue(hssfRow.getCell(j)));// 操作部门
					break;
				case 41:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						dto.setOperateTime(sdf.parse(getValue(hssfRow.getCell(j))));// 操作时间
					} catch (Exception el) {
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
							Long time = new Long(getValue(hssfRow.getCell(j)));
							String d = sdf.format(time);
							dto.setOperateTime(sdf.parse(d));
						} catch (Exception e) {
							try {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
								dto.setOperateTime(sdf.parse(getValue(hssfRow.getCell(j))));// 操作时间
							} catch (Exception ee) {
								isContinue = false;
								importMsg.appendMessage("第" + i + "行" + j + "列" + j
										+ "列_操作时间格式不对[yyyy-MM-dd hh:mm:ss,yyyy年MM月dd日 hh:mm:ss]");
							}
						}
					}
					break;
				case 42:
					String level = null;
					if ("第一类".equals(getValue(hssfRow.getCell(j)))) {
						level = "1";
					} else if ("第二类".equals(getValue(hssfRow.getCell(j)))) {
						level = "2";
					} else if ("第三类".equals(getValue(hssfRow.getCell(j)))) {
						level = "3";
					} else if ("其它".equals(getValue(hssfRow.getCell(j)))) {
						level = "0";
					} else {
						level = "";
					}
					dto.setHotspotLevel(level);
					break;
				case 43:
					dto.setWlanServiceType(getValue(hssfRow.getCell(j)));
					break;
				case 44:
					dto.setProjectNum(getValue(hssfRow.getCell(j)));
					break;
				case 45:
					if ("是".equals(getValue(hssfRow.getCell(j)))) {
						dto.setCooService(1);
					} else if ("否".equals(getValue(hssfRow.getCell(j)))) {
						dto.setCooService(0);
					} else if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {

					} else {
						System.out.println("45:" + getValue(hssfRow.getCell(j)));
						importMsg.appendMessage("第" + i + "行" + j + "列是否为合作业务只能选是或否，或者为空");
						isContinue = false;
						break;
					}
					break;
				case 46:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						dto.setProjectCompleteDate(sdf.parse(getValue(hssfRow.getCell(j))));// 开通时间
					} catch (Exception e) {
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
							dto.setProjectCompleteDate(sdf.parse(getValue(hssfRow.getCell(j))));// 开通时间
						} catch (Exception ee) {
							isContinue = false;
							importMsg.appendMessage(
									"第" + i + "行" + j + "列开通时间格式不对[yyyy-MM-dd hh:mm:ss,yyyy年MM月dd日 hh:mm:ss]");
						}
					}
					break;
				case 47:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						dto.setProjectAcceptDate(sdf.parse(getValue(hssfRow.getCell(j))));// 交维时间
					} catch (Exception e) {
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
							dto.setProjectAcceptDate(sdf.parse(getValue(hssfRow.getCell(j))));// 交维时间
						} catch (Exception ee) {
							isContinue = false;
							importMsg.appendMessage(
									"第" + i + "行" + j + "列交维时间格式不对[yyyy-MM-dd hh:mm:ss,yyyy年MM月dd日 hh:mm:ss]");
						}
					}
					break;
				case 48:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						dto.setProjectApplyDate(sdf.parse(getValue(hssfRow.getCell(j))));// 申请入网时间
					} catch (Exception e) {
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
							dto.setProjectApplyDate(sdf.parse(getValue(hssfRow.getCell(j))));// 申请入网时间
						} catch (Exception ee) {
							isContinue = false;
							importMsg.appendMessage(
									"第" + i + "行" + j + "列申请入网时间格式不对[yyyy-MM-dd hh:mm:ss,yyyy年MM月dd日 hh:mm:ss]");
						}
					}
					break;
				case 49:
					if ("是".equals(getValue(hssfRow.getCell(j)))) {
						dto.setIsVi(1);
					} else if ("否".equals(getValue(hssfRow.getCell(j)))) {
						dto.setIsVi(0);
					} else if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {

					} else {
						importMsg.appendMessage("第" + i + "行" + j + "列是否张贴VI标识只能选是或否，或者为空");
						isContinue = false;
						break;
					}
					break;
				}
				dto.setRow(i);
			}
			dto.setEntryStaff(20000);
			if (!isContinue) {
				importMsg.countFail();
				continue;
			}
			aryLis1.add(dto);
		}
		return aryLis1;
	}

	public List<SwitchDto> getSwitch(HSSFWorkbook hssfWorkbook, ImportMsg importMsg, int sheetid) throws Exception {

		List<SwitchDto> SwitchDtos = new ArrayList<SwitchDto>();
		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetid);
		int rowcnt = hssfSheet.getLastRowNum();// 行数
		System.out.println("热点行数" + rowcnt);
		int columncnt = 15;// 列数

		for (int i = 3; i <= rowcnt; i++) {
			SwitchDto switchDto = new SwitchDto();
			HSSFRow hssfRow = hssfSheet.getRow(i);
			boolean isContinue = false;
			isContinue = true;
			for (int j = 0; j < columncnt; j++) {
				switch (j) {
				case 0:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行设备名称不能为空");
					}
					switchDto.setSysName(getValue(hssfRow.getCell(j))); // 设备名称
					break;
				case 1:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行厂商名称不能为空");
					}
					switchDto.setVendor(getValue(hssfRow.getCell(j)));// 厂商
					break;
				case 2:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行型号不能为空");
					}
					switchDto.setModel(getValue(hssfRow.getCell(j)));// 型号
					break;
				case 3:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行IP地址不能为空");
					} else if (!Pattern.matches(
							"^((1?\\d?\\d|(2([0-4]\\d|5[0-5])))\\.){3}(1?\\d?\\d|(2([0-4]\\d|5[0-5])))$",
							getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行IP地址格式不对");
					}
					switchDto.setIpAddr(getValue(hssfRow.getCell(j)));// IP地址
					break;
				case 4:
					switchDto.setPrimarySwitch(getValue(hssfRow.getCell(j)));// 主交换机(传输出口)
					break;
				case 5:
					switchDto.setTransformBandWidth(getValue(hssfRow.getCell(j)));// 传输带宽（MB）
					break;
				case 6:
					switchDto.setSwitchExitPort(getValue(hssfRow.getCell(j)));// 交换机出口端口
					break;
				case 7:
					switchDto.setRemark(getValue(hssfRow.getCell(j)));// 备注
					break;
				case 8:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行NAS_ID不能为空");
					} else if (!Pattern.matches("\\d{4}\\.\\d{4}\\.210\\.00\\.460", getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行NAS_ID格式 不对");
					}
					switchDto.setNasId(getValue(hssfRow.getCell(j)));
					break;
				case 9:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					switchDto.setAlias(getValue(hssfRow.getCell(j)));// 设备别名
					break;
				case 10:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行交换机层次不能为空");
					}
					if ("核心交换机".equals(getValue(hssfRow.getCell(j))))
						switchDto.setSwitchLevel(1);// 交换机层次
					else if ("汇聚交换机".equals(getValue(hssfRow.getCell(j))))
						switchDto.setSwitchLevel(2);
					else if ("热点汇聚交换机".equals(getValue(hssfRow.getCell(j))))
						switchDto.setSwitchLevel(3);
					else if ("热点接入交换机".equals(getValue(hssfRow.getCell(j))))
						switchDto.setSwitchLevel(4);
					else {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行交换机层次只能为[热点汇聚交换机,热点接入交换机]");
					}
					break;
				case 11:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行ReadCommunity不能为空");
					}
					switchDto.setReadCommunity(getValue(hssfRow.getCell(j)));// ReadCommunity
					break;
				case 12:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行WriteCommunity不能为空");
					}
					switchDto.setWriteCommunity(getValue(hssfRow.getCell(j)));// WriteCommunity
					break;
				case 13:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行安装位置不能为空");
					}
					switchDto.setLocation(getValue(hssfRow.getCell(j)));// 安装位置
					break;
				case 14:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行上联端口交换机名称不能为空");
					}
					switchDto.setUpPortName(getValue(hssfRow.getCell(j)));// 上联端口交换机名称
					break;
				}
				switchDto.setRow(i);
				switchDto.setColumn(j);
			}
			if (!isContinue) {
				importMsg.countFail();
				continue;
			}
			SwitchDtos.add(switchDto);
		}
		return SwitchDtos;
	}

	public List<ApImportDto> getAp(HSSFWorkbook hssfWorkbook, ImportMsg importMsg, int sheetid) {
		List<ApImportDto> apImportDtos = new ArrayList<ApImportDto>();
		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetid);
		int rowcnt = hssfSheet.getLastRowNum();// 行数
		System.out.println("Ap行数" + rowcnt);
		int columncnt = 18;// 列数
		for (int i = 3; i <= rowcnt; i++) {
			ApImportDto apImportDto = new ApImportDto();
			HSSFRow hssfRow = hssfSheet.getRow(i);
			boolean isContinue = false;
			isContinue = true;
			for (int j = 0; j < columncnt; j++) {
				switch (j) {
				case 0:
					apImportDto.setSysName(getValue(hssfRow.getCell(j))); // 设备名称
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行设备名称不能为空");
					}
					break;
				case 1:
					apImportDto.setApType(getValue(hssfRow.getCell(j))); // ap类型
					break;
				case 2:
					apImportDto.setOnwerDevice(getValue(hssfRow.getCell(j))); // 所属设备名称
					break;
				case 3:
					apImportDto.setPowerSupplyMode(getValue(hssfRow.getCell(j)));// 供电模式
					break;
				case 4:
					apImportDto.setVendor(getValue(hssfRow.getCell(j)));// 厂商类型
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行厂商类型不能为空");
					}
					break;
				case 5:
					apImportDto.setModel(getValue(hssfRow.getCell(j)));// 型号
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行型号不能为空");
					}
					break;
				case 6:
					apImportDto.setSysVersion(getValue(hssfRow.getCell(j)));// 软件版本
					break;
				case 7:
					apImportDto.setIpAddr(getValue(hssfRow.getCell(j)));// 管理地址
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行管理地址不能为空");
					} else if (!Pattern.matches(
							"^((1?\\d?\\d|(2([0-4]\\d|5[0-5])))\\.){3}(1?\\d?\\d|(2([0-4]\\d|5[0-5])))$",
							getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行管理地址格式不对");
					}
					break;
				case 8:
					apImportDto
							.setMacAddr(getValue(hssfRow.getCell(j)).replace(":", " ").replace("-", " ").toUpperCase());// MAC地址
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						isContinue = false;

						importMsg.appendMessage("第" + i + "行MAC地址不能为空");
					} else if (!Pattern.matches("([a-fA-F\\d]{2}[\\s\\-\\:]{1}){5}[a-fA-F\\d]{2}",
							getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行MAC地址格式不对");
					}
					break;
				case 9:
					apImportDto.setRemark(getValue(hssfRow.getCell(j)));// 备注
					break;
				case 10:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						importMsg.appendMessage("第" + i + "行NAS_ID不能为空");
						isContinue = false;
						break;
					} else if (!Pattern.matches("\\d{4}\\.\\d{4}\\.210\\.00\\.460", getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行NAS_ID格式不对");
						break;
					}
					apImportDto.setNasId(getValue(hssfRow.getCell(j)));
					break;
				case 11:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					apImportDto.setAlias(getValue(hssfRow.getCell(j)));// 设备别名
					break;
				case 12:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					else if (("是").equals(getValue(hssfRow.getCell(j))))
						apImportDto.setDualCard(1);
					else if ("否".equals(getValue(hssfRow.getCell(j))))
						apImportDto.setDualCard(0);// 是否双卡
					else {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行软件版本只能填是或否，但可以不填");
					}
					break;
				case 13:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					if ("室内".equals(getValue(hssfRow.getCell(j))))
						apImportDto.setCoverageMode(1);// 覆盖类型
					else if ("室外".equals(getValue(hssfRow.getCell(j))))
						apImportDto.setCoverageMode(2);// 覆盖类型
					else {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行覆盖类型只能是室内或室外");
					}
					break;
				case 14:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					int num = 0;
					if ("独立".equals(getValue(hssfRow.getCell(j)))) {
						num = 1;
					} else if ("3G合路".equals(getValue(hssfRow.getCell(j)))) {
						num = 2;
					} else if ("2G合路".equals(getValue(hssfRow.getCell(j)))) {
						num = 3;
					} else if ("2G/3G合路".equals(getValue(hssfRow.getCell(j)))) {
						num = 4;
					} else {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行 合路模式只能是[独立,3G合路,2G合路,2G/3G合路]");
						break;
					}
					apImportDto.setCombineMode(num);// 合路模式
					break;
				case 15:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					apImportDto.setLocation(getValue(hssfRow.getCell(j)));// 安装位置
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行安装位置不能为空");
					}
					break;
				case 16:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					else if (!"1".equals(getValue(hssfRow.getCell(j))) && !"6".equals(getValue(hssfRow.getCell(j)))
							&& !"11".equals(getValue(hssfRow.getCell(j)))) {
						isContinue = false;
						importMsg.appendMessage("第" + i + "行开通频点只能是[1,6,11]");
						break;
					}
					apImportDto.setChannel(Integer.parseInt(getValue(hssfRow.getCell(j))));// 开通频点
					break;
				case 17:
					if (StringUtils.isBlank(getValue(hssfRow.getCell(j))))
						break;
					apImportDto.setCoverageScope(getValue(hssfRow.getCell(j)));// 覆盖范围
					break;
				}
				apImportDto.setRow(i);
				apImportDto.setColumn(j);
			}
			if (!isContinue) {
				importMsg.countFail();
				continue;
			}
			apImportDtos.add(apImportDto);
		}
		return apImportDtos;
	}

	public String getHotSpotOut(HSSFWorkbook hssfWorkbook, ImportMsg importMsg) {
		String nasids = "";
		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(1);
		int rowcnt = hssfSheet.getLastRowNum();// 行数
		System.out.println("热点退服行数" + rowcnt);
		for (int i = 2; i <= rowcnt; i++) {
			HSSFRow hssfRow = hssfSheet.getRow(i);
			if (StringUtils.isBlank(getValue(hssfRow.getCell(0))))
				importMsg.appendMessage("第" + i + "行0列逻辑热点名称不能为空");
			else
				nasids += getValue(hssfRow.getCell(0)) + ",";
		}
		return nasids.substring(0, nasids.length() - 1);
	}

	public String getApOut(HSSFWorkbook hssfWorkbook, ImportMsg importMsg) {
		String ips = "";
		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(1);
		int rowcnt = hssfSheet.getLastRowNum();// 行数
		System.out.println("ap退服行数" + rowcnt);
		for (int i = 2; i <= rowcnt; i++) {
			HSSFRow hssfRow = hssfSheet.getRow(i);
			if (StringUtils.isBlank(getValue(hssfRow.getCell(2))))
				importMsg.appendMessage("第" + i + "行2列ip地址不能为空");
			else
				ips += getValue(hssfRow.getCell(2)) + ",";
		}
		return ips.substring(0, ips.length() - 1);
	}

	private boolean isIntValue(String value) {
		String pattern = "[0-9]+(.[0-9]+)?";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(value);
		return m.matches();
	}

	public boolean isContainsElement(Object[] collection, Object element) {
		return Arrays.asList(collection).contains(element);
	}

	protected String getValue(HSSFCell hssfCell) {
		try {
			if (hssfCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				return String.valueOf(hssfCell.getBooleanCellValue());
			} else if (hssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				if (DateUtil.isCellDateFormatted(hssfCell)) {
					return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.format(DateUtil.getJavaDate(hssfCell.getNumericCellValue()));
				} else {
					DecimalFormat df = new DecimalFormat("0");
					return String.valueOf(df.format(hssfCell.getNumericCellValue()));
				}
			} else {
				return String.valueOf(hssfCell.getStringCellValue());
			}
		} catch (NullPointerException e) {
			return null;
		}
	}


}
