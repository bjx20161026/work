package com.jobsAutomatic.service.operator.aps;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ApApplyNetService {
	private ApApplyNet apApplyNet;
	public void ApplyNetService(String WorkOrderId){
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
			apApplyNet =new ApApplyNet();
			apApplyNet.ApplyNet(mac_addr);
		}
		jdbcTemplate.update("update work_order set statement='入网申请完成，待入网审核' where workjob_id = ?",WorkOrderId);
	}
} 
