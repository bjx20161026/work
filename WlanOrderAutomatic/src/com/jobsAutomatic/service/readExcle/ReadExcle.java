package com.jobsAutomatic.service.readExcle;

import java.io.IOException;

import com.jobsAutomatic.service.common.Common;
import com.jobsAutomatic.service.util.Util;



public interface ReadExcle {
    /**
     * read the Excel file
     * @param path the path of the Excel file
     * @return
     * @throws IOException
     */
    public <T> Object readExcel(String path) throws IOException;  
    /**
     * Read the Excel 2010
     * @param path the path of the excel file
     * @return list
     * @throws IOException
     */
    public <T> Object readXlsx(String path) throws IOException;
    /**
     * Read the Excel 2003-2007
     * @param path the path of the Excel
     * @return 
     * @return 
     * @return list
     * @throws IOException
     */
    public <T> Object readXls(String path) throws IOException;
}
