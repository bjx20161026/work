package com.jobsAutomatic.service.check;

import java.util.concurrent.DelayQueue;

public class QueueCheckMaker {
	public static DelayQueue<CheckTask> checkqueue;
	public static void init(){
		QueueCheckHandle queueCheckHandle = new QueueCheckHandle();
		new Thread(queueCheckHandle).start();
	}
	public static DelayQueue<CheckTask> getQueue() {
		return checkqueue;
	}
	public static void setQueue(DelayQueue<CheckTask> queue) {
		QueueCheckHandle.checkqueue = checkqueue;
	}
}
