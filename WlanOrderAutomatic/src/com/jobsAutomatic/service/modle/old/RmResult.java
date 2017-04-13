package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;

public class RmResult implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String value;
	private String key;
	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
