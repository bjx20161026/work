package com.jobsAutomatic.service.tempRetire;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.jobsAutomatic.service.modle.OrdrWithFile;
import com.jobsAutomatic.service.modle.WorkOrder;
import com.jobsAutomatic.service.tempRetire.task.OrderWithFileTask;
import com.jobsAutomatic.service.tempRetire.task.TempRetireTask;

public class WorkOrderHandle implements Runnable {
	Logger logger = Logger.getLogger(WorkOrderHandle.class);
	private JdbcTemplate jdbcTemplate;

	public WorkOrderHandle(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("开始处理文件");
		try {
			RowMapper<OrdrWithFile> rowMapper = new BeanPropertyRowMapper<OrdrWithFile>(OrdrWithFile.class);
			List<OrdrWithFile> ordrWithFiles = jdbcTemplate
					.query("select * from work_order_file where flag = 0 and opreate_date > sysdate - 2", rowMapper);
			for (OrdrWithFile ordrWithFile : ordrWithFiles) {
				OrderWithFileTask orderWithFileTask = new OrderWithFileTask();
				orderWithFileTask.setJdbcTemplate(jdbcTemplate);
				orderWithFileTask.setXmlText(ordrWithFile.getXmltext());
				orderWithFileTask.HandleTask();
				jdbcTemplate.update("update work_order_file set flag = 1 where uuid = ?", ordrWithFile.getUuid());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("开始处理待临时退服工单");
		try {
			RowMapper<WorkOrder> rowMapper = new BeanPropertyRowMapper<WorkOrder>(WorkOrder.class);
			List<WorkOrder> workOrders = jdbcTemplate
					.query("Select * from work_order where statement='待处理' and workjob_type = '临时退服'", rowMapper);
			for (WorkOrder workOrder : workOrders) {
				TempRetireTask tempRetireTask = new TempRetireTask();
				tempRetireTask.setJdbcTemplate(jdbcTemplate);
				tempRetireTask.setWorkOrder(workOrder);
				tempRetireTask.HandleTask();
				logger.info("临时退服工单号：" + workOrder.getWorkjob_id());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
