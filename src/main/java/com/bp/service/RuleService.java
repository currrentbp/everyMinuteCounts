package com.bp.service;

import java.util.List;

import com.bp.entity.Rule;

/**
 * 
 * @author current_bp
 * @createTime 20160901
 *
 */
public interface RuleService {
	
	/*
	 *1、获得活动的所有规则 
	 *2、根据活动规则判断是否中奖
	 *3、如果未中奖：根据未中奖的规则获取奖品
	 *4、如果中奖：则根据中奖规则获取奖品
	 * 
	 */
	
	public boolean createRule(Rule rule);
	/**
	 * 根据规则ID获取规则
	 * @param id
	 * @return
	 */
	public Rule getRuleById(Long activityId,Long id);
	
	/**
	 * 根据活动ID获取规则列表
	 * @param activityId
	 * @return
	 */
	public List<Rule> getRulesByActivityId(Long activityId);
	/**
	 * 根据规则类型获取规则
	 * @param rules
	 * @param type
	 * @return
	 */
	public List<Rule> getRulesByType(List<Rule> rules,Integer type);
	/**
	 * 根据状态获取规则
	 * @param rules
	 * @param status
	 * @return
	 */
	public List<Rule> getRulesByStatus(List<Rule >rules,Integer status);
	
	/**
	 * 计算是否中奖
	 * @return true:中奖,false:没中奖
	 */
	public boolean isWin(Long activityId,List<Rule> rules, Long customerId);
	
	/**
	 * 计算中奖获得的奖品规则，可能获取的是没中奖的奖品规则
	 * @param rules
	 * @return
	 */
	public Rule calculationWin(Long activityId, List<Rule> rules, Long customerId);

}
