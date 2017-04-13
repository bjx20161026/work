package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;

/**
 * 
 * @author wanghp
 * 2012-6-20
 * ӵ�ж��IP��ַ��AC��ѯ��
 *
 */
public class AcNasIdCompare implements Serializable{
	private static final long serialVersionUID = 7118760451822734428L;
	private String acName;
	private String ipAddress;
	private String webNasId;
	private String peapNasId;
	/**
	 * 
	 * @return ���AC����
	 */
	public String getAcName() {
		return acName;
	}
	/**
	 * 
	 * @return ����AC����
	 */
	public void setAcName(String acName) {
		this.acName = acName;
	}
	/**
	 * 
	 * @return ���IP��ַ
	 */
	public String getIpAddress() {
		return ipAddress;
	}
	/**
	 * 
	 * @return ����IP��ַ
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	/**
	 * 
	 * @return ���WebNasId
	 */
	public String getWebNasId() {
		return webNasId;
	}
	/**
	 * 
	 * @return ����WebNasId
	 */
	public void setWebNasId(String webNasId) {
		this.webNasId = webNasId;
	}
	/**
	 * 
	 * @return ���PeapNasId
	 */
	public String getPeapNasId() {
		return peapNasId;
	}
	/**
	 * 
	 * @return ����PeapNasId
	 */
	public void setPeapNasId(String peapNasId) {
		this.peapNasId = peapNasId;
	}
	
}
