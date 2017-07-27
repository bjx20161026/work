package com.jobsAutomatic.service.readExcle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jobsAutomatic.service.common.Common;
import com.jobsAutomatic.service.modle.SwitchDto;
import com.jobsAutomatic.service.util.Util;

public class ReadSwitch implements ReadExcle {
	public List<SwitchDto> readXlsx(String path, ImportMsg importMsg, int sheetId) throws Exception {
		List<SwitchDto> aryLis1;
		System.out.println(Common.PROCESSING + path);
		InputStream is = new FileInputStream(path);
		String postfix = Util.getPostfix(path);
		if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
			ReadXlsSheet readXlsSheet = new ReadXlsSheet();
			aryLis1 = readXlsSheet.getSwitch(hssfWorkbook, importMsg, sheetId);
			hssfWorkbook.close();
		} else {
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
			ReadSheet readSheet = new ReadSheet();
			aryLis1 = readSheet.getSwitch(xssfWorkbook, importMsg, sheetId);
			xssfWorkbook.close();
		}
		return aryLis1;
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
}
