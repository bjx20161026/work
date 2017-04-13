package com.jobsAutomatic.service.operator.hotspots;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;
@Service
public class HotApplyNetService{
	
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	private HotApplyNet hotApplyNet;
	public void ApplyNetService(String WorkOrderId) throws Exception{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.39:1521:ipnet");
		dataSource.setUsername("res");
		dataSource.setPassword("SHres!23$");
	    jdbcTemplate=new JdbcTemplate(dataSource);
		String include=jdbcTemplate.queryForObject("select include from work_order where workjob_id =?",java.lang.String.class,WorkOrderId);
		String[] nasIds = include.split(",");
		for(String nasId:nasIds){
			System.out.println("nasId:"+nasId);
			String hotspotid=jdbcTemplate.queryForObject("select hotspot_id from prm_wlan_hotspot where NAS_ID =?",java.lang.String.class,nasId);
			System.out.println("hotspotid:"+hotspotid);
			hotApplyNet =new HotApplyNet();
			hotApplyNet.ApplyNet(hotspotid);
		}
		jdbcTemplate.update("update work_order set statement='入网申请完成，待入网审核' where workjob_id = ?",WorkOrderId);
	}
}
