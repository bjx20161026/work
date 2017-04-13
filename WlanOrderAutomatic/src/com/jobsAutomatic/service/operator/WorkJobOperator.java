package com.jobsAutomatic.service.operator;

import com.jobsAutomatic.service.modle.WorkJob;

public class WorkJobOperator extends DBOperator{
	
	public void InsertWorkJob(WorkJob workJob){
		String sql="insert into PRM_WLAN_WORKJOBS(workjob_id,title,worker,department,send_time,handle_time,location,area,statement,issucced)values(?,?,?,?,to_date(?,'SYYYY-MM-DD HH12:MI:SS AM'),to_date(?,'SYYYY-MM-DD HH12:MI:SS AM'),?,?,?,0)";
//		jdbcTemplate.update(sql, new Object[]{workJob.getWorkjob_id(),workJob.getTitle(),workJob.getWorker(),workJob.getDepartment(),workJob.getSend_time().replace("AM","����").replace("PM", "����"),workJob.getHandle_time().replace("AM","����").replace("PM", "����"),workJob.getLocation(),workJob.getArea(),workJob.getStatement(),workJob.getIssucced()});
		jdbcTemplate.update(sql, new Object[]{workJob.getWorkjob_id(),workJob.getTitle(),workJob.getWorker(),workJob.getDepartment(),null,null,workJob.getLocation(),workJob.getArea(),workJob.getStatement()});
        System.out.println("插入成功");
	}
}
