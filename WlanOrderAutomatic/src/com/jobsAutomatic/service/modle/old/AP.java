package com.jobsAutomatic.service.modle.old;

import java.util.List;

/**
 * APģ��
 * @author wjhu
 * @date 2012-2-16 ����02:14:46
 */
public class AP extends Device {
	private static final long serialVersionUID = 7902015110456018699L;
	/**
	 * �ȵ�UUID
	 */
	private String HOTSPOT_ID;
	/**
	 * �����ȵ�
	 */
	private Hotspot hotspot;
	/**
	 * ���Ƿ�Χ
	 */
	private String COVERAGE_SCOPE;
	/**
	 * ����������UUID
	 */
	private String SWITCH_ID;
	/**
	 * ����������
	 */
	private Switch sw;
	/**
	 * ����ģʽ 
	 * <p>
	 * ȡֵ��Χ: 1- ���� 2- ���� 
	 */
	private int COVERAGE_MODE;
    /**
     * ��·ģʽ 1 - ���� 2- 3G��· 3 - 2G��· 4 - 2G/3G��·
     */
    private int COMBINE_MODE;

    /**
	 * ��װλ��
	 */
	private String LOCATION;
	/**
	 * �Ƿ�˫��
	 * <p>
	 * ȡֵ��Χ:0 : �� 1�� ��
	 */
	private int DUAL_CARD;
	/**
	 * ��ͨƵ��
	 */
	private int CHANNEL;
	/**
	 * �����б�
	 */
	private List<ApAntenna> antennaList;
	private String IPV6_ADDR;
    private String IPV6_PREFIX;
	
	public String getIPV6_ADDR() {
		return IPV6_ADDR;
	}
	public void setIPV6_ADDR(String ipv6_addr) {
		IPV6_ADDR = ipv6_addr;
	}
	public String getIPV6_PREFIX() {
		return IPV6_PREFIX;
	}
	public void setIPV6_PREFIX(String ipv6_prefix) {
		IPV6_PREFIX = ipv6_prefix;
	}
	public List<ApAntenna> getAntennaList() {
		return antennaList;
	}
	public void setAntennaList(List<ApAntenna> antennaList) {
		this.antennaList = antennaList;
	}
	public int getDUAL_CARD() {
		return DUAL_CARD;
	}
	public void setDUAL_CARD(int dual_card) {
		DUAL_CARD = dual_card;
	}
	public int getCHANNEL() {
		return CHANNEL;
	}
	public void setCHANNEL(int channel) {
		CHANNEL = channel;
	}
	public String getHOTSPOT_ID() {
		return HOTSPOT_ID;
	}
	public void setHOTSPOT_ID(String hotspot_id) {
		HOTSPOT_ID = hotspot_id;
	}
	public String getCOVERAGE_SCOPE() {
		return COVERAGE_SCOPE;
	}
	public void setCOVERAGE_SCOPE(String coverage_scope) {
		COVERAGE_SCOPE = coverage_scope;
	}
	public String getSWITCH_ID() {
		return SWITCH_ID;
	}
	public void setSWITCH_ID(String switch_id) {
		SWITCH_ID = switch_id;
	}
	public int getCOVERAGE_MODE() {
		return COVERAGE_MODE;
	}
	public void setCOVERAGE_MODE(int coverage_mode) {
		COVERAGE_MODE = coverage_mode;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(String location) {
		LOCATION = location;
	}
	public Hotspot getHotspot() {
		return hotspot;
	}
	public void setHotspot(Hotspot hotspot) {
		this.hotspot = hotspot;
	}
	public Switch getSw() {
		return sw;
	}
	public void setSw(Switch sw) {
		this.sw = sw;
	}

    public int getCOMBINE_MODE() {
        return COMBINE_MODE;
    }

    public void setCOMBINE_MODE(int COMBINE_MODE) {
        this.COMBINE_MODE = COMBINE_MODE;
    }
}
