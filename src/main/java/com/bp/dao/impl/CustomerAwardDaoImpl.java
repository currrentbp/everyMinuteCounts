package com.bp.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bp.dao.CustomerAwardDao;

import redis.clients.jedis.Jedis;

/**
 * 
 * @author current_bp
 * @createTime 20161031
 *
 */
public class CustomerAwardDaoImpl implements CustomerAwardDao{

	private final static Logger logger = Logger.getLogger(CustomerAwardDaoImpl.class);
	@Autowired
	Jedis jedis;
	
	//======服务层接口代码=========================================================//
	@Override
	public boolean addWinRecord(Long activityId, Long customerId, Long awardId) {
		//not work 先做
		jedis.lset("winRecord_"+activityId+"_"+customerId+"_"+awardId,0 ,"");
		return false;
	}

	@Override
	public boolean addNotWinRecord(Long activityId, Long customerId, Long awardId) {
		// TODO not work
		return false;
	}

	@Override
	public Integer getWinRecordCount(Long activityId, Long customerId) {
		// TODO not work
		return null;
	}

	@Override
	public Integer getAllRecordCount(Long activityId, Long customerId) {
		// TODO not work
		return null;
	}

	
	
	//======第一层代码=========================================================//
}
