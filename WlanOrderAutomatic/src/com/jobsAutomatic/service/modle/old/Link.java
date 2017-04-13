package com.jobsAutomatic.service.modle.old;

public class Link extends Entity {

	private static final long serialVersionUID = -749341761257222016L;
	
	private String ID;
	
	private String LEFT_DEVICE_ID;
	
	private String LEFT_IF_ID;
	
	private String LEFT_IF_NAME;
	
	private String RIGHT_DEVICE_ID;
	
	private String RIGHT_DEVICE_NAME; 
	
	private String RIGHT_IF_ID;
	
	private String RIGHT_IF_NAME;

	public String getLEFT_DEVICE_ID() {
		return LEFT_DEVICE_ID;
	}

	public void setLEFT_DEVICE_ID(String left_device_id) {
		LEFT_DEVICE_ID = left_device_id;
	}

	public String getLEFT_IF_ID() {
		return LEFT_IF_ID;
	}

	public void setLEFT_IF_ID(String left_if_id) {
		LEFT_IF_ID = left_if_id;
	}

	public String getRIGHT_DEVICE_ID() {
		return RIGHT_DEVICE_ID;
	}

	public void setRIGHT_DEVICE_ID(String right_device_id) {
		RIGHT_DEVICE_ID = right_device_id;
	}

	public String getRIGHT_DEVICE_NAME() {
		return RIGHT_DEVICE_NAME;
	}

	public void setRIGHT_DEVICE_NAME(String right_device_name) {
		RIGHT_DEVICE_NAME = right_device_name;
	}

	public String getRIGHT_IF_ID() {
		return RIGHT_IF_ID;
	}

	public void setRIGHT_IF_ID(String right_if_id) {
		RIGHT_IF_ID = right_if_id;
	}

	public String getRIGHT_IF_NAME() {
		return RIGHT_IF_NAME;
	}

	public void setRIGHT_IF_NAME(String right_if_name) {
		RIGHT_IF_NAME = right_if_name;
	}

	public String getLEFT_IF_NAME() {
		return LEFT_IF_NAME;
	}

	public void setLEFT_IF_NAME(String left_if_name) {
		LEFT_IF_NAME = left_if_name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String id) {
		ID = id;
	}
}
