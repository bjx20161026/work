package com.jobsAutomatic.service.modle;

import java.io.Serializable;

public class Room implements Serializable  {
	private static final long serialVersionUID = 3122351091873805286L;
	private String name;
	private String id;
	private String district;
	private String apanage;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApanage() {
		return apanage;
	}

	public void setApanage(String apanage) {
		this.apanage = apanage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
}
