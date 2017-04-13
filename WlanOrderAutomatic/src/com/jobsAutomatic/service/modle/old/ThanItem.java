/*
 * ThanItem.java was created on 2012-3-8 ����11:14:38
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;
/**
 * �豸��˱ȶ���ģ��
 * @author huwenjiang
 * @version V1.0 2012-3-8 ����11:14:55
 */
public class ThanItem  implements Serializable{

	private static final long serialVersionUID = 2318472478380285129L;
	/**
	 * �ȶ���
	 */
	private String item;
	/**
	 * ���Ͽ�����
	 */
	private String resValue;
	/**
	 * ���п�����
	 */
	private String runValue;
	/**
	 * �ȶԽ��
	 */
	private int result;
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getResValue() {
		return resValue;
	}
	public void setResValue(String resValue) {
		this.resValue = resValue;
	}
	public String getRunValue() {
		return runValue;
	}
	public void setRunValue(String runValue) {
		this.runValue = runValue;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
}
