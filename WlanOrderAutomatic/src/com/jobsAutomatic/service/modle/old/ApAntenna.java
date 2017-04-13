/*
 * ApAntenna.java was created on 2012-3-5 ����10:50:31
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.modle.old;
/**
 * AP����ģ�� ��Ӧ������ PRM_AP_ANTENNA ��
 * @author huwenjiang
 * @version V1.0 2012-3-5 ����10:50:48
 */
public class ApAntenna extends Entity {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 2892162069415164134L;
	/**
	 * ����ID
	 */
	private String ID;
	/**
	 *����AP�豸(AP_ID)
	 */
	private AP ap;
	/**
	 * �������� : 1 -- ȫ������ 2- ��������
	 */
	private int ANTENNA_TYPE;
	/**
	 * ���߳���
	 */
	private String VENDOR;
	/**
	 * ���߹Ҹ� ��λ���ף�
	 */
	private int HEIGHT;
	/**
	 * �������� ��λ dBi
	 */
	private int GAIN;
	/**
	 * ��λ��
	 */
	private int AZIMUTH;
	/**
	 * ��װλ��
	 */
	private String LOCATION;
	public String getID() {
		return ID;
	}
	public void setID(String id) {
		ID = id;
	}
	public AP getAp() {
		return ap;
	}
	public void setAp(AP ap) {
		this.ap = ap;
	}
	public int getANTENNA_TYPE() {
		return ANTENNA_TYPE;
	}
	public void setANTENNA_TYPE(int antenna_type) {
		ANTENNA_TYPE = antenna_type;
	}
	public String getVENDOR() {
		return VENDOR;
	}
	public void setVENDOR(String vendor) {
		VENDOR = vendor;
	}
	public int getHEIGHT() {
		return HEIGHT;
	}
	public void setHEIGHT(int height) {
		HEIGHT = height;
	}
	public int getGAIN() {
		return GAIN;
	}
	public void setGAIN(int gain) {
		GAIN = gain;
	}
	public int getAZIMUTH() {
		return AZIMUTH;
	}
	public void setAZIMUTH(int azimuth) {
		AZIMUTH = azimuth;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(String location) {
		LOCATION = location;
	}
}
