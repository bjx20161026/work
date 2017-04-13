package com.jobsAutomatic.service.operator.aps;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ApReviewNetService {
	private ApReviewNet apReviewNet;
	public void ReviewNetService(String WorkOrderId){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.39:1521:ipnet");
		dataSource.setUsername("res");
		dataSource.setPassword("SHres!23$");
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String include=jdbcTemplate.queryForObject("select include from work_order where workjob_id =?",java.lang.String.class,WorkOrderId);
		String[] mac_addrs = include.split(",");
		for(String mac_addr:mac_addrs){
			System.out.println("mac_addr:"+mac_addr);
			apReviewNet =new ApReviewNet();
			apReviewNet.ReviewPassed(mac_addr);
		}
		jdbcTemplate.update("update work_order set statement='入网审核完成，待校验' where workjob_id = ?",WorkOrderId);
	}
}
