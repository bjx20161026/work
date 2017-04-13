/*
 * AuditInterface.java was created on 2012-3-28 ����11:03:00
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;

/**
 * ���Ͽ������п�ӿ���Ϣ�ȶ�
 * @author huwenjiang
 * @version V1.0 2012-3-28 ����11:03:05
 */
public class AuditInterface implements Serializable {

	private static final long serialVersionUID = -3294547152334623856L;
	/**���Ͽ�ӿ�����*/
	private String resInfName;
	/**���Ͽ�ӿ�Ip*/
	private String resInfIp;
	/**���Ͽ�ӿ�mac*/
	private String resInfMac;
	/**���п�ӿ�����*/
	private String rtInfName;
	/**���п�ӿ�Ip*/
	private String rtInfIp;
	/**���п�ӿ�mac*/
	private String rtInfMac;
	public String getResInfName() {
		return resInfName;
	}
	public void setResInfName(String resInfName) {
		this.resInfName = resInfName;
	}
	public String getResInfIp() {
		return resInfIp;
	}
	public void setResInfIp(String resInfIp) {
		this.resInfIp = resInfIp;
	}
	public String getResInfMac() {
		return resInfMac;
	}
	public void setResInfMac(String resInfMac) {
		this.resInfMac = resInfMac;
	}
	public String getRtInfName() {
		return rtInfName;
	}
	public void setRtInfName(String rtInfName) {
		this.rtInfName = rtInfName;
	}
	public String getRtInfIp() {
		return rtInfIp;
	}
	public void setRtInfIp(String rtInfIp) {
		this.rtInfIp = rtInfIp;
	}
	public String getRtInfMac() {
		return rtInfMac;
	}
	public void setRtInfMac(String rtInfMac) {
		this.rtInfMac = rtInfMac;
	}
	
}
