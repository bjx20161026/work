package com.jobsAutomatic.service.modle.old;

public class hotInterface extends Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 0L;
	private String HOT_ID;
	private String SWITCH_ID;
	private String SWITCH_NAME;
	private String SWITCH_PORT_ID;
	private String SWITCH_PORT_NAME;
	private String VLAN;
	public String getHOT_ID() {
		return HOT_ID;
	}
	public void setHOT_ID(String hot_id) {
		HOT_ID = hot_id;
	}
	public String getSWITCH_ID() {
		return SWITCH_ID;
	}
	public void setSWITCH_ID(String switch_id) {
		SWITCH_ID = switch_id;
	}
	public String getSWITCH_NAME() {
		return SWITCH_NAME;
	}
	public void setSWITCH_NAME(String switch_name) {
		SWITCH_NAME = switch_name;
	}
	public String getSWITCH_PORT_ID() {
		return SWITCH_PORT_ID;
	}
	public void setSWITCH_PORT_ID(String switch_port_id) {
		SWITCH_PORT_ID = switch_port_id;
	}
	public String getSWITCH_PORT_NAME() {
		return SWITCH_PORT_NAME;
	}
	public void setSWITCH_PORT_NAME(String switch_port_name) {
		SWITCH_PORT_NAME = switch_port_name;
	}
	public String getVLAN() {
		return VLAN;
	}
	public void setVLAN(String vlan) {
		VLAN = vlan;
	}
}
