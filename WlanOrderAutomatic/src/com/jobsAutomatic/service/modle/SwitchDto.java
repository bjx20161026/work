/*
 * SwitchDto.java was created on 12-6-6 ����10:37
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.modle;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: wjhu
 * Date: 12-6-6
 * Time: ����10:37
 * To change this template use File | Settings | File Templates.
 */
public class SwitchDto implements Serializable {

    private static final long serialVersionUID = -5555752533746926909L;
    /**
     * NAS_ID
     */
    private String nasId;
    /**
     * �豸����
     */
    private String sysName;
    /**
     * �豸����
     */
    private String alias;
    /**
     * IP��ַ
     */
    private String ipAddr;
    /**
     * ���������(1 - ���Ľ����� 2 - ��۽����� 3 - �ȵ��۽����� 4 - �ȵ���뽻����)
     */
    private int switchLevel;
    /**
     * �豸����
     */
    private String vendor;
    /**
     * �豸�ͺ�
     */
    private String model;
    /**
     * ��community
     */
    private String readCommunity;
    /**
     *дcommunity
     */
    private String writeCommunity;
    /**
     * ��װλ��
     */
    private String location;
    /**
     * �����˿�����
     */
    private String upPortName;
    /**
     * ¼����Ա����
     */
    private long entryStaff;
    /**
     * ����������Excel���������� (���ڴ�����ʾ)
     */
    private int row;
    /**
     * ����������Excel����������  (���ڴ�����ʾ)
     */
    private int column;
    
    /**
     * ��������(�������)
     */
    private String primarySwitch;
    
    /**
     * �������MB��
     */
    private String transformBandWidth;
    
    /**
     * ���������ڶ˿�
     */
    private String switchExitPort;
    
    /**
     * ��ע
     */
    private String remark;

    public String getPrimarySwitch() {
		return primarySwitch;
	}

	public void setPrimarySwitch(String primarySwitch) {
		this.primarySwitch = primarySwitch;
	}

	public String getTransformBandWidth() {
		return transformBandWidth;
	}

	public void setTransformBandWidth(String transformBandWidth) {
		this.transformBandWidth = transformBandWidth;
	}

	public String getSwitchExitPort() {
		return switchExitPort;
	}

	public void setSwitchExitPort(String switchExitPort) {
		this.switchExitPort = switchExitPort;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getNasId() {
        return nasId;
    }

    public void setNasId(String nasId) {
        this.nasId = nasId;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public int getSwitchLevel() {
        return switchLevel;
    }

    public void setSwitchLevel(int switchLevel) {
        this.switchLevel = switchLevel;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReadCommunity() {
        return readCommunity;
    }

    public void setReadCommunity(String readCommunity) {
        this.readCommunity = readCommunity;
    }

    public String getWriteCommunity() {
        return writeCommunity;
    }

    public void setWriteCommunity(String writeCommunity) {
        this.writeCommunity = writeCommunity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUpPortName() {
        return upPortName;
    }

    public void setUpPortName(String upPortName) {
        this.upPortName = upPortName;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public long getEntryStaff() {
        return entryStaff;
    }

    public void setEntryStaff(long entryStaff) {
        this.entryStaff = entryStaff;
    }
}
