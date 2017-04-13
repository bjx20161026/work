package com.jobsAutomatic.service.modle.old;

/**
 * �ӿڱ�ģ��
 * 
 * @author wjhu
 * @date 2012-2-26 ����10:48:11
 */
public class Interface extends Entity {

	private static final long serialVersionUID = -749341761257222016L;
	/**
	 * �ӿ�UUID
	 */
	private String ID;
	/**
	 * �豸UUID
	 */
	private String DEVICE_ID;
	/**
	 * �豸
	 */
	private Device device;
	/**
	 * �ӿ�����
	 */
	private String IF_NAME;
	/**
	 * �ӿ�IP��ַ
	 */
	private String IP_ADDR; 
	/**
	 * IP��ַ����
	 */
	private String NETMASK;
	/**
	 * �ӿ�����VLAN
	 */
	private String VLAN_ID;
	/**
	 * �ӿ�����
	 */
	private InterfaceType interfaceType;
	/**
	 * �ӿ�����
	 */
	private String INTERFACE_TYPE;
	/**
	 * �ӿ�����
	 */
	private String INTERFACE_TYPE_NAME;
	/**
	 * �ӿ�MAC ��ַ
	 */
	private String MAC_ADDR;// 
	private String IF_SPEED;// 
	/**
	 * PRM_INTERFACE.SERVICE_SYSTEM(����ҵ��ϵͳ��CMNET, WLAN)
	 */
	private String SERVICE_SYSTEM="WLAN";
	/**
	 * PRM_INTERFACE.DIRECTION(�ӿڻ�������1 :  �����˿� 2: �����˿� 3: ���ݻ����˿�)
	 */
	private Integer DIRECTION;
	/**
	 * PRM_INTERFACE.REAL_BANDWIDTH(�������( ��λΪMbps))
	 */
	private Integer REAL_BANDWIDTH;
	/**
	 * PRM_INTERFACE.BANDWIDTH(�ɼ�����(bps))
	 */
	private long BANDWIDTH;
	/**
	 * PRM_INTERFACE.IF_DESCR(�ӿ�������Ϣ)
	 */
	private String IF_DESCR;
	/**
	 * PRM_INTERFACE.IF_INDEX(��ӦMIB��ӿ�����)
	 */
	private Integer IF_INDEX;

	public String getIF_DESCR() {
		return IF_DESCR;
	}

	public void setIF_DESCR(String if_descr) {
		IF_DESCR = if_descr;
	}

	public Integer getIF_INDEX() {
		return IF_INDEX;
	}

	public void setIF_INDEX(Integer if_index) {
		IF_INDEX = if_index;
	}

	public InterfaceType getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(InterfaceType interfaceType) {
		this.interfaceType = interfaceType;
	}

	public String getMAC_ADDR() {
		return MAC_ADDR;
	}

	public void setMAC_ADDR(String mac_addr) {
		MAC_ADDR = mac_addr;
	}

	public String getID() {
		return ID;
	}

	public void setID(String id) {
		ID = id;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public String getIF_NAME() {
		return IF_NAME;
	}

	public void setIF_NAME(String if_name) {
		IF_NAME = if_name;
	}

	public String getIP_ADDR() {
		return IP_ADDR;
	}

	public void setIP_ADDR(String ip_addr) {
		IP_ADDR = ip_addr;
	}

	public String getNETMASK() {
		return NETMASK;
	}

	public void setNETMASK(String netmask) {
		NETMASK = netmask;
	}

	public String getVLAN_ID() {
		return VLAN_ID;
	}

	public void setVLAN_ID(String vlan_id) {
		VLAN_ID = vlan_id;
	}

	public String getDEVICE_ID() {
		return DEVICE_ID;
	}

	public void setDEVICE_ID(String device_id) {
		DEVICE_ID = device_id;
	}

	public String getIF_SPEED() {
		return IF_SPEED;
	}

	public void setIF_SPEED(String if_speed) {
		IF_SPEED = if_speed;
	}

	public String getINTERFACE_TYPE() {
		return INTERFACE_TYPE;
	}

	public void setINTERFACE_TYPE(String interface_type) {
		INTERFACE_TYPE = interface_type;
	}

	public String getINTERFACE_TYPE_NAME() {
		return INTERFACE_TYPE_NAME;
	}

	public void setINTERFACE_TYPE_NAME(String interface_type_name) {
		INTERFACE_TYPE_NAME = interface_type_name;
	}

	public String getSERVICE_SYSTEM() {
		return SERVICE_SYSTEM;
	}

	public void setSERVICE_SYSTEM(String service_system) {
		SERVICE_SYSTEM = service_system;
	}

	public Integer getDIRECTION() {
		return DIRECTION;
	}

	public void setDIRECTION(Integer direction) {
		DIRECTION = direction;
	}

	public Integer getREAL_BANDWIDTH() {
		return REAL_BANDWIDTH;
	}

	public void setREAL_BANDWIDTH(Integer real_bandwidth) {
		if(real_bandwidth==0){
			real_bandwidth=null;
		}
		REAL_BANDWIDTH = real_bandwidth;
	}

	public long getBANDWIDTH() {
		return BANDWIDTH;
	}

	public void setBANDWIDTH(long bandwidth) {
		BANDWIDTH = bandwidth;
	}


}
