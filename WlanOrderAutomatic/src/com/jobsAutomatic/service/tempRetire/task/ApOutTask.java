package com.jobsAutomatic.service.tempRetire.task;

import com.jobsAutomatic.service.operator.aps.ApApplyNetService;
import com.jobsAutomatic.service.operator.aps.ApReviewNetService;
import com.jobsAutomatic.service.readExcle.ImportMsg;
import com.jobsAutomatic.service.readExcle.ReadAp;

public class ApOutTask extends ATask {

	@Override
	public void HandleTask() {
		// TODO Auto-generated method stub
		try {
			String filePath = workOrder.getLocalfile();
			ImportMsg importMsg = new ImportMsg();
			System.out.println("ap退服开始:" + workOrder.getWorkjob_id());
			String include = new ReadAp().readXlsx1(filePath, importMsg, 1);
			jdbcTemplate.update("update work_order set  statement='校验完成',include = ? where workjob_id = ?", include,
					workOrder.getWorkjob_id());
			new ApApplyNetService().ApplyNetService(workOrder.getWorkjob_id());
			new ApReviewNetService().ReviewNetService(workOrder.getWorkjob_id());
			SendSuccess();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
