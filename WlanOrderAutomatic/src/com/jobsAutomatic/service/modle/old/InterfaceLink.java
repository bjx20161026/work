package com.jobsAutomatic.service.modle.old;


/**
 * �豸��·ģ��
 * ��Ӧ���ݿ��:PRM_INTERFACE_LINK
 * @author wjhu
 * @date 2012-2-26 ����10:52:02
 */
public class InterfaceLink extends Entity {
	
	private static final long serialVersionUID = -3134499610892705930L;
	/**
	 * ��· UUID 
	 */
	private String ID;
	/**
	 * ������·�����豸
	 */
	private Interface leftIf;
	/**
	 * ������·�Զ��豸
	 */
	private Interface rightIf;
	public String getID() {
		return ID;
	}
	public void setID(String id) {
		ID = id;
	}
	public Interface getLeftIf() {
		return leftIf;
	}
	public void setLeftIf(Interface leftIf) {
		this.leftIf = leftIf;
	}
	public Interface getRightIf() {
		return rightIf;
	}
	public void setRightIf(Interface rightIf) {
		this.rightIf = rightIf;
	}
	
	

}
