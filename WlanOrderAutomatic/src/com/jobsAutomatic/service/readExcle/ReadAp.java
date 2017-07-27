package com.jobsAutomatic.service.readExcle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jobsAutomatic.service.common.Common;
import com.jobsAutomatic.service.modle.ApImportDto;
import com.jobsAutomatic.service.util.Util;

public class ReadAp implements ReadExcle {
	public List<ApImportDto> readXlsx(String path, ImportMsg importMsg, int sheetId) throws Exception {
		List<ApImportDto> apImportDtos;
		System.out.println(Common.PROCESSING + path);
		InputStream is = new FileInputStream(path);
		String postfix = Util.getPostfix(path);
		if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
			ReadXlsSheet readXlsSheet = new ReadXlsSheet();
			apImportDtos = readXlsSheet.getAp(hssfWorkbook, importMsg, sheetId);
			hssfWorkbook.close();
		} else {
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
			ReadSheet readSheet = new ReadSheet();
			apImportDtos = readSheet.getAp(xssfWorkbook, importMsg, sheetId);
			xssfWorkbook.close();
		}
		return apImportDtos;
	}

	public String readXlsx1(String path, ImportMsg importMsg, int sheetId) {
		try {
			System.out.println(Common.PROCESSING + path);
			InputStream is = new FileInputStream(path);
			String postfix = Util.getPostfix(path);
			String ips;
			if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
				ReadXlsSheet readXlsSheet = new ReadXlsSheet();
				ips = readXlsSheet.getApOut(hssfWorkbook, importMsg);
			} else {
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
				ReadSheet readSheet = new ReadSheet();
				ips = readSheet.getApOut(xssfWorkbook, importMsg);
				xssfWorkbook.close();
			}
			return ips;
		} catch (Exception e) {
			importMsg.appendMessage("读取ap退服文件失败，请确认文件是否正确" + path);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public <T> Object readExcel(String path) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Object readXlsx(String path) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Object readXls(String path) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args){
		ReadAp readAp = new ReadAp();
		try {
			readAp.readXlsx("F:/SH-206-170719-00009_WLAN.xls", new ImportMsg(), 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
