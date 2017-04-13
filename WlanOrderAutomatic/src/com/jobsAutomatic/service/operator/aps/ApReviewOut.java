package com.jobsAutomatic.service.operator.aps;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ApReviewOut {

		public void ReviewOutPassed(String ip){
			DriverManagerDataSource dataSource=new DriverManagerDataSource();
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@10.221.18.39:1521:ipnet");
			dataSource.setUsername("res");
			dataSource.setPassword("SHres!23$");
			JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
			String deviceid=jdbcTemplate.queryForObject("select device_id from prm_device where ip_addr = ?",java.lang.String.class,ip);
			String sql="call SP_PROCESS_AUDIT_REQUEST('"+deviceid+"',1)";
			jdbcTemplate.execute(sql);
		}
	
		public void ReviewOutNotPassed(String ip){
			DriverManagerDataSource dataSource=new DriverManagerDataSource();
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@10.221.18.39:1521:ipnet");
			dataSource.setUsername("res");
			dataSource.setPassword("SHres!23$");
			JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
			jdbcTemplate.update("update prm_device set audit_status = 6,ENTRY_DATE=sysdate where ip_addr = ?",ip);
		}
	}
