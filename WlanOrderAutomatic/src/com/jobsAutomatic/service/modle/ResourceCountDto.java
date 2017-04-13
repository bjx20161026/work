package com.jobsAutomatic.service.modle;

/**
 * 
 * @author wanghp
 * 2012-12-17
 * ��Դ����ͳ��
 *
 */
public class ResourceCountDto {
	private int apCount;
	private int switchCount;
	private int hotspotCount;
	private String city;
	private String vendor;
	/**
	 * 
	 * @return AP����
	 */
	public int getApCount() {
		return apCount;
	}
	/**
	 * 
	 * @param apCount  AP����
	 */
	public void setApCount(int apCount) {
		this.apCount = apCount;
	}
	/**
	 * 
	 * @return  ����������
	 */
	public int getSwitchCount() {
		return switchCount;
	}
	/**
	 * 
	 * @param switchCount  ����������
	 */
	public void setSwitchCount(int switchCount) {
		this.switchCount = switchCount;
	}
	/**
	 * 
	 * @return  �ȵ�����
	 */
	public int getHotspotCount() {
		return hotspotCount;
	}
	/**
	 * 
	 * @param hotspotCount �ȵ�����
	 */
	public void setHotspotCount(int hotspotCount) {
		this.hotspotCount = hotspotCount;
	}
	/**
	 * 
	 * @return ���طֹ�˾
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 
	 * @param city ���طֹ�˾
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 
	 *  @return  �豸����
	 */
	public String getVendor() {
		return vendor;
	}
	/**
	 * 
	 * @param vendor �豸����
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	@Override
	public String toString() {
		return "ResourceCountBean [apCount=" + apCount + ", city=" + city
				+ ", hotspotCount=" + hotspotCount + ", switchCount="
				+ switchCount + ", vendor=" + vendor + "]";
	}
	public ResourceCountDto() {
		// TODO Auto-generated constructor stub
	}
	public ResourceCountDto(int apCount, int switchCount, int hotspotCount,
			String city, String vendor) {
		super();
		this.apCount = apCount;
		this.switchCount = switchCount;
		this.hotspotCount = hotspotCount;
		this.city = city;
		this.vendor = vendor;
	}
	
}
