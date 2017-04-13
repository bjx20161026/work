package com.jobsAutomatic.service.operator.hotspots;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
/*�������ͨ��
 * 
 */
public class HotReviewOut {
	public void ReviewOutPassed(String hotspotid){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.39:1521:ipnet");
		dataSource.setUsername("res");
		dataSource.setPassword("SHres!23$");
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="call SP_PROCESS_AUDIT_REQUEST('"+hotspotid+"',2)";
		jdbcTemplate.execute(sql);
	}
	
	public void ReviewOutNotPassed(String hotspotid){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.39:1521:ipnet");
		dataSource.setUsername("res");
		dataSource.setPassword("SHres!23$");
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.update("update prm_wlan_hotspot set audit_status = 6,ENTRY_DATE=sysdate WHERE hotspot_id = ? ",hotspotid);
		jdbcTemplate.update("update prm_device set audit_status = 6,ENTRY_DATE=sysdate where device_id in ( select device_id from prm_device_ap WHERE hotspot_id = ? )",hotspotid);
		jdbcTemplate.update("update prm_device set audit_status = 6,ENTRY_DATE=sysdate where device_id in ( select device_id from prm_device_switch WHERE hotspot_id = ?  )",hotspotid);
	}
}
