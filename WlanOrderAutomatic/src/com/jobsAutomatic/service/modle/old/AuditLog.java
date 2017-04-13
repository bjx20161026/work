package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;
import java.util.Date;

/**
 * ��˼�¼ģ��
 * @author wjhu
 * @date 2012-2-23 ����01:02:33
 */
public class AuditLog implements Serializable{

	private static final long serialVersionUID = 3520796161222541585L;
	/**
	 * ��˼�¼��ˮ��
	 */
	private long AUDIT_NO; 
	/**
	 * �����Ա
	 */
	private String AUDITOR;
	/**
	 * ���ʱ��
	 */
	private Date AUDIT_TIME;
	/**
	 *  ���طֹ�˾����������;
	 */
	private String CITY; 
	/**
	 * ������
	 */
	private String DETAIL; 
	/**
	 * ��˶������� �� 1- AC �豸��Ϣ  2- �ȵ���Ϣ
	 */
	private int TARGET_TYPE; 
	/**
	 * ����˶���Ϊ�ȵ� �� �ȵ㽻������AP ʱ����д �ȵ�ID
	 */
	private String HOTSPOT_ID; 
	/**
	 * �����˶���ΪAC ��AP ���������豸ʱ��д�豸ID
	 */
	private String DEVICE_ID; 
	/**
	 * ��˽��״̬ ; 3 - ���ͨ�� 4 - ���δͨ��
	 */
	private int AUDIT_STATUS; 

	public long getAUDIT_NO() {
		return AUDIT_NO;
	}

	public void setAUDIT_NO(long audit_no) {
		AUDIT_NO = audit_no;
	}

	public String getAUDITOR() {
		return AUDITOR;
	}

	public void setAUDITOR(String auditor) {
		AUDITOR = auditor;
	}

	public Date getAUDIT_TIME() {
		return AUDIT_TIME;
	}

	public void setAUDIT_TIME(Date audit_time) {
		AUDIT_TIME = audit_time;
	}

	public String getCITY() {
		return CITY;
	}

	public void setCITY(String city) {
		CITY = city;
	}

	public String getDETAIL() {
		return DETAIL;
	}

	public void setDETAIL(String detail) {
		DETAIL = detail;
	}

	public int getTARGET_TYPE() {
		return TARGET_TYPE;
	}

	public void setTARGET_TYPE(int target_type) {
		TARGET_TYPE = target_type;
	}

	public String getHOTSPOT_ID() {
		return HOTSPOT_ID;
	}

	public void setHOTSPOT_ID(String hotspot_id) {
		HOTSPOT_ID = hotspot_id;
	}

	public String getDEVICE_ID() {
		return DEVICE_ID;
	}

	public void setDEVICE_ID(String device_id) {
		DEVICE_ID = device_id;
	}

	public int getAUDIT_STATUS() {
		return AUDIT_STATUS;
	}

	public void setAUDIT_STATUS(int audit_status) {
		AUDIT_STATUS = audit_status;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	

}
