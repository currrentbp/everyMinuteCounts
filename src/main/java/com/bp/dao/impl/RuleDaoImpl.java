package com.bp.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.bp.dao.RuleDao;
import com.bp.entity.Activity;
import com.bp.entity.Rule;
import com.bp.statusOrType.RuleType;
import com.bp.util.RedisUtil;
import com.bp.util.SerializeUtil;

import redis.clients.jedis.Jedis;

public class RuleDaoImpl implements RuleDao {

	Jedis jedis = RedisUtil.getJedis();

	private final static Logger logger = Logger.getLogger(ActivityDaoImpl.class);

	
	
	
	//======用于服务层的方法=======================华丽分割线======================================//
	@Override
	public boolean createRule(Rule rule) {
		String s1 = null;
		if (rule.getType() == RuleType.RULE_AWARD.getValue()) {
			s1 = jedis.set(("rule_" + rule.getActivityId() + "_" + rule.getId() + "_" + rule.getOther1()).getBytes(),
					SerializeUtil.serialize(rule));
		} else {
			s1 = jedis.set(("rule_" + rule.getActivityId() + "_" + rule.getId()).getBytes(),
					SerializeUtil.serialize(rule));
		}
		return null != s1 && "OK".equalsIgnoreCase(s1);
	}

	@Override
	public Rule getRuleById(Long activityId, Long id) {
		byte[] rule = jedis.get(("rule_" + activityId + "_" + id).getBytes());

		return (Rule) SerializeUtil.unserialize(rule);
	}

	@Override
	public List<Rule> getRulesByActivityId(Long activityId) {
		List<String> ruleKeys = getRuleKeysByActivityId(activityId);

		if (null == ruleKeys || 0 == ruleKeys.size()) {
			return new ArrayList<Rule>();
		}

		List<Rule> result = new ArrayList<Rule>();
		Rule rule = null;
		for (int i = 0; i < ruleKeys.size(); i++) {
			rule = (Rule) SerializeUtil.unserialize(jedis.get(ruleKeys.get(i).getBytes()));
			result.add(rule);
		}

		return result;
	}

	/**
	 * 根据活动ID获得所有对用的规则ID
	 * 
	 * @param activityId
	 * @return
	 */
	private List<String> getRuleKeysByActivityId(Long activityId) {
		Set<String> ids = jedis.keys("rule_" + activityId + "_*");

		if (null == ids || ids.isEmpty()) {
			return null;
		}

		Iterator<String> ids1 = ids.iterator();
		List<String> result = new ArrayList<String>();

		while (ids1.hasNext()) {
			result.add(ids1.next());
		}

		return result;
	}

	@Override
	public Integer getSumAwardNumNow(Long activityId, Long awardId) {
		
		byte[] sumAwardNumNow = jedis.get(("ruleAward_sumAwardNumNow_" + activityId + "_" + awardId+"").getBytes());

		return (Integer) SerializeUtil.unserialize(sumAwardNumNow);
	}

	@Override
	public Integer addOneNumFromSumAwardNum(Long activityId, Long awardId) {
		Long sumAwardNumNow = jedis.incr("ruleAward_sumAwardNumNow_" + activityId + "_" + awardId+"");

		return Integer.parseInt(""+sumAwardNumNow);
	}

	@Override
	public Integer deleteOneNumFromSumAwardNum(Long activityId, Long awardId) {
		Long sumAwardNumNow = jedis.decr("ruleAward_sumAwardNumNow_" + activityId + "_" + awardId+"");

		return Integer.parseInt(""+sumAwardNumNow);
		
	}

	@Override
	public Integer getEverydayAwardNumNow(Long activityId, Long awardId) {
		byte[] everydayAwardNumNow = jedis.get(("ruleAward_everydayAwardNumNow_" + activityId + "_" + awardId+"").getBytes());

		return (Integer) SerializeUtil.unserialize(everydayAwardNumNow);
	}
	
	//========第一层方法=============================华丽分割线=====================================//

}
