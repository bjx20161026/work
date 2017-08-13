package com.jobsAutomatic.service.tempRetire.task;

import java.util.List;

import com.jobsAutomatic.service.modle.HotspotImportDto;
import com.jobsAutomatic.service.operator.SwitchDataImport;
import com.jobsAutomatic.service.operator.aps.ApDataImport;
import com.jobsAutomatic.service.operator.hotspots.HotApplyNetService;
import com.jobsAutomatic.service.operator.hotspots.HotReviewNetService;
import com.jobsAutomatic.service.operator.hotspots.HotSpotDataImport;
import com.jobsAutomatic.service.readExcle.ImportMsg;
import com.jobsAutomatic.service.readExcle.ReadAp;
import com.jobsAutomatic.service.readExcle.ReadHotspot;
import com.jobsAutomatic.service.readExcle.ReadSwitch;

public class HotChangeTask extends ATask {
	String include = "";

	@Override
	public void HandleTask() {
		try {
			// TODO Auto-generated method stub
			String filePath = workOrder.getLocalfile();
			ImportMsg importMsg = new ImportMsg();
			List<HotspotImportDto> hotspots = new ReadHotspot().readXlsx(filePath, importMsg);
			HotSpotDataImport hotSpotDataImport = new HotSpotDataImport();
			hotSpotDataImport.setJdbcTemplate(jdbcTemplate);
			hotSpotDataImport.saveImportData(hotspots, importMsg);
			SwitchDataImport switchDataImport = new SwitchDataImport();
			switchDataImport.setJdbcTemplate(jdbcTemplate);
			switchDataImport.saveImportData(new ReadSwitch().readXlsx(filePath, importMsg, 2), importMsg);
			ApDataImport apDataImport = new ApDataImport();
			apDataImport.setJdbcTemplate(jdbcTemplate);
			apDataImport.saveImportData(new ReadAp().readXlsx(filePath, importMsg, 3), importMsg);
			if (importMsg.getFailureCount() == 0) {
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
			} else {
				System.out.println("importMsg.getMessage() -->" + importMsg.getMessage());
				Sendfailure(importMsg.getMessage());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
