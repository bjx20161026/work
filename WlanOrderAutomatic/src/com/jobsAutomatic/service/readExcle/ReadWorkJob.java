package com.jobsAutomatic.service.readExcle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jobsAutomatic.service.common.Common;
import com.jobsAutomatic.service.modle.WorkJob;



public class ReadWorkJob extends ReadExcle{
	 private WorkJob workJob;

	 public WorkJob readXlsx(String path) throws IOException {
	       System.out.println(Common.PROCESSING + path);
	        InputStream is = new FileInputStream(path);
	        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
	        ReadSheet readSheet=new ReadSheet();
	        workJob=readSheet.setWorkJob(xssfWorkbook); 
            xssfWorkbook.close();		 
			return workJob;}
	 public String getSheetName(String path) throws IOException{
		 InputStream is = new FileInputStream(path);
		 XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		 ReadSheet readSheet=new ReadSheet();
		 String SheetName = readSheet.getSheetName(xssfWorkbook, 1);
		 xssfWorkbook.close();	
	     return SheetName; 
	 }
	 
}
