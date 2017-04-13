package com.jobsAutomatic.service.tempRetire.task;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jobsAutomatic.dao.OperateWorkOrder;
import com.jobsAutomatic.service.Sender.Receipt;
import com.jobsAutomatic.service.modle.WorkOrder;

public abstract class ATask {
	Logger logger = Logger.getLogger(ATask.class);
//	@Autowired
	OperateWorkOrder updateWorkOrder = new OperateWorkOrder();
	public JdbcTemplate jdbcTemplate;
	public WorkOrder workOrder;
	public String result;

	public abstract void HandleTask() throws Exception;

	public WorkOrder getWorkOrder() {
		return workOrder;
	}

	public void setWorkOrder(WorkOrder workOrder) {
		this.workOrder = workOrder;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void SendSuccess() {
		result = new Receipt().SendReceipt(workOrder.getWorkjob_id(), "成功", "");
		updateWorkOrder.setJdbcTemplate(jdbcTemplate);
		if (result.equals("0"))
			updateWorkOrder.Update("处理完成", 1, "", workOrder.getWorkjob_id());
		else
			updateWorkOrder.Update("回单失败", 2, result, workOrder.getWorkjob_id());
	}
	public void Sendfailure(String failReason){
		result = new Receipt().SendReceipt(workOrder.getWorkjob_id(), "失败", failReason);
		updateWorkOrder.setJdbcTemplate(jdbcTemplate);
		updateWorkOrder.Update("校验失败", 2, failReason, workOrder.getWorkjob_id());
	}
	public void CheckSuccess(){
		
	}
}
