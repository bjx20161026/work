package com.jobsAutomatic.service.readExcle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jobsAutomatic.service.common.Common;
import com.jobsAutomatic.service.modle.WorkJob;
import com.jobsAutomatic.service.util.Util;

public class ReadWorkJob implements ReadExcle {
	Logger logger = Logger.getLogger(getClass());
	private WorkJob workJob;

	@Override
	public WorkJob readExcel(String path) throws IOException {
		if (path == null || Common.EMPTY.equals(path)) {
			return null;
		} else {
			String postfix = Util.getPostfix(path);
			if (!Common.EMPTY.equals(postfix)) {
				if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
					return readXls(path);
				} else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
					return readXlsx(path);
				}
			} else {
				System.out.println(path + Common.NOT_EXCEL_FILE);
			}
		}
		return null;
	}

	@Override
	public WorkJob readXlsx(String path) throws IOException {
		logger.info(Common.PROCESSING + path);
		InputStream is = new FileInputStream(path);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		ReadSheet readSheet = new ReadSheet();
		workJob = readSheet.setWorkJob(xssfWorkbook);
		xssfWorkbook.close();
		return workJob;
	}

	@Override
	public WorkJob readXls(String path) throws IOException {
		logger.info(Common.PROCESSING + path);
		InputStream is = new FileInputStream(path);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		ReadXlsSheet readXlsSheet = new ReadXlsSheet();
		workJob = readXlsSheet.setWorkJob(hssfWorkbook);
		hssfWorkbook.close();
		return workJob;
	}

	public String getSheetName(String path) throws IOException {
		InputStream is = new FileInputStream(path);
		String postfix = Util.getPostfix(path);

		if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
			ReadXlsSheet readXlsSheet = new ReadXlsSheet();
			String SheetName = readXlsSheet.getSheetName(hssfWorkbook, 1);
			hssfWorkbook.close();
			return SheetName;
		} else {
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
			ReadSheet readSheet = new ReadSheet();
			String SheetName = readSheet.getSheetName(xssfWorkbook, 1);
			xssfWorkbook.close();
			return SheetName;
		}
	}

	public static void main(String[] args) {
		ReadWorkJob readWorkJob = new ReadWorkJob();
		try {
			;
			System.out.println(readWorkJob.getSheetName("F:/SH-206-170719-00009_WLAN.xls"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
