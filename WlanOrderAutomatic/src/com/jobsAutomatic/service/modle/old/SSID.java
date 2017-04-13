package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;

/**
 * SSIDʵ��ģ��
 * 
 * @author huwenjiang
 * @version V1.0 2012-3-1 ����10:07:17
 */
public class SSID implements Serializable {
	private static final long serialVersionUID = -3562102745523362873L;
	/**
	 * UUID
	 */
	private String id;
	/**
	 * ����
	 */
	private String name;
	/**
	 * ҵ������
	 */
	private String businessType;
	/**
	 * ��ע
	 */
	private String remark;

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

}
