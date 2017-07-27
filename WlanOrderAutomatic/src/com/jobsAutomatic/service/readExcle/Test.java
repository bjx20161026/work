//package com.jobsAutomatic.service.readExcle;
//
//import java.util.List;
//
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import com.jobsAutomatic.service.modle.ApImportDto;
//import com.jobsAutomatic.service.modle.HotspotImportDto;
//import com.jobsAutomatic.service.modle.SwitchDto;
//import com.jobsAutomatic.service.operator.SwitchDataImport;
//import com.jobsAutomatic.service.operator.aps.ApDataImport;
//import com.jobsAutomatic.service.operator.hotspots.HotSpotDataImport;
//
//
//
//public class Test {
//
//	public static void main(String[] args)  {
//
////		WorkJob workJob = null;
////		ReadExcle rh=new ReadWorkJob();
////		try {
////		 workJob=(WorkJob) rh.readXlsx("F:/热点导入.xlsx");
////		 System.out.println(workJob.getWorkjob_id());
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		System.out.println(workJob.getSend_time()); 
////		CheckWorkJob check=new CheckWorkJob();
////	    check.setWorkJob(workJob);
////	    String str=check.CheckWork();
////	    System.out.println(str);
//		DriverManagerDataSource dataSource=new DriverManagerDataSource();
//		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.39:1521:ipnet");
//		dataSource.setUsername("res");
//		dataSource.setPassword("SHres!23$");
//		ImportMsg importMsg=new ImportMsg();
////		WorkJobOperator workJobOperator=new WorkJobOperator();
////		workJobOperator.setDataSource(dataSource);
////		workJobOperator.InsertWorkJob(workJob);	
//		
//		List<HotspotImportDto> aryLis1;
//		try{
//		ReadHotspot rh=new ReadHotspot();
//		aryLis1=rh.readXlsx("F:/热点导入.xlsx", importMsg);
//		HotspotImportDto dto = aryLis1.get(0);
//		System.out.println(dto.getAcs()+" "+dto.getApAddrFrom()+" "+dto.getCity()+dto.getOperateTime());
//		HotSpotDataImport hotSpotDataImport=new HotSpotDataImport();
//		hotSpotDataImport.setDataSource(dataSource);
//		hotSpotDataImport.saveImportData(aryLis1,importMsg);
//		
//		List<SwitchDto> switches;
//		ReadSwitch rs=new ReadSwitch();
//		switches=rs.readXlsx("F:/热点导入.xlsx", importMsg,2);
//		SwitchDto dt2=switches.get(0);
//		System.out.println("交换机:"+dt2.getAlias()+","+dt2.getIpAddr());
//		SwitchDataImport switchDataImport=new SwitchDataImport();
//		switchDataImport.setDataSource(dataSource);
//		switchDataImport.saveImportData(switches, importMsg);
//		
//		List<ApImportDto> apImportDtos;
//		ReadAp ra=new ReadAp();
//		apImportDtos=ra.readXlsx("F:/热点导入.xlsx", importMsg,3);
//		ApImportDto dt3=apImportDtos.get(0);
//		System.out.println("AP:"+dt3.getAlias()+","+dt3.getIpAddr());
//		ApDataImport apDataImport=new ApDataImport();
//		apDataImport.setDataSource(dataSource);
//		apDataImport.saveImportData(apImportDtos, importMsg);
////			System.out.println(new ReadHotspot().readXlsx1("F:/热点退服.xlsx", importMsg));
//
//		}catch(Exception ee){
//			ee.printStackTrace();
//		}
//		System.out.println("导入失败: "+importMsg.getMessage());
//		System.out.println("导入成功: "+importMsg.getImportMsg());
////		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
////		String sql="Select * from work_order where statement='待处理'";
////		jdbcTemplate.execute(sql);
////	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
////	     Date date2 = sdf.parse("2017-03-01 16:30:00"); 
////		jdbcTemplate.update("update RM_OBJECT_STATUS_POLICY@WLAN_RM set stamp_end=? where object_id='402881f95a4035eb015a404e49930002'",date2);			
////		int i=jdbcTemplate.queryForInt("select count(*) from prm_wlan_hotspot");
////		System.out.println(i);
////		RowMapper<WorkOrder> rowMapper=new BeanPropertyRowMapper<WorkOrder>(WorkOrder.class);
////		List<WorkOrder> workOrders= jdbcTemplate.query(sql, rowMapper);
////		for (WorkOrder workOrder : workOrders) {
////		    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+","+workOrder.getArea()+","+workOrder.getWorkjob_id()+","+workOrder.getWorkjob_type());
////	}
//	}
//}
