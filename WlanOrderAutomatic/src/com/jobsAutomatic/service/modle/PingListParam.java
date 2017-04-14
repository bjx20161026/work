package com.jobsAutomatic.service.modle;

import java.io.Serializable;

import com.jobsAutomatic.service.modle.old.Device;

public class PingListParam extends Device implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String param_id;
	private String param_name;
	private int packet_count;
	private int packet_size;
	private int timeout;
	private int frequency;
	private int retry_times;
	/*
	 * 最大时延
	 */
	private int timeLateMax;
	/**
	 * 最小时延
	 */
	private int timeLateMin;
	/**
	 * 平均时延
	 */
	private int timeLateAvg;
	/**
	 * 发包数
	 */
	private int sendPackets;
	/**
	 * 收包数
	 */
	private int recvPackets;
	/**
	 * 丢包数
	 */
	private int dropPackets;
	/**
	 * 丢包率
	 */
	private double dropRate;
	/**
	 * 环境探测是否正常
	 */
	private boolean isNormal;
	/**
	 * 环境探测结果描述
	 */
	private String detectEnvResultDesc;
	
	public String getParam_id() {
		return param_id;
	}
	
	public void setParam_id(String param_id) {
		this.param_id = param_id;
	}
	
	public String getParam_name() {
		return param_name;
	}
	
	public void setParam_name(String param_name) {
		this.param_name = param_name;
	}
	
	public int getPacket_count() {
		return packet_count;
	}
	
	public void setPacket_count(int packet_count) {
		this.packet_count = packet_count;
	}
	
	public int getPacket_size() {
		return packet_size;
	}
	
	public void setPacket_size(int packet_size) {
		this.packet_size = packet_size;
	}
	
	public int getTimeout() {
		return timeout;
	}
	
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	/**
	 * @return the timeLateMax
	 */
	public int getTimeLateMax() {
		return this.timeLateMax;
	}

	/**
	 * @param timeLateMax the timeLateMax to set
	 */
	public void setTimeLateMax(int timeLateMax) {
		this.timeLateMax = timeLateMax;
	}

	/**
	 * @return the timeLateMin
	 */
	public int getTimeLateMin() {
		return this.timeLateMin;
	}

	/**
	 * @param timeLateMin the timeLateMin to set
	 */
	public void setTimeLateMin(int timeLateMin) {
		this.timeLateMin = timeLateMin;
	}

	/**
	 * @return the timeLateAvg
	 */
	public int getTimeLateAvg() {
		return this.timeLateAvg;
	}

	/**
	 * @param timeLateAvg the timeLateAvg to set
	 */
	public void setTimeLateAvg(int timeLateAvg) {
		this.timeLateAvg = timeLateAvg;
	}

	/**
	 * @return the sendPackets
	 */
	public int getSendPackets() {
		return this.sendPackets;
	}

	/**
	 * @param sendPackets the sendPackets to set
	 */
	public void setSendPackets(int sendPackets) {
		this.sendPackets = sendPackets;
	}

	/**
	 * @return the recvPackets
	 */
	public int getRecvPackets() {
		return this.recvPackets;
	}

	/**
	 * @param recvPackets the recvPackets to set
	 */
	public void setRecvPackets(int recvPackets) {
		this.recvPackets = recvPackets;
	}

	/**
	 * @return the dropPackets
	 */
	public int getDropPackets() {
		return this.dropPackets;
	}

	/**
	 * @param dropPackets the dropPackets to set
	 */
	public void setDropPackets(int dropPackets) {
		this.dropPackets = dropPackets;
	}

	/**
	 * @return the dropRate
	 */
	public double getDropRate() {
		return this.dropRate;
	}

	/**
	 * @param dropRate the dropRate to set
	 */
	public void setDropRate(double dropRate) {
		this.dropRate = dropRate;
	}

	/**
	 * @return the isNormal
	 */
	public boolean isNormal() {
		return this.isNormal;
	}

	/**
	 * @param isNormal the isNormal to set
	 */
	public void setNormal(boolean isNormal) {
		this.isNormal = isNormal;
	}

	/**
	 * @return the detectEnvResultDesc
	 */
	public String getDetectEnvResultDesc() {
		return this.detectEnvResultDesc;
	}

	/**
	 * @param detectEnvResultDesc the detectEnvResultDesc to set
	 */
	public void setDetectEnvResultDesc(String detectEnvResultDesc) {
		this.detectEnvResultDesc = detectEnvResultDesc;
	}

	public int getRetry_times() {
		return retry_times;
	}
	
	public void setRetry_times(int retry_times) {
		this.retry_times = retry_times;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PingListParam [detectEnvResultDesc=" + detectEnvResultDesc
				+ ", dropPackets=" + dropPackets + ", dropRate=" + dropRate
				+ ", frequency=" + frequency + ", isNormal=" + isNormal
				+ ", packet_count=" + packet_count + ", packet_size="
				+ packet_size + ", param_id=" + param_id + ", param_name="
				+ param_name + ", recvPackets=" + recvPackets
				+ ", retry_times=" + retry_times + ", sendPackets="
				+ sendPackets + ", timeLateAvg=" + timeLateAvg
				+ ", timeLateMax=" + timeLateMax + ", timeLateMin="
				+ timeLateMin + ", timeout=" + timeout + "]";
	}

}
