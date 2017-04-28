package com.jobsAutomatic.service.check;

import java.util.Date;
import java.util.concurrent.DelayQueue;

public class QueueCheckPut {
	private DelayQueue<CheckTask> checkqueue;
	public QueueCheckPut(String include,String workjob_id){
		Date date = new Date();
        long id = date.getTime();
        CheckTask checkTask = new CheckTask(include,workjob_id,id,id+2*60*60*1000);
        checkqueue=QueueCheckMaker.getQueue();
        checkqueue.offer(checkTask);
	}
}
