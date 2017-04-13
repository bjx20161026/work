package com.jobsAutomatic.service.modle;

import java.util.List;

public class ReplyWorkOrder {
	private int totalSize;
	private List<WorkOrder> data;
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public List<WorkOrder> getData() {
		return data;
	}
	public void setData(List<WorkOrder> data) {
		this.data = data;
	}

}
