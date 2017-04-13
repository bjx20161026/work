package com.jobsAutomatic.service.modle;

import java.util.Date;

public class QueryCondition {
	private String workjob_id;
	private String workjob_type;
	private String statement;
	private Date send_time;
	private Date finishtime;
	private String startIndex;
	private String lastIndex;
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
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	public Date getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(Date finishtime) {
		this.finishtime = finishtime;
	}
	public String getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(String startIndex) {
		this.startIndex = startIndex;
	}
	public String getLastIndex() {
		return lastIndex;
	}
	public void setLastIndex(String lastIndex) {
		this.lastIndex = lastIndex;
	}

}
