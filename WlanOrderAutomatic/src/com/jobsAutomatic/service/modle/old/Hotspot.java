package com.jobsAutomatic.service.modle.old;



import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.jobsAutomatic.service.modle.SubCoverType;
import com.jobsAutomatic.service.modle.Vendor;





/**
 * �����ȵ�ģ��
 *
 * @author wjhu
 * @date 2012-2-26 ����11:02:23
 */
public class Hotspot implements Serializable
{

	private static final long serialVersionUID = 910371250971813538L;
	/**
	 * �ȵ� ID
	 */
	private String HOTSPOT_ID;
	/**
	 * �ȵ�����
	 */
	private String HOTSPOT_NAME;
	/**
	 * �ȵ�NAS_ID
	 */
	private String NAS_ID;
	/**
	 * �����߼��ȵ�����
	 */
	private PrimaryHotspot primaryHotspot;
	/**
	 * �ȵ�����
	 */
	private String hotspotType;
	/**
	 * �ȵ��ַ
	 */
	private String location;
	/**
	 * ʡ��ֱϽ��
	 */
	private String province;
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
	 * VIP���� :  1 - ��ͨ  2- VIP  3 - VVIP
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
	private String projectNo;
	/**
	 * ���ɳ���
	 */
	private ImpVendor impVendor;
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
	private ImpVendor maintVendor;
	/**
	 * ��������
	 */
	private coverType coverType;
	/**
	 * ����������
	 */
	private SubCoverType subCoverType;
	/**
	 * ���Ƿ�Χ
	 */
	private String coverageScope;
	/**
	 * ��Χ�ر꽨��
	 */
	private String  landMarks;
	/**
	 * ������С��
	 */
	private String ceLlid;
	/**
	 * λ��������
	 */
	private String laCid;
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
	 * ¼��ʱ��
	 */
	private Date entryDate;
	/**
	 * ¼����Ա����
	 */
	private Integer entryStaff;
	/**
	 * �����Ա
	 */
	private long auditor;
	/**
	 * ���״̬�� 0 - ��Ϣ¼���� 1- ��Ϣ¼�����  2- �ύ���  3 - ���ͨ�� 4 - ���δͨ��
	 */
	private Integer auditStatus;
	/**
	 * ���ʱ��
	 */
	private Date auditDate;
	/**
	 * ���ͨ��ʱ��
	 */
	private Date auditFinDate;
	/**
	 * ����״̬ :  1 -  ������  2 - ����  3- ������   4 - ����
	 * �����������ָ��Դ�����Ͽ�����������п⣬������ָ���������п����
	 */
	private Integer manageStatus;
	/**
	 * �豸����
	 */
	private Vendor vendor;
	/**
	 * ����AC�б�
	 */
	private Set<AC> acs;
	/**
	 * ����SSID�б�
	 */
	private Set<SSID> ssids;
	/**
	 * �ȵ�������Ϣ
	 */
	private Set<HotspotIpAlloc> hotspotIpAllocs;
	/**
	 * �ȵ�����Ļ�۽�����������ϵ
	 */
	private HotspotVlan hotspotVlan;
	/**
	 * ����ɾ��ʱ��
	 */
	private Date deleteDatetime;
	
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
	
	
	
	public String getHotspotLevel() {
		return hotspotLevel;
	}

	public void setHotspotLevel(String hotspotLevel) {
		this.hotspotLevel = hotspotLevel;
	}

	public String getVipString()
	{
		String vipStr = "��ͨ";
		if (this.getVip() != null)
		{
			switch (this.getVip())
			{
			case 1:
				vipStr = "��ͨ";
				break;
			case 2:
				vipStr = "VIP";
				break;
			case 3:
				vipStr = "VVIP";
				break;
			}
		}

		return vipStr;
	}

	public Set<AC> getAcs()
	{
		return acs;
	}

	public void setAcs(Set<AC> acs)
	{
		this.acs = acs;
	}

	public Set<SSID> getSsids()
	{
		return ssids;
	}

	public void setSsids(Set<SSID> ssids)
	{
		this.ssids = ssids;
	}

	public Set<HotspotIpAlloc> getHotspotIpAllocs()
	{
		return hotspotIpAllocs;
	}

	public void setHotspotIpAllocs(Set<HotspotIpAlloc> hotspotIpAllocs)
	{
		this.hotspotIpAllocs = hotspotIpAllocs;
	}

	public HotspotVlan getHotspotVlan()
	{
		return hotspotVlan;
	}

	public void setHotspotVlan(HotspotVlan hotspotVlan)
	{
		this.hotspotVlan = hotspotVlan;
	}

	public String getHOTSPOT_ID()
	{
		return HOTSPOT_ID;
	}

	public void setHOTSPOT_ID(String hotspot_id)
	{
		HOTSPOT_ID = hotspot_id;
	}

	public String getHOTSPOT_NAME()
	{
		return HOTSPOT_NAME;
	}

	public void setHOTSPOT_NAME(String hotspot_name)
	{
		HOTSPOT_NAME = hotspot_name;
	}

	public String getNAS_ID()
	{
		return NAS_ID;
	}

	public void setNAS_ID(String nas_id)
	{
		NAS_ID = nas_id;
	}

	public PrimaryHotspot getPrimaryHotspot()
	{
		return primaryHotspot;
	}

	public void setPrimaryHotspot(PrimaryHotspot primaryHotspot)
	{
		this.primaryHotspot = primaryHotspot;
	}

	public String getHotspotType()
	{
		return hotspotType;
	}

	public void setHotspotType(String hotspotType)
	{
		this.hotspotType = hotspotType;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getDistrict()
	{
		return district;
	}

	public void setDistrict(String district)
	{
		this.district = district;
	}

	public Integer getSwitchNumber()
	{
		return switchNumber;
	}

	public void setSwitchNumber(Integer switchNumber)
	{
		this.switchNumber = switchNumber;
	}

	public Integer getVip()
	{
		return isVip;
	}

	public Integer getIsVip() {
		return isVip;
	}

	public void setIsVip(Integer isVip) {
		this.isVip = isVip;
	}

	public Date getDeleteDatetime() {
		return deleteDatetime;
	}

	public void setDeleteDatetime(Date deleteDatetime) {
		this.deleteDatetime = deleteDatetime;
	}

	public void setVip(Integer vip)
	{
		isVip = vip;
	}

	public float getLongtitude()
	{
		return longtitude;
	}

	public void setLongtitude(float longtitude)
	{
		this.longtitude = longtitude;
	}

	public float getLatitude()
	{
		return latitude;
	}

	public void setLatitude(float latitude)
	{
		this.latitude = latitude;
	}

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public ImpVendor getImpVendor()
	{
		return impVendor;
	}

	public void setImpVendor(ImpVendor impVendor)
	{
		this.impVendor = impVendor;
	}

	public Integer getTransType()
	{
		return transType;
	}

	public void setTransType(Integer transType)
	{
		this.transType = transType;
	}

	public String getTransCardLoc()
	{
		return transCardLoc;
	}

	public void setTransCardLoc(String transCardLoc)
	{
		this.transCardLoc = transCardLoc;
	}

	public String getDf()
	{
		return df;
	}

	public void setDf(String df)
	{
		this.df = df;
	}

	public String getRing()
	{
		return ring;
	}

	public void setRing(String ring)
	{
		this.ring = ring;
	}

	public ImpVendor getMaintVendor()
	{
		return maintVendor;
	}

	public void setMaintVendor(ImpVendor maintVendor)
	{
		this.maintVendor = maintVendor;
	}

	public coverType getCoverType()
	{
		return coverType;
	}

	public void setCoverType(coverType coverType)
	{
		this.coverType = coverType;
	}

	public SubCoverType getSubCoverType()
	{
		return subCoverType;
	}

	public void setSubCoverType(SubCoverType subCoverType)
	{
		this.subCoverType = subCoverType;
	}

	public String getCoverageScope()
	{
		return coverageScope;
	}

	public void setCoverageScope(String coverageScope)
	{
		this.coverageScope = coverageScope;
	}

	public Integer getApNumber()
	{
		return apNumber;
	}

	public void setApNumber(Integer apNumber)
	{
		this.apNumber = apNumber;
	}

	public Integer getProjectStatus()
	{
		return projectStatus;
	}

	public void setProjectStatus(Integer projectStatus)
	{
		this.projectStatus = projectStatus;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public Integer getBandwith()
	{
		return bandwith;
	}

	public void setBandwith(Integer bandwith)
	{
		this.bandwith = bandwith;
	}

	public Integer getCoverageMode()
	{
		return coverageMode;
	}

	public void setCoverageMode(Integer coverageMode)
	{
		this.coverageMode = coverageMode;
	}

	public Integer getCombineMode()
	{
		return combineMode;
	}

	public void setCombineMode(Integer combineMode)
	{
		this.combineMode = combineMode;
	}

	public Date getEntryDate()
	{
		return entryDate;
	}

	public void setEntryDate(Date entryDate)
	{
		this.entryDate = entryDate;
	}

	public Integer getEntryStaff()
	{
		return entryStaff;
	}

	public void setEntryStaff(Integer entryStaff)
	{
		this.entryStaff = entryStaff;
	}

	public long getAuditor()
	{
		return auditor;
	}

	public void setAuditor(long auditor)
	{
		this.auditor = auditor;
	}

	public Integer getAuditStatus()
	{
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus)
	{
		this.auditStatus = auditStatus;
	}

	public Date getAuditDate()
	{
		return auditDate;
	}

	public void setAuditDate(Date auditDate)
	{
		this.auditDate = auditDate;
	}

	public Date getAuditFinDate()
	{
		return auditFinDate;
	}

	public void setAuditFinDate(Date auditFinDate)
	{
		this.auditFinDate = auditFinDate;
	}

	public Integer getManageStatus()
	{
		return manageStatus;
	}

	public void setManageStatus(Integer manageStatus)
	{
		this.manageStatus = manageStatus;
	}

	public Vendor getVendor()
	{
		return vendor;
	}

	public void setVendor(Vendor vendor)
	{
		this.vendor = vendor;
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

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Date getProjectApplyDate() {
		return projectApplyDate;
	}

	public void setProjectApplyDate(Date projectApplyDate) {
		this.projectApplyDate = projectApplyDate;
	}

	public String getProjectNum() {
		return projectNum;
	}

	public void setProjectNum(String projectNum) {
		this.projectNum = projectNum;
	}
}
