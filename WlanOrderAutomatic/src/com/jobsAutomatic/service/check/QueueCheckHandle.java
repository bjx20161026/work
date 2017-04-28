package com.jobsAutomatic.service.check;

import java.util.concurrent.DelayQueue;

import org.apache.log4j.Logger;

import com.jobsAutomatic.dao.CheckRm;
import com.jobsAutomatic.dao.OperateWorkOrder;
import com.jobsAutomatic.service.Sender.Receipt;


public class QueueCheckHandle implements Runnable {
	Logger logger = Logger.getLogger(QueueCheckHandle.class);
	public static DelayQueue<CheckTask> checkqueue;
	public String result;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
				try {
					String reason = "";
					CheckTask take = checkqueue.take();
					String include = take.getInclude();
					String[] nasIds = include.split(",");
					CheckRm checkRm = new CheckRm();
					for(String nasId:nasIds){					
						if(checkRm.CheckAp(nasId) == 0) reason  += "nasId : "+nasId+" AP采集未发现  ";
						if(checkRm.CheckSwitch(nasId) == 0 )  reason  += "nasId : "+nasId+" 交换机采集未发现  ";					
					}
					OperateWorkOrder updateWorkOrder = new OperateWorkOrder();
					if(reason.equals("")){
						result = new Receipt().SendReceipt(take.getWorkjob_id(), "成功", "");
						if (result!=null&&result.equals("0"))
							updateWorkOrder.Update("处理完成", 1, "", take.getWorkjob_id());
						else
							updateWorkOrder.Update("回单失败", 2, result, take.getWorkjob_id());
					}else{
						updateWorkOrder.Update("入库失败", 2, reason, take.getWorkjob_id());
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					logger.error(e.getMessage());
					e.printStackTrace();
				}
		}			
	}
	
	public static void main(String[] args){
		CheckRm checkRm = new CheckRm();
		int a = checkRm.CheckAp("0156.0001.210.00.460");
		System.out.println(a);
//		System.out.println(checkRm.CheckSwitch("0156.0001.210.00.460"));
	}

}
