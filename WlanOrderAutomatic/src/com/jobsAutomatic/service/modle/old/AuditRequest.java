/*
 * AuditRequest.java was created on 2012-5-16 ����03:27:48
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;
import java.util.Date;

/**
 * ��˶���ģ��
 * 
 * @author huwenjiang
 * @version V1.0 2012-5-16 ����03:34:51
 */
public class AuditRequest implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1137865596054603587L;
	/**
	 * RES.PRM_AUDIT_REQUEST.REQ_NO (���������)
	 * 
	 * @ibatorgenerated 2012-05-16 15:31:39
	 */
	private Integer reqNo;
	/**
	 * RES.PRM_AUDIT_REQUEST.REQ_TYPE (��������: 1- ���� 2 - ����)
	 * 
	 * @ibatorgenerated 2012-05-16 15:31:39
	 */
	private Integer reqType;
	/**
	 * RES.PRM_AUDIT_REQUEST.TARGET_TYPE (��˶������� �� 1- �豸 2- �ȵ�)
	 * 
	 * @ibatorgenerated 2012-05-16 15:31:39
	 */
	private Integer targetType;
	/**
	 * RES.PRM_AUDIT_REQUEST.OBJECT_ID (�ȵ�ID �� �豸ID)
	 * 
	 * @ibatorgenerated 2012-05-16 15:31:39
	 */
	private String objectId;
	/**
	 * RES.PRM_AUDIT_REQUEST.EMP_NO (�����˹���)
	 * 
	 * @ibatorgenerated 2012-05-16 15:31:39
	 */
	private Integer empNo;
	/**
	 * RES.PRM_AUDIT_REQUEST.REQ_TIME (����ʱ��)
	 * 
	 * @ibatorgenerated 2012-05-16 15:31:39
	 */
	private Date reqTime;
	/**
	 * RES.PRM_AUDIT_REQUEST.REQ_CAUSE (��������)
	 * 
	 * @ibatorgenerated 2012-05-16 15:31:39
	 */
	private String reqCause;
	/**
	 * RES.PRM_AUDIT_REQUEST.ATTACHMENT (�����ĵ��������˴��·��)
	 * 
	 * @ibatorgenerated 2012-05-16 15:31:39
	 */
	private String attachment;
	/**
	 * RES.PRM_AUDIT_REQUEST.STATUS (����״̬: 0 - δ���� 1 - �Ѵ���)
	 * 
	 * @ibatorgenerated 2012-05-16 15:31:39
	 */
	private Integer status;

	public Integer getReqNo() {
		return reqNo;
	}

	public void setReqNo(Integer reqNo) {
		this.reqNo = reqNo;
	}

	public Integer getReqType() {
		return reqType;
	}

	public void setReqType(Integer reqType) {
		this.reqType = reqType;
	}

	public Integer getTargetType() {
		return targetType;
	}

	public void setTargetType(Integer targetType) {
		this.targetType = targetType;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public Date getReqTime() {
		return reqTime;
	}

	public void setReqTime(Date reqTime) {
		this.reqTime = reqTime;
	}

	public String getReqCause() {
		return reqCause;
	}

	public void setReqCause(String reqCause) {
		this.reqCause = reqCause;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
