package com.bp.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.bp.entity.Activity;
import com.bp.entity.CreateActivityId;
import com.bp.entityCondition.ActivityCondition;
import com.bp.service.ActivityService;
import com.bp.statusOrType.ActivityStatus;
import com.bp.statusOrType.ActivityType;

/**
 * 
 * @author current_bp
 * @createTime 20160830
 *
 */

public class ActivityTest extends BaseTest {

	private final static Logger logger = Logger.getLogger(ActivityTest.class);

	@Autowired
	ActivityService activityService;

	@Test
	public void createActivity() {
		for (int i = 0; i < 10; i++) {
			Activity activity = new Activity();
			Long id = CreateActivityId.getActivityId();
			activity.setId(id);
			System.out.println("id:"+id);
			activity.setName("activityName_"+i);
			activity.setStatus(ActivityStatus.ACTIVITY_IS_START.getValue());
			activity.setStartDate("20160"+(i+1)+"01");
			activity.setEndDate("20160"+(i+3)+"01");
			activity.setCreateTime(new Date());
			activity.setUpdateTime(new Date());
			activity.setType(ActivityType.ACTIVITY_RED_ENVELOPE.getValue());
			activity.setTimes(new String[]{"070000-125959","130000-195959"});
			activity.setIsInSQL(0);

			boolean flag = activityService.createActivity(activity);
			logger.info("flag:" + flag);
		}
	}

	@Test
	public void getActivityById() {
		logger.info(JSON.toJSONString(activityService.getActivityById(1000L)));
		logger.info(JSON.toJSONString(activityService.getActivityById(1001L)));
	}

	@Test
	public void getAllActivity() {
		logger.info(JSON.toJSONString(activityService.getActivityList()));
	}

	@Test
	public void getActivityByCondition() {
		ActivityCondition ac = new ActivityCondition();
		ac.setStatus(1);
		
		logger.info("===>getActivityByCondition: activityList:"+ 
				JSON.toJSONString(activityService.getActivityListByCondition(ac)));

	}
}
