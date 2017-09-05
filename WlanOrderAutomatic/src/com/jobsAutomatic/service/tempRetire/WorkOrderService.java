package com.jobsAutomatic.service.tempRetire;

import java.util.concurrent.DelayQueue;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class WorkOrderService {
	 @Resource 
	JdbcTemplate jdbcTemplate;
	
	
	@PostConstruct
	public synchronized void init(){
		QueueMaker.setQueue(new DelayQueue<RetireTask>());
		QueueMaker.setJdbcTemplate(jdbcTemplate);
		QueueMaker.init();
		System.out.println("doWorkHandle... ...");
		new WorkShedual(jdbcTemplate);
	}
	
	public static void main(String[] args) throws Exception{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.39:1521:ipnet");
		dataSource.setUsername("res");
		dataSource.setPassword("SHres!23$");
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		QueueMaker.setQueue(new DelayQueue<RetireTask>());
		QueueMaker.setJdbcTemplate(jdbcTemplate);
		QueueMaker.init();
		new WorkShedual(jdbcTemplate);
	}
}
