package com.jobsAutomatic.service.readExcle;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jobsAutomatic.service.common.Common;
import com.jobsAutomatic.service.modle.ApImportDto;


public class ReadAp extends ReadExcle{
	public List<ApImportDto> readXlsx(String path,ImportMsg importMsg,int sheetId) throws Exception{	
		 List<ApImportDto> apImportDtos;
		 System.out.println(Common.PROCESSING + path);
	     InputStream is = new FileInputStream(path);
	     XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
	     ReadSheet readSheet=new ReadSheet();
	     apImportDtos=readSheet.getAp(xssfWorkbook, importMsg,sheetId);
	     xssfWorkbook.close();
		 return apImportDtos;
	}
	public String readXlsx1(String path,ImportMsg importMsg,int sheetId){
		try{
			 System.out.println(Common.PROCESSING + path);
		     InputStream is = new FileInputStream(path);
		     XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		     ReadSheet readSheet=new ReadSheet();
		     String ips=readSheet.getApOut(xssfWorkbook, importMsg);
		     xssfWorkbook.close();
		     return ips;
		}catch(Exception e){
			importMsg.appendMessage("读取ap退服文件失败，请确认文件是否正确"+path);
			e.printStackTrace();
			return null;
		}
	}
}
