package com.bp.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.bp.service.ActivityService;
import com.bp.service.QueueService;

/**
 * 
 * @author current_bp
 * @createTime 20161011
 *
 */
public class QueueServiceTest extends BaseTest {
	private final static Logger logger = Logger.getLogger(ActivityTest.class);

	@Autowired
	QueueService queueService;
	
	@Test
	public void addPerson() {
		System.out.println("===>addPerson:"+JSON.toJSONString(queueService.addPerson(1001L, 10002L)));
	}


	public void removePerson() {
		//TODO 先做
		System.out.println("===>removePerson:"+JSON.toJSONString(queueService.removePerson(1001L)));
	}

	@Test
	public void getPerson() {
		System.out.println("===>getPerson: customerId:"+JSON.toJSONString(queueService.getPerson(1001L)));
	}
}
