package com.jobsAutomatic.service.modle;

import java.util.Date;

public class OrdrWithFile {
	private String xmltext;
	private Date opreate_date;
	private int flag;
	private String uuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getXmltext() {
		return xmltext;
	}

	public void setXmltext(String xmltext) {
		this.xmltext = xmltext;
	}

	public Date getOpreate_date() {
		return opreate_date;
	}

	public void setOpreate_date(Date opreate_date) {
		this.opreate_date = opreate_date;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
