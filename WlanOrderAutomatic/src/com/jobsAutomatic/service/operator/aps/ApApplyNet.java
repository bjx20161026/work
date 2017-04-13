package com.jobsAutomatic.service.operator.aps;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ApApplyNet {
	public void ApplyNet(String mac_addr){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.36:1521:ipnet");
		dataSource.setUsername("rm");
		dataSource.setPassword("SHrm!23$");
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
//		jdbcTemplate.update("update prm_wlan_hotspot@RES set audit_status = 1,ENTRY_DATE=sysdate,MANAGE_STATUS=1,PROJECT_STATUS=2 where hotspot_id = ?",hotspotid);
		jdbcTemplate.update("update prm_device@RES set audit_status = 1,ENTRY_DATE=sysdate,MANAGE_STATUS=1,PROJECT_STATUS=2 where mac_addr = ?",mac_addr);
//		jdbcTemplate.update("update prm_device@RES set audit_status = 1,ENTRY_DATE=sysdate,MANAGE_STATUS=1,PROJECT_STATUS=2 where device_id in (select device_id from prm_device_switch@RES where hotspot_id = ?)",hotspotid);
//		String sql="call SP_VERIFY_AP_HOTSPOT('"+hotspotid+"')";
//		jdbcTemplate.execute(sql);
	}
}
