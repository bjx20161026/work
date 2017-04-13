package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;

import com.jobsAutomatic.service.modle.Vendor;





/**
 * �豸���̰忨����ģ��
 * 
 * @ClassName: VendorCard
 * @author wjhu
 * @date 2012-2-28 ����12:45:19
 */
public class VendorCard implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 4603355955381920482L;
	/**
	 * �忨����ID
	 */
	private String ID;
	/**
	 * ���̱���
	 */
	private Vendor vendor;
	/**
	 * �忨����
	 */
	private String CARD_NAME;
	/**
	 * �忨���� : 1 �� ������� 2�� �߿� 3�� ��Դ��
	 */
	private int CARD_TYPE;

	public String getID() {
		return ID;
	}

	public void setID(String id) {
		ID = id;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getCARD_NAME() {
		return CARD_NAME;
	}

	public void setCARD_NAME(String card_name) {
		CARD_NAME = card_name;
	}

	public int getCARD_TYPE() {
		return CARD_TYPE;
	}

	public void setCARD_TYPE(int card_type) {
		CARD_TYPE = card_type;
	}

}
