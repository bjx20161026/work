/*
 * DeviceType.java was created on 2012-3-1 ����01:21:55
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;

/**
 * �豸����ģ�ͱ�
 * 
 * @author huwenjiang
 * @version V1.0 2012-3-1 ����01:42:43
 */
public class DeviceType implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 0L;
	/**
	 * Ӣ������
	 */
	private String NAME;
	/**
	 * ��������
	 */
	private String NAME_CN;
	/**
	 * �豸������ֵ�ͱ���
	 */
	private int NUM_CODE;

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String name) {
		NAME = name;
	}

	public String getNAME_CN() {
		return NAME_CN;
	}

	public void setNAME_CN(String name_cn) {
		NAME_CN = name_cn;
	}

	public int getNUM_CODE() {
		return NUM_CODE;
	}

	public void setNUM_CODE(int num_code) {
		NUM_CODE = num_code;
	}

}
