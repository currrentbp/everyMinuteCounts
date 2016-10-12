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
	private final static Logger logger = Logger.getLogger(QueueServiceTest.class);

	@Autowired
	QueueService queueService;
	
	@Test
	public void addPerson() {
		logger.info("===>addPerson:"+JSON.toJSONString(queueService.addPerson(1001L, 10002L)));
	}

	@Test
	public void removePerson() {
		logger.info("===>removePerson:"+JSON.toJSONString(queueService.removePerson(1L)));
	}

	@Test
	public void getPerson() {
		logger.info("===>getPerson: customerId:"+JSON.toJSONString(queueService.getPerson(1001L)));
	}
}
