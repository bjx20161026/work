package com.jobsAutomatic.service.tempRetire.task;

import com.jobsAutomatic.service.operator.hotspots.HotOutApplyService;
import com.jobsAutomatic.service.operator.hotspots.HotReviewOutService;
import com.jobsAutomatic.service.readExcle.ImportMsg;
import com.jobsAutomatic.service.readExcle.ReadHotspot;



public class HotOutTask extends ATask{

	@Override
	public void HandleTask() {
		// TODO Auto-generated method stub
		try{
			String filePath = workOrder.getLocalfile();
			ImportMsg importMsg = new ImportMsg();
			System.out.println("热点退服开始:" + workOrder.getWorkjob_id());
			String include = new ReadHotspot().readXlsx1(filePath, importMsg);
			jdbcTemplate.update("update work_order set  statement='校验完成',include = ? where workjob_id = ?",
					include, workOrder.getWorkjob_id());
			new HotOutApplyService().OutApplytService(workOrder.getWorkjob_id());
			new HotReviewOutService().ReviewOutService(workOrder.getWorkjob_id());
			SendSuccess();
		}catch(Exception e){
			e.printStackTrace();
			NotSend(e.getMessage());
			logger.error(e.getMessage());
		}
	}
}
