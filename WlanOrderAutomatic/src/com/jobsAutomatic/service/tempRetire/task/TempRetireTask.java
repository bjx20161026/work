package com.jobsAutomatic.service.tempRetire.task;

import org.springframework.dao.EmptyResultDataAccessException;

import com.jobsAutomatic.service.Sender.Receipt;
import com.jobsAutomatic.service.tempRetire.QueuePut;



public class TempRetireTask extends ATask {
//	@Autowired
//	UpdateWorkOrder updateWorkOrder;
	@Override
	public void HandleTask() {
		// TODO Auto-generated method stub
		System.out.println("处理临时退服工单");
		try {
			updateWorkOrder.setJdbcTemplate(jdbcTemplate);
			String hotspotid = jdbcTemplate.queryForObject("select hotspot_id from prm_wlan_hotspot where NAS_ID =?",
					java.lang.String.class, workOrder.getNasid());
			System.out.println("临时退服热点id：" + hotspotid);
			jdbcTemplate.update("update work_order set  statement='处理中' where workjob_id = ?",
					workOrder.getWorkjob_id());
			System.out.println(workOrder.getShield_start() + "," + workOrder.getShield_end() + "," + hotspotid);
			new QueuePut(workOrder.getShield_start(), workOrder.getShield_end(), hotspotid, 4,workOrder.getWorkjob_id());
			jdbcTemplate.update("insert into temp_task(workjob_id,startDate,endDate,hotstpotid,projectStatus)values(?,?,?,?,?)",workOrder.getWorkjob_id(),workOrder.getShield_start(), workOrder.getShield_end(),hotspotid,4);
//			SendSuccess();
		} catch (EmptyResultDataAccessException eh) {
			new Receipt().SendReceipt(workOrder.getWorkjob_id(), "失败", "临时退服对应热点未找到");
			updateWorkOrder.Update("校验失败", 2, "临时退服对应热点未找到", workOrder.getWorkjob_id(),"SYSTEM");
			logger.error("work_id:"+workOrder.getWorkjob_id()+"临时退服对应热点未找到 --> "+eh.getMessage());
			eh.printStackTrace();
		}
	}
}
