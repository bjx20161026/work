package com.jobsAutomatic.service.readExcle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jobsAutomatic.service.common.Common;
import com.jobsAutomatic.service.modle.HotspotImportDto;
import com.jobsAutomatic.service.util.Util;

public class ReadHotspot implements ReadExcle {

	public List<HotspotImportDto> readXlsx(String path, ImportMsg importMsg) {
		List<HotspotImportDto> aryLis1;
		try {
			System.out.println(Common.PROCESSING + path);
			InputStream is = new FileInputStream(path);
			String postfix = Util.getPostfix(path);
			if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
				ReadXlsSheet readXlsSheet = new ReadXlsSheet();
				aryLis1 = readXlsSheet.setHotSpot(hssfWorkbook, importMsg);
				hssfWorkbook.close();
			} else {
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
				ReadSheet readSheet = new ReadSheet();
				aryLis1 = readSheet.setHotSpot(xssfWorkbook, importMsg);
				xssfWorkbook.close();
			}
			return aryLis1;
		} catch (Exception e) {
			importMsg.appendMessage("读取热点导入文件失败，请确认文件是否正确" + path);
			return null;
		}
	}

	public String readXlsx1(String path, ImportMsg importMsg) throws IOException {
		try {
			System.out.println(Common.PROCESSING + path);
			InputStream is = new FileInputStream(path);
			String postfix = Util.getPostfix(path);
			String nasids;
			if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
				ReadXlsSheet readXlsSheet = new ReadXlsSheet();
				nasids = readXlsSheet.getHotSpotOut(hssfWorkbook, importMsg);
				hssfWorkbook.close();
			} else {
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
				ReadSheet readSheet = new ReadSheet();
				nasids = readSheet.getHotSpotOut(xssfWorkbook, importMsg);
				xssfWorkbook.close();
			}
			return nasids;
		} catch (Exception e) {
			importMsg.appendMessage("读取热点退服文件失败，请确认文件是否正确" + path);
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
}
