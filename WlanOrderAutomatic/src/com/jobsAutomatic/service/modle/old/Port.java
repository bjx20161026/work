/*
 * Port.java was created on 2012-3-1 ����02:02:09
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.modle.old;
/**
 * �豸�忨�˿���Ϣʵ��
 * @author huwenjiang
 * @version V1.0 2012-3-1 ����02:02:28
 */
public class Port extends Entity {
	private static final long serialVersionUID = 0L;
	/**
	 * ��ʶ
	 */
	private String ID;
	/**
	 * �����豸
	 */
	private Device device; 
	/**
	 * ʵ��
	 */
	private String INSTANCE;
	/**
	 * ʵ������
	 */
	private String NAME;
	/**
	 * λ�����
	 */
	private int PARENTRELPOS;
	/**
	 * ��ʵ������
	 */
	private int CONTAINEDIN;
	/**
	 * ����
	 */
	private String DESCR;
	/**
	 * ����ʵ���ʶ
	 */
	private Card LEFT_CARD;
	/**
	 * 3���� ,9�忨 ,5��λ , ��������
	 */
	private int LEFT_TYPE =3;
	/**
	 * �ӿ����� �������� RM_INTERFACE
	 */
	private int IF_INDEX;
	/**
	 * ��������
	 */
	private String VENDOR_TYPE;
	/**
	 * �˿���Ϣ
	 */
	private Interface inf;
	public Interface getInf() {
		return inf;
	}
	public void setInf(Interface inf) {
		this.inf = inf;
	}
	public String getID() {
		return ID;
	}
	public void setID(String id) {
		ID = id;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	public String getINSTANCE() {
		return INSTANCE;
	}
	public void setINSTANCE(String instance) {
		INSTANCE = instance;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String name) {
		NAME = name;
	}
	public int getPARENTRELPOS() {
		return PARENTRELPOS;
	}
	public void setPARENTRELPOS(int parentrelpos) {
		PARENTRELPOS = parentrelpos;
	}
	public int getCONTAINEDIN() {
		return CONTAINEDIN;
	}
	public void setCONTAINEDIN(int containedin) {
		CONTAINEDIN = containedin;
	}
	public String getDESCR() {
		return DESCR;
	}
	public void setDESCR(String descr) {
		DESCR = descr;
	}
	public Card getLEFT_CARD() {
		return LEFT_CARD;
	}
	public void setLEFT_CARD(Card left_card) {
		LEFT_CARD = left_card;
	}
	public int getLEFT_TYPE() {
		return LEFT_TYPE;
	}
	public void setLEFT_TYPE(int left_type) {
		LEFT_TYPE = left_type;
	}
	public int getIF_INDEX() {
		return IF_INDEX;
	}
	public void setIF_INDEX(int if_index) {
		IF_INDEX = if_index;
	}
	public String getVENDOR_TYPE() {
		return VENDOR_TYPE;
	}
	public void setVENDOR_TYPE(String vendor_type) {
		VENDOR_TYPE = vendor_type;
	}
	
	
}
