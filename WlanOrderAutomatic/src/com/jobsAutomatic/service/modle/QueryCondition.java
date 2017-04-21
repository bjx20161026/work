package com.jobsAutomatic.service.modle;

public class QueryCondition {
	private String workjob_id;
	private String workjob_type;
	private String statement;
	private String send_time;
	private String finishtime;
	private String start;
	private String limit;
	private String user;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getWorkjob_id() {
		return workjob_id;
	}
	public void setWorkjob_id(String workjob_id) {
		this.workjob_id = workjob_id;
	}
	public String getWorkjob_type() {
		return workjob_type;
	}
	public void setWorkjob_type(String workjob_type) {
		this.workjob_type = workjob_type;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	public String getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(String finishtime) {
		this.finishtime = finishtime;
	}
	@Override
	public String toString(){
		return "workjob_id:"+workjob_id+"  workjob_type:"+workjob_type+"  statement:"+statement+" send_time:"+send_time+"  finishtime:"+finishtime+"  start:"+start+"  limit:"+limit+"  user:"+user;
	}
	
	public static void main(String[] args){
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setWorkjob_id("12345");
		queryCondition.setUser("system");
		System.out.println(queryCondition.toString());
	}
}
