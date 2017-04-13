package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;
import java.util.Set;
/**
 * AC��ģ��
 * @author huwenjiang
 * @version V1.0 2012-5-2 ����02:58:13
 */
public class AcGroup implements Serializable {
    /**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -7823164241733135202L;
	/**
     * RES.PRM_AC_GROUP.GROUP_ID (AC �� ID)
     * @ibatorgenerated 2012-05-02 14:51:25
     */
    private String groupId;

    /**
     * RES.PRM_AC_GROUP.GROUP_NAME (AC ������)
     * @ibatorgenerated 2012-05-02 14:51:25
     */
    private String groupName;

    /**
     * RES.PRM_AC_GROUP.WORK_MODE ( 1 -  ����ģʽ  2-  ���طֵ�ģʽ)
     * @ibatorgenerated 2012-05-02 14:51:25
     */
    private Short workMode;

    /**
     * RES.PRM_AC_GROUP.NETWORK (�������� :   WLANר��/ ������)
     * @ibatorgenerated 2012-05-02 14:51:25
     */
    private String network;
    /**
     * AC�б�
     */
    private Set<AC> acs;

    public Set<AC> getAcs() {
		return acs;
	}

	public void setAcs(Set<AC> acs) {
		this.acs = acs;
	}

	public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Short getWorkMode() {
        return workMode;
    }

    public void setWorkMode(Short workMode) {
        this.workMode = workMode;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }
}