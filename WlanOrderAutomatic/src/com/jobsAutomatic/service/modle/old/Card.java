package com.jobsAutomatic.service.modle.old;

import java.util.List;

public class Card extends Entity {
	private static final long serialVersionUID = 5985781786070446969L;
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
	 * �忨���� 
	 */
	private String NAME;
	/**
	 * ����ʵ���ʶ����˲�λ�����ĸ�ʵ�� �����ǻ�����߰忨��
	 */
	private String LEFT_ID;
	/**
	 * 3���� ,9�忨 ,5 ��λ ,
	 */
	private int LEFT_TYPE = 5;
	/**
	 * ��������
	 */
	private String VENDOR_TYPE; 
	/**
	 * ����汾
	 */
	private String SOFTWARE_VERSION;
	/**
	 * ���к�
	 */
	private String SERIAL_NUM; 
	/**
	 * �忨�����ap�������������Թ���AC��
	 * @deprecated
	 */
	private int MAX_AP_NUM_PERMITTED;
	/**
	 * �忨������ն��������������Թ���AC��
	 * @deprecated
	 */
	private int MAX_STA_NUM_PERMITTED; 
	/**
	 * �����ַ����Թ���AC��
	 * @deprecated
	 */
	private String IP_ADDR;
	
	/**
	 * �忨�˿�
	 */
	private List<Port> portList;
	/**
	 * (�Ƿ�ռ�ã�0-��1-�� Ĭ����0)
	 */
	private String OCCUPY_STATUS;
	/**
	 * ���AC�豸��ÿ��AC������һ���忨
	 * 
	 */
	private AC acCard;
	/**
	 * �忨����
	 */
	private VendorCard cardType;
	
	public VendorCard getCardType() {
		return cardType;
	}
	public void setCardType(VendorCard cardType) {
		this.cardType = cardType;
	}
	public String getIP_ADDR() {
		return IP_ADDR;
	}
	public void setIP_ADDR(String ip_addr) {
		IP_ADDR = ip_addr;
	}
	public int getMAX_AP_NUM_PERMITTED() {
		return MAX_AP_NUM_PERMITTED;
	}
	public void setMAX_AP_NUM_PERMITTED(int max_ap_num_permitted) {
		MAX_AP_NUM_PERMITTED = max_ap_num_permitted;
	}
	public int getMAX_STA_NUM_PERMITTED() {
		return MAX_STA_NUM_PERMITTED;
	}
	public void setMAX_STA_NUM_PERMITTED(int max_sta_num_permitted) {
		MAX_STA_NUM_PERMITTED = max_sta_num_permitted;
	}
	public String getVENDOR_TYPE()
	{
		return VENDOR_TYPE;
	}
	public void setVENDOR_TYPE(String vendor_type)
	{
		VENDOR_TYPE = vendor_type;
	}
	public String getSOFTWARE_VERSION()
	{
		return SOFTWARE_VERSION;
	}
	public void setSOFTWARE_VERSION(String software_version)
	{
		SOFTWARE_VERSION = software_version;
	}
	public String getSERIAL_NUM()
	{
		return SERIAL_NUM;
	}
	public void setSERIAL_NUM(String serial_num)
	{
		SERIAL_NUM = serial_num;
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
	public List<Port> getPortList() {
		return portList;
	}
	public void setPortList(List<Port> portList) {
		this.portList = portList;
	}
	public String getOCCUPY_STATUS() {
		return OCCUPY_STATUS;
	}
	public void setOCCUPY_STATUS(String occupy_status) {
		OCCUPY_STATUS = occupy_status;
	}
	public AC getAcCard() {
		return acCard;
	}
	public void setAcCard(AC acCard) {
		this.acCard = acCard;
	}
}
