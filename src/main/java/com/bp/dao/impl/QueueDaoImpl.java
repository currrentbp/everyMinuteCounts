package com.bp.dao.impl;

import org.apache.log4j.Logger;

import com.bp.dao.QueueDao;
import com.bp.util.RedisUtil;
import com.bp.util.SerializeUtil;

import redis.clients.jedis.Jedis;

public class QueueDaoImpl implements QueueDao {

	Jedis jedis = RedisUtil.getJedis();

	private final static Logger logger = Logger.getLogger(QueueDaoImpl.class);

	@Override
	public boolean addPerson(Long activityId, Long customer) {
		return jedis.rpush("queue_" + activityId, "" + customer) > 0;
	}

	@Override
	public String removePerson(Long activityId) {
		Long length = jedis.llen(("queue_" + activityId).getBytes());

		if (length == 0) {
			return null;
		}
		
		return jedis.lpop("queue_"+activityId);
	}

	@Override
	public Long getPerson(Long activityId) {
		Long length = jedis.llen(("queue_" + activityId).getBytes());

		if (length == 0) {
			return null;
		}

		String customerId = jedis.lindex("queue_" + activityId, length-1);

		return Long.parseLong(customerId);
	}

}
