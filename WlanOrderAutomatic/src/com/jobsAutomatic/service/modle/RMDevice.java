package com.jobsAutomatic.service.modle;

import java.io.Serializable;

public class RMDevice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 基础信息
	private String DEVICE_ID;

	private String nameCheckRemark;	
	
	private String SYS_NAME;
	
	private String AP_NAME;

	public String getAP_NAME() {
		return AP_NAME;
	}

	public void setAP_NAME(String aPNAME) {
		AP_NAME = aPNAME;
	}

	public String getNameCheckRemark() {
		return nameCheckRemark;
	}

	public void setNameCheckRemark(String nameCheckRemark) {
		this.nameCheckRemark = nameCheckRemark;
	}

	private String IP_ADDR;

	private String MAC_ADDR;

	private String NETMASK;

	private String GATEWAY;

	private String PROVINCE;

	private String CITY;
	
	private String APANAGE;
	
	private String RMDISTRICT;

	private String SERIAL_NUMBER;

	private String SYS_LOCATION;

	private String SYS_VERSION;

	private String SYS_OID;

	private String SYS_CONTACT;

	private String SYS_UPTIME;

	private int IF_NUMBER;

	private String SOFTWARE_NAME;

	private String SOFTWARE_VERSION;

	private String PROJECT_STATUS;
	
	private String LAST_TIMESTAMP;

	private String SYS_DESCR;
	
	private String ALIAS;
	
	private String AC_SYS_NAME;
	
	private String SWITCH_SYS_NAME;

	// AP信息
	private String AC_ID;

	private String HOTSPOT_ID;

	private String HOTSPOT_LOCATION;

	private String DISTRICT;

	// AC信息
	// null
	private String SERVICE_SYSTEM_NAME; //所属业务系统
	private String COLLECTOR_ID;
	private int AP_COUNT;
	
	//switch 信息
	private String switch_level;  //设备层次
	// 设备类型 RM_DEVICE_TEMPLATE
	private String DEVICE_TYPE;
	
	private String VENDOR;
	
	private String SYS_MODEL;
	
	private String COVERAGE_SCOPE;
	
	// 采集机名称 CTL_COLLECTOR PROBE_NAME
	private String COLLECTOR_NAME;
	
	// 设备采集机分配情况，若此设备的COLLECTOR_ID字段有值，则显示已分配，否则为未分配
	private String COLLECTOR_STATUS;
	
	
	private String AGENT_ID;
	
	private String AGENT_NAME;

	private String PROJECT_NAME;
	
	// 设备代理配置情况，若此设备的AGENT_ID字段有值，则显示已分配，否则为未分配
	private String AGENT_STATUS;
	
	// 设备工程配置情况，若此设备的PROJECT_NAME字段有值，则显示已分配，否则为未分配
	private String PROJECT_NAME_STATUS;
	
	//AC机房ID
	private String roomId;
	
	//AC 板卡名称 ，格式为’厂商-机房 nasid第一段‘
	private String CODE_NAME;

	public String getCODE_NAME() {
		return CODE_NAME;
	}

	public void setCODE_NAME(String cODENAME) {
		CODE_NAME = cODENAME;
	}

	public String getAC_ID() {
		return AC_ID;
	}

	public void setAC_ID(String uuid) {
		AC_ID = uuid;
	}

	public String getCITY() {
		return CITY;
	}

	public void setCITY(String city) {
		CITY = city;
	}

	public String getDEVICE_ID() {
		return DEVICE_ID;
	}

	public void setDEVICE_ID(String deviceId) {
		DEVICE_ID = deviceId;
	}

	public String getGATEWAY() {
		return GATEWAY;
	}

	public void setGATEWAY(String gateway) {
		GATEWAY = gateway;
	}

	public String getHOTSPOT_ID() {
		return HOTSPOT_ID;
	}

	public void setHOTSPOT_ID(String hotSpotID) {
		HOTSPOT_ID = hotSpotID;
	}

	public String getIP_ADDR() {
		return IP_ADDR;
	}

	public void setIP_ADDR(String address) {
		IP_ADDR = address;
	}

	public String getMAC_ADDR() {
		return MAC_ADDR;
	}

	public void setMAC_ADDR(String macAddress) {
		MAC_ADDR = macAddress;
	}

	public String getNETMASK() {
		return NETMASK;
	}

	public void setNETMASK(String netMask) {
		NETMASK = netMask;
	}

	public String getPROVINCE() {
		return PROVINCE;
	}

	public void setPROVINCE(String province) {
		PROVINCE = province;
	}

	public String getSERIAL_NUMBER() {
		return SERIAL_NUMBER;
	}

	public void setSERIAL_NUMBER(String serialNum) {
		SERIAL_NUMBER = serialNum;
	}

	public String getSYS_LOCATION() {
		return SYS_LOCATION;
	}

	public void setSYS_LOCATION(String sysLocation) {
		SYS_LOCATION = sysLocation;
	}

	public String getSYS_NAME() {
		return SYS_NAME;
	}

	public void setSYS_NAME(String sysName) {
		SYS_NAME = sysName;
	}

	public int getIF_NUMBER() {
		return IF_NUMBER;
	}

	public void setIF_NUMBER(int ifNumber) {
		IF_NUMBER = ifNumber;
	}

	public String getLAST_TIMESTAMP() {
		return LAST_TIMESTAMP;
	}

	public void setLAST_TIMESTAMP(String lastTimestamp) {
		LAST_TIMESTAMP = lastTimestamp;
	}

	public String getSOFTWARE_NAME() {
		return SOFTWARE_NAME;
	}

	public void setSOFTWARE_NAME(String softwareName) {
		SOFTWARE_NAME = softwareName;
	}

	public String getSOFTWARE_VERSION() {
		return SOFTWARE_VERSION;
	}

	public void setSOFTWARE_VERSION(String softwareVersion) {
		SOFTWARE_VERSION = softwareVersion;
	}

	public String getSYS_CONTACT() {
		return SYS_CONTACT;
	}

	public void setSYS_CONTACT(String sysContact) {
		SYS_CONTACT = sysContact;
	}

	public String getSYS_OID() {
		return SYS_OID;
	}

	public void setSYS_OID(String sysOid) {
		SYS_OID = sysOid;
	}

	public String getSYS_UPTIME() {
		return SYS_UPTIME;
	}

	public void setSYS_UPTIME(String sysUptime) {
		SYS_UPTIME = sysUptime;
	}

	public String getSYS_VERSION() {
		return SYS_VERSION;
	}

	public void setSYS_VERSION(String sysVersion) {
		SYS_VERSION = sysVersion;
	}

	public String getHOTSPOT_LOCATION() {
		return HOTSPOT_LOCATION;
	}

	public void setHOTSPOT_LOCATION(String hotspot_location) {
		HOTSPOT_LOCATION = hotspot_location;
	}

	public String getDISTRICT() {
		return DISTRICT;
	}

	public void setDISTRICT(String district) {
		DISTRICT = district;
	}

	public String getSYS_DESCR() {
		return SYS_DESCR;
	}

	public void setSYS_DESCR(String sys_descr) {
		SYS_DESCR = sys_descr;
	}
	
	public String getCOLLECTOR_ID() {
		return COLLECTOR_ID;
	}

	public void setCOLLECTOR_ID(String collector_id) {
		COLLECTOR_ID = collector_id;
	}

	public String getCOLLECTOR_NAME() {
		return COLLECTOR_NAME;
	}

	public void setCOLLECTOR_NAME(String collector_name) {
		COLLECTOR_NAME = collector_name;
	}

	public String getDEVICE_TYPE() {
		return DEVICE_TYPE;
	}

	public void setDEVICE_TYPE(String device_type) {
		DEVICE_TYPE = device_type;
	}

	public String getAGENT_ID() {
		return AGENT_ID;
	}

	public void setAGENT_ID(String agent_id) {
		AGENT_ID = agent_id;
	}
	
	public String getPROJECT_NAME() {
		return PROJECT_NAME;
	}

	public void setPROJECT_NAME(String project_name) {
		PROJECT_NAME = project_name;
	}

	public String getAGENT_NAME() {
		return AGENT_NAME;
	}

	public void setAGENT_NAME(String agent_name) {
		AGENT_NAME = agent_name;
	}
	
	public String getALIAS() {
		return ALIAS;
	}

	public void setALIAS(String alias) {
		ALIAS = alias;
	}

	public String getCOLLECTOR_STATUS() {
		return COLLECTOR_STATUS;
	}

	public void setCOLLECTOR_STATUS(String collector_status) {
		COLLECTOR_STATUS = collector_status;
	}

	public String getAGENT_STATUS() {
		return AGENT_STATUS;
	}

	public void setAGENT_STATUS(String agent_status) {
		AGENT_STATUS = agent_status;
	}
	
	

	public String getPROJECT_NAME_STATUS() {
		return PROJECT_NAME_STATUS;
	}

	public void setPROJECT_NAME_STATUS(String project_name_status) {
		PROJECT_NAME_STATUS = project_name_status;
	}

	public String getPROJECT_STATUS() {
		return PROJECT_STATUS;
	}

	public void setPROJECT_STATUS(String project_status) {
		PROJECT_STATUS = project_status;
	}

	public String getVENDOR() {
		return VENDOR;
	}

	public void setVENDOR(String vendor) {
		VENDOR = vendor;
	}

	public String getSYS_MODEL() {
		return SYS_MODEL;
	}

	public void setSYS_MODEL(String sys_model) {
		SYS_MODEL = sys_model;
	}

	public String getCOVERAGE_SCOPE() {
		return COVERAGE_SCOPE;
	}

	public void setCOVERAGE_SCOPE(String coverage_scope) {
		COVERAGE_SCOPE = coverage_scope;
	}

	public String getRMDISTRICT() {
		return RMDISTRICT;
	}

	public void setRMDISTRICT(String rmdistrict) {
		RMDISTRICT = rmdistrict;
	}

	public String getAC_SYS_NAME() {
		return AC_SYS_NAME;
	}

	public void setAC_SYS_NAME(String ac_sys_name) {
		AC_SYS_NAME = ac_sys_name;
	}

	public String getSWITCH_SYS_NAME() {
		return SWITCH_SYS_NAME;
	}

	public void setSWITCH_SYS_NAME(String switch_sys_name) {
		SWITCH_SYS_NAME = switch_sys_name;
	}

	public String getSERVICE_SYSTEM_NAME() {
		return SERVICE_SYSTEM_NAME;
	}

	public void setSERVICE_SYSTEM_NAME(String service_system_name) {
		SERVICE_SYSTEM_NAME = service_system_name;
	}

	public String getAPANAGE() {
		return APANAGE;
	}

	public void setAPANAGE(String apanage) {
		APANAGE = apanage;
	}

	public int getAP_COUNT() {
		return AP_COUNT;
	}

	public void setAP_COUNT(int ap_count) {
		AP_COUNT = ap_count;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getSwitch_level() {
		return switch_level;
	}

	public void setSwitch_level(String switch_level) {
		this.switch_level = switch_level;
	}


}
