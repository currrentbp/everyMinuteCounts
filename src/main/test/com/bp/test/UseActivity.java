package com.bp.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bp.service.ActivityService;
import com.bp.service.RuleService;

/**
 * 
 * @author current_bp
 * @createTime 20161013
 *
 */

public class UseActivity extends BaseTest {

	private final static Logger logger = Logger.getLogger(UseActivity.class);

	@Autowired
	ActivityService activityService;
	@Autowired
	RuleService ruleService;

	@Test
	public void useActivity() {
		
		/*
		 * 1、参与活动，
		 * 2、插入队列
		 * 3、唤醒队列
		 */

	}

}
