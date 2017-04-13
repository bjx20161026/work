/*
 * InterfaceVo.java was created on 2012-4-11 ����11:14:13
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.modle;

import java.io.Serializable;
import java.util.List;

import com.jobsAutomatic.service.modle.old.Interface;


public class InterfaceDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Interface> list;

	private Integer targetType; //1 ap ac �ȵ㽻���� 2 ���Ļ���豸

	public Integer getTargetType() {
		return targetType;
	}

	public void setTargetType(Integer targetType) {
		this.targetType = targetType;
	}

	public List<Interface> getList() {
		return list;
	}

	public void setList(List<Interface> list) {
		this.list = list;
	}

}
