package com.jobsAutomatic.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.jobsAutomatic.service.modle.QueryCondition;
import com.jobsAutomatic.service.modle.ReplyWorkOrder;
import com.jobsAutomatic.service.modle.UpdateSql;
import com.jobsAutomatic.service.modle.WorkJob;
import com.jobsAutomatic.service.modle.WorkOrder;
import com.jobsAutomatic.service.util.Sms;
import com.jobsAutomatic.service.util.Util;

@Repository
public class OperateWorkOrder extends DaoSupport {
	
	public OperateWorkOrder(){
		try{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.39:1521:ipnet");
		dataSource.setUsername("res");
		dataSource.setPassword("SHres!23$");
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		this.jdbcTemplate = jdbcTemplate;
		}catch(Exception e){
			Sms sms = new Sms();
			try {
				sms.SendMessage("数据库连接异常 ："+e.getMessage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				logger.error(e1);
			}	
		}
	}

	public int Update(String statement, int issucced, String failed_reason, String workjob_id) {
		int i = jdbcTemplate.update(
				"update work_order set  statement= ?,issucced = ?,operatetime = sysdate,failed_reason = ? where workjob_id = ?",
				statement, issucced, failed_reason, workjob_id);
		return i;
	}
	
	public int Insert(String statement, int issucced, String failed_reason, String workjob_id){
		int i = jdbcTemplate.update("insert into work_order(statement,issucced,operatetime,failed_reason,workjob_id)values(?,?,sysdate,?,?)",statement, issucced, failed_reason, workjob_id);
		return i;
	}
	
	
	
	public int Update(String statement, int issucced, String failed_reason, String workjob_id,String user) {
		int i = jdbcTemplate.update(
				"update work_order set  statement= ?,issucced = ?,operatetime = sysdate,failed_reason = ?,order_user = ? where workjob_id = ?",
				statement, issucced, failed_reason,user, workjob_id);
		return i;
	}
	
	public int Update(String statement,String user,String workjob_id){
		int i =jdbcTemplate.update(
				"update work_order set  statement= ?,operatetime = sysdate,ORDER_USER = ? where workjob_id = ?",
				statement,user, workjob_id);
		return i;
	}

	public List<WorkOrder> getAllOrder() {
		logger.info("getAllOrder");
		RowMapper<WorkOrder> rowMapper = new BeanPropertyRowMapper<WorkOrder>(WorkOrder.class);
		List<WorkOrder> workOrders = jdbcTemplate.query("Select * from work_order", rowMapper);
		return workOrders;
	}
	public void RecordOperate(List<WorkOrder> workOrders){
		for(WorkOrder workOrder:workOrders){
		jdbcTemplate.update(
					"update work_order set  ORDER_USER= ?,operatetime = sysdate where workjob_id = ?",
					workOrder.getOrder_user(),workOrder.getWorkjob_id());
		jdbcTemplate.update(
				"insert into wlan_opreate_log(oprate_time,opreator,oprate_detail)values(sysdate,?,?)",
				workOrder.getOrder_user(),"处理工单");
		}
	}
	public void RecordOperate(String user,String workjob_id,String detail){
		jdbcTemplate.update(
					"update work_order set  ORDER_USER= ?,operatetime = sysdate where workjob_id = ?",
					user,workjob_id);
		jdbcTemplate.update(
				"insert into wlan_opreate_log(oprate_time,opreator,oprate_detail)values(sysdate,?,?)",
				user,"手动回单:"+detail);
	}
	
	public List<Map<String,Object>> getAllOrderByCondition(QueryCondition queryCondition){
		String workjob_id,workjob_type,statement,send_time,finishtime;
		Util util = new Util();
		List<UpdateSql> list = new ArrayList<UpdateSql>();
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
		if(workjob_type!=null&&workjob_type.equals("非临时退服")) list.add(util.getUpdateSql("workjob_type", "临时退服", "NOTLIKE"));
		else list.add(util.getUpdateSql("workjob_type", workjob_type, "VARCHAR"));
		list.add(util.getUpdateSql("workjob_id", workjob_id, "LIKE"));
		list.add(util.getUpdateSql("send_time", send_time, "DATE2"));
		list.add(util.getUpdateSql("finishtime", finishtime, "DATE2"));
		if(statement==null||statement!=null&&!statement.equals("处理完成")) list.add(util.getUpdateSql("statement", statement, "VARCHAR"));
		String sql = util.getWhere("", list);
		System.out.println("sql:"+sql);
		if(statement!=null&&statement.equals("处理完成"))
			if(!sql.equals("")) sql = "select * from (select * from work_order where STATEMENT = '处理中' or STATEMENT = '处理完成' ) where "+sql;
			else sql = "select * from work_order where STATEMENT = '处理中' or STATEMENT = '处理完成'";
		else
			if(!sql.equals("")) sql = "Select * from work_order where "+sql;
			else sql = "Select * from work_order";
				return jdbcTemplate.queryForList(sql);
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
		if(workjob_type!=null&&workjob_type.equals("非临时退服")) list.add(util.getUpdateSql("workjob_type", "临时退服", "NOTLIKE"));
		else list.add(util.getUpdateSql("workjob_type", workjob_type, "VARCHAR"));
		list.add(util.getUpdateSql("workjob_id", workjob_id, "LIKE"));
		list.add(util.getUpdateSql("send_time", send_time, "DATE2"));
		list.add(util.getUpdateSql("finishtime", finishtime, "DATE2"));
		if(statement==null||statement!=null&&!statement.equals("处理完成")) list.add(util.getUpdateSql("statement", statement, "VARCHAR"));
		String sql = util.getWhere("", list);
		System.out.println("sql:"+sql);
		String sql2="";
		if(statement!=null&&statement.equals("处理完成"))
			if(!sql.equals("")) sql2 = "select count(*) from (select * from work_order where STATEMENT = '处理中' or STATEMENT = '处理完成' ) where "+sql;
			else sql2 = "select count(*) from work_order where STATEMENT = '处理中' or STATEMENT = '处理完成'";
		else
			if(!sql.equals("")) sql2 = "Select count(*) from work_order where "+sql;
			else sql2 = "Select count(*) from work_order";
		@SuppressWarnings("deprecation")
		int totalSize = jdbcTemplate.queryForInt(sql2);
		if(statement!=null&&statement.equals("处理完成"))
			if(!sql.equals("")) sql = "select * from (select * from work_order where STATEMENT = '处理中' or STATEMENT = '处理完成' ) where "+sql;
			else sql = "select * from work_order where STATEMENT = '处理中' or STATEMENT = '处理完成'";
		else
			if(!sql.equals("")) sql = "Select * from work_order where "+sql;
			else sql = "Select * from work_order";
		System.out.println("sql2------>>>>>>"+sql2);
		System.out.println("sql------>>>>>>"+sql);
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