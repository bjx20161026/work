package com.jobsAutomatic.service.tempRetire;

import java.util.concurrent.DelayQueue;

import org.springframework.jdbc.core.JdbcTemplate;

public class QueueHandle implements Runnable{
	
	private DelayQueue<RetireTask> queue;
	private JdbcTemplate jdbcTemplate;

	public QueueHandle(DelayQueue<RetireTask> queue,JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.queue = queue;
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				RetireTask take = queue.take();
				System.out.println("临时退服处理开始");
				String sql="call SP_HOT_PROJECT_STATUS_CHANGE('"+take.getHotstpotid()+"',"+take.getProjectStatus()+")";
				jdbcTemplate.execute(sql);
				jdbcTemplate.update("update RM_OBJECT_STATUS_POLICY@WLAN_RM set stamp_end=? where object_id=?",take.getEndDate(),take.getHotstpotid());
//				new Receipt().SendReceipt(take.getWorkjob_id(), "成功", "");
//				jdbcTemplate.update("update work_order set  statement='处理完成',issucced = 1,operatetime = sysdate where workjob_id = ?",take.getWorkjob_id());		
//				System.out.println("临时退服处理完成");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
