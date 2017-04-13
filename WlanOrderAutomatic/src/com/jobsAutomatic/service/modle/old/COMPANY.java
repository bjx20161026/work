package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;
public class COMPANY implements Serializable{
	private static final long serialVersionUID = -3562102745523362873L;
	private String UUID;
	private String NAME;
	private String APANAGE;
	private String CONTACT;
	private String PHONE;
	private String FAX;
	private String EMAIL;
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uuid) {
		UUID = uuid;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String name) {
		NAME = name;
	}
	public String getAPANAGE() {
		return APANAGE;
	}
	public void setAPANAGE(String apanage) {
		APANAGE = apanage;
	}
	public String getCONTACT() {
		return CONTACT;
	}
	public void setCONTACT(String contact) {
		CONTACT = contact;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String phone) {
		PHONE = phone;
	}
	public String getFAX() {
		return FAX;
	}
	public void setFAX(String fax) {
		FAX = fax;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String email) {
		EMAIL = email;
	}
}
