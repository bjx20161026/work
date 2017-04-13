package com.jobsAutomatic.service.operator.aps;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ApReviewNet {
	/*�������ͨ��
	 * 
	 */
	public void ReviewPassed(String mac_addr){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.39:1521:ipnet");
		dataSource.setUsername("res");
		dataSource.setPassword("SHres!23$");
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
//		jdbcTemplate.update("insert into PRM_AUDIT_LOG(AUDITOR,AUDIT_TIME,CITY,DETAIL,TARGET_TYPE,HOTSPOT_ID,AUDIT_STATUS)values(?,sysdate,'��������',?,2,?,3)",auditor,detail,hotspotid);
//		jdbcTemplate.update("update prm_wlan_hotspot set audit_status = 3,ENTRY_DATE=sysdate,AUDIT_DATE=sysdate,AUDIT_FIN_DATE=sysdate,MANAGE_STATUS=2,PROJECT_STATUS=1 where hotspot_id=?",hotspotid);
//		jdbcTemplate.update("update prm_device set audit_status = 3,ENTRY_DATE=sysdate,MANAGE_STATUS=1,PROJECT_STATUS=2 where mac_addr = ?",mac_addr);
		jdbcTemplate.update("update prm_device set audit_status = 3,ENTRY_DATE=sysdate,AUDIT_DATE=sysdate,AUDIT_FIN_DATE=sysdate,MANAGE_STATUS=2,PROJECT_STATUS=1 where mac_addr = ? and audit_status != 3",mac_addr);

//		jdbcTemplate.update("update prm_device set audit_status = 3,ENTRY_DATE=sysdate,AUDIT_DATE=sysdate,AUDIT_FIN_DATE=sysdate,MANAGE_STATUS=2,PROJECT_STATUS=1 where device_id in(select device_id from prm_device_switch where hotspot_id = ?) and audit_status != 3",hotspotid);
	}
	
	public void ReviewNotPassed(String mac_addr){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.39:1521:ipnet");
		dataSource.setUsername("res");
		dataSource.setPassword("SHres!23$");
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
//		jdbcTemplate.update("insert into PRM_AUDIT_LOG(AUDITOR,AUDIT_TIME,CITY,DETAIL,TARGET_TYPE,HOTSPOT_ID,AUDIT_STATUS)values(?,sysdate,'��������',?,2,?,4)",auditor,detail,hotspotid);
//		jdbcTemplate.update("update prm_wlan_hotspot set audit_status = 4,ENTRY_DATE=sysdate,AUDIT_DATE=sysdate where hotspot_id=?",hotspotid);
		jdbcTemplate.update("update prm_device set audit_status = 4,ENTRY_DATE=sysdate,AUDIT_DATE=sysdate,AUDIT_FIN_DATE=sysdate,MANAGE_STATUS=2,PROJECT_STATUS=1 where mac_addr = ? and audit_status != 3",mac_addr);
//		jdbcTemplate.update("update prm_device set audit_status = 4,ENTRY_DATE=sysdate,AUDIT_DATE=sysdate where device_id in(select device_id from prm_device_switch where hotspot_id = ?)",hotspotid);
	}
}
