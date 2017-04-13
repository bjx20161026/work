package com.jobsAutomatic.service.modle.old;





import java.util.Date;

import com.jobsAutomatic.service.modle.Room;
import com.jobsAutomatic.service.modle.Vendor;



/**
 * ��Ӧ���ݿ���PRM_DEVICE��ṹ
 *
 * @author huwenjiang
 * @version V1.0 2012-3-1 ����01:11:23
 */
public class Device extends Entity {
    private static final long serialVersionUID = 438725574019548182L;
    /**
     * �豸UUID
     */
    private String DEVICE_ID;
    /**
     * �豸���� 9 λ��ֵ ��ǰ2λΪ�豸����, ��7λͨ��sequence ���ɣ�����7λ��߲�0 )
     */
    private long DEVICE_CODE;
    /**
     * �豸ϵͳ����
     */
    private String SYS_NAME;
    /**
     * ��������
     *
     * @deprecated
     */
    private String VENDOR;
    /**
     * ��������
     */
    private Vendor vendor;
    /**
     * �豸����
     */
    private String DEVICE_TYPE;
    /**
     * �豸�ͺ�
     */
    private String MODEL;
    /**
     * �豸����
     */
    private String ALIAS;
    /**
     * �豸IP��ַ
     */
    private String IP_ADDR;
    /**
     * �豸MAC��ַ
     */
    private String MAC_ADDR;
    /**
     * ����ʡ�� ��ֱϽ�У�
     */
    private String PROVINCE;
    /**
     * ����ʡΪ���У� ֱϽ��Ϊ ����
     */
    private String CITY;
    /**
     * ���ػ�������
     */
    private String DISTRICT;
    /**
     * �豸���к�;
     */
    private String SERIAL_NUMBER;
    /**
     * �豸�汾��Ϣ(����汾)
     */
    private String SYS_VERSION;
    /**
     * �Ƿ��к󱸵�Դ �� �� / ��
     */
    private String UPS_FLAG;
    /**
     * ���̱��
     */
    private String PROJECT_NO;
    /**
     * ����״̬,ȡֵΪ: 1 - ��������/ 2 - ����״̬/ 3 - ��ʱ����
     */
    private int PROJECT_STATUS;
    /**
     * �ʲ����
     */
    private String ASSET_NUMBER;
    /**
     * SNMP �ɶ� COMMUNITY
     */
    private String READ_COMMUNITY;
    /**
     * SNMP ��д COMMUNITY
     */
    private String WRITE_COMMUNITY;
    /**
     * �����Ա
     */
    private String AUDITOR;
    /**
     * ���״̬�� 0 - ��Ϣ¼���� 1- ��Ϣ¼����� 2- �ύ��� 3 - ���ͨ�� 4 - ���δͨ��
     */
    private int AUDIT_STATUS;
    /**
     * ���ʱ��
     */
    private Date AUDIT_DATE;
    /**
     * ���ͨ��ʱ��
     */
    private Date AUDIT_FIN_DATE;
    /**
     * ����״̬ : 1 - ������ 2 - ���� 3- ������ 4 - ���������������ָ��Դ�����Ͽ�����������п⣬������ָ���������п����
     */
    private int MANAGE_STATUS;
    /**
     * ����λ��
     */
    private String SHELF_LOCATION;
    /**
     * ��ע
     */
    private String REMARK;
    /**
     * Ӳ���汾��Ϣ
     */
    private String HARDWARE_REV;
    /**
     * ����ҵ��ϵͳ :  CMNET ,WLAN
     */
    private String SERVICE_SYSTEM = "WLAN";
    /**
     * �豸��Σ�����, ��� , ����
     */
    private String DEVICE_LEVEL = "�����";
    /**
     * ��������
     */
    private Room room;
    /**
     * Ӳ���汾
     */
    private String hardwareRev;
    /**
     * ɾ��ʱ��
     */
    private Date delDateTime;


    public String getHardwareRev() {
		return hardwareRev;
	}

	public void setHardwareRev(String hardwareRev) {
		this.hardwareRev = hardwareRev;
	}

	public Date getDelDateTime() {
		return delDateTime;
	}

	public void setDelDateTime(Date delDateTime) {
		this.delDateTime = delDateTime;
	}

	public String renderProjectStatus() {
        String status = "��������";
        switch (this.PROJECT_STATUS) {
            case 1:
                status = "��������";
                break;
            case 2:
                status = "����״̬";
                break;
            case 3:
                status = "��ʱ����";
                break;
            default:
                break;
        }
        return status;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getALIAS() {
        return ALIAS;
    }

    public String getASSET_NUMBER() {
        return ASSET_NUMBER;
    }

    public Date getAUDIT_DATE() {
        return AUDIT_DATE;
    }

    public Date getAUDIT_FIN_DATE() {
        return AUDIT_FIN_DATE;
    }

    public int getAUDIT_STATUS() {
        return AUDIT_STATUS;
    }

    public String getAUDITOR() {
        return AUDITOR;
    }

    public String getCITY() {
        return CITY;
    }

    public long getDEVICE_CODE() {
        return DEVICE_CODE;
    }

    public String getDEVICE_ID() {
        return DEVICE_ID;
    }

    public String getDEVICE_TYPE() {
        return DEVICE_TYPE;
    }

    public String getDISTRICT() {
        return DISTRICT;
    }

    public String getHARDWARE_REV() {
        return HARDWARE_REV;
    }

    public String getIP_ADDR() {
        return IP_ADDR;
    }

    public String getMAC_ADDR() {
        return MAC_ADDR;
    }

    public int getMANAGE_STATUS() {
        return MANAGE_STATUS;
    }

    public String getMODEL() {
        return MODEL;
    }

    public String getPROJECT_NO() {
        return PROJECT_NO;
    }

    public int getPROJECT_STATUS() {
        return PROJECT_STATUS;
    }

    public String getPROVINCE() {
        return PROVINCE;
    }

    public String getREAD_COMMUNITY() {
        return READ_COMMUNITY;
    }

    public String getREMARK() {
        return REMARK;
    }

    public String getSERIAL_NUMBER() {
        return SERIAL_NUMBER;
    }

    public String getSHELF_LOCATION() {
        return SHELF_LOCATION;
    }

    public String getSYS_NAME() {
        return SYS_NAME;
    }

    public String getSYS_VERSION() {
        return SYS_VERSION;
    }

    public String getUPS_FLAG() {
        return UPS_FLAG;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public String getVENDOR() {
        return VENDOR;
    }

    public String getWRITE_COMMUNITY() {
        return WRITE_COMMUNITY;
    }

    public void setALIAS(String alias) {
        ALIAS = alias;
    }

    public void setASSET_NUMBER(String asset_number) {
        ASSET_NUMBER = asset_number;
    }

    public void setAUDIT_DATE(Date audit_date) {
        AUDIT_DATE = audit_date;
    }

    public void setAUDIT_FIN_DATE(Date audit_fin_date) {
        AUDIT_FIN_DATE = audit_fin_date;
    }

    public void setAUDIT_STATUS(int audit_status) {
        AUDIT_STATUS = audit_status;
    }

    public void setAUDITOR(String auditor) {
        AUDITOR = auditor;
    }

    public void setCITY(String city) {
        CITY = city;
    }

    public void setDEVICE_CODE(long device_code) {
        DEVICE_CODE = device_code;
    }

    public void setDEVICE_ID(String device_id) {
        DEVICE_ID = device_id;
    }

    public void setDEVICE_TYPE(String device_type) {
        DEVICE_TYPE = device_type;
    }

    public void setDISTRICT(String district) {
        DISTRICT = district;
    }

    public void setHARDWARE_REV(String hardware_rev) {
        HARDWARE_REV = hardware_rev;
    }

    public void setIP_ADDR(String ip_addr) {
        IP_ADDR = ip_addr;
    }

    public void setMAC_ADDR(String mac_addr) {
        MAC_ADDR = mac_addr;
    }

    public void setMANAGE_STATUS(int manage_status) {
        MANAGE_STATUS = manage_status;
    }

    public void setMODEL(String model) {
        MODEL = model;
    }

    public void setPROJECT_NO(String project_no) {
        PROJECT_NO = project_no;
    }

    public void setPROJECT_STATUS(int project_status) {
        PROJECT_STATUS = project_status;
    }

    public void setPROVINCE(String province) {
        PROVINCE = province;
    }

    public void setREAD_COMMUNITY(String read_community) {
        READ_COMMUNITY = read_community;
    }

    public void setREMARK(String remark) {
        REMARK = remark;
    }

    public void setSERIAL_NUMBER(String serial_number) {
        SERIAL_NUMBER = serial_number;
    }

    public void setSHELF_LOCATION(String shelf_location) {
        SHELF_LOCATION = shelf_location;
    }

    public void setSYS_NAME(String sys_name) {
        SYS_NAME = sys_name;
    }

    public void setSYS_VERSION(String sys_version) {
        SYS_VERSION = sys_version;
    }

    public void setUPS_FLAG(String ups_flag) {
        UPS_FLAG = ups_flag;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setVENDOR(String vendor) {
        VENDOR = vendor;
    }

    public void setWRITE_COMMUNITY(String write_community) {
        WRITE_COMMUNITY = write_community;
    }

    public String getSERVICE_SYSTEM() {
        return SERVICE_SYSTEM;
    }

    public void setSERVICE_SYSTEM(String service_system) {
        SERVICE_SYSTEM = service_system;
    }

    public String getDEVICE_LEVEL() {
        return DEVICE_LEVEL;
    }

    public void setDEVICE_LEVEL(String device_level) {
        DEVICE_LEVEL = device_level;
    }

}
