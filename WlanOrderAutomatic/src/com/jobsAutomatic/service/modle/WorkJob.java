package com.jobsAutomatic.service.modle;

public class WorkJob {
	private  String  workjob_id;
	private  String  title;
	private  String  worker;
	private  String  department;
	private  String  send_time;
	private  String  handle_time;
	private  String  location;
	private  String  area;
	private  String  statement;
	private  int  issucced;

	public String getWorkjob_id() {
		return workjob_id;
	}
	public void setWorkjob_id(String workjob_id) {
		this.workjob_id = workjob_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	public String getHandle_time() {
		return handle_time;
	}
	public void setHandle_time(String handle_time) {
		this.handle_time = handle_time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public int getIssucced() {
		return issucced;
	}
	public void setIssucced(int issucced) {
		this.issucced = issucced;
	}

}
