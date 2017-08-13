package com.jobsAutomatic.service.util;

import java.util.List;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.jobsAutomatic.service.modle.HotspotImportDto;
import com.jobsAutomatic.service.operator.SwitchDataImport;
import com.jobsAutomatic.service.operator.aps.ApDataImport;
import com.jobsAutomatic.service.operator.hotspots.HotSpotDataImport;
import com.jobsAutomatic.service.readExcle.ImportMsg;
import com.jobsAutomatic.service.readExcle.ReadAp;
import com.jobsAutomatic.service.readExcle.ReadHotspot;
import com.jobsAutomatic.service.readExcle.ReadSwitch;
import com.jobsAutomatic.service.util.ftp.FileOperate;




public class Test {
	public static void main(String[] args){
//		DriverManagerDataSource dataSource=new DriverManagerDataSource();
//		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.36:1521:ipnet");
//		dataSource.setUsername("rm");
//		dataSource.setPassword("SHrm!23$");
//		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
//		String sql="  select min(result) from  (  SELECT CASE  WHEN SYS_NAME_RESULT = 1 AND VENDOR_RESULT = 1 AND MODEL_RESULT = 1 AND   IP_ADDR_RESULT = 1 THEN   2  WHEN IP_ADDR_RESULT = 0 OR IP_ADDR_RESULT = 2 THEN   0  ELSE   1  END AS RESULT   FROM (SELECT CASE  WHEN T2.SYS_NAME IS NULL THEN 0  WHEN T1.SYS_NAME = T2.SYS_NAME THEN 1  ELSE 2    END AS SYS_NAME_RESULT,    CASE  WHEN T2.VENDOR IS NULL THEN 0  WHEN T1.VENDOR = T2.VENDOR THEN 1  ELSE 2    END AS VENDOR_RESULT,    CASE  WHEN T2.SYS_MODEL IS NULL THEN 0  WHEN T1.MODEL = T2.SYS_MODEL THEN 1  ELSE 2    END AS MODEL_RESULT,    CASE  WHEN T2.IP_ADDR IS NULL THEN 0  WHEN T1.IP_ADDR = T2.IP_ADDR THEN 1  ELSE 2    END AS IP_ADDR_RESULT   FROM (SELECT T1.DEVICE_ID,    T1.MAC_ADDR,    T1.SYS_NAME,    T1.VENDOR,    T1.MODEL,    T1.IP_ADDR FROM PRM_DEVICE@RES T1, PRM_DEVICE_AP@RES T2  WHERE T1.DEVICE_ID = T2.DEVICE_ID  AND T2.HOTSPOT_ID =    (SELECT HOTSPOT_ID     FROM PRM_WLAN_HOTSPOT@RES    WHERE NAS_ID = ?)) T1   LEFT JOIN (SELECT T1.MAC_ADDR,    T1.SYS_NAME,    T2.VENDOR,    T1.DEVICE_MODEL AS SYS_MODEL,    T1.IP_ADDR   from RM_DEVICE    T1,    RM_DEVICE_TEMPLATE T2,    RM_AP_CONFIG   T3  WHERE T1.DEVICE_ID = T3.DEVICE_ID    AND T1.SYS_OID = T2.SYS_OID    AND T3.HOTSPOT_ID =    (SELECT HOTSPOT_ID   FROM RM_WLAN_HOTSPOT  WHERE NAS_ID = ?)) T2   ON T1.MAC_ADDR = T2.MAC_ADDR) T1   )   union all   select min(result) from  ( SELECT CASE  WHEN SYS_NAME_RESULT = 1 AND VENDOR_RESULT = 1 AND   MODEL_RESULT = 1 AND IP_ADDR_RESULT = 1 THEN 2  WHEN IP_ADDR_RESULT = 0 OR IP_ADDR_RESULT = 2 THEN 0  ELSE 1    END AS RESULT   FROM (SELECT  CASE    WHEN T2.SYS_NAME IS NULL THEN     0    WHEN T1.SYS_NAME = T2.SYS_NAME THEN     1    ELSE     2    END AS SYS_NAME_RESULT,    CASE    WHEN T2.VENDOR IS NULL THEN     0    WHEN T1.VENDOR = T2.VENDOR THEN     1    ELSE     2    END AS VENDOR_RESULT,    CASE    WHEN T2.SYS_MODEL IS NULL THEN     0    WHEN T1.MODEL = T2.SYS_MODEL THEN     1    ELSE     2    END AS MODEL_RESULT,    CASE    WHEN T2.IP_ADDR IS NULL THEN     0    WHEN T1.IP_ADDR = T2.IP_ADDR THEN     1    ELSE     2    END AS IP_ADDR_RESULT FROM (SELECT T1.DEVICE_ID,  T1.SYS_NAME,  T1.VENDOR,  T1.MODEL,  T1.IP_ADDR     FROM PRM_DEVICE@RES T1, PRM_DEVICE_SWITCH@RES T2    WHERE T1.DEVICE_ID = T2.DEVICE_ID    AND T2.HOTSPOT_ID =  (SELECT HOTSPOT_ID   FROM PRM_WLAN_HOTSPOT@RES    WHERE NAS_ID =  ?)) T1 LEFT JOIN (SELECT T1.SYS_NAME,    T2.VENDOR,    T2.SYS_MODEL,    T1.IP_ADDR   from RM_DEVICE    T1,    RM_DEVICE_TEMPLATE T2,    RM_SWITCH_EXT_INFO T3  WHERE T1.DEVICE_ID = T3.DEVICE_ID  AND T1.SYS_OID = T2.SYS_OID  AND T2.DEVICE_TYPE = 'SWITCH'  AND T3.HOTSPOT_ID =    (SELECT HOTSPOT_ID     FROM RM_WLAN_HOTSPOT    WHERE NAS_ID =  ?)) T2   ON T1.IP_ADDR = T2.IP_ADDR) T1   )";
//		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql,"0267.0200.210.00.460","0267.0200.210.00.460","0267.0200.210.00.460","0267.0200.210.00.460");
//		for(Map<String, Object> i:list){
//			System.out.println(i.get("min(result)"));
//		}
		
//		FileOperate fo = null;
		String ftpUrl="ftp://inas:1Na512#$@10.221.18.29:21//home/inas/fast-clt-pro/test/热点导入.xlsx";
//		String localUrl="../data/";
//		String filePath=localUrl+ftpUrl.substring(ftpUrl.lastIndexOf("/")+1);
		try {
//			 File file = new File(localUrl);
//			 if (!file .exists()&&!file.isDirectory()) {
//				 System.out.println("文件夹不存在，新建。。。");
//				 file.mkdirs();
//			 }
//			 System.out.println(file);
//			fo = new FileOperate(ftpUrl);
//			
//			fo.login();
//			for(String s:fo.ls())
//				System.out.println(s);
//		
//			fo.cd();
//			
//		
//			for(String s:fo.ls()){
//				System.out.println(s);
//			}
//
//			fo.get(ftpUrl.substring(ftpUrl.lastIndexOf("/")+1), new FileOutputStream(localUrl+ftpUrl.substring(ftpUrl.lastIndexOf("/")+1)));
//			File file2 = new File(localUrl+ftpUrl.substring(ftpUrl.lastIndexOf("/")+1));
//			System.out.println(file2);
			
		    FileOperate fo = new FileOperate(ftpUrl);
		    String filePath=fo.getDownloadFile();
			
			DriverManagerDataSource dataSource=new DriverManagerDataSource();
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@10.221.18.39:1521:ipnet");
			dataSource.setUsername("res");
			dataSource.setPassword("SHres!23$");
			ImportMsg importMsg=new ImportMsg();
			
			@SuppressWarnings("unused")
			List<HotspotImportDto> aryLis1;
			try{
			ReadHotspot rh=new ReadHotspot();
//			aryLis1=rh.readXlsx(filePath, importMsg);
//			HotspotImportDto dto = aryLis1.get(0);
//			System.out.println(dto.getAcs()+" "+dto.getApAddrFrom()+" "+dto.getCity()+dto.getOperateTime());
			HotSpotDataImport hotSpotDataImport=new HotSpotDataImport();
			hotSpotDataImport.setDataSource(dataSource);
			hotSpotDataImport.saveImportData(rh.readXlsx(filePath, importMsg),importMsg);
			
			SwitchDataImport switchDataImport=new SwitchDataImport();
			switchDataImport.setDataSource(dataSource);
			switchDataImport.saveImportData(new ReadSwitch().readXlsx(filePath, importMsg,2), importMsg);
			try{


			ApDataImport apDataImport=new ApDataImport();
			apDataImport.setDataSource(dataSource);
			apDataImport.saveImportData(new ReadAp().readXlsx(filePath, importMsg,3), importMsg);
			}catch(Exception e){
				e.printStackTrace();
			}
			}catch(Exception ee){
				ee.printStackTrace();
			}
			System.out.println("导入失败: "+importMsg.getMessage());
			System.out.println("导入成功: "+importMsg.getImportMsg());
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
