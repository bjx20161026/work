package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;
/**
 * ���ɳ���ģ��
 * @author wjhu
 * @date 2012-2-10 ����03:41:58
 */
public class ImpVendor implements Serializable {
	private static final long serialVersionUID = 4869315254726276008L;
	private String uuid;
	private String name;
	private String apanage;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApanage() {
		return apanage;
	}
	public void setApanage(String apanage) {
		this.apanage = apanage;
	}
	
}
