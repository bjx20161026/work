package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;
import java.util.Date;

/**
 * WLAN�ȵ����ϵ��빤����¼
 */
public class WlanWorkOrder implements Serializable {

    private static final long serialVersionUID = 3235389975929286500L;
    /**
     * �����ȵ�
     */
    private Hotspot hotspot;
    /**
     * ������
     */
    private String orderNo;
    /**
     * ��������
     */
    private String orderTitle;
    /**
     * �������� 1-���� 2-���� 3-���
     */
    private int orderType;
    /**
     * ������
     */
    private String operator;
    /**
     * ��������
     */
    private String operateDept;
    /**
     * ����ʱ��
     */
    private Date operateTime;

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle == null ? null : orderTitle.trim();
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getOperateDept() {
        return operateDept;
    }

    public void setOperateDept(String operateDept) {
        this.operateDept = operateDept == null ? null : operateDept.trim();
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Hotspot getHotspot() {
        return hotspot;
    }

    public void setHotspot(Hotspot hotspot) {
        this.hotspot = hotspot;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}