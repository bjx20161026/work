/*
 * HotspotVLAN.java was created on 12-6-1 ����1:50
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: wjhu
 * Date: 12-6-1
 * Time: ����1:50
 * To change this template use File | Settings | File Templates.
 */
public class HotspotVlan implements Serializable {

    private static final long serialVersionUID = -4754406628911439339L;
    /**
     * �����ȵ�
     */
    private Hotspot hotspot;
    /**
     * �������Ľ������˿�
     */
    private Interface inf;
    /**
     * �ȵ���ص�VLAN  , �˴��򻯴���������д���VLAN
     */
    private String vlan;

    public Hotspot getHotspot() {
        return hotspot;
    }

    public void setHotspot(Hotspot hotspot) {
        this.hotspot = hotspot;
    }

    public Interface getInf() {
        return inf;
    }

    public void setInf(Interface inf) {
        this.inf = inf;
    }

    public String getVlan() {
        return vlan;
    }

    public void setVlan(String vlan) {
        this.vlan = vlan;
    }
}
