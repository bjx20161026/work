/*
 * ApImportDto.java was created on 12-6-6 ����12:39
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.modle;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: wjhu
 * Date: 12-6-6
 * Time: ����12:39
 * To change this template use File | Settings | File Templates.
 */
public class ApImportDto implements Serializable {

    private static final long serialVersionUID = 5141225769093528193L;
    /***
     * �����ȵ�NAS_ID
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
     * mac��ַ
     */
    private String macAddr;
    /**
     * �����ַ
     */
    private String ipAddr;
    /**
     * ����汾
     */
    private String sysVersion;
    /**
     * �Ƿ�˫��
     * <p>
     * ȡֵ��Χ:0 : �� 1�� ��
     */
    private int dualCard;
    /**
     * �豸����
     */
    private String vendor;
    /**
     * �豸�ͺ�
     */
    private String model;
    /**
     * ����������
     */
    private String switchName;
    /**
     * ���緽ʽ
     */
    private String powerSupplyMode;
    /**
     * ����ģʽ
     * ȡֵ��Χ: 1- ���� 2- ����
     */
    private int coverageMode;
    /**
     * ��װλ��
     */
    private String location;
    /**
     * ��ͨƵ�㣨һ��Ϊ1��6��11����һ���� ����ܳ���13
     */
    private int channel;
    /**
     * ���Ƿ�Χ
     */
    private String coverageScope;
    /**
     * ¼����Ա����
     */
    private long entryStaff;

    private int row;

    private int column;
    
    /**
     * �����豸
     */
    private String onwerDevice;
    
    /**
     * ap����
     */
    private String apType;
    
    private String remark;
    
    private int combineMode;

    public int getCombineMode() {
		return combineMode;
	}

	public void setCombineMode(int combineMode) {
		this.combineMode = combineMode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getApType() {
		return apType;
	}

	public void setApType(String apType) {
		this.apType = apType;
	}

	public String getOnwerDevice() {
		return onwerDevice;
	}

	public void setOnwerDevice(String onwerDevice) {
		this.onwerDevice = onwerDevice;
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

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getSysVersion() {
        return sysVersion;
    }

    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion;
    }

    public int getDualCard() {
        return dualCard;
    }

    public void setDualCard(int dualCard) {
        this.dualCard = dualCard;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getSwitchName() {
        return switchName;
    }

    public void setSwitchName(String switchName) {
        this.switchName = switchName;
    }

    public String getPowerSupplyMode() {
        return powerSupplyMode;
    }

    public void setPowerSupplyMode(String powerSupplyMode) {
        this.powerSupplyMode = powerSupplyMode;
    }

    public int getCoverageMode() {
        return coverageMode;
    }

    public void setCoverageMode(int coverageMode) {
        this.coverageMode = coverageMode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getCoverageScope() {
        return coverageScope;
    }

    public void setCoverageScope(String coverageScope) {
        this.coverageScope = coverageScope;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getEntryStaff() {
        return entryStaff;
    }

    public void setEntryStaff(long entryStaff) {
        this.entryStaff = entryStaff;
    }
}
