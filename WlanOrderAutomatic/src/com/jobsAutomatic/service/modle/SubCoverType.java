package com.jobsAutomatic.service.modle;

import java.io.Serializable;
public class SubCoverType implements Serializable {
	private static final long serialVersionUID = 5887684598128185825L;
	private String name;
	private String id;
	private String parentType;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentType() {
		return parentType;
	}
	public void setParentType(String parentType) {
		this.parentType = parentType;
	}
}
