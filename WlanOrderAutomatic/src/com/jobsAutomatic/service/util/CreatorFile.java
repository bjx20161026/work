package com.jobsAutomatic.service.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.csvreader.CsvWriter;

public class CreatorFile {
	private CsvWriter cw;

	public byte[] Creator(String[] heads, List<Map<String, Object>> datas, String type) throws IOException {
		if (type.equals("csv"))
			return CreatCsv(heads, datas);
		else
			return createExcelFile(heads, datas, type);
	}

	public byte[] CreatCsv(String[] heads, List<Map<String, Object>> datas) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String[] head = {"工单流水号","主题","派单人","派单部门","派单时间","处理时限","热点名称","屏蔽开始时间","屏蔽结束时间","属地分公司","行政区域","附件ftp信息","工单处理状态","是否成功","工单类型","nasid","完成时间","回单信息","工单包含的处理项","操作时间","本地附件路径","失败原因","操作人"};
		cw = new CsvWriter(new PrintWriter(new OutputStreamWriter(bos, "gbk")), ',');
		cw.writeRecord(head, true);
		cw.flush();
		for (Map<String, Object> data : datas) {
			Object[] records = map2Array(data, heads);
			for (Object s : records) {
				System.out.println(String.valueOf(s).equals("null") ? "" : String.valueOf(s));
				cw.write(String.valueOf(s).equals("null") ? "" : String.valueOf(s));
			}
			cw.endRecord();
		}
		cw.flush();
		bos.flush();
		bos.close();
		return bos.toByteArray();
	}

	@SuppressWarnings("rawtypes")
	public static Object[] map2Array(Map map, String[] properiesName) {
		int len = properiesName.length;
		Object[] objs = new Object[len];
		for (int i = 0; i < len; i++) {
			System.out.println(objs[i] = map.get(properiesName[i]));
		}
		return objs;
	}

	public byte[] toArray(InputStream is) throws Exception {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = is.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.flush();
		return bos.toByteArray();
	}

	@SuppressWarnings("deprecation")
	public byte[] createExcelFile(String[] heads, List<Map<String, Object>> datas, String type) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Workbook workbook = null;
		try {
			if (type.equals("xls"))
				workbook = new HSSFWorkbook();
			else
				workbook = new XSSFWorkbook();
		} catch (Exception e) {
			System.out.println("It cause Error on CREATING excel workbook: ");
			e.printStackTrace();
		}
		if (workbook != null) {
			Sheet sheet = workbook.createSheet("sheet1");
			Row row0 = sheet.createRow(0);
			String[] head = {"工单流水号","主题","派单人","派单部门","派单时间","处理时限","热点名称","屏蔽开始时间","屏蔽结束时间","属地分公司","行政区域","附件ftp信息","工单处理状态","是否成功","工单类型","nasid","完成时间","回单信息","工单包含的处理项","操作时间","本地附件路径","失败原因","操作人"};
			for (int i = 0; i < head.length; i++) {
				Cell cell = row0.createCell(i, Cell.CELL_TYPE_STRING);
				cell.setCellValue(head[i]);
			}
			for (int rowNum = 1; rowNum < datas.size()+1; rowNum++) {
				Map<String, Object> map = datas.get(rowNum - 1);
				Row row = sheet.createRow(rowNum);
				for (int i = 0; i < heads.length; i++) {
					Cell cell = row.createCell(i, Cell.CELL_TYPE_STRING);
					cell.setCellValue(
							String.valueOf(map.get(heads[i])).equals("null") ? "" : String.valueOf(map.get(heads[i])));
				}
			}
			workbook.write(bos);
			bos.flush();
			bos.close();
		}
		return bos.toByteArray();
	}
}
