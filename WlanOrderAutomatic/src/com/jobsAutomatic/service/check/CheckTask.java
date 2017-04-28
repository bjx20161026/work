package com.jobsAutomatic.service.check;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class CheckTask implements Delayed{
	private long excuteTime;
	private long id;
	private String include;
	private String workjob_id;
	
	public CheckTask(String include, String workjob_id, long id,long delayTime){
		this.id = id;
		this.include = include;
		this.workjob_id = workjob_id;
		this.excuteTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
	}

	@Override
	public int compareTo(Delayed delayed) {
		// TODO Auto-generated method stub
		CheckTask ct = (CheckTask) delayed;
		return this.id > ct.id ? 1 : (this.id < ct.id ? -1 : 0);
	}

	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		return unit.convert(this.excuteTime - System.nanoTime(), TimeUnit.NANOSECONDS);
	}
	
	public String getInclude() {
		return include;
	}

	public void setInclude(String include) {
		this.include = include;
	}

	public String getWorkjob_id() {
		return workjob_id;
	}

	public void setWorkjob_id(String workjob_id) {
		this.workjob_id = workjob_id;
	}

}
