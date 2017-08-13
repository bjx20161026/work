/*
 * ImportMsg.java was created on 12-6-7 下午3:52
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.readExcle;

import java.util.Date;


/**
 * 导入实时消息 User: wjhu Date: 12-6-7 Time: 下午3:52
 */
public class ImportMsg {
	/**
	 * 导入状态
	 */
	private String status;
	/**
	 * 返回消息
	 */
	private String message;
	/**
	 * 总记录数
	 */
	private int totalCount;
	/**
	 * 成功数量
	 */
	private int successfulCount;
	/**
	 * 失败数量
	 */
	private int failureCount;
	/**
	 * 开始时间
	 */
	private Date startTime = new Date();
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 总耗时(秒)
	 * 
	 * @return
	 */
	public String getElapsedTime() {
		if (endTime == null) {
			endTime = new Date();
		}
		int t = (int) ((endTime.getTime() - startTime.getTime()) / 1000);
		return t + "秒";
	}
	/**
	 * 累加成功记录数
	 */
	public void countSuccess() {
		setSuccessfulCount(getSuccessfulCount() + 1);
	}

	/**
	 * 累加失败记录数
	 */
	public void countFail() {
		setFailureCount(getFailureCount() + 1);
	}
	public String getImportMsg() {
		StringBuilder sb = new StringBuilder("本次导入共耗时" + getElapsedTime()
				+ "</br>");
		sb.append("成功导入" + getSuccessfulCount() + "条</br>");
		sb.append("失败" + getFailureCount() + "条</br>");
		if (getMessage() != null)
			sb.append("导入失败详细日志：</br>"+getMessage());
		return sb.toString();
	}
	public void appendMessage(String message) {
		if (getMessage() == null)
			setMessage(message + "</br>");
		else
			setMessage(getMessage() + message + "</br>");
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getSuccessfulCount() {
		return successfulCount;
	}

	public void setSuccessfulCount(int successfulCount) {
		this.successfulCount = successfulCount;
	}

	public int getFailureCount() {
		return failureCount;
	}

	public void setFailureCount(int failureCount) {
		this.failureCount = failureCount;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
