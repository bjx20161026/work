package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;



public class HotspotIpAlloc implements Serializable {

    private static final long serialVersionUID = -6591970282181028287L;
    /**
     * �����ȵ�
     */
    private Hotspot hotspot;
    /**
     * ���ص�ַ
     */
    private String gateway;
    /**
     * ������IP������ַ
     */
    private String swAddrTo;
    /**
     * ������IP��ʼ��ַ
     */
    private String swAddrFrom;
    /**
     * AP ip��ʼ��ַ
     */
    private String apAddrFrom;
    /**
     * AP ip������ַ
     */
    private String apAddrTo;
    /**
     * IP��ַ��
     */
    private String ipAddrSegment;
    /**
     * IP��ַ��ʼ��ַ long��
     */
    private long netAddrFromNum;
    /**
     * IP��ַ������ַ long��
     */
    private long netAddrToNum;
    /**
     * ������IP��ַ��ʼ��ַ long��
     */
    private long swAddrFromNum;
    /**
     * ������IP��ַ������ַ long��
     */
    private long swAddrToNum;
    /**
     * AP IP��ַ��ʼ��ַ long��
     */
    private long apAddrFromNum;
    /**
     * AP IP��ַ������ַ long��
     */
    private long apAddrToNum;

    public String getSwAddrFrom() {
        return swAddrFrom;
    }

    public void setSwAddrFrom(String swAddrFrom) {
        this.swAddrFrom = swAddrFrom == null ? null : swAddrFrom.trim();
    }

    public String getSwAddrTo() {
        return swAddrTo;
    }

    public void setSwAddrTo(String swAddrTo) {
        this.swAddrTo = swAddrTo == null ? null : swAddrTo.trim();
    }

    public String getApAddrFrom() {
        return apAddrFrom;
    }

    public void setApAddrFrom(String apAddrFrom) {
        this.apAddrFrom = apAddrFrom == null ? null : apAddrFrom.trim();
    }

    public String getApAddrTo() {
        return apAddrTo;
    }

    public void setApAddrTo(String apAddrTo) {
        this.apAddrTo = apAddrTo == null ? null : apAddrTo.trim();
    }

    public String getIpAddrSegment() {
        return ipAddrSegment;
    }

    public void setIpAddrSegment(String ipAddrSegment) {
        this.ipAddrSegment = ipAddrSegment == null ? null : ipAddrSegment.trim();
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public Hotspot getHotspot() {
        return hotspot;
    }

    public void setHotspot(Hotspot hotspot) {
        this.hotspot = hotspot;
    }

    public long getNetAddrFromNum() {
        return netAddrFromNum;
    }

    public void setNetAddrFromNum(long netAddrFromNum) {
        this.netAddrFromNum = netAddrFromNum;
    }

    public long getNetAddrToNum() {
        return netAddrToNum;
    }

    public void setNetAddrToNum(long netAddrToNum) {
        this.netAddrToNum = netAddrToNum;
    }

    public long getSwAddrFromNum() {
        return swAddrFromNum;
    }

    public void setSwAddrFromNum(long swAddrFromNum) {
        this.swAddrFromNum = swAddrFromNum;
    }

    public long getSwAddrToNum() {
        return swAddrToNum;
    }

    public void setSwAddrToNum(long swAddrToNum) {
        this.swAddrToNum = swAddrToNum;
    }

    public long getApAddrFromNum() {
        return apAddrFromNum;
    }

    public void setApAddrFromNum(long apAddrFromNum) {
        this.apAddrFromNum = apAddrFromNum;
    }

    public long getApAddrToNum() {
        return apAddrToNum;
    }

    public void setApAddrToNum(long apAddrToNum) {
        this.apAddrToNum = apAddrToNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotspotIpAlloc that = (HotspotIpAlloc) o;

        if (apAddrFromNum != that.apAddrFromNum) return false;
        if (apAddrToNum != that.apAddrToNum) return false;
        if (netAddrFromNum != that.netAddrFromNum) return false;
        if (netAddrToNum != that.netAddrToNum) return false;
        if (swAddrFromNum != that.swAddrFromNum) return false;
        if (swAddrToNum != that.swAddrToNum) return false;
        if (apAddrFrom != null ? !apAddrFrom.equals(that.apAddrFrom) : that.apAddrFrom != null) return false;
        if (apAddrTo != null ? !apAddrTo.equals(that.apAddrTo) : that.apAddrTo != null) return false;
        if (gateway != null ? !gateway.equals(that.gateway) : that.gateway != null) return false;
        if (hotspot != null ? !hotspot.equals(that.hotspot) : that.hotspot != null) return false;
        if (ipAddrSegment != null ? !ipAddrSegment.equals(that.ipAddrSegment) : that.ipAddrSegment != null)
            return false;
        if (swAddrFrom != null ? !swAddrFrom.equals(that.swAddrFrom) : that.swAddrFrom != null) return false;
        if (swAddrTo != null ? !swAddrTo.equals(that.swAddrTo) : that.swAddrTo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hotspot != null ? hotspot.hashCode() : 0;
        result = 31 * result + (gateway != null ? gateway.hashCode() : 0);
        result = 31 * result + (swAddrTo != null ? swAddrTo.hashCode() : 0);
        result = 31 * result + (swAddrFrom != null ? swAddrFrom.hashCode() : 0);
        result = 31 * result + (apAddrFrom != null ? apAddrFrom.hashCode() : 0);
        result = 31 * result + (apAddrTo != null ? apAddrTo.hashCode() : 0);
        result = 31 * result + (ipAddrSegment != null ? ipAddrSegment.hashCode() : 0);
        result = 31 * result + (int) (netAddrFromNum ^ (netAddrFromNum >>> 32));
        result = 31 * result + (int) (netAddrToNum ^ (netAddrToNum >>> 32));
        result = 31 * result + (int) (swAddrFromNum ^ (swAddrFromNum >>> 32));
        result = 31 * result + (int) (swAddrToNum ^ (swAddrToNum >>> 32));
        result = 31 * result + (int) (apAddrFromNum ^ (apAddrFromNum >>> 32));
        result = 31 * result + (int) (apAddrToNum ^ (apAddrToNum >>> 32));
        return result;
    }
}