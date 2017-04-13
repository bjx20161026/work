package com.jobsAutomatic.service.tempRetire;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.jdbc.core.JdbcTemplate;

public class WorkShedual {
	public WorkShedual(JdbcTemplate jdbcTemplate){
		WorkOrderHandle workOrderHandle=new WorkOrderHandle(jdbcTemplate);
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(workOrderHandle, 1,60, TimeUnit.SECONDS);
	}
}
