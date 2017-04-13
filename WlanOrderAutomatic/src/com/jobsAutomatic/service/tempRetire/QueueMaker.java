package com.jobsAutomatic.service.tempRetire;

import java.util.concurrent.DelayQueue;

import org.springframework.jdbc.core.JdbcTemplate;

public class QueueMaker {
public static DelayQueue<RetireTask> queue;
public static JdbcTemplate jdbcTemplate;	
	
	public static void init(){
		QueueHandle queueHandle = new QueueHandle(queue,jdbcTemplate);
		new Thread(queueHandle).start();
	}
	public static DelayQueue<RetireTask> getQueue() {
		return queue;
	}
	public static void setQueue(DelayQueue<RetireTask> queue) {
		QueueMaker.queue = queue;
	}
	public static JdbcTemplate getJdbcTemplate() {
	    return jdbcTemplate;
    }
    public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	    QueueMaker.jdbcTemplate = jdbcTemplate;
    }
}
