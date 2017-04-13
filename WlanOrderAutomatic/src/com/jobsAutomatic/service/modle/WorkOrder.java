package com.jobsAutomatic.service.modle;

import java.util.Date;
import com.jobsAutomatic.service.util.CustomDateSerializer;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public class WorkOrder {
	private	String	workjob_id;
	private	String	title;
	private	String	worker;
	private	String	department;
	private	Date	send_time;
	private	Date	handle_time;
	private	String	hotspotname;
	private	Date	shield_start;
	private	Date	shield_end;
	private	String	location;
	private	String	area;
	private	String	ftp;
	private	String	statement;
	private	int	issucced;
	private	String	workjob_type;
	private	String	nasid;
	private String  localfile;
	private Date finishtime;
	private Date operatetime;
	private String failed_reason;
	
	
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(Date finishtime) {
		this.finishtime = finishtime;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getOperatetime() {
		return operatetime;
	}
	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}
	public String getFailed_reason() {
		return failed_reason;
	}
	public void setFailed_reason(String failed_reason) {
		this.failed_reason = failed_reason;
	}

	public String getLocalfile() {
		return localfile;
	}
	public void setLocalfile(String localfile) {
		this.localfile = localfile;
	}
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
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getHandle_time() {
		return handle_time;
	}
	public void setHandle_time(Date handle_time) {
		this.handle_time = handle_time;
	}
	public String getHotspotname() {
		return hotspotname;
	}
	public void setHotspotname(String hotspotname) {
		this.hotspotname = hotspotname;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getShield_start() {
		return shield_start;
	}
	public void setShield_start(Date shield_start) {
		this.shield_start = shield_start;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getShield_end() {
		return shield_end;
	}
	public void setShield_end(Date shield_end) {
		this.shield_end = shield_end;
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
	public String getFtp() {
		return ftp;
	}
	public void setFtp(String ftp) {
		this.ftp = ftp;
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
	public String getWorkjob_type() {
		return workjob_type;
	}
	public void setWorkjob_type(String workjob_type) {
		this.workjob_type = workjob_type;
	}
	public String getNasid() {
		return nasid;
	}
	public void setNasid(String nasid) {
		this.nasid = nasid;
	}
}
