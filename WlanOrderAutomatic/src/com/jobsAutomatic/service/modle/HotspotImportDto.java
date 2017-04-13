/*
 * HotspotImportDto.java was created on 12-6-2 ����7:38
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.modle;

import java.util.Date;

/**
 * Created with IntelliJ IDEA. User: wjhu Date: 12-6-2 Time: ����7:38 To change
 * this template use File | Settings | File Templates.
 */
public class HotspotImportDto {
	private String SpareAC;//所属备用AC
	public String getSpareAC() {
		return SpareAC;
	}
	public void setSpareAC(String spareAC) {
		SpareAC = spareAC;
	}
	/**
	 * �ȵ�����
	 */
	private String hotspotName;
	/**
	 * �ȵ�NAS_ID
	 */
	private String nasId;
	/**
	 * �����߼��ȵ�
	 */
	private String primaryHotspotName;
	/**
	 * �ȵ�����
	 */
	private String hotspotType;
	/**
	 * �ȵ��ַ
	 */
	private String location;
	/**
	 * ���� �� ֱϽ������
	 */
	private String city;
	/**
	 * ���ػ�������
	 */
	private String district;
	/**
	 * �ȵ��ڽ�������
	 */
	private Integer switchNumber;
	/**
	 * VIP���� : 1 - ��ͨ 2- VIP 3 - VVIP
	 */
	private Integer isVip;
	/**
	 * ����
	 */
	private float longtitude;
	/**
	 * γ��
	 */
	private float latitude;
	/**
	 * ���̱��
	 */
	private String project_no;
	/**
	 * ���ɳ���
	 */
	private String impVendor;
	/**
	 * �������ͣ�0- ���� 1- MSTP 2- GPON 3 - PTN 4 - E1
	 */
	private Integer transType;
	/**
	 * ���䵥���λ����������ΪMSTP ʱ��Ҫ¼��
	 */
	private String transCardLoc;
	/**
	 * �������߼ܣ���������ΪMSTP ʱ��Ҫ¼��
	 */
	private String df;
	/**
	 * ����������������ΪMSTP ʱ��Ҫ¼��
	 */
	private String ring;
	/**
	 * ��ά����
	 */
	private String maintVendor;
	/**
	 * ��������
	 */
	private String coverType;
	/**
	 * ����������
	 */
	private String subCoverType;
	/**
	 * ���Ƿ�Χ
	 */
	private String coverageScope;
	/**
	 * �ȵ���AP��
	 */
	private Integer apNumber;
	/**
	 * ����״̬: 1 - �������� 2 - �����½� 3 - ��ʱ���� 4 - ���̸��
	 */
	private Integer projectStatus;
	/**
	 * ��ע
	 */
	private String remark;
	/**
	 * �ȵ����
	 */
	private Integer bandwith;
	/**
	 * ����ģʽ �� 1- ���� 2 - ���� 3 - ����/����
	 */
	private Integer coverageMode;
	/**
	 * ��·ģʽ : 1 - ���� 2- 3G��· 3 - 2G��· 4 - 2G/3G��·
	 */
	private Integer combineMode;
	/**
	 * ¼����Ա����
	 */
	private Integer entryStaff;
	/**
	 * �豸����
	 */
	private String vendor;

	/**
	 * ���ص�ַ
	 */
	private String gateway;
	/**
	 * ������IP������ַ
	 */
	private String swAddrTo;
	/**
	 * ������IP��ʼ��ַ
	 */
	private String swAddrFrom;
	/**
	 * AP ip��ʼ��ַ
	 */
	private String apAddrFrom;
	/**
	 * AP ip������ַ
	 */
	private String apAddrTo;
	/**
	 * IP��ַ��
	 */
	private String ipAddrSegment;
	/**
	 * ������ʼ��ַ
	 */
	private String netAddrFrom;
	/**
	 * ���ν�����ַ
	 */
	private String netAddrTo;
	/**
	 * �������� 24-30 ������
	 */
	private int mask;
	/**
	 * ��۽���������
	 */
	private String coreSwitchName;
	/**
	 * ��۽������˿�
	 */
	private String coreSwitchPort;
	/**
	 * VLAN
	 */
	private String vlan;
	/**
	 * SSID
	 */
	private String ssids;
	/**
	 * ����AC
	 */
	private String acs;
	/**
	 * ������¼����excel��
	 */
	private int row;

    private int column;
    
    private String  landMarks;
    
    private String  ceLlid;
    
    private String  laCid;
    
    /**
     * ������
     */
    private String workOrderId;

    /**
     * ��������
     */
    private String workOrderTheme;
    
    /**
     * ��������   (1-���� 2-���� 3-���)
     */
    private int workOrderType;
    
    /**
     * ������
     */
    private String operator;
    
    /**
     * ��������
     */
    private String operateDept;
    
    /**
     * ����ʱ��
     */
    private Date operateTime;
    
    /**
     * �����ȵ�ȼ�
     */
    private String hotspotLevel;
    
    /**
     * wlanҵ������
     */
    private String wlanServiceType; 
    
    /**
     * ��Ŀ���
     */
    private String projectNum;
    
    /**
     * ����ҵ��  0����   1����
     */
    private Integer cooService;
    
    /**
     * ��ͨʱ��
     */
    private Date projectCompleteDate;
    
    /**
     * ��άʱ��
     */
    private Date projectAcceptDate;
    
    /**
     * ��������ʱ��
     */
    private Date projectApplyDate;
    
    /**
     * �Ƿ�����VI��ʶ  0:��  1����
     */
    private Integer isVi;
    
	public Integer getIsVip() {
		return isVip;
	}
	public void setIsVip(Integer isVip) {
		this.isVip = isVip;
	}
	public String getWlanServiceType() {
		return wlanServiceType;
	}
	public void setWlanServiceType(String wlanServiceType) {
		this.wlanServiceType = wlanServiceType;
	}
	public Date getProjectCompleteDate() {
		return projectCompleteDate;
	}
	public void setProjectCompleteDate(Date projectCompleteDate) {
		this.projectCompleteDate = projectCompleteDate;
	}
	public Date getProjectAcceptDate() {
		return projectAcceptDate;
	}
	public void setProjectAcceptDate(Date projectAcceptDate) {
		this.projectAcceptDate = projectAcceptDate;
	}
	public Date getProjectApplyDate() {
		return projectApplyDate;
	}
	public void setProjectApplyDate(Date projectApplyDate) {
		this.projectApplyDate = projectApplyDate;
	}
	public Integer getCooService() {
		return cooService;
	}
	public void setCooService(Integer cooService) {
		this.cooService = cooService;
	}
	public Integer getIsVi() {
		return isVi;
	}
	public void setIsVi(Integer isVi) {
		this.isVi = isVi;
	}
	public String getHotspotLevel() {
		return hotspotLevel;
	}
	public void setHotspotLevel(String hotspotLevel) {
		this.hotspotLevel = hotspotLevel;
	}
	public String getWorkOrderId() {
		return workOrderId;
	}
	public void setWorkOrderId(String workOrderId) {
		this.workOrderId = workOrderId;
	}
	public String getWorkOrderTheme() {
		return workOrderTheme;
	}
	public void setWorkOrderTheme(String workOrderTheme) {
		this.workOrderTheme = workOrderTheme;
	}
	public int getWorkOrderType() {
		return workOrderType;
	}
	public void setWorkOrderType(int workOrderType) {
		this.workOrderType = workOrderType;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperateDept() {
		return operateDept;
	}
	public void setOperateDept(String operateDept) {
		this.operateDept = operateDept;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	public String getAcs() {
		return acs;
	}
	public String getApAddrFrom() {
		return apAddrFrom;
	}

	public String getApAddrTo() {
		return apAddrTo;
	}

	public Integer getApNumber() {
		return apNumber;
	}

	public Integer getBandwith() {
		return bandwith;
	}

	public String getCity() {
		return city;
	}

	public int getColumn() {
		return column;
	}

	public Integer getCombineMode() {
		return combineMode;
	}

	public String getCoreSwitchName() {
		return coreSwitchName;
	}

	public String getCoreSwitchPort() {
		return coreSwitchPort;
	}

	public Integer getCoverageMode() {
		return coverageMode;
	}

	public String getCoverageScope() {
		return coverageScope;
	}

	public String getCoverType() {
		return coverType;
	}

	public String getDf() {
		return df;
	}

	public String getDistrict() {
		return district;
	}

	public Integer getEntryStaff() {
		return entryStaff;
	}

	public String getGateway() {
		return gateway;
	}

	public String getHotspotName() {
		return hotspotName;
	}

	public String getHotspotType() {
		return hotspotType;
	}

	public String getImpVendor() {
		return impVendor;
	}

	public String getIpAddrSegment() {
		return ipAddrSegment;
	}

	public float getLatitude() {
		return latitude;
	}

	public String getLocation() {
		return location;
	}

	public float getLongtitude() {
		return longtitude;
	}

	public String getMaintVendor() {
		return maintVendor;
	}

	public int getMask() {
		return mask;
	}

	public String getNasId() {
		return nasId;
	}

	public String getNetAddrFrom() {
		return netAddrFrom;
	}

	public String getNetAddrTo() {
		return netAddrTo;
	}

	public String getPrimaryHotspotName() {
		return primaryHotspotName;
	}

	public String getProject_no() {
		return project_no;
	}

	public Integer getProjectStatus() {
		return projectStatus;
	}

	public String getRemark() {
		return remark;
	}

	public String getRing() {
		return ring;
	}

	public int getRow() {
		return row;
	}

	public String getSsids() {
		return ssids;
	}

	public String getSubCoverType() {
		return subCoverType;
	}

	public String getSwAddrFrom() {
		return swAddrFrom;
	}

	public String getSwAddrTo() {
		return swAddrTo;
	}

	public Integer getSwitchNumber() {
		return switchNumber;
	}

	public String getTransCardLoc() {
		return transCardLoc;
	}

	public Integer getTransType() {
		return transType;
	}

	public String getVendor() {
		return vendor;
	}

	public Integer getVip() {
		return isVip;
	}

	public String getVlan() {
		return vlan;
	}

	public void setAcs(String acs) {
		this.acs = acs;
	}

	public void setApAddrFrom(String apAddrFrom) {
		this.apAddrFrom = apAddrFrom;
	}

	public void setApAddrTo(String apAddrTo) {
		this.apAddrTo = apAddrTo;
	}

	public void setApNumber(Integer apNumber) {
		this.apNumber = apNumber;
	}

	public void setBandwith(Integer bandwith) {
		this.bandwith = bandwith;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public void setCombineMode(Integer combineMode) {
		this.combineMode = combineMode;
	}

	public void setCoreSwitchName(String coreSwitchName) {
		this.coreSwitchName = coreSwitchName;
	}

	public void setCoreSwitchPort(String coreSwitchPort) {
		this.coreSwitchPort = coreSwitchPort;
	}

	public void setCoverageMode(Integer coverageMode) {
		this.coverageMode = coverageMode;
	}

	public void setCoverageScope(String coverageScope) {
		this.coverageScope = coverageScope;
	}

	public void setCoverType(String coverType) {
		this.coverType = coverType;
	}

	public void setDf(String df) {
		this.df = df;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setEntryStaff(Integer entryStaff) {
		this.entryStaff = entryStaff;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public void setHotspotName(String hotspotName) {
		this.hotspotName = hotspotName;
	}

	public void setHotspotType(String hotspotType) {
		this.hotspotType = hotspotType;
	}

	public void setImpVendor(String impVendor) {
		this.impVendor = impVendor;
	}

	public void setIpAddrSegment(String ipAddrSegment) {
		this.ipAddrSegment = ipAddrSegment;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setLongtitude(float longtitude) {
		this.longtitude = longtitude;
	}

	public void setMaintVendor(String maintVendor) {
		this.maintVendor = maintVendor;
	}

	public void setMask(int mask) {
		this.mask = mask;
	}

	public void setNasId(String nasId) {
		this.nasId = nasId;
	}

	public void setNetAddrFrom(String netAddrFrom) {
		this.netAddrFrom = netAddrFrom;
	}

	public void setNetAddrTo(String netAddrTo) {
		this.netAddrTo = netAddrTo;
	}

	public void setPrimaryHotspotName(String primaryHotspotName) {
		this.primaryHotspotName = primaryHotspotName;
	}

	public void setProject_no(String project_no) {
		this.project_no = project_no;
	}

	public void setProjectStatus(Integer projectStatus) {
		this.projectStatus = projectStatus;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setRing(String ring) {
		this.ring = ring;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setSsids(String ssids) {
		this.ssids = ssids;
	}

	public void setSubCoverType(String subCoverType) {
		this.subCoverType = subCoverType;
	}

	public void setSwAddrFrom(String swAddrFrom) {
		this.swAddrFrom = swAddrFrom;
	}

	public void setSwAddrTo(String swAddrTo) {
		this.swAddrTo = swAddrTo;
	}

	public void setSwitchNumber(Integer switchNumber) {
		this.switchNumber = switchNumber;
	}

	public void setTransCardLoc(String transCardLoc) {
		this.transCardLoc = transCardLoc;
	}

	public void setTransType(Integer transType) {
		this.transType = transType;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public void setVip(Integer vip) {
		isVip = vip;
	}

	public void setVlan(String vlan) {
		this.vlan = vlan;
	}
	public String getLandMarks() {
		return landMarks;
	}
	public void setLandMarks(String landMarks) {
		this.landMarks = landMarks;
	}
	public String getCeLlid() {
		return ceLlid;
	}
	public void setCeLlid(String ceLlid) {
		this.ceLlid = ceLlid;
	}
	public String getLaCid() {
		return laCid;
	}
	public void setLaCid(String laCid) {
		this.laCid = laCid;
	}
	public String getProjectNum() {
		return projectNum;
	}
	public void setProjectNum(String projectNum) {
		this.projectNum = projectNum;
	}
}
