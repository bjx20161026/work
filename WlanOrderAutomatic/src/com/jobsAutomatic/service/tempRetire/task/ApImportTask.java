package com.jobsAutomatic.service.tempRetire.task;

import java.util.List;

import com.jobsAutomatic.service.modle.ApImportDto;
import com.jobsAutomatic.service.operator.aps.ApApplyNetService;
import com.jobsAutomatic.service.operator.aps.ApDataImport;
import com.jobsAutomatic.service.operator.aps.ApReviewNetService;
import com.jobsAutomatic.service.readExcle.ImportMsg;
import com.jobsAutomatic.service.readExcle.ReadAp;



public class ApImportTask extends ATask {

	@Override
	public void HandleTask() {
		// TODO Auto-generated method stub
		try {
			String filePath = workOrder.getLocalfile();
			ImportMsg importMsg = new ImportMsg();
			List<ApImportDto> apImportDtos = new ReadAp().readXlsx(filePath, importMsg, 1);
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
			String include = "";
			for (ApImportDto apImportDto : apImportDtos) {
				include += apImportDto.getMacAddr() + ",";
			}
			include = include.substring(0, include.length() - 1);
			jdbcTemplate.update("update work_order set  statement='校验完成',include = ? where workjob_id = ?", include,
					workOrder.getWorkjob_id());
			new ApApplyNetService().ApplyNetService(workOrder.getWorkjob_id());
			new ApReviewNetService().ReviewNetService(workOrder.getWorkjob_id());
		    SendSuccess(); 			
		} catch (Exception e) {
			logger.error(e.getMessage());
			NotSend(e.getMessage());
			e.printStackTrace();
		}
	}
}
