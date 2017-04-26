package com.jobsAutomatic.service.tempRetire;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class RetireTask implements Delayed {
	private long id;
	private Date endDate;
	private long excuteTime;
	private String hotstpotid;
	private int projectStatus;
	private String workjob_id;	

	public String getWorkjob_id() {
		return workjob_id;
	}

	public void setWorkjob_id(String workjob_id) {
		this.workjob_id = workjob_id;
	}

	public RetireTask(long id, Date endDate, long delayTime, String hotstpotid, int projectStatus,String workjob_id) {
		this.id = id;
		this.endDate = endDate;
		this.workjob_id = workjob_id;
		this.hotstpotid = hotstpotid;
		this.projectStatus = projectStatus;
		this.excuteTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
		System.out.println(this.excuteTime);
	}

	@Override
	public int compareTo(Delayed delayed) {
		// TODO Auto-generated method stub
		RetireTask rt = (RetireTask) delayed;
		return this.id > rt.id ? 1 : (this.id < rt.id ? -1 : 0);
	}

	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		return unit.convert(this.excuteTime - System.nanoTime(), TimeUnit.NANOSECONDS);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getExcuteTime() {
		return excuteTime;
	}

	public void setExcuteTime(long excuteTime) {
		this.excuteTime = excuteTime;
	}

	public String getHotstpotid() {
		return hotstpotid;
	}

	public void setHotstpotid(String hotstpotid) {
		this.hotstpotid = hotstpotid;
	}

	public int getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(int projectStatus) {
		this.projectStatus = projectStatus;
	}
}
