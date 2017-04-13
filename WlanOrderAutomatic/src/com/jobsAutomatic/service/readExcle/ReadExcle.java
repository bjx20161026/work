package com.jobsAutomatic.service.readExcle;

import java.io.IOException;

import com.jobsAutomatic.service.common.Common;
import com.jobsAutomatic.service.util.Util;



public abstract class ReadExcle {
    /**
     * read the Excel file
     * @param path the path of the Excel file
     * @return
     * @throws IOException
     */
    public Object readExcel(String path) throws IOException {
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
    /**
     * Read the Excel 2010
     * @param path the path of the excel file
     * @return list
     * @throws IOException
     */
    public <T> Object readXlsx(String path) throws IOException {
		return null;}
    /**
     * Read the Excel 2003-2007
     * @param path the path of the Excel
     * @return 
     * @return 
     * @return list
     * @throws IOException
     */
    public <T> Object readXls(String path) throws IOException {
		return null;
    }
}
