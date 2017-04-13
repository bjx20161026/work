package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;

public class AlarmJumpResult implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String city;
	private String hotspotname;
	private String sysname;
	private String ipaddr;
	private String title;
	private String severity;
	private String starttime;
	private String descr;
	private String status;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHotspotname() {
		return hotspotname;
	}
	public void setHotspotname(String hotspotname) {
		this.hotspotname = hotspotname;
	}
	public String getSysname() {
		return sysname;
	}
	public void setSysname(String sysname) {
		this.sysname = sysname;
	}
	public String getIpaddr() {
		return ipaddr;
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
