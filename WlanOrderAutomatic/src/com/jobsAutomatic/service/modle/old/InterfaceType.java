package com.jobsAutomatic.service.modle.old;

import java.io.Serializable;

/**
 * �˿�����ģ��
 * @author wjhu
 * @version 1.0 
 */
public class InterfaceType implements Serializable{
	/**
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 5964553249599143108L;
	/**
	 * �˿�����
	 */
	private int IF_TYPE;
	/**
	 * �˿���������
	 */
	private String IF_TYPE_NAME;
	/**
	 * //�˿����� ��M Ϊ��λ
	 */
	private String IF_SPEED;
	public int getIF_TYPE() {
		return IF_TYPE;
	}
	public void setIF_TYPE(int if_type) {
		IF_TYPE = if_type;
	}
	public String getIF_TYPE_NAME() {
		return IF_TYPE_NAME;
	}
	public void setIF_TYPE_NAME(String if_type_name) {
		IF_TYPE_NAME = if_type_name;
	}
	public String getIF_SPEED() {
		return IF_SPEED;
	}
	public void setIF_SPEED(String if_speed) {
		IF_SPEED = if_speed;
	}
	
	

}
