package com.bp.dao;

import java.util.List;

import com.bp.entity.Rule;

/**
 * 
 * @author current_bp
 * @createTime 20160901
 *
 */
public interface RuleDao {

	/**
	 * 创建一条规则
	 * @param rule
	 * @return
	 */
	public boolean createRule(Rule rule);
	/**
	 * 根据规则ID获取规则
	 * @param id
	 * @return
	 */
	public Rule getRuleById(Long activityId,Long id);
	
	/**
	 * 获取规则列表根据活动ID
	 * @param activityId
	 * @return
	 */
	public List<Rule> getRulesByActivityId(Long activityId);
	/**
	 * 获取该活动的该奖品的现在的总名额数（即已经使用的名额数）
	 * @param activityId
	 * @param awardId
	 * @return
	 */
	public Integer getSumAwardNumNow(Long activityId, Long awardId);
	/**
	 * 在该活动的该奖品的总名额中增加一个使用名额
	 * @param activityId
	 * @param awardId
	 * @return
	 */
	public Integer addOneNumFromSumAwardNum(Long activityId, Long awardId);
	/**
	 * 在该活动的该奖品的总名额中减少一个使用名额
	 * @param activityId
	 * @param awardId
	 * @return
	 */
	public Integer deleteOneNumFromSumAwardNum(Long activityId, Long awardId);
	/**
	 * 获取该活动的该奖品的现在的每天名额数（即已经使用的名额数）
	 * @param activityId
	 * @param awardId
	 * @return
	 */
	public Integer getEverydayAwardNumNow(Long activityId, Long awardId);
	
	/**
	 * 获取该活动的该奖品的现在的该时间段名额数（即已经使用的名额数）
	 * @param activityId
	 * @param awardId
	 * @return
	 */
	public Integer getTimeAwardNumNow(Long activityId, Long awardId);
	/**
	 * 获取该客户的该活动的总中奖名额数（即已经使用的名额数）
	 * @param activityId
	 * @param awardId
	 * @return
	 */
	public Integer getCustomerAwardNumNow(Long activityId, Long awardId);
	/**
	 * 获取该客户的该活动的当天中奖名额数（即已经使用的名额数）
	 * @param activityId
	 * @param awardId
	 * @return
	 */
	public Integer getCustomerEveryDaySumAwardNumNow(Long activityId, Long awardId);
}
