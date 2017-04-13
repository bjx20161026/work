/*
 * NasIdCheck.java was created on 12-6-16 ����1:58
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;

/**
 * @author: wjhu
 * @date: 12-6-16
 * @time: ����1:58
 */
public class NasIdCheck implements Serializable {
    private static final long serialVersionUID = -7071785541347942998L;
    /**
     * ��AC
     */
    private String primaryName;
    /**
     * ��AC
     */
    private String backupName;
    /**
     * ip��ַ
     */
    private String ipAddr;
    /**
     * ��ACNasId
     */
    private String primaryNasId;
    /**
     * ��ACNasId
     */
    private String backupNasId;
    /**
     * ����NasId
     */
    private String omcNasId;
    /**
     * �ǻ�����NasId
     */
    private String smartNasId;

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public String getBackupName() {
        return backupName;
    }

    public void setBackupName(String backupName) {
        this.backupName = backupName;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getPrimaryNasId() {
        return primaryNasId;
    }

    public void setPrimaryNasId(String primaryNasId) {
        this.primaryNasId = primaryNasId;
    }

    public String getBackupNasId() {
        return backupNasId;
    }

    public void setBackupNasId(String backupNasId) {
        this.backupNasId = backupNasId;
    }

    public String getOmcNasId() {
        return omcNasId;
    }

    public void setOmcNasId(String omcNasId) {
        this.omcNasId = omcNasId;
    }

    public String getSmartNasId() {
        return smartNasId;
    }

    public void setSmartNasId(String smartNasId) {
        this.smartNasId = smartNasId;
    }
}
