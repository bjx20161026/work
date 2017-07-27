package com.jobsAutomatic.test;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Receipt {
	public String SendReceipt(String sheetId, String makeResult, String failReason) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("opDetail");
		Element recordInfo = root.addElement("recordInfo");
		Element fieldsheetId = recordInfo.addElement("fieldInfo");
		Element ChNamesheetId = fieldsheetId.addElement("fieldChName");
		ChNamesheetId.setText("工单流水号");
		Element EnNamesheetId = fieldsheetId.addElement("fieldEnName");
		EnNamesheetId.setText("sheetId");
		Element ContentsheetId = fieldsheetId.addElement("fieldContent");
		ContentsheetId.setText(sheetId);
		Element fieldResult = recordInfo.addElement("fieldInfo");
		Element ChNameResult = fieldResult.addElement("fieldChName");
		ChNameResult.setText("制作结果");
		Element EnNameResult = fieldResult.addElement("fieldEnName");
		EnNameResult.setText("makeResult");
		Element ContentResult = fieldResult.addElement("fieldContent");
		ContentResult.setText(makeResult);
		Element fieldReason = recordInfo.addElement("fieldInfo");
		Element ChNameReason = fieldReason.addElement("fieldChName");
		ChNameReason.setText("不成功理由");
		Element EnNameReason = fieldReason.addElement("fieldEnName");
		EnNameReason.setText("failReason");
		Element ContentReason = fieldReason.addElement("fieldContent");
		ContentReason.setText(failReason);
		String docXmlText = document.asXML();
		System.out.println("docXmlText:" + docXmlText);
		return docXmlText;
	}

	public static void main(String[] args) {
		try {
			System.out.println(new Receipt().SendReceipt("<>", "&", "'\""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
