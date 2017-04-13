package com.jobsAutomatic.service.tempRetire;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jobsAutomatic.service.modle.WorkOrder;
import com.jobsAutomatic.service.tempRetire.task.ApImportTask;
import com.jobsAutomatic.service.tempRetire.task.ApOutTask;
import com.jobsAutomatic.service.tempRetire.task.HotChangeTask;
import com.jobsAutomatic.service.tempRetire.task.HotImportTask;
import com.jobsAutomatic.service.tempRetire.task.HotOutTask;

public class OrderClassify {
	
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	Logger logger = Logger.getLogger(OrderClassify.class);

	/*
	 * return number of successful insertion
	 */
	public int DoClassify(List<WorkOrder> workOrders) {
		int i = 0;
		for (WorkOrder workOrder : workOrders) {
			try {
				if (workOrder.getWorkjob_type().equals("热点导入")) {
					HotImportTask hotImportTask = new HotImportTask();
					hotImportTask.setJdbcTemplate(jdbcTemplate);
					hotImportTask.setWorkOrder(workOrder);
					hotImportTask.HandleTask();
				} else if (workOrder.getWorkjob_type().equals("热点退服")) {
					HotOutTask hotOutTask = new HotOutTask();
					hotOutTask.setJdbcTemplate(jdbcTemplate);
					hotOutTask.setWorkOrder(workOrder);
					hotOutTask.HandleTask();
				} else if (workOrder.getWorkjob_type().equals("热点变更")) {
					HotChangeTask hotChangeTask = new HotChangeTask();
					hotChangeTask.setJdbcTemplate(jdbcTemplate);
					hotChangeTask.setWorkOrder(workOrder);
					hotChangeTask.HandleTask();
				} else if (workOrder.getWorkjob_type().equals("AP入网")) {
					ApImportTask apImportTask = new ApImportTask();
					apImportTask.setJdbcTemplate(jdbcTemplate);
					apImportTask.setWorkOrder(workOrder);
					apImportTask.HandleTask();
				} else if (workOrder.getWorkjob_type().equals("AP变更")) {
					ApOutTask apOutTask = new ApOutTask();
					apOutTask.setJdbcTemplate(jdbcTemplate);
					apOutTask.setWorkOrder(workOrder);
					apOutTask.HandleTask();
				}
				i++;
			} catch (Exception e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		return i;
	}
}
