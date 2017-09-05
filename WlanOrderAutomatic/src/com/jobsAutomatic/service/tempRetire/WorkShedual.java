package com.jobsAutomatic.service.tempRetire;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.jdbc.core.JdbcTemplate;

public class WorkShedual {
	public WorkShedual(JdbcTemplate jdbcTemplate){
		WorkOrderHandle workOrderHandle=new WorkOrderHandle(jdbcTemplate);
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(workOrderHandle, 1,60, TimeUnit.SECONDS);
		List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from temp_task");
		for(Map map:list){
			new QueuePut((Date)map.get("STARTDATE"), (Date)map.get("ENDDATE"), (String)map.get("HOTSTPOTID"),((BigDecimal) map.get("PROJECTSTATUS")).intValue(),(String) map.get("WORKJOB_ID"));
		}
	}
}
