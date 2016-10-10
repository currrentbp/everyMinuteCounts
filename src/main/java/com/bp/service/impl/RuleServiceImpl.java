package com.bp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.bp.dao.RuleDao;
import com.bp.entity.Rule;
import com.bp.entity.StaticProperty;
import com.bp.service.RuleService;
import com.bp.statusOrType.RuleType;
import com.bp.util.RandomUtil;

public class RuleServiceImpl implements RuleService {

	@Autowired
	RuleDao ruleDao;

	// ====下面的是服务层公开的方法========================华丽分割线============================================//
	@Override
	public Rule getRuleById(Long activityId, Long id) {

		return ruleDao.getRuleById(activityId, id);
	}

	@Override
	public List<Rule> getRulesByActivityId(Long activityId) {
		return ruleDao.getRulesByActivityId(activityId);
	}

	@Override
	public List<Rule> getRulesByType(List<Rule> rules, Integer type) {
		if (null == rules || 0 == rules.size() || null == type) {
			return rules;
		}

		List<Rule> result = new ArrayList<Rule>();

		Rule rule = null;
		for (int i = 0; i < rules.size(); i++) {
			rule = rules.get(i);
			if (rule.getType().intValue() == type.intValue()) {
				result.add(rule);
			}
		}

		return result;
	}

	@Override
	public List<Rule> getRulesByStatus(List<Rule> rules, Integer status) {
		if (null == rules || 0 == rules.size() || null == status) {
			return rules;
		}

		List<Rule> result = new ArrayList<Rule>();

		Rule rule = null;
		for (int i = 0; i < rules.size(); i++) {
			rule = rules.get(i);
			if (rule.getStatus().intValue() == status.intValue()) {
				result.add(rule);
			}
		}

		return result;
	}

	@Override
	public boolean isWin(Long activityId, List<Rule> rules, Long customerId) {
		List<Rule> nowinRules = getRulesByType(rules, RuleType.RULE_NOWIN_PROBABILITY.getValue());
		if (null == nowinRules || 0 == nowinRules.size()) {// 如果不存在不中奖，表示一定中奖了
			return true;
		}

		Rule noWinRule = nowinRules.get(0);// 获取没有中奖的概率//这个规则应该只有一个
		String probability = null == noWinRule ? "" : noWinRule.getOther1();
		if (null == probability || "".equals(probability.trim())) {
			return true;
		}

		int noWinprob1 = (int) (Float.parseFloat(probability) * StaticProperty.maxInt / 100);// 因为概率是100%
		int r1 = RandomUtil.getLargeRandomNum(StaticProperty.maxInt);
		System.out.println("===>isWin: nowinprob:"+noWinprob1+" random1:"+r1);
		
		if (r1 <= noWinprob1) {// 不中奖
			return false;
		}

		return true;
	}

	@Override
	public Rule calculationWin(Long activityId, List<Rule> rules, Long customerId) {
		if (null == rules || 0 == rules.size()) {// 一般不会的。。。。。
			return null;
		}
		// 获取唯一一个不中奖的奖品//不可能没有
		List<Rule> noWinRules = getRulesByType(rules, RuleType.RULE_AWARD.getValue());
		Rule noWinRule = noWinRules.get(0);

		// 1、先抽奖，定位中的是什么奖
		// 2、根据能否中奖，获取奖品的规则
		// 3、修改奖品名额
		
		Rule awardRule = getAward(activityId, rules, customerId);// 可能为空

		boolean flag = (null != awardRule) && couldWin(activityId, rules, customerId, awardRule);

		// 表示能中奖
		if (flag) {
			// TODO 需要修改相关数据
			boolean changeOk = changeAwardNum(activityId, rules, customerId, awardRule);
			return changeOk ? awardRule : noWinRule;
		} else {// 不能中奖
			return noWinRule;
		}
	}

	@Override
	public boolean createRule(Rule rule) {
		return ruleDao.createRule(rule);
	}

	// =====下面是服务层的子方法=====================华丽分割线================================//
	/**
	 * 抽奖：抽的是中的奖品
	 * 
	 * @param activityId
	 * @param rules
	 * @param customerId
	 * @return
	 */
	public Rule getAward(Long activityId, List<Rule> rules, Long customerId) {
		if (null == rules || 0 == rules.size()) {
			return null;
		}

		// 1、获取抽奖规则
		// 2、根据抽奖规则获取中奖的内容
		// 3、获取中奖内容

		List<Rule> proRules = getRulesByType(rules, RuleType.RULE_WIN_EACH_AWARD_PROBABILITY.getValue());
		List<Rule> awardRules = getRulesByType(rules, RuleType.RULE_AWARD.getValue());

		List<Rule> proRulesByOrder = rulesOrderByRule1(proRules);
		System.out.println("proRuleByOrder:" + JSON.toJSONString(proRulesByOrder));

		Long randomNum = (long) (Math.random() * StaticProperty.maxInt);
		Rule sumPro = getRandomRule(proRulesByOrder, randomNum);// 获取中奖概率的rule

		Rule awardRule = getAwardRuleByWinPro(awardRules, sumPro);

		return awardRule;
	}

	/**
	 * 判断是否能中奖,如果没有相应的规则，则默认认为可以中奖
	 * 
	 * @param activityId
	 * @param rules：所有的规则
	 * @param customerId
	 * @param awardRule
	 *            : other1是奖品ID
	 * @return
	 */
	public boolean couldWin(Long activityId, List<Rule> rules, Long customerId, Rule awardRule) {
		if (null == rules || 0 == rules.size()) {
			return false;
		}

		// 1、根据规则判断是否能中奖：活动的总名额限制
		// 2、根据规则判断是否能中奖：活动单日的名额
		// 3、根据规则判断是否能中奖：活动时间段的名额
		// 4、根据规则判断是否能中奖：活动期间该客户的名额限制
		// 5、根据规则判断是否能中奖：活动期间该客户的单日中奖名额

		//TODO not complete
		boolean flag1 = checkSumAwardNum(rules, activityId, customerId, awardRule);
		boolean flag2 = flag1 && checkEverydayAwardNum(rules, activityId, customerId, awardRule);
		boolean flag3 = flag2 && checkTimeSumAwardNum(rules, activityId, customerId, awardRule);
		boolean flag4 = flag3 && checkCustomerAwardNum(rules, activityId, customerId, awardRule);
		boolean flag5 = flag4 && checkCustomerEveryDaySumAwardNum(rules, activityId, customerId, awardRule);

		return flag5;
	}

	/**
	 * 修改名额
	 * 
	 * @param activityId
	 * @param rules
	 * @param customerId
	 * @param awardRule
	 * @return
	 */
	private boolean changeAwardNum(Long activityId, List<Rule> rules, Long customerId, Rule awardRule) {
		return false;
	}

	/**
	 * 根据rule1字段排序
	 * 
	 * @param proRules
	 * @return
	 */
	private List<Rule> rulesOrderByRule1(List<Rule> rules) {
		if (null == rules || 0 == rules.size()) {
			return null;
		}

		return bubblSort(rules);
	}

	private Rule getRandomRule(List<Rule> proRulesByOrder, Long randomNum) {
		if (null == proRulesByOrder || 0 == proRulesByOrder.size()) {
			return null;
		}

		float sum = 0.0f;
		Rule rule = null;
		for (int i = 0; i < proRulesByOrder.size(); i++) {
			sum = sum + Float.parseFloat(proRulesByOrder.get(i).getOther1()) * StaticProperty.maxInt;
			if (sum <= randomNum) {
				rule = proRulesByOrder.get(i);
			} else {
				break;
			}
		}
		return rule;
	}

	// ====================华丽分割线================================//

	/**
	 * 根据中奖的概率规则获取奖品规则:有可能为空
	 * 
	 * @param rules
	 * @param sumPro
	 * @return
	 */
	private Rule getAwardRuleByWinPro(List<Rule> rules, Rule sumPro) {
		if (null == rules || 0 == rules.size() || null == sumPro) {
			return null;
		}

		Integer index = sumPro.getRule1();
		Rule rule = null;
		for (int i = 0; i < rules.size(); i++) {
			if (rules.get(i).getRule1().intValue() == index.intValue()) {
				rule = rules.get(i);
			}
		}

		return rule;
	}

	/**
	 * 
	 * @param rules
	 * @param activityId
	 * @param customerId
	 * @param awardRule
	 * @return
	 */
	private boolean checkCustomerEveryDaySumAwardNum(List<Rule> rules, Long activityId, Long customerId,
			Rule awardRule) {
		// TODO not work
		return false;
	}

	/**
	 * 
	 * @param rules
	 * @param activityId
	 * @param customerId
	 * @param awardRule
	 * @return
	 */
	private boolean checkCustomerAwardNum(List<Rule> rules, Long activityId, Long customerId, Rule awardRule) {
		// TODO not work
		return false;
	}

	/**
	 * 检查每个时间段的奖品总名额
	 * @param rules
	 * @param activityId
	 * @param customerId
	 * @param awardRule
	 * @return
	 */
	private boolean checkTimeSumAwardNum(List<Rule> rules, Long activityId, Long customerId, Rule awardRule) {
		if (null == awardRule) {
			return false;
		}

		Long awardId = Long.parseLong(awardRule.getOther1());
		Integer timeAwardNum = getTimeSumAwardRuleByAwardId(rules, awardId);

		Integer timeAwardNumNow = ruleDao.getTimeAwardNumNow(activityId, awardId);

		if (timeAwardNum <= timeAwardNumNow) {// 名额已满
			return false;
		}

		return true;
	}

	

	/**
	 * 检查每天的总名额,只检查名额，不参与修改名额
	 * 
	 * @param rules
	 * @param activityId
	 * @param customerId
	 * @param awardRule
	 * @return
	 */
	private boolean checkEverydayAwardNum(List<Rule> rules, Long activityId, Long customerId, Rule awardRule) {
		if (null == awardRule) {
			return false;
		}

		Long awardId = Long.parseLong(awardRule.getOther1());
		Integer everydayAwardNum = getEverydayAwardNumRuleByAwardId(rules, awardId);

		Integer everydayAwardNumNow = ruleDao.getEverydayAwardNumNow(activityId, awardId);

		if (everydayAwardNum <= everydayAwardNumNow) {// 名额已满
			return false;
		}

		return false;
	}

	/**
	 * 检查该奖品的总名额,只检查名额，不参与修改名额
	 * 
	 * @param rules
	 * @param activityId
	 * @param customerId
	 * @param awardRule
	 * @return
	 */
	private boolean checkSumAwardNum(List<Rule> rules, Long activityId, Long customerId, Rule awardRule) {
		if (null == awardRule) {
			return false;
		}

		Long awardId = Long.parseLong(awardRule.getOther1());
		Integer sumAwardNum = getSumAwardNumRuleByAwardId(rules, awardId);

		Integer sumAwardNumNow = ruleDao.getSumAwardNumNow(activityId, awardId);

		if (sumAwardNum <= sumAwardNumNow) {// 名额已满
			return false;
		}

		return true;
	}

	/**
	 * 冒泡(bubble sorting),默认：升序排序
	 * 
	 * @param resource
	 * @return
	 */
	public List<Rule> bubblSort(List<Rule> resource) {
		return bubblSort(resource, true);
	}

	/**
	 * 冒泡(bubble sorting)
	 * 
	 * @param resource
	 * @param isAsc:
	 *            是否升序
	 * @return
	 */
	public List<Rule> bubblSort(List<Rule> resource, boolean isAsc) {
		List<Rule> result = new ArrayList<Rule>();

		if (null == resource || 0 == resource.size()) {
			return resource;
		} else {
			result = resource;
		}

		for (int i = 0; i < result.size(); i++) {

			for (int j = i; j < result.size(); j++) {
				if (swapCondition(isAsc, result, i, j)) {
					swap(result, i, j);
				}
			}
		}

		return result;
	}

	/**
	 * 排序时，升序：第一个小于第二个数，就不需要换位置，否则换位置， 降序：第一个大于第二个时，不需要换位置，否则换位置
	 * 
	 * @param isAsc：是否是升序
	 * @param resource：原数据源
	 * @param location1：位置一
	 * @param location2：位置二
	 * @return
	 */
	public boolean swapCondition(boolean isAsc, List<Rule> resource, int location1, int location2) {
		if (isAsc) {// 升序
			if (resource.get(location1).getRule1() < resource.get(location2).getRule1()) {
				return false;
			} else {
				return true;
			}
		} else {// 降序
			if (resource.get(location1).getRule1() > resource.get(location2).getRule1()) {
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 * 互换两个位置的数据
	 * 
	 * @param resource：数据源
	 * @param location1：位置一
	 * @param location2：位置二
	 */
	public void swap(List<Rule> resource, int location1, int location2) {
		Rule temp = resource.get(location1);
		resource.set(location1, resource.get(location2));
		resource.set(location2, temp);
	}

	// =====================华丽分割线==================================================//

	/**
	 * 根据奖品ID获取总奖品名额规则中的总名额数
	 * 
	 * @param rules
	 * @param awardId
	 * @return:-1:表示没有规则
	 */
	private Integer getSumAwardNumRuleByAwardId(List<Rule> rules, Long awardId) {
		List<Rule> rules1 = getRulesByType(rules, RuleType.RULE_ALL_AWARD_NUM.getValue());

		if (null == rules1 || 0 == rules1.size()) {
			return -1;
		}
		Integer result = -1;

		for (int i = 0; i < rules1.size(); i++) {
			if (rules1.get(i).getOther1().equals("" + awardId)) {
				result = rules1.get(i).getRule1();
			}
		}

		return result;
	}

	/**
	 * 根据奖品ID获取的每天奖品规则的每天名额
	 * 
	 * @param rules
	 * @param awardId
	 * @return
	 */
	private Integer getEverydayAwardNumRuleByAwardId(List<Rule> rules, Long awardId) {
		List<Rule> rules1 = getRulesByType(rules, RuleType.RULE_ONE_DAY_AWARD_NUM.getValue());

		if (null == rules1 || 0 == rules1.size()) {
			return -1;
		}
		Integer result = -1;

		for (int i = 0; i < rules1.size(); i++) {
			if (rules1.get(i).getOther1().equals("" + awardId)) {
				result = rules1.get(i).getRule1();
			}
		}

		return result;
	}
	
	private Integer getTimeSumAwardRuleByAwardId(List<Rule> rules, Long awardId) {
		List<Rule> rules1 = getRulesByType(rules, RuleType.RULE_ONE_TIME_AWARD_NUM.getValue());

		if (null == rules1 || 0 == rules1.size()) {
			return -1;
		}
		Integer result = -1;

		for (int i = 0; i < rules1.size(); i++) {
			if (rules1.get(i).getOther1().equals("" + awardId)) {
				result = rules1.get(i).getRule1();
			}
		}

		return result;
	}
}
