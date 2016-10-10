package com.bp.service;

import java.util.List;

import com.bp.entity.Activity;
import com.bp.entityCondition.ActivityCondition;

/**
 * 
 * @author current_bp
 * @createTime 20160830
 *
 */
public interface ActivityService {
	
	
	/**
	 * 创建一个活动
	 * @param activity
	 * @return
	 */
	public boolean createActivity(Activity activity);
	
	/**
	 * 根据ID获取活动
	 * @param id
	 * @return
	 */
	public Activity getActivityById(Long id);
	
	/**
	 * 获取所有的活动的列表
	 * @return
	 */
	public List<Activity> getActivityList();
	
	
	/**
	 * 根据条件获取相应的活动
	 * @param activityCondition
	 * @return
	 */
	public List<Activity> getActivityListByCondition(ActivityCondition activityCondition);

}
