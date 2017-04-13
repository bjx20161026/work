package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;
/**
 * ��������ģ��
 * @author wjhu
 * @date 2012-2-26 ����10:56:18
 */
public class coverType implements Serializable{
	private static final long serialVersionUID = -3562102745523362873L;
	private String ID;
	private String NAME;
    public coverType() {
    }
    public coverType(String ID) {
        this.ID = ID;
    }

    public String getID() {
		return ID;
	}
	public void setID(String id) {
		ID = id;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String name) {
		NAME = name;
	}
}
