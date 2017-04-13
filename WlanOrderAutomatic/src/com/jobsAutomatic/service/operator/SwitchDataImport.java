package com.jobsAutomatic.service.operator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.jobsAutomatic.service.modle.SwitchDto;
import com.jobsAutomatic.service.modle.UpdateSql;
import com.jobsAutomatic.service.modle.Vendor;
import com.jobsAutomatic.service.modle.old.Hotspot;
import com.jobsAutomatic.service.modle.old.Switch;
import com.jobsAutomatic.service.readExcle.ImportMsg;
import com.jobsAutomatic.service.util.IdUtils;
import com.jobsAutomatic.service.util.Util;




public class SwitchDataImport extends DBOperator{
	 public ImportMsg saveImportData(List<SwitchDto> switches,ImportMsg importMsg) {
		  for (int i = 0; i < switches.size(); i++) {
	            SwitchDto dto = switches.get(i);
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
	            RowMapper<Switch> swType=new BeanPropertyRowMapper<Switch>(Switch.class);
	            Switch sw;
	            try{
	            	System.out.println("dto.getIpAddr():"+dto.getIpAddr());
	            	sw=jdbcTemplate.queryForObject("SELECT T1.DEVICE_ID,T1.SYS_NAME,T1.DEVICE_TYPE,T1.MODEL,T1.ALIAS,T1.IP_ADDR,T1.MAC_ADDR,T1.CITY,T1.DISTRICT,T1.SERIAL_NUMBER,T1.SHELF_LOCATION,T1.READ_COMMUNITY,T1.WRITE_COMMUNITY,T1.SYS_VERSION,T1.PROJECT_STATUS,T1.AUDIT_STATUS,T1.AUDIT_DATE,T1.AUDIT_FIN_DATE,T1.MANAGE_STATUS,T1.DEVICE_LEVEL,T1.SERVICE_SYSTEM,T2.LOCATION,T2.SWITCH_LEVEL,T3.NAME AS RM_VENDOR_NAME,T3.NAME_CN AS RM_VENDOR_NAME_CN, T4.HOTSPOT_ID,T4.HOTSPOT_NAME,T4.NAS_ID  FROM PRM_DEVICE T1,PRM_DEVICE_SWITCH T2,RM_VENDOR T3,PRM_WLAN_HOTSPOT T4 WHERE T1.DEVICE_ID = T2.DEVICE_ID AND T1.VENDOR = T3.NAME(+) AND T2.HOTSPOT_ID = T4.HOTSPOT_ID AND T1.DEVICE_TYPE = 'SWITCH' AND T1.IP_ADDR= ?",swType,dto.getIpAddr());
	            	isUpdate = true;
	            	System.out.println("交换机操作为更新");
	            }catch(EmptyResultDataAccessException em){
	                sw = new Switch();
	                sw.setDEVICE_ID(IdUtils.GeneratorUUID());
	                System.out.println("交换机操作为新增");
	            }
	            
	            sw.setHotspot(hotspot);
	            sw.setCITY(hotspot.getCity());
	            sw.setDISTRICT(hotspot.getDistrict());
	            sw.setSYS_NAME(dto.getSysName());
	            sw.setALIAS(dto.getAlias());
	            sw.setIP_ADDR(dto.getIpAddr());
	            sw.setSWITCH_LEVEL(dto.getSwitchLevel());
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

	            sw.setVendor(vendor);
	            sw.setMODEL(dto.getModel());
	            sw.setREAD_COMMUNITY(dto.getReadCommunity());
	            sw.setWRITE_COMMUNITY(dto.getWriteCommunity());
	            sw.setENTRY_STAFF(dto.getEntryStaff());
	            sw.setLOCATION(dto.getLocation());
	            
	            try {
	                if (!isUpdate) {
	                	 jdbcTemplate.update("insert into prm_device (device_id,sys_name,alias,city,district,ip_addr,mac_addr,serial_number,vendor,device_type,model,entry_staff,entry_date,shelf_location,READ_COMMUNITY,WRITE_COMMUNITY,AUDIT_STATUS,SERVICE_SYSTEM,DEVICE_LEVEL)values(?,?,?,?,?,?,?,?,?,'SWITCH',?,?,sysdate,?,?,?,1,'WLAN','接入层')" ,sw.getDEVICE_ID(),sw.getSYS_NAME(),sw.getALIAS(),sw.getCITY(),sw.getDISTRICT(),sw.getIP_ADDR(),sw.getMAC_ADDR(),sw.getSERIAL_NUMBER(),sw.getVendor().getName(),sw.getMODEL(),sw.getENTRY_STAFF(),sw.getSHELF_LOCATION(),sw.getREAD_COMMUNITY(),sw.getWRITE_COMMUNITY());
	                	 jdbcTemplate.update("INSERT INTO PRM_DEVICE_SWITCH(DEVICE_ID,HOTSPOT_ID,SWITCH_LEVEL,LOCATION)values(?,?,?,?)",sw.getDEVICE_ID(),sw.getHotspot().getHOTSPOT_ID(),sw.getSWITCH_LEVEL(),sw.getLOCATION());
	                	 System.out.println("交换机数据新增操作完成");
	                } else {
	         	       String sql="";
	        	       Util util;
	        	       List<UpdateSql> listu;
	        	       sql="update RES.prm_device set ";
	               	   util=new Util();
	               	   listu=new ArrayList<UpdateSql>();
	               	   listu.add(util.getUpdateSql("sys_name",sw.getSYS_NAME(), "VARCHAR"));
	               	   listu.add(util.getUpdateSql("alias",sw.getALIAS(), "VARCHAR"));
	               	   listu.add(util.getUpdateSql("city",sw.getCITY(), "VARCHAR"));
	               	   listu.add(util.getUpdateSql("district",sw.getDISTRICT(), "VARCHAR"));
	               	   listu.add(util.getUpdateSql("serial_number",sw.getSERIAL_NUMBER(), "VARCHAR"));
	               	   listu.add(util.getUpdateSql("vendor",sw.getVendor().getName(), "VARCHAR"));
	               	   listu.add(util.getUpdateSql("model",sw.getMODEL(), "VARCHAR"));
	               	   listu.add(util.getUpdateSql("ip_addr",sw.getIP_ADDR(), "VARCHAR"));
	               	   listu.add(util.getUpdateSql("MAC_ADDR",sw.getMAC_ADDR(), "VARCHAR"));
	               	   listu.add(util.getUpdateSql("SHELF_LOCATION",sw.getSHELF_LOCATION(), "VARCHAR"));
	               	   listu.add(util.getUpdateSql("entry_staff",sw.getENTRY_STAFF(), "VARCHAR"));
	               	   listu.add(util.getUpdateSql("READ_COMMUNITY",sw.getREAD_COMMUNITY(), "VARCHAR"));
	               	   listu.add(util.getUpdateSql("WRITE_COMMUNITY",sw.getWRITE_COMMUNITY(), "VARCHAR"));
	               	   sql=util.getUpdate(sql, listu);
	               	   sql+=",ENTRY_DATE=sysdate,AUDIT_STATUS=1 where device_id = ?";
	                   jdbcTemplate.update(sql,sw.getDEVICE_ID());	                	
	        	       sql="update RES.PRM_DEVICE_SWITCH set ";
	               	   util=new Util();
	               	   listu=new ArrayList<UpdateSql>();
	               	   listu.add(util.getUpdateSql("HOTSPOT_ID",sw.getHotspot().getHOTSPOT_ID(), "VARCHAR"));
	               	   listu.add(util.getUpdateSql("SWITCH_LEVEL",sw.getSWITCH_LEVEL(), "VARCHAR"));
	               	   listu.add(util.getUpdateSql("LOCATION",sw.getLOCATION(), "VARCHAR"));
	               	   sql=util.getUpdate(sql, listu);
	               	   sql+=" where device_id = ?";
	               	   System.out.println("sql:"+sql);
	                   jdbcTemplate.update(sql,sw.getDEVICE_ID());
	                   System.out.println("交换机数据更新完成");
	                }
	            } catch (Exception e) {
	            	e.printStackTrace();
	                importMsg.appendMessage(getFailureMsg("数据入库发生异常",dto.getRow()));
	                importMsg.countFail();
	                continue;
	            }
	            sw = null;
	            importMsg.countSuccess(); //累加导入成功记录数  		
		  }
		return importMsg;
	 }
}

