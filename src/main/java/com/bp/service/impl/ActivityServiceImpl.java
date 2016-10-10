package com.bp.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.bp.dao.ActivityDao;
import com.bp.entity.Activity;
import com.bp.entityCondition.ActivityCondition;
import com.bp.service.ActivityService;
import com.bp.util.TimeUtil;

/**
 * 
 * @author current_bp
 * @createTime 20160830
 *
 */

public class ActivityServiceImpl implements ActivityService {

	@Autowired
	ActivityDao activityDao;
	
	// ====下面的是服务层公开的方法========================华丽分割线============================================//

	@Override
	public boolean createActivity(Activity activity) {

		return activityDao.createActivity(activity);
	}

	@Override
	public Activity getActivityById(Long id) {
		return activityDao.getActivityById(id);
	}

	@Override
	public List<Activity> getActivityList() {
		return activityDao.getActivityList();
	}

	@Override
	public List<Activity> getActivityListByCondition(ActivityCondition activityCondition) {
		List<Activity> allActivitys = getActivityList();

		List<Activity> allActivity1 = getActivityByStatus(allActivitys, activityCondition.getStatus());

		List<Activity> allActivity2 = getActivityByDate(allActivity1);

		List<Activity> allActivity3 = getActivityByTime(allActivity2);

		List<Activity> allActivity4 = getActivityByFrequency(allActivity3);

		// gc
		allActivity1 = null;
		allActivity2 = null;
		allActivity3 = null;

		return allActivity4;
	}

	// ====下面的是主方法的子方法========================华丽分割线============================================//

	/**
	 * 根据频次获取活动
	 * 
	 * @param allActivity
	 * @param frequency
	 * @return
	 */
	private List<Activity> getActivityByFrequency(List<Activity> allActivity) {
		if (null == allActivity || 0 == allActivity.size()) {
			return null;
		}
		
		List<Activity> result = new ArrayList<>();
		for (int i = 0; i < allActivity.size(); i++) {
			Activity activity = allActivity.get(i);
			if(null == activity){
				continue;
			}
			if(null == activity.getFrequency() || 0 == activity.getFrequency().length){
				result.add(activity);
			}
			else if (Arrays.asList(activity.getFrequency()).contains(TimeUtil.getWeekOfDate1().intValue())) {
				result.add(activity);
			}
		}

		return result;
	}

	/**
	 * 获取符合时间段的活动
	 * 
	 * @param allActivity
	 * @param status
	 * @return
	 */
	private List<Activity> getActivityByTime(List<Activity> allActivity) {
		if (null == allActivity || 0 == allActivity.size()) {
			return null;
		}
		
		List<Activity> result = new ArrayList<>();
		
		
		for (int i = 0; i < allActivity.size(); i++) {
			Activity activity = allActivity.get(i);
			if(null == activity){
				continue;
			}
			String [] times = activity.getTimes();
			if (isActivityTime(times)) {
				result.add(activity);
				continue;
			}
		}

		return result;
	}

	

	/**
	 * 根据开始日期和截止日期获取活动
	 * 
	 * @param allActivity1
	 * @param date
	 * @return
	 */
	private List<Activity> getActivityByDate(List<Activity> allActivity) {
		if (null == allActivity || 0 == allActivity.size()) {
			return null;
		}
		List<Activity> result = new ArrayList<>();
		for (int i = 0; i < allActivity.size(); i++) {
			Activity activity = allActivity.get(i);
			if(null == activity){
				continue;
			}
			if (isActivityDate(activity)) {
				result.add(activity);
			}
		}

		return result;
	}

	

	/**
	 * 根据状态获取活动
	 * 
	 * @param allActivity
	 * @param status
	 * @return
	 */
	private List<Activity> getActivityByStatus(List<Activity> allActivity, Integer status) {
		if (null == allActivity || 0 == allActivity.size()) {
			return null;
		}

		List<Activity> result = new ArrayList<>();
		for (int i = 0; i < allActivity.size(); i++) {
			Activity activity = allActivity.get(i);
			if(null == activity){
				continue;
			}
			if (activity.getStatus().intValue() == status.intValue()) {
				result.add(activity);
			}
		}

		return result;
	}
	
	
	
	
	
	
	
	
	// ====下面的是次方法的子方法========================华丽分割线============================================//

	
	/**
	 * 根据当前时间判断是否是在活动时间段内
	 * @param times:['070000-080000','090000-100000']
	 * @param nowTime
	 * @return
	 */
	private boolean isActivityTime(String[] times) {
		
		String nowTime = TimeUtil.currentTimeByFormat("HHmmss");
		System.out.println("nowTime:"+nowTime);
		Integer now = Integer.parseInt(nowTime);
		
		if(null == times || 0 == times.length){
			return true;
		}
		
		for(int i=0;i<times.length;i++){
			String time = times[i];
			Integer startTime = Integer.parseInt(time.split("-")[0]);
			Integer endTime = Integer.parseInt(time.split("-")[1]);
			
			if(startTime.intValue() <= now.intValue() && now <= endTime.intValue() ){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 根据活动的开始日期和截止日期判断该活动是否是符合要求的活动
	 * @param activity
	 * @return
	 */
	private boolean isActivityDate(Activity activity) {
		String today1 = TimeUtil.currentTimeByFormat("yyyyMMdd");
		
		Integer today = Integer.parseInt(today1);
		
		if(null == activity){
			return true;//无欲则刚  TAT
		}
		Integer startDate = Integer.parseInt(activity.getStartDate());
		Integer endDate = Integer.parseInt(activity.getEndDate());
		
		if(startDate.intValue() <= today && today <= endDate.intValue()){
			return true;
		}
		
		return false;
	}
}
