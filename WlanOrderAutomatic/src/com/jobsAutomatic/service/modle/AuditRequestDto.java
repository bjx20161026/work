/*
 * AuditRequestDto.java was created on 2012-5-1810:51:24
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.modle;

import com.jobsAutomatic.service.modle.old.AuditRequest;

public class AuditRequestDto {

    private AuditRequest areq;

    private int auditResult;

    private int manageType;

    @SuppressWarnings("unused")
	private String detail;

    @SuppressWarnings("unused")
	private String user;
    
    private String objectType;

    public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public AuditRequest getAreq() {
        return areq;
    }

    public int getManageType() {
        return manageType;
    }

    public void setManageType(int manageType) {
        this.manageType = manageType;
    }

    public void setAreq(AuditRequest areq) {
        this.areq = areq;
    }

    public int getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(int auditResult) {
        this.auditResult = auditResult;
    }
}
