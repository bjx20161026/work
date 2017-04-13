package com.jobsAutomatic.service.modle.old;

/**
 * �ȵ���ڵ�·ģ�ͣ����ȵ㽻��������==�ȵ��۽������������ȵ���û���ȵ����AP��������������·��ϵ�ô�ģ�ͣ�
 * @author wjhu
 * @date 2012-2-26 ����10:58:10
 */
public class HotspotExitLink extends Entity {
	
	private static final long serialVersionUID = 9109221724337032619L;
	/**
	 * �ȵ���ڵ�·ID
	 */
	private String ID;
	/**
	 * �����ȵ�
	 */
	private Hotspot hotspot;
	/**
	 * �ȵ�����豸�������豸ֻ���� �ȵ��۽����� ��AP
	 */
	private Interface leftIf;
	/**
	 * ������·�Զ��豸����
	 */
	private String RIGHT_DEVICE_NAME;
	/**
	 * ������·�Զ��豸�˿�����
	 */
	private String RIGHT_IF_NAME;
	public String getID() {
		return ID;
	}
	public void setID(String id) {
		ID = id;
	}
	public Hotspot getHotspot() {
		return hotspot;
	}
	public void setHotspot(Hotspot hotspot) {
		this.hotspot = hotspot;
	}
	public Interface getLeftIf() {
		return leftIf;
	}
	public void setLeftIf(Interface leftIf) {
		this.leftIf = leftIf;
	}
	public String getRIGHT_DEVICE_NAME() {
		return RIGHT_DEVICE_NAME;
	}
	public void setRIGHT_DEVICE_NAME(String right_device_name) {
		RIGHT_DEVICE_NAME = right_device_name;
	}
	public String getRIGHT_IF_NAME() {
		return RIGHT_IF_NAME;
	}
	public void setRIGHT_IF_NAME(String right_if_name) {
		RIGHT_IF_NAME = right_if_name;
	}
	
}
