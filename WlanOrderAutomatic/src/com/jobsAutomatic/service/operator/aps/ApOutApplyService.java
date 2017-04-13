package com.jobsAutomatic.service.operator.aps;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ApOutApplyService {
	private ApOutApply apOutApply;
	public void OutApplytService(String WorkOrderId){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.39:1521:ipnet");
		dataSource.setUsername("res");
		dataSource.setPassword("SHres!23$");
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String include=jdbcTemplate.queryForObject("select include from work_order where workjob_id =?",java.lang.String.class,WorkOrderId);
		String[] ips = include.split(",");
		for(String ip:ips){
			System.out.println("ip:"+ip);
			apOutApply =new ApOutApply();
			apOutApply.OutApply(ip);
		}
		jdbcTemplate.update("update work_order set statement='退服申请完成，待退服审核' where workjob_id = ?",WorkOrderId);
	}
}
