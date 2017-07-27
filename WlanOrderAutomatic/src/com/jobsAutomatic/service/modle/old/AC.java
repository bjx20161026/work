package com.jobsAutomatic.service.modle.old;

import com.jobsAutomatic.service.modle.Room;

public class AC extends Device {
	private static final long serialVersionUID = 2187998857137716259L;

	private int MAX_AP_NUM_PERMITTED;

	private int MAX_STA_NUM_PERMITTED;
	/**
	 * ����
	 * 
	 * @deprecated
	 */
	@Deprecated
	private String ROOM;
	/**
	 * ����
	 */
	private Room rmRoom;
	/**
	 * ҵ������
	 * <p>
	 * ȡֵ��Χ: 1 - WLAN 2 - ��УWLAN
	 */
	private int SERVICE_TYPE;
	/**
	 * ����
	 */
	private Frame frame;
	/**
	 * NAS_ID
	 */
	private String NAS_ID;
	/**
	 * NAS_IP
	 */
	private String NAS_IP;
	/**
	 * AC �������� �� 1 : �߼�AC �豸 2������AC�Ӱ�
	 */
	private int MANAGE_TYPE =1;
	/**
	 * ���ֶν���AC ����Ϊ����忨ʱ����д�������߼�AC �豸ID
	 */
	private AC parentAc;
	/**
	 * ����AC��
	 */
	private AcGroup acGroup;
    /**
     * ac���� ��Ҫ�ڱ�����õ�
     * ����-����-nasid-��һ��  ('�Ǵ￵-����1471')
     */
    private String CODE_NAME;
    private String IPV6_ADDR;
    private String IPV6_PREFIX;
    
    

    public String getIPV6_ADDR() {
		return IPV6_ADDR;
	}

	public void setIPV6_ADDR(String ipv6_addr) {
		IPV6_ADDR = ipv6_addr;
	}

	public String getIPV6_PREFIX() {
		return IPV6_PREFIX;
	}

	public void setIPV6_PREFIX(String ipv6_prefix) {
		IPV6_PREFIX = ipv6_prefix;
	}

	public String getCODE_NAME() {
        return CODE_NAME;
    }

    public void setCODE_NAME(String CODE_NAME) {
        this.CODE_NAME = CODE_NAME;
    }

    public AC getParentAc() {
		return parentAc;
	}

	public void setParentAc(AC parentAc) {
		this.parentAc = parentAc;
	}

	public String getNAS_IP() {
		return NAS_IP;
	}

	public void setNAS_IP(String nas_ip) {
		NAS_IP = nas_ip;
	}

	public int getMANAGE_TYPE() {
		return MANAGE_TYPE;
	}

	public void setMANAGE_TYPE(int manage_type) {
		MANAGE_TYPE = manage_type;
	}

	public String getNAS_ID() {
		return NAS_ID;
	}

	public void setNAS_ID(String nas_id) {
		NAS_ID = nas_id;
	}

	public int getMAX_AP_NUM_PERMITTED() {
		return MAX_AP_NUM_PERMITTED;
	}

	public int getMAX_STA_NUM_PERMITTED() {
		return MAX_STA_NUM_PERMITTED;
	}

	public String getROOM() {
		return ROOM;
	}

	public int getSERVICE_TYPE() {
		return SERVICE_TYPE;
	}

	public void setMAX_AP_NUM_PERMITTED(int max_ap_num_permitted) {
		MAX_AP_NUM_PERMITTED = max_ap_num_permitted;
	}

	public void setMAX_STA_NUM_PERMITTED(int max_sta_num_permitted) {
		MAX_STA_NUM_PERMITTED = max_sta_num_permitted;
	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	public void setROOM(String room) {
		ROOM = room;
	}

	public void setSERVICE_TYPE(int service_type) {
		SERVICE_TYPE = service_type;
	}

	public Room getRmRoom() {
		return rmRoom;
	}

	public void setRmRoom(Room rmRoom) {
		this.rmRoom = rmRoom;
	}

	public AcGroup getAcGroup() {
		return acGroup;
	}

	public void setAcGroup(AcGroup acGroup) {
		this.acGroup = acGroup;
	}

}
