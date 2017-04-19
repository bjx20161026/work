package com.jobsAutomatic.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jobsAutomatic.service.modle.QueryCondition;
import com.jobsAutomatic.service.modle.ReplyWorkOrder;
import com.jobsAutomatic.service.modle.UpdateSql;
import com.jobsAutomatic.service.modle.WorkJob;
import com.jobsAutomatic.service.modle.WorkOrder;
import com.jobsAutomatic.service.util.Util;

@Repository
public class OperateWorkOrder extends DaoSupport {

	public int Update(String statement, int issucced, String failed_reason, String workjob_id) {
		int i = jdbcTemplate.update(
				"update work_order set  statement= ?,issucced = ?,operatetime = sysdate,failed_reason = ? where workjob_id = ?",
				statement, issucced, failed_reason, workjob_id);
		return i;
	}

	public List<WorkOrder> getAllOrder() {
		logger.info("getAllOrder");
		RowMapper<WorkOrder> rowMapper = new BeanPropertyRowMapper<WorkOrder>(WorkOrder.class);
		List<WorkOrder> workOrders = jdbcTemplate.query("Select * from work_order", rowMapper);
		return workOrders;
	}

	public ReplyWorkOrder getOrderByCondition(QueryCondition queryCondition) {
		String workjob_id,workjob_type,statement,send_time,finishtime;
		Util util = new Util();
		List<UpdateSql> list = new ArrayList<UpdateSql>();
		int start = 0;
		int last = 100;
		try{
			start=Integer.parseInt(queryCondition.getStart());
		}catch(Exception e){
			logger.error(e.getMessage());
			start = 0;
		}
		try{
			last=Integer.parseInt(queryCondition.getLimit())+start;
		}catch(Exception e){
			logger.error(e.getMessage());
			last = 100;
		}
		try{
			workjob_id=queryCondition.getWorkjob_id();
		}catch(NullPointerException e){
			workjob_id = null;
		}
		try{
			workjob_type=queryCondition.getWorkjob_type();
		}catch(NullPointerException e){
			workjob_type = null;
		}
		try{
			statement=queryCondition.getStatement();
		}catch(NullPointerException e){
			statement = null;
		}
		try{
			send_time=queryCondition.getSend_time();
		}catch(NullPointerException e){
			send_time = null;
		}
		try{
			finishtime=queryCondition.getFinishtime();
		}catch(NullPointerException e){
			finishtime = null;
		}
		if(workjob_type!=null&&workjob_type.equals("非临时退服")) list.add(util.getUpdateSql("workjob_type", workjob_type, "NOTLIKE"));
		else list.add(util.getUpdateSql("workjob_type", workjob_type, "VARCHAR"));
		list.add(util.getUpdateSql("workjob_id", workjob_id, "LIKE"));
		list.add(util.getUpdateSql("send_time", send_time, "DATE2"));
		list.add(util.getUpdateSql("finishtime", finishtime, "DATE2"));
		list.add(util.getUpdateSql("statement", statement, "VARCHAR"));
		String sql = util.getWhere("", list);
		System.out.println("sql:"+sql);
		String sql2="";
		if(!sql.equals("")) sql2 = "Select count(*) from work_order where "+sql;
		else sql2 = "Select count(*) from work_order";
		@SuppressWarnings("deprecation")
		int totalSize = jdbcTemplate.queryForInt(sql2);
		if(!sql.equals("")) sql = "Select * from work_order where "+sql;
		else sql = "Select * from work_order";
		RowMapper<WorkOrder> rowMapper = new BeanPropertyRowMapper<WorkOrder>(WorkOrder.class);
		List<WorkOrder> workOrders = jdbcTemplate.query("SELECT * FROM (SELECT temp.* ,ROWNUM num FROM ( "+sql+" ) temp where ROWNUM <= ? ) WHERE　num > ?", rowMapper,last,start);
		
		
		ReplyWorkOrder replyWorkOrder = new ReplyWorkOrder();
		replyWorkOrder.setData(workOrders);
		replyWorkOrder.setTotalSize(totalSize);
		return replyWorkOrder;
	}
	
	@SuppressWarnings("deprecation")
	public int getCountByCondition(QueryCondition queryCondition){
		Util util = new Util();
		List<UpdateSql> list = new ArrayList<UpdateSql>();
		String workjob_id,workjob_type,statement;
		String send_time;
		String finishtime;
		try{
			workjob_id=queryCondition.getWorkjob_id();
		}catch(NullPointerException e){
			workjob_id = null;
		}
		try{
			workjob_type=queryCondition.getWorkjob_type();
		}catch(NullPointerException e){
			workjob_type = null;
		}
		try{
			statement=queryCondition.getStatement();
		}catch(NullPointerException e){
			statement = null;
		}
		try{
			send_time=queryCondition.getSend_time();
		}catch(NullPointerException e){
			send_time = null;
		}
		try{
			finishtime=queryCondition.getFinishtime();
		}catch(NullPointerException e){
			finishtime = null;
		}
		list.add(util.getUpdateSql("workjob_id", workjob_id, "VARCHAR"));
		list.add(util.getUpdateSql("workjob_type", workjob_type, "VARCHAR"));
		list.add(util.getUpdateSql("send_time", send_time, "DATE"));
		list.add(util.getUpdateSql("finishtime", finishtime, "DATE"));
		list.add(util.getUpdateSql("statement", statement, "VARCHAR"));
		String sql = util.getWhere("", list);

		if(!sql.equals("")) sql = "Select count(*) from work_order where "+sql;
		else sql = "Select count(*) from work_order";
		return jdbcTemplate.queryForInt(sql);
	}

	public int Insert(WorkJob workJob, String type, String localFile,String ftpUrl) {
		int i = jdbcTemplate.update(
				"insert into work_order(workjob_id,title,department,send_time,handle_time,location,area,statement,workjob_type,localfile,operatetime,ftp)values(?,?,?,to_date(?,'SYYYY-MM-DD HH24:MI:SS'),to_date(?,'SYYYY-MM-DD HH24:MI:SS'),?,?,?,?,?,sysdate,?)",
				workJob.getWorkjob_id(), workJob.getTitle(), workJob.getDepartment(), workJob.getSend_time(),
				workJob.getHandle_time(), workJob.getLocation(), workJob.getArea(), "待处理", type, localFile,ftpUrl);
		return i;
	}
}