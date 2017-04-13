/*
 * PrimaryHotspot.java was created on 12-5-31 ����3:42
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: wjhu
 * Date: 12-5-31
 * Time: ����3:42
 * To change this template use File | Settings | File Templates.
 */
public class PrimaryHotspot implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * �߼��ȵ�ID
     */
    private String hotspotId;
    /**
     * �߼��ȵ�����
     */
    private String hotspotName;
    /**
     * ��������
     */
    private String district;

    public String getHotspotId() {
        return hotspotId;
    }

    public void setHotspotId(String hotspotId) {
        this.hotspotId = hotspotId;
    }

    public String getHotspotName() {
        return hotspotName;
    }

    public void setHotspotName(String hotspotName) {
        this.hotspotName = hotspotName;
    }

    public String getDistrict() {

        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrimaryHotspot that = (PrimaryHotspot) o;

        if (district != null ? !district.equals(that.district) : that.district != null) return false;
        if (hotspotId != null ? !hotspotId.equals(that.hotspotId) : that.hotspotId != null) return false;
        if (hotspotName != null ? !hotspotName.equals(that.hotspotName) : that.hotspotName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hotspotId != null ? hotspotId.hashCode() : 0;
        result = 31 * result + (hotspotName != null ? hotspotName.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        return result;
    }

}
