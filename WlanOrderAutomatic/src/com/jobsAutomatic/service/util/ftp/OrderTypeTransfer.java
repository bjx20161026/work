package com.jobsAutomatic.service.util.ftp;

import java.util.Properties;

import com.jobsAutomatic.service.util.FileTools;

public class OrderTypeTransfer {
	public String Transfer(String sheetName){
		Properties pro = FileTools.getProperties("OrderType.properties");
		for(Object object:pro.keySet()){
			if(sheetName.equalsIgnoreCase(object.toString()))
				return pro.getProperty(object.toString());
		}
		return null;
	}
}
