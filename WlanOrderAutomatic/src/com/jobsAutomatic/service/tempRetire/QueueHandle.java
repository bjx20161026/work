package com.jobsAutomatic.service.tempRetire;

import java.util.concurrent.DelayQueue;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jobsAutomatic.dao.OperateWorkOrder;
import com.jobsAutomatic.service.Sender.Receipt;

public class QueueHandle implements Runnable {
	Logger logger = Logger.getLogger(QueueHandle.class);
	private DelayQueue<RetireTask> queue;
	private JdbcTemplate jdbcTemplate;

	public QueueHandle(DelayQueue<RetireTask> queue,JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.queue = queue;
		this.jdbcTemplate = jdbcTemplate;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				RetireTask take = queue.take();
				if(take.getProjectStatus() == 4){
				String sql="call SP_HOT_PROJECT_STATUS_CHANGE('"+take.getHotstpotid()+"',"+take.getProjectStatus()+")";
				int i = 0;
				for(int j = 1;i!=4; j++){
				logger.info("工单号："+take.getWorkjob_id()+" --->>>第 "+j+" 次尝试");
				logger.info("sql--->>>"+sql);
				jdbcTemplate.execute(sql);
				Thread.sleep(60000);
				i = jdbcTemplate.queryForInt("select PROJECT_STATUS from prm_wlan_hotspot where HOTSPOT_ID = ?",take.getHotstpotid());
				}
				jdbcTemplate.update("delete from temp_task where  workjob_id = ? and projectStatus = ?",take.getWorkjob_id(),take.getProjectStatus());	
				new QueuePut(take.getEndDate(), take.getEndDate(), take.getHotstpotid(), 1,take.getWorkjob_id());
				jdbcTemplate.update("insert into temp_task(workjob_id,startDate,endDate,hotstpotid,projectStatus)values(?,?,?,?,?)",take.getWorkjob_id(),take.getEndDate(), take.getEndDate(),take.getHotstpotid(),1);
				String result = new Receipt().SendReceipt(take.getWorkjob_id(), "成功", "");
				OperateWorkOrder updateWorkOrder = new OperateWorkOrder();
				updateWorkOrder.setJdbcTemplate(jdbcTemplate);
				if (result!=null&&result.equals("0"))
					updateWorkOrder.Update("处理完成", 1, "", take.getWorkjob_id());
				else
					updateWorkOrder.Update("回单失败", 2, result, take.getWorkjob_id());
				}else{
					String sql="call SP_HOT_PROJECT_STATUS_CHANGE('"+take.getHotstpotid()+"',"+take.getProjectStatus()+")";
					int k = 0;
					for(int j = 1;k!=1; j++){
						logger.info("工单号："+take.getWorkjob_id()+" --->>>第 "+j+" 次尝试");
						logger.info("sql--->>>"+sql);
						jdbcTemplate.execute(sql);
						Thread.sleep(60000);
						k = jdbcTemplate.queryForInt("select PROJECT_STATUS from prm_wlan_hotspot where HOTSPOT_ID = ?",take.getHotstpotid());
						}
					jdbcTemplate.update("delete from temp_task where  workjob_id = ? and projectStatus = ?",take.getWorkjob_id(),take.getProjectStatus());
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}
		}
	}
}
