package com.jobsAutomatic.service.readExcle;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jobsAutomatic.service.common.Common;
import com.jobsAutomatic.service.modle.SwitchDto;


public class ReadSwitch extends ReadExcle{
	public List<SwitchDto> readXlsx(String path,ImportMsg importMsg,int sheetId) throws Exception{	
		 List<SwitchDto> aryLis1;
		 System.out.println(Common.PROCESSING + path);
	     InputStream is = new FileInputStream(path);
	     XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
	     ReadSheet readSheet=new ReadSheet();
	     aryLis1=readSheet.getSwitch(xssfWorkbook, importMsg,sheetId);
	     xssfWorkbook.close();
		 return aryLis1;
	}
}
