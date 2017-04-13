package com.jobsAutomatic.service.util.ftp;

public class OrderTypeTransfer {
	public String Transfer(String sheetName){
		if(sheetName.equalsIgnoreCase("AP导入")) return "AP入网";
		else if(sheetName.equalsIgnoreCase("AP退服")) return "AP变更";
		else if(sheetName.equalsIgnoreCase("热点导入")) return "热点变更";
		else return sheetName;
	}
}
