package com.jobsAutomatic.service.operator.aps;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.jobsAutomatic.service.modle.ApImportDto;
import com.jobsAutomatic.service.modle.UpdateSql;
import com.jobsAutomatic.service.modle.Vendor;
import com.jobsAutomatic.service.modle.old.AP;
import com.jobsAutomatic.service.modle.old.Hotspot;
import com.jobsAutomatic.service.modle.old.Switch;
import com.jobsAutomatic.service.operator.DBOperator;
import com.jobsAutomatic.service.readExcle.ImportMsg;
import com.jobsAutomatic.service.util.IdUtils;
import com.jobsAutomatic.service.util.Util;



public class ApDataImport extends DBOperator{
	 public ImportMsg saveImportData(List<ApImportDto> apImportDtos,ImportMsg importMsg) {
	        for (int i = 0; i < apImportDtos.size(); i++) {
	        	ApImportDto dto = apImportDtos.get(i);
	    		RowMapper<Hotspot> rowMapper=new BeanPropertyRowMapper<Hotspot>(Hotspot.class);
				Hotspot hotspot;
	    		try{
	    			System.out.println("getNasId:"+dto.getNasId());
	     		    hotspot = jdbcTemplate.queryForObject("select * from prm_wlan_hotspot where NAS_ID =?",rowMapper,dto.getNasId());
	                System.out.println("热点已经存在");
	     		}catch(EmptyResultDataAccessException eh){
	     			System.out.println("归属热点没有在系统中查找到");
	                importMsg.appendMessage(getFailureMsg("归属热点没有在系统中查找到",dto.getRow()));
	                importMsg.countFail();
	                continue;	                 
	     		}
	     		System.out.println("获取hotspot完成");		       
	            boolean isUpdate = false; //默认操作是新增		
	            AP ap;
	    		RowMapper<AP> apType=new BeanPropertyRowMapper<AP>(AP.class);
	    		try{
	    			ap = jdbcTemplate.queryForObject("select DEVICE_ID,SYS_NAME,DEVICE_TYPE,MODEL,ALIAS,IP_ADDR,MAC_ADDR,CITY,DISTRICT,SERIAL_NUMBER,SYS_VERSION,PROJECT_STATUS,AUDIT_STATUS,AUDIT_DATE,AUDIT_FIN_DATE,MANAGE_STATUS from prm_device where mac_addr = ?",apType,dto.getMacAddr().trim());
	    			isUpdate = true;
	    			System.out.println("Ap存在将执行更新操作");
	    		}catch(EmptyResultDataAccessException eh){
	    			ap = new AP();
	                ap.setDEVICE_ID(IdUtils.GeneratorUUID());
	                System.out.println("Ap不存在将执行新增操作");
	    		}
	    		Vendor vendor;
	            RowMapper<Vendor> vendorType=new BeanPropertyRowMapper<Vendor>(Vendor.class);
	            try{
	            	vendor = jdbcTemplate.queryForObject("select * from res.RM_VENDOR where NAME_CN =?",vendorType,dto.getVendor());
	                System.out.println("交换机Vendor：" +dto.getVendor() );
	            	
	            }catch(EmptyResultDataAccessException em){
	            	System.out.println("[" + dto.getVendor() + "]没有在设备厂商数据字典中查找到");
	                importMsg.appendMessage(getFailureMsg("[" + dto.getVendor() + "]没有在设备厂商数据字典中查找到", dto.getRow()));
	                importMsg.countFail();
	                continue;
	            }
	            ap.setVendor(vendor);
	            if (StringUtils.isNotBlank(dto.getSwitchName())) {
	            	try{
		            RowMapper<Switch> swType=new BeanPropertyRowMapper<Switch>(Switch.class);
		            Switch sw;
	            	sw=jdbcTemplate.queryForObject("SELECT T1.DEVICE_ID,T1.SYS_NAME,T1.DEVICE_TYPE,T1.MODEL,T1.ALIAS,T1.IP_ADDR,T1.MAC_ADDR,T1.CITY,T1.DISTRICT,T1.SERIAL_NUMBER,T1.SHELF_LOCATION,T1.READ_COMMUNITY,T1.WRITE_COMMUNITY,T1.SYS_VERSION,T1.PROJECT_STATUS,T1.AUDIT_STATUS,T1.AUDIT_DATE,T1.AUDIT_FIN_DATE,T1.MANAGE_STATUS,T1.DEVICE_LEVEL,T1.SERVICE_SYSTEM,T2.LOCATION,T2.SWITCH_LEVEL,T3.NAME AS RM_VENDOR_NAME,T3.NAME_CN AS RM_VENDOR_NAME_CN, T4.HOTSPOT_ID,T4.HOTSPOT_NAME,T4.NAS_ID  FROM PRM_DEVICE T1,PRM_DEVICE_SWITCH T2,RM_VENDOR T3,PRM_WLAN_HOTSPOT T4 WHERE T1.DEVICE_ID = T2.DEVICE_ID AND T1.VENDOR = T3.NAME(+) AND T2.HOTSPOT_ID = T4.HOTSPOT_ID AND T1.DEVICE_TYPE = 'SWITCH' AND T2.HOTSPOT_ID= ? AND T1.SYS_NAME = ?",swType,hotspot.getHOTSPOT_ID(),dto.getSwitchName());
	            	ap.setSw(sw);
	                System.out.println("AP 交换机存在");
	            	}catch(Exception e){
	            		System.out.println("AP 交换机bu存在");
	            		e.printStackTrace();
	            	}
	            }
	            ap.setHotspot(hotspot);
	            ap.setCITY(hotspot.getCity());
	            ap.setDISTRICT(hotspot.getDistrict());
	            ap.setSYS_NAME(dto.getSysName());
	            ap.setALIAS(dto.getAlias());
	            ap.setMAC_ADDR(dto.getMacAddr());
	            ap.setIP_ADDR(dto.getIpAddr());
	            ap.setSYS_VERSION(dto.getSysVersion());
	            ap.setDUAL_CARD(dto.getDualCard());
	            ap.setMODEL(dto.getModel());
	            ap.setCOVERAGE_MODE(dto.getCoverageMode());
	            ap.setCOMBINE_MODE(dto.getCombineMode());
	            ap.setCOVERAGE_SCOPE(dto.getCoverageScope());
	            ap.setCHANNEL(dto.getChannel());
	            ap.setLOCATION(dto.getLocation());
	            ap.setENTRY_STAFF(dto.getEntryStaff());
	            String swId;
	            try{
	                swId=ap.getSw().getDEVICE_ID();
	            }catch(NullPointerException en){
	            	swId=null;
	            }
	            try {
	                if (!isUpdate) {
	                	 jdbcTemplate.update("insert into prm_device (device_id,sys_name,alias,city,district,ip_addr,mac_addr,serial_number,sys_version,vendor,device_type,model,entry_staff,entry_date,AUDIT_STATUS,SERVICE_SYSTEM,DEVICE_LEVEL)values(?,?,?,?,?,?,?,?,?,?,'FIT_AP',?,?,sysdate,0,'WLAN','接入层')"
	                			 ,ap.getDEVICE_ID(),ap.getSYS_NAME(),ap.getALIAS(),ap.getCITY(),ap.getDISTRICT(),ap.getIP_ADDR(),ap.getMAC_ADDR()
	                			 ,ap.getSERIAL_NUMBER(),ap.getSYS_VERSION(),ap.getVendor().getName(),ap.getMODEL(),ap.getENTRY_STAFF());
	                	 jdbcTemplate.update("insert into RES.PRM_DEVICE_AP(DEVICE_ID,HOTSPOT_ID,COVERAGE_SCOPE,SWITCH_ID,COVERAGE_MODE,LOCATION,DUAL_CARD,CHANNEL,COMBINE_MODE)values(?,?,?,?,?,?,?,?,?)"
	                	 		,ap.getDEVICE_ID(),ap.getHotspot().getHOTSPOT_ID(),ap.getCOVERAGE_SCOPE(),swId
	                	 		,ap.getCOVERAGE_MODE(),ap.getLOCATION(),ap.getDUAL_CARD(),ap.getCHANNEL(),ap.getCOMBINE_MODE());
	                	 System.out.println("AP录入，DEVICE_ID = "+ap.getDEVICE_ID());
	                } else {
		         	       String sql="";
		        	       Util util;
		        	       List<UpdateSql> listu;
		        	       sql="update RES.prm_device set ";
		               	   util=new Util();
		               	   listu=new ArrayList<UpdateSql>();
		               	   listu.add(util.getUpdateSql("sys_name",ap.getSYS_NAME(), "VARCHAR"));
		               	   listu.add(util.getUpdateSql("alias",ap.getALIAS(), "VARCHAR"));
		               	   listu.add(util.getUpdateSql("city",ap.getCITY(), "VARCHAR"));
		               	   listu.add(util.getUpdateSql("district",ap.getDISTRICT(), "VARCHAR"));
		               	   listu.add(util.getUpdateSql("SYS_VERSION",ap.getSYS_VERSION(), "VARCHAR"));
		               	   listu.add(util.getUpdateSql("vendor",ap.getVendor().getName(), "VARCHAR"));
		               	   listu.add(util.getUpdateSql("model",ap.getMODEL(), "VARCHAR"));
		               	   listu.add(util.getUpdateSql("ip_addr",ap.getIP_ADDR(), "VARCHAR"));
		               	   listu.add(util.getUpdateSql("MAC_ADDR",ap.getMAC_ADDR(), "VARCHAR"));
		               	   listu.add(util.getUpdateSql("entry_staff",ap.getENTRY_STAFF(), "VARCHAR"));
		               	   listu.add(util.getUpdateSql("serial_number",ap.getSERIAL_NUMBER(), "VARCHAR"));
		               	   sql=util.getUpdate(sql, listu);
		               	   sql+=",ENTRY_DATE=sysdate,AUDIT_STATUS=0 where device_id = ?";
		               	   System.out.println(sql);
		               	   jdbcTemplate.update(sql,ap.getDEVICE_ID());	     
		        	       sql="update RES.PRM_DEVICE_AP set ";
		               	   util=new Util();
		               	   listu=new ArrayList<UpdateSql>();
		                   listu.add(util.getUpdateSql("HOTSPOT_ID",ap.getHotspot().getHOTSPOT_ID(), "VARCHAR"));
		                   listu.add(util.getUpdateSql("COVERAGE_SCOPE",ap.getCOVERAGE_SCOPE(), "VARCHAR"));
		                   listu.add(util.getUpdateSql("SWITCH_ID",ap.getSWITCH_ID(), "VARCHAR"));
		                   listu.add(util.getUpdateSql("COVERAGE_MODE",ap.getCOVERAGE_MODE(), "VARCHAR"));
		                   listu.add(util.getUpdateSql("LOCATION",ap.getLOCATION(), "VARCHAR"));
		                   listu.add(util.getUpdateSql("DUAL_CARD",ap.getDUAL_CARD(), "VARCHAR"));
		                   listu.add(util.getUpdateSql("CHANNEL",ap.getCHANNEL(), "VARCHAR"));
		                   listu.add(util.getUpdateSql("COMBINE_MODE",ap.getCOMBINE_MODE(), "VARCHAR"));
		               	   sql=util.getUpdate(sql, listu);
		               	   sql+=" where DEVICE_ID = ?";
		               	   System.out.println(sql);
		               	   int n=jdbcTemplate.update(sql,ap.getDEVICE_ID());
		               	   System.out.println("AP 跟新了 "+n+"行，DEVICE_ID = "+ap.getDEVICE_ID());
	                }
	            } catch (Exception e) {
	            	e.printStackTrace();
	                importMsg.appendMessage(getFailureMsg("数据入库发生异常",dto.getRow()));
	                importMsg.countFail();
	                continue;
	            }		
	            ap = null;
	            importMsg.countSuccess();
	        }
			return importMsg;
	 }
}
