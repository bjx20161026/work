package com.jobsAutomatic.service.operator.hotspots;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;
@Service
public class HotApplyNet {
	JdbcTemplate jdbcTemplate2;
	public JdbcTemplate getJdbcTemplate2() {
		return jdbcTemplate2;
	}
	public void setJdbcTemplate2(JdbcTemplate jdbcTemplate2) {
		this.jdbcTemplate2 = jdbcTemplate2;
	}
	public void ApplyNet(String hotspotid) throws Exception{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.36:1521:ipnet");
		dataSource.setUsername("rm");
		dataSource.setPassword("SHrm!23$");
	    jdbcTemplate2=new JdbcTemplate(dataSource);
		jdbcTemplate2.update("update prm_wlan_hotspot@RES set audit_status = 1,ENTRY_DATE=sysdate,MANAGE_STATUS=1,PROJECT_STATUS=2 where hotspot_id = ?",hotspotid);
		jdbcTemplate2.update("update prm_device@RES set audit_status = 1,ENTRY_DATE=sysdate,MANAGE_STATUS=1,PROJECT_STATUS=2 where device_id in (select device_id from prm_device_ap@RES where hotspot_id = ? )",hotspotid);
		jdbcTemplate2.update("update prm_device@RES set audit_status = 1,ENTRY_DATE=sysdate,MANAGE_STATUS=1,PROJECT_STATUS=2 where device_id in (select device_id from prm_device_switch@RES where hotspot_id = ?)",hotspotid);
		String sql="call SP_VERIFY_AP_HOTSPOT('"+hotspotid+"')";
		jdbcTemplate2.execute(sql);
	}
}
