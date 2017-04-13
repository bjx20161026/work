package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;

/**
 * �豸����ģ��
 * 
 * @author wjhu
 * @date 2012-2-20 ����01:24:00
 */
public class DeviceTypeModel implements Serializable {

	private static final long serialVersionUID = 8652299411615182781L;
	/**
	 * ��������Ӣ��
	 */
	private String VENDOR_NAME;
	/**
	 * �豸���� Ӣ������
	 */
	private String DEVICE_TYPE;
	/**
	 * �豸�ͺ�
	 */
	private String MODEL;

	public String getVENDOR_NAME() {
		return VENDOR_NAME;
	}
	
	public void setVENDOR_NAME(String vendor_name) {
		VENDOR_NAME = vendor_name;
	}

	public String getDEVICE_TYPE() {
		return DEVICE_TYPE;
	}

	public void setDEVICE_TYPE(String device_type) {
		DEVICE_TYPE = device_type;
	}

	public String getMODEL() {
		return MODEL;
	}

	public void setMODEL(String model) {
		MODEL = model;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

}
