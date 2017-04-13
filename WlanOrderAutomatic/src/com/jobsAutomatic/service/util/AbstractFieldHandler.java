package com.jobsAutomatic.service.util;


public abstract class AbstractFieldHandler<T, K> {
	/**
	 * ��Ҫ���ص�ֵ
	 */
	private K returnValue;
	/**
	 * ����У��ʧ�ܵ���ʾ
	 */
	private String errorMsg;
	/**
	 * У��״̬ true��ʾУ��ɹ�
	 */
	private boolean status;

	/**
	 * �����ض���Ҫ���ֵ����ת��
	 * 
	 * @param value
	 * @return
	 */
	protected abstract K converter(T value);

	/**
	 * У���Ƿ���Ϲ淶
	 * 
	 * @param value
	 * @return
	 */
	protected abstract boolean validator(T value);

	/**
	 * �ⲿʹ��ʱ��ֻ��Ҫ���ñ�����
	 * 
	 * @param value
	 */
	public void handler(T value) {
        setStatus(validator(value));
		setReturnValue(converter(value));
	}
	public K getReturnValue() {
		return returnValue;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setReturnValue(K returnValue) {
		this.returnValue = returnValue;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public static abstract class None extends
			AbstractFieldHandler<Object, Object> {
	}

}
