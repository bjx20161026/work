package com.jobsAutomatic.service.tempRetire.task;

import java.util.List;

import com.jobsAutomatic.service.modle.ApImportDto;
import com.jobsAutomatic.service.modle.HotspotImportDto;
import com.jobsAutomatic.service.modle.SwitchDto;
import com.jobsAutomatic.service.operator.SwitchDataImport;
import com.jobsAutomatic.service.operator.aps.ApDataImport;
import com.jobsAutomatic.service.operator.hotspots.HotApplyNetService;
import com.jobsAutomatic.service.operator.hotspots.HotReviewNetService;
import com.jobsAutomatic.service.operator.hotspots.HotSpotDataImport;
import com.jobsAutomatic.service.readExcle.ImportMsg;
import com.jobsAutomatic.service.readExcle.ReadAp;
import com.jobsAutomatic.service.readExcle.ReadHotspot;
import com.jobsAutomatic.service.readExcle.ReadSwitch;



public class HotImportTask extends ATask {
	String include = "";
	@Override
	public void HandleTask() {
		try {
			// TODO Auto-generated method stub
			String filePath = workOrder.getLocalfile();
			ImportMsg importMsg = new ImportMsg();
			List<HotspotImportDto> hotspots = new ReadHotspot().readXlsx(filePath, importMsg);
			if(importMsg.getFailureCount() != 0){
				logger.error("importMsg.getMessage() -->" + importMsg.getMessage());
				Sendfailure(importMsg.getMessage());
				return;
			}
			HotSpotDataImport hotSpotDataImport = new HotSpotDataImport();
			hotSpotDataImport.setJdbcTemplate(jdbcTemplate);
			hotSpotDataImport.saveImportData(hotspots, importMsg);
			if(importMsg.getFailureCount() != 0){
				logger.error("importMsg.getMessage() -->" + importMsg.getMessage());
				NotSend(importMsg.getMessage());
				return;
			}
			List<SwitchDto> switches = new ReadSwitch().readXlsx(filePath, importMsg, 2);
			if(importMsg.getFailureCount() != 0){
				logger.error("importMsg.getMessage() -->" + importMsg.getMessage());
				Sendfailure(importMsg.getMessage());
				return;
			}
			SwitchDataImport switchDataImport = new SwitchDataImport();
			switchDataImport.setJdbcTemplate(jdbcTemplate);
			switchDataImport.saveImportData(switches, importMsg);
			if(importMsg.getFailureCount() != 0){
				logger.error("importMsg.getMessage() -->" + importMsg.getMessage());
				NotSend(importMsg.getMessage());
				return;
			}
			List<ApImportDto> apImportDtos = new ReadAp().readXlsx(filePath, importMsg, 3);
			if(importMsg.getFailureCount() != 0){
				logger.error("importMsg.getMessage() -->" + importMsg.getMessage());
				Sendfailure(importMsg.getMessage());
				return;
			}
			ApDataImport apDataImport = new ApDataImport();
			apDataImport.setJdbcTemplate(jdbcTemplate);
			apDataImport.saveImportData(apImportDtos, importMsg);
			if(importMsg.getFailureCount() != 0){
				logger.error("importMsg.getMessage() -->" + importMsg.getMessage());
				NotSend(importMsg.getMessage());
				return;
			}
			for (HotspotImportDto hotspot : hotspots) {
				include += hotspot.getNasId() + ",";
			}
			System.out.println("include -->>" + include);
			include = include.substring(0, include.length() - 1);
			jdbcTemplate.update("update work_order set  statement='校验完成',include = ? where workjob_id = ?", include,
					workOrder.getWorkjob_id());
			new HotApplyNetService().ApplyNetService(workOrder.getWorkjob_id());
			new HotReviewNetService().ReviewNetService(workOrder.getWorkjob_id());
			SendSuccess();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			NotSend(e.getMessage());
		}
	}
}
