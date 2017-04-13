package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;


public class AcNoAuthStatusModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ����Ψһ��ʶ
	 */
	private String taskId;
	/**
	 * �豸����
	 */
	private String deviceName;
	/**
	 * AC����֤״̬��δ֪-0������-1���ر�-2��
	 */
	private boolean isAuthOpen;
	/**
	 * ����ʼʱ��
	 */
	private String taskStartTime;
	/**
	 * �������ʱ��
	 */
	private String taskEndTime;
	/**
	 * PINGִ��״̬ ��δִ��-0��PING������֤�ɹ�-1��PING������֤ʧ��-2��
	 */
	private String pingTaskStatus;
	/**
	 * PING������־��Ϣ
	 */
	private String pingTaskResult;
	/**
	 * PINGִ��ʱ��
	 */
	private int pingExectime;
	/**
	 * ����̽��ִ��״̬ ��δִ��-0���豸������֤�ɹ�-1���豸������֤ʧ��-2��
	 */
	private String envTaskStatus;
	/**
	 * ����̽����־
	 */
	private String envTaskResult;
	/**
	 * ����̽��ִ��ʱ��
	 */
	private String envExectime;
	/**
	 * AC����ִ֤��״̬ ��δִ��-0��AC����ִ֤�гɹ�-1��AC����ִ֤��ʧ��-2��
	 */
	private String noAuthTaskStatus;
	/**
	 * AC����ִ֤����־
	 */
	private String noAuthTaskResult;
	/**
	 * AC����ִ֤��ʱ��
	 */
	private int noAuthExectime;
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public boolean isAuthOpen() {
		return isAuthOpen;
	}
	public void setAuthOpen(boolean isAuthOpen) {
		this.isAuthOpen = isAuthOpen;
	}
	public String getTaskStartTime() {
		return taskStartTime;
	}
	public void setTaskStartTime(String taskStartTime) {
		this.taskStartTime = taskStartTime;
	}
	public String getTaskEndTime() {
		return taskEndTime;
	}
	public void setTaskEndTime(String taskEndTime) {
		this.taskEndTime = taskEndTime;
	}
	public String getPingTaskStatus() {
		return pingTaskStatus;
	}
	public void setPingTaskStatus(String pingTaskStatus) {
		this.pingTaskStatus = pingTaskStatus;
	}
	public String getPingTaskResult() {
		return pingTaskResult;
	}
	public void setPingTaskResult(String pingTaskResult) {
		this.pingTaskResult = pingTaskResult;
	}
	public int getPingExectime() {
		return pingExectime;
	}
	public void setPingExectime(int pingExectime) {
		this.pingExectime = pingExectime;
	}
	public String getEnvTaskStatus() {
		return envTaskStatus;
	}
	public void setEnvTaskStatus(String envTaskStatus) {
		this.envTaskStatus = envTaskStatus;
	}
	public String getEnvTaskResult() {
		return envTaskResult;
	}
	public void setEnvTaskResult(String envTaskResult) {
		this.envTaskResult = envTaskResult;
	}
	public String getEnvExectime() {
		return envExectime;
	}
	public void setEnvExectime(String envExectime) {
		this.envExectime = envExectime;
	}
	public String getNoAuthTaskStatus() {
		return noAuthTaskStatus;
	}
	public void setNoAuthTaskStatus(String noAuthTaskStatus) {
		this.noAuthTaskStatus = noAuthTaskStatus;
	}
	public String getNoAuthTaskResult() {
		return noAuthTaskResult;
	}
	public void setNoAuthTaskResult(String noAuthTaskResult) {
		this.noAuthTaskResult = noAuthTaskResult;
	}
	public int getNoAuthExectime() {
		return noAuthExectime;
	}
	public void setNoAuthExectime(int noAuthExectime) {
		this.noAuthExectime = noAuthExectime;
	}
	@Override
	public String toString() {
		return "AcNoAuthStatusModel [DeviceName=" + deviceName
				+ ", envExectime=" + envExectime + ", envTaskResult="
				+ envTaskResult + ", envTaskStatus=" + envTaskStatus
				+ ", isAuthOpen=" + isAuthOpen + ", noAuthExectime="
				+ noAuthExectime + ", noAuthTaskResult=" + noAuthTaskResult
				+ ", noAuthTaskStatus=" + noAuthTaskStatus + ", pingExectime="
				+ pingExectime + ", pingTaskResult=" + pingTaskResult
				+ ", pingTaskStatus=" + pingTaskStatus + ", taskEndTime="
				+ taskEndTime + ", taskId=" + taskId + ", taskStartTime="
				+ taskStartTime + "]";
	}
	
	public AcNoAuthStatusModel() {
		// TODO Auto-generated constructor stub
	}
	public AcNoAuthStatusModel(String taskId, String deviceName,
			boolean isAuthOpen, String taskStartTime, String taskEndTime,
			String pingTaskStatus, String pingTaskResult, int pingExectime,
			String envTaskStatus, String envTaskResult, String envExectime,
			String noAuthTaskStatus, String noAuthTaskResult, int noAuthExectime) {
		super();
		this.taskId = taskId;
		this.deviceName = deviceName;
		this.isAuthOpen = isAuthOpen;
		this.taskStartTime = taskStartTime;
		this.taskEndTime = taskEndTime;
		this.pingTaskStatus = pingTaskStatus;
		this.pingTaskResult = pingTaskResult;
		this.pingExectime = pingExectime;
		this.envTaskStatus = envTaskStatus;
		this.envTaskResult = envTaskResult;
		this.envExectime = envExectime;
		this.noAuthTaskStatus = noAuthTaskStatus;
		this.noAuthTaskResult = noAuthTaskResult;
		this.noAuthExectime = noAuthExectime;
	}
	
	
	
}
