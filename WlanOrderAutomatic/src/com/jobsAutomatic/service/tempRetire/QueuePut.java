package com.jobsAutomatic.service.tempRetire;

import java.util.Date;
import java.util.concurrent.DelayQueue;

public class QueuePut {
	private DelayQueue<RetireTask> queue;
	public QueuePut(Date startDate,Date endDate,String hotstpotid,int projectStatus,String workjob_id){
		Date date = new Date();
        long time = date.getTime();
        long starttime = startDate.getTime();
        RetireTask retireTask = new RetireTask(starttime,endDate,starttime-time,hotstpotid,projectStatus,workjob_id);
        queue=QueueMaker.getQueue();
        queue.offer(retireTask);
	}
}
