package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;
/**
 * ��ά����ģ��
 * @author wjhu
 * @date 2012-2-26 ����10:56:31
 */
public class MaintVendor implements Serializable {
	private static final long serialVersionUID = -1518239709649764614L;
	private String uuid;
	private String name;
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
}
