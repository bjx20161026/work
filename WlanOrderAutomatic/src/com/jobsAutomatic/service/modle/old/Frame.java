package com.jobsAutomatic.service.modle.old;

import java.util.ArrayList;
import java.util.List;
/**
 * ����ģ��
 * @author wjhu
 * @date 2012-2-9 ����10:36:35
 */
public class Frame extends Entity {
	private static final long serialVersionUID = 5896299674209833022L;
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
	 * �������� 
	 */
	private String NAME ="MainFrame";
	/**
	 * (�Ƿ�ռ�ã�0-��1-�� Ĭ����0)
	 */
	private String OCCUPY_STATUS;
	/**
	 * ����
	 */
    private String VENDOR;
    /**
     * ��λ�б�
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<Slot> slotList = new ArrayList(); 
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
	public String getOCCUPY_STATUS() {
		return OCCUPY_STATUS;
	}
	public void setOCCUPY_STATUS(String occupy_status) {
		OCCUPY_STATUS = occupy_status;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public List<Slot> getSlotList() {
		return slotList;
	}
	public void setSlotList(List<Slot> slotList) {
		this.slotList = slotList;
	}
	public String getINSTANCE() {
		return INSTANCE;
	}
	public void setINSTANCE(String instance) {
		INSTANCE = instance;
	}
	public String getVENDOR()
	{
		return VENDOR;
	}
	public void setVENDOR(String vendor)
	{
		VENDOR = vendor;
	}
	
}
