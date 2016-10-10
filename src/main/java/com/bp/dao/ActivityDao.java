package com.bp.dao;

import java.util.List;

import com.bp.entity.Activity;

/**
 * 
 * @author current_bp
 * @createTime 20160830
 *
 */
public interface ActivityDao {

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
	 * 获取所有活动的KEY的列表
	 * @return
	 */
	public List<String> getActivityKeysList();
}
