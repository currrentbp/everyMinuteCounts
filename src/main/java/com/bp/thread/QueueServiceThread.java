package com.bp.thread;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bp.service.QueueService;


/**
 * 
 * @author current_bp
 * @createTime 20161031
 *
 */
public class QueueServiceThread {

	private QueueThread queueThread = null;
	private final static Logger logger = Logger.getLogger(QueueServiceThread.class);
	
	
	public void addPersonToQueue(){
		
	}
}


class QueueThread implements Runnable{
	private final static Logger logger = Logger.getLogger(QueueThread.class);
	
	private Long customerId;
	private Long activityId;
	public QueueThread() {
	}
	public QueueThread(Long activityId,Long customerId) {
		this.customerId = customerId;
		this.activityId = activityId;
	}
	
	@Autowired
	QueueService queueService;
	
	
	@Override
	public void run() {
		queueService.addPerson(activityId, customerId);
	}
	
}
