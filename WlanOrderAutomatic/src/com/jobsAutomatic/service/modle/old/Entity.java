/*
 * Entity.java was created on 2012-3-1 ����12:41:00
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;
import java.util.Date;
/**
 * ʵ��ģ�ͻ���
 * @author huwenjiang
 * @version V1.0 2012-3-1 ����12:41:22
 */
public class Entity implements Serializable {
	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = 0L;
	/**
	 * ¼��ʱ��
	 */
	private Date ENTRY_DATE;
	/**
	 * ¼����Ա����
	 */
	private long ENTRY_STAFF;
	public Date getENTRY_DATE() {
		return ENTRY_DATE;
	}
	public void setENTRY_DATE(Date entry_date) {
		ENTRY_DATE = entry_date;
	}
	public long getENTRY_STAFF() {
		return ENTRY_STAFF;
	}
	public void setENTRY_STAFF(long entry_staff) {
		ENTRY_STAFF = entry_staff;
	} 
	
}
