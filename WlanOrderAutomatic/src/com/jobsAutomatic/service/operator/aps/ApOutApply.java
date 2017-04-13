package com.jobsAutomatic.service.operator.aps;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ApOutApply {
	public void OutApply(String ip_addr){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.39:1521:ipnet");
		dataSource.setUsername("res");
		dataSource.setPassword("SHres!23$");
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
//		jdbcTemplate.update("insert into RES.PRM_AUDIT_REQUEST (REQ_NO, REQ_TYPE, TARGET_TYPE, OBJECT_ID, EMP_NO, REQ_TIME, REQ_CAUSE, ATTACHMENT, STATUS ) values (null, 2, 2, ?, '20000000', sysdate, ?, ?, 0)",hotspotid,"����",null);
//		jdbcTemplate.update("update prm_wlan_hotspot set audit_status = 5,ENTRY_DATE=sysdate WHERE hotspot_id = ? ",hotspotid);
		jdbcTemplate.update("update prm_device set audit_status = 5,ENTRY_DATE=sysdate where device_id in ( select device_id from prm_device where ip_addr = ? )",ip_addr);
//		jdbcTemplate.update("update prm_device set audit_status = 5,ENTRY_DATE=sysdate where device_id in ( select device_id from prm_device_switch WHERE hotspot_id = ?  )",hotspotid);
	}
}
