package com.bp.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.bp.dao.ActivityDao;
import com.bp.entity.Activity;
import com.bp.util.RedisUtil;
import com.bp.util.SerializeUtil;

import redis.clients.jedis.Jedis;

public class ActivityDaoImpl implements ActivityDao {

	Jedis jedis = RedisUtil.getJedis();
	
	private final static Logger logger = Logger.getLogger(ActivityDaoImpl.class);
	
	
	@Override
	public boolean createActivity(Activity activity) {
		
		String s1 = jedis.set(("activity_"+activity.getId()).getBytes(), SerializeUtil.serialize(activity));
		return null != s1 && "OK".equalsIgnoreCase(s1);
	}


	@Override
	public Activity getActivityById(Long id) {
		byte[] activity = jedis.get(("activity_"+id).getBytes());

		return (Activity) SerializeUtil.unserialize(activity);
	}


	@Override
	public List<Activity> getActivityList() {
		//TODO 也许此处有更优的解决方法，此时我还不知道。。。。20160831
		//TODO 最起码可以用管道
		List<String> activityIds = getActivityKeysList();
		logger.info("===>getActivityList: ids:"+JSON.toJSON(activityIds));
		if(null == activityIds || 0 == activityIds.size()){
			return null;
		}
		
		List<Activity> activitys = new ArrayList<>();
		for(int i=0;i<activityIds.size();i++){
			Activity activity = (Activity)SerializeUtil.unserialize(jedis.get(activityIds.get(i).getBytes()));
			logger.info("===>getActivityList: activity:"+JSON.toJSON(activity));
			
			activitys.add(activity);
		}
		
		return activitys;
	}


	@Override
	public List<String> getActivityKeysList() {
		Set<String> ids = jedis.keys("activity_*");
		
		if(null == ids || ids.isEmpty()){
			return null;
		}
		
		Iterator<String> ids1 = ids.iterator();
		List<String> result = new ArrayList<String >();
		
		while(ids1.hasNext()){
			result.add(ids1.next());
		}
		
//		System.out.println(result);
		
		return result;
	}

}
