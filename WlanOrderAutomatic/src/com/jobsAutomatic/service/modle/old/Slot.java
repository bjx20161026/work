package com.jobsAutomatic.service.modle.old;


/**
 * ��λģ��
 * 
 * @author wjhu
 * @date 2012-2-9 ����10:28:23
 */
public class Slot extends Entity {
	private static final long serialVersionUID = -9137065992037134687L;
	/**
	 * ��ʶ
	 */
	private String ID;
	/**
	 * �豸UUID
	 */
	private String DEVICE_ID;
	/**
	 * ʵ������
	 */
	private String INSTANCE;
	/**
	 * ��λ����
	 */
	private String NAME;
	/**
	 * ����ʵ���ʶ����˲�λ�����ĸ�ʵ�� �����ǻ�����߰忨��
	 */
	private String LEFT_ID;
	/**
	 * 3���� ,9�忨 ,5 ��λ
	 */
	private int LEFT_TYPE = 3;
	/**
	 * (�Ƿ�ռ�ã�0-��1-�� Ĭ����0)
	 */
	private String OCCUPY_STATUS;
	/**
	 * ��������
	 */
	private String VENDOR;
	/**
	 * �忨
	 */
	private Card card;

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public String getID() {
		return ID;
	}

	public void setID(String id) {
		ID = id;
	}

	public String getDEVICE_ID() {
		return DEVICE_ID;
	}

	public void setDEVICE_ID(String device_id) {
		DEVICE_ID = device_id;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String name) {
		NAME = name;
	}

	public String getLEFT_ID() {
		return LEFT_ID;
	}

	public void setLEFT_ID(String left_id) {
		LEFT_ID = left_id;
	}

	public int getLEFT_TYPE() {
		return LEFT_TYPE;
	}

	public void setLEFT_TYPE(int left_type) {
		LEFT_TYPE = left_type;
	}

	public String getOCCUPY_STATUS() {
		return OCCUPY_STATUS;
	}

	public void setOCCUPY_STATUS(String occupy_status) {
		OCCUPY_STATUS = occupy_status;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getINSTANCE() {
		return INSTANCE;
	}

	public void setINSTANCE(String instance) {
		INSTANCE = instance;
	}

	public String getVENDOR() {
		return VENDOR;
	}

	public void setVENDOR(String vendor) {
		VENDOR = vendor;
	}
}
