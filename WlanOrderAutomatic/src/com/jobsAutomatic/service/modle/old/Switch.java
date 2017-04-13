package com.jobsAutomatic.service.modle.old;

/**
 * �ȵ��۽����������뽻����ģ��
 *
 * @author wjhu
 * @date 2012-2-28 ����12:30:57
 */
public class Switch extends Device {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = -4180278949520926490L;
    /**
     * �����ȵ�
     */
    private Hotspot hotspot;
    /**
     * ���������� 1 - ���Ľ����� 2 - ��۽����� 3 - �ȵ��۽����� 4 - �ȵ���뽻����
     */
    private int SWITCH_LEVEL;
    /**
	 * �ȵ�UUID
	 */
	private String HOTSPOT_ID;
    public String getHOTSPOT_ID() {
		return HOTSPOT_ID;
	}

	public void setHOTSPOT_ID(String hOTSPOTID) {
		HOTSPOT_ID = hOTSPOTID;
	}

	/**
     * ��װλ��
     */
    private String LOCATION;

    public Hotspot getHotspot() {
        return hotspot;
    }

    public void setHotspot(Hotspot hotspot) {
        this.hotspot = hotspot;
    }

    public int getSWITCH_LEVEL() {
        return SWITCH_LEVEL;
    }

    public void setSWITCH_LEVEL(int switch_level) {
        SWITCH_LEVEL = switch_level;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String location) {
        LOCATION = location;
    }

    public String getSwitchType() {
        String type = "�ȵ���뽻����";
        switch (this.SWITCH_LEVEL) {
            case 1:
                type = "���Ľ�����";
                break;
            case 2:
                type = "��۽�����";
                break;
            case 3:
                type = "�ȵ��۽�����";
                break;
            case 4:
                type = "�ȵ���뽻����";
                break;
            default:
                break;
        }
        return type;
    }

}
