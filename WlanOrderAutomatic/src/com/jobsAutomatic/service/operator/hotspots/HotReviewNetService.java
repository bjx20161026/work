package com.jobsAutomatic.service.operator.hotspots;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class HotReviewNetService {
	private HotReviewNet HotReviewNet;
	public void ReviewNetService(String WorkOrderId){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.39:1521:ipnet");
		dataSource.setUsername("res");
		dataSource.setPassword("SHres!23$");
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String include=jdbcTemplate.queryForObject("select include from work_order where workjob_id =?",java.lang.String.class,WorkOrderId);
		String[] nasIds = include.split(",");
		for(String nasId:nasIds){
			System.out.println("nasId:"+nasId);
			String hotspotid=jdbcTemplate.queryForObject("select hotspot_id from prm_wlan_hotspot where NAS_ID =?",java.lang.String.class,nasId);
			System.out.println("hotspotid:"+hotspotid);
			HotReviewNet =new HotReviewNet();
			HotReviewNet.ReviewPassed(hotspotid, "测试", "200000");
		}
		jdbcTemplate.update("update work_order set statement='入网审核完成，待现网校验' where workjob_id = ?",WorkOrderId);
	}
}
