package com.bp.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.bp.entity.CreateRuleId;
import com.bp.entity.Rule;
import com.bp.service.RuleService;
import com.bp.statusOrType.RuleType;

/**
 * 
 * @author current_bp
 * @createTime 20160901
 *
 */

public class RuleTest extends BaseTest {

	private final static Logger logger = Logger.getLogger(RuleTest.class);

	@Autowired
	RuleService ruleService;

	@Test
	public void createRule() {
		Long activityId = 1001L;
		// 中奖
		Rule rule = new Rule();
		rule.setActivityId(activityId);
		rule.setCreateTime(new Date());
		rule.setId(CreateRuleId.getRuleId());
		rule.setIsInSQL(0);
		rule.setType(RuleType.RULE_WIN_EACH_AWARD_PROBABILITY.getValue());
		rule.setUpdateTime(new Date());
		rule.setRule1(1);// 设置奖品位置
		rule.setOther1("25.0");// 设置概率
		ruleService.createRule(rule);

		// 奖品规则
		Rule rule2 = new Rule();
		rule2.setActivityId(activityId);
		rule2.setCreateTime(new Date());
		rule2.setId(CreateRuleId.getRuleId());
		rule2.setIsInSQL(0);
		rule2.setType(RuleType.RULE_AWARD.getValue());
		rule2.setUpdateTime(new Date());
		rule2.setRule1(1);// 设置奖品位置
		rule2.setOther1("" + (10001L));// 设置产品的ID
		ruleService.createRule(rule2);

		// RULE_ALL_AWARD_NUM:该奖品的活动期间总名额
		Rule RULE_ALL_AWARD_NUM = new Rule();
		RULE_ALL_AWARD_NUM.setActivityId(activityId);
		RULE_ALL_AWARD_NUM.setCreateTime(new Date());
		RULE_ALL_AWARD_NUM.setId(CreateRuleId.getRuleId());
		RULE_ALL_AWARD_NUM.setIsInSQL(0);
		RULE_ALL_AWARD_NUM.setType(RuleType.RULE_ALL_AWARD_NUM.getValue());
		RULE_ALL_AWARD_NUM.setUpdateTime(new Date());
		RULE_ALL_AWARD_NUM.setRule1(5);// 设置奖品总名额
		RULE_ALL_AWARD_NUM.setOther1("" + (10001L));// 设置产品的ID
		ruleService.createRule(RULE_ALL_AWARD_NUM);

		// RULE_ONE_DAY_AWARD_NUM:该奖品的每日的总名额
		Rule RULE_ONE_DAY_AWARD_NUM = new Rule();
		RULE_ONE_DAY_AWARD_NUM.setActivityId(activityId);
		RULE_ONE_DAY_AWARD_NUM.setCreateTime(new Date());
		RULE_ONE_DAY_AWARD_NUM.setId(CreateRuleId.getRuleId());
		RULE_ONE_DAY_AWARD_NUM.setIsInSQL(0);
		RULE_ONE_DAY_AWARD_NUM.setType(RuleType.RULE_ONE_DAY_AWARD_NUM.getValue());
		RULE_ONE_DAY_AWARD_NUM.setUpdateTime(new Date());
		RULE_ONE_DAY_AWARD_NUM.setRule1(1);// 设置该奖品的每日总名额
		RULE_ONE_DAY_AWARD_NUM.setOther1("" + (10001L));// 设置产品的ID
		ruleService.createRule(RULE_ONE_DAY_AWARD_NUM);

		// RULE_ONE_TIME_AWARD_NUM:该奖品的每个时间段的名额
		Rule RULE_ONE_TIME_AWARD_NUM = new Rule();
		RULE_ONE_TIME_AWARD_NUM.setActivityId(activityId);
		RULE_ONE_TIME_AWARD_NUM.setCreateTime(new Date());
		RULE_ONE_TIME_AWARD_NUM.setId(CreateRuleId.getRuleId());
		RULE_ONE_TIME_AWARD_NUM.setIsInSQL(0);
		RULE_ONE_TIME_AWARD_NUM.setType(RuleType.RULE_ONE_TIME_AWARD_NUM.getValue());
		RULE_ONE_TIME_AWARD_NUM.setUpdateTime(new Date());
		RULE_ONE_TIME_AWARD_NUM.setRule1(1);// 设置该奖品的该时间段的总名额
		RULE_ONE_TIME_AWARD_NUM.setOther1("" + (10001L));// 设置产品的ID
		RULE_ONE_TIME_AWARD_NUM.setOther2("070000-125959");// 设置奖品在该时间段
		ruleService.createRule(RULE_ONE_TIME_AWARD_NUM);

		// RULE_ONE_PERSON_ALL_AWARD_NUM:活动期间的每个人的总名额
		Rule RULE_ONE_PERSON_ALL_AWARD_NUM = new Rule();
		RULE_ONE_PERSON_ALL_AWARD_NUM.setActivityId(activityId);
		RULE_ONE_PERSON_ALL_AWARD_NUM.setCreateTime(new Date());
		RULE_ONE_PERSON_ALL_AWARD_NUM.setId(CreateRuleId.getRuleId());
		RULE_ONE_PERSON_ALL_AWARD_NUM.setIsInSQL(0);
		RULE_ONE_PERSON_ALL_AWARD_NUM.setType(RuleType.RULE_ONE_PERSON_ALL_AWARD_NUM.getValue());
		RULE_ONE_PERSON_ALL_AWARD_NUM.setUpdateTime(new Date());
		RULE_ONE_PERSON_ALL_AWARD_NUM.setRule1(1);// 设置该奖品的每日总名额
		RULE_ONE_PERSON_ALL_AWARD_NUM.setOther1("" + (10001L));// 设置产品的ID
		ruleService.createRule(RULE_ONE_PERSON_ALL_AWARD_NUM);

		// RULE_ONE_PERSON_ONE_DAY_AWARD_NUM:活动期间每个人的每天的总名额
		Rule RULE_ONE_PERSON_ONE_DAY_AWARD_NUM = new Rule();
		RULE_ONE_PERSON_ONE_DAY_AWARD_NUM.setActivityId(activityId);
		RULE_ONE_PERSON_ONE_DAY_AWARD_NUM.setCreateTime(new Date());
		RULE_ONE_PERSON_ONE_DAY_AWARD_NUM.setId(CreateRuleId.getRuleId());
		RULE_ONE_PERSON_ONE_DAY_AWARD_NUM.setIsInSQL(0);
		RULE_ONE_PERSON_ONE_DAY_AWARD_NUM.setType(RuleType.RULE_ONE_PERSON_ONE_DAY_AWARD_NUM.getValue());
		RULE_ONE_PERSON_ONE_DAY_AWARD_NUM.setUpdateTime(new Date());
		RULE_ONE_PERSON_ONE_DAY_AWARD_NUM.setRule1(1);// 设置该奖品的每日总名额
		RULE_ONE_PERSON_ONE_DAY_AWARD_NUM.setOther1("" + (10001L));// 设置产品的ID
		ruleService.createRule(RULE_ONE_PERSON_ONE_DAY_AWARD_NUM);

		// 第二个奖品的规则
		// 中奖
		Rule rule_22 = new Rule();
		rule_22.setActivityId(activityId);
		rule_22.setCreateTime(new Date());
		rule_22.setId(CreateRuleId.getRuleId());
		rule_22.setIsInSQL(0);
		rule_22.setType(RuleType.RULE_WIN_EACH_AWARD_PROBABILITY.getValue());
		rule_22.setUpdateTime(new Date());
		rule_22.setRule1(1);// 设置奖品位置
		rule_22.setOther1("25.0");// 设置概率
		ruleService.createRule(rule_22);

		// 奖品规则
		Rule rule2_22 = new Rule();
		rule2_22.setActivityId(activityId);
		rule2_22.setCreateTime(new Date());
		rule2_22.setId(CreateRuleId.getRuleId());
		rule2_22.setIsInSQL(0);
		rule2_22.setType(RuleType.RULE_AWARD.getValue());
		rule2_22.setUpdateTime(new Date());
		rule2_22.setRule1(2);// 设置奖品位置
		rule2_22.setOther1("" + (10002L));// 设置产品的ID
		ruleService.createRule(rule2_22);

		// RULE_ALL_AWARD_NUM:该奖品的活动期间总名额
		Rule RULE_ALL_AWARD_NUM_2 = new Rule();
		RULE_ALL_AWARD_NUM_2.setActivityId(activityId);
		RULE_ALL_AWARD_NUM_2.setCreateTime(new Date());
		RULE_ALL_AWARD_NUM_2.setId(CreateRuleId.getRuleId());
		RULE_ALL_AWARD_NUM_2.setIsInSQL(0);
		RULE_ALL_AWARD_NUM_2.setType(RuleType.RULE_ALL_AWARD_NUM.getValue());
		RULE_ALL_AWARD_NUM_2.setUpdateTime(new Date());
		RULE_ALL_AWARD_NUM_2.setRule1(5);// 设置奖品总名额
		RULE_ALL_AWARD_NUM_2.setOther1("" + (10002L));// 设置产品的ID
		ruleService.createRule(RULE_ALL_AWARD_NUM_2);

		// RULE_ONE_DAY_AWARD_NUM:该奖品的每日的总名额
		Rule RULE_ONE_DAY_AWARD_NUM_2 = new Rule();
		RULE_ONE_DAY_AWARD_NUM_2.setActivityId(activityId);
		RULE_ONE_DAY_AWARD_NUM_2.setCreateTime(new Date());
		RULE_ONE_DAY_AWARD_NUM_2.setId(CreateRuleId.getRuleId());
		RULE_ONE_DAY_AWARD_NUM_2.setIsInSQL(0);
		RULE_ONE_DAY_AWARD_NUM_2.setType(RuleType.RULE_ONE_DAY_AWARD_NUM.getValue());
		RULE_ONE_DAY_AWARD_NUM_2.setUpdateTime(new Date());
		RULE_ONE_DAY_AWARD_NUM_2.setRule1(1);// 设置该奖品的每日总名额
		RULE_ONE_DAY_AWARD_NUM_2.setOther1("" + (10002L));// 设置产品的ID
		ruleService.createRule(RULE_ONE_DAY_AWARD_NUM_2);

		// RULE_ONE_TIME_AWARD_NUM:该奖品的每个时间段的名额
		Rule RULE_ONE_TIME_AWARD_NUM_2 = new Rule();
		RULE_ONE_TIME_AWARD_NUM_2.setActivityId(activityId);
		RULE_ONE_TIME_AWARD_NUM_2.setCreateTime(new Date());
		RULE_ONE_TIME_AWARD_NUM_2.setId(CreateRuleId.getRuleId());
		RULE_ONE_TIME_AWARD_NUM_2.setIsInSQL(0);
		RULE_ONE_TIME_AWARD_NUM_2.setType(RuleType.RULE_ONE_TIME_AWARD_NUM.getValue());
		RULE_ONE_TIME_AWARD_NUM_2.setUpdateTime(new Date());
		RULE_ONE_TIME_AWARD_NUM_2.setRule1(1);// 设置该奖品的该时间段的总名额
		RULE_ONE_TIME_AWARD_NUM_2.setOther1("" + (10002L));// 设置产品的ID
		RULE_ONE_TIME_AWARD_NUM_2.setOther2("070000-125959");// 设置奖品在该时间段
		ruleService.createRule(RULE_ONE_TIME_AWARD_NUM_2);

		// RULE_ONE_PERSON_ALL_AWARD_NUM:活动期间的每个人的总名额
		Rule RULE_ONE_PERSON_ALL_AWARD_NUM_2 = new Rule();
		RULE_ONE_PERSON_ALL_AWARD_NUM_2.setActivityId(activityId);
		RULE_ONE_PERSON_ALL_AWARD_NUM_2.setCreateTime(new Date());
		RULE_ONE_PERSON_ALL_AWARD_NUM_2.setId(CreateRuleId.getRuleId());
		RULE_ONE_PERSON_ALL_AWARD_NUM_2.setIsInSQL(0);
		RULE_ONE_PERSON_ALL_AWARD_NUM_2.setType(RuleType.RULE_ONE_PERSON_ALL_AWARD_NUM.getValue());
		RULE_ONE_PERSON_ALL_AWARD_NUM_2.setUpdateTime(new Date());
		RULE_ONE_PERSON_ALL_AWARD_NUM_2.setRule1(1);// 设置该奖品的每日总名额
		RULE_ONE_PERSON_ALL_AWARD_NUM_2.setOther1("" + (10002L));// 设置产品的ID
		ruleService.createRule(RULE_ONE_PERSON_ALL_AWARD_NUM_2);

		// RULE_ONE_PERSON_ONE_DAY_AWARD_NUM:活动期间每个人的每天的总名额
		Rule RULE_ONE_PERSON_ONE_DAY_AWARD_NUM_2 = new Rule();
		RULE_ONE_PERSON_ONE_DAY_AWARD_NUM_2.setActivityId(activityId);
		RULE_ONE_PERSON_ONE_DAY_AWARD_NUM_2.setCreateTime(new Date());
		RULE_ONE_PERSON_ONE_DAY_AWARD_NUM_2.setId(CreateRuleId.getRuleId());
		RULE_ONE_PERSON_ONE_DAY_AWARD_NUM_2.setIsInSQL(0);
		RULE_ONE_PERSON_ONE_DAY_AWARD_NUM_2.setType(RuleType.RULE_ONE_PERSON_ONE_DAY_AWARD_NUM.getValue());
		RULE_ONE_PERSON_ONE_DAY_AWARD_NUM_2.setUpdateTime(new Date());
		RULE_ONE_PERSON_ONE_DAY_AWARD_NUM_2.setRule1(1);// 设置该奖品的每日总名额
		RULE_ONE_PERSON_ONE_DAY_AWARD_NUM_2.setOther1("" + (10002L));// 设置产品的ID
		ruleService.createRule(RULE_ONE_PERSON_ONE_DAY_AWARD_NUM_2);

		// 不中奖的奖品
		Rule rule2_1 = new Rule();
		rule2_1.setActivityId(activityId);
		rule2_1.setCreateTime(new Date());
		rule2_1.setId(CreateRuleId.getRuleId());
		rule2_1.setIsInSQL(0);
		rule2_1.setType(RuleType.RULE_AWARD.getValue());
		rule2_1.setUpdateTime(new Date());
		rule2_1.setRule1(0);// 设置奖品位置
		rule2_1.setOther1("谢谢参与！");// 设置产品的ID
		ruleService.createRule(rule2_1);

		// 不中奖
		Rule rule3 = new Rule();
		rule3.setActivityId(activityId);
		rule3.setCreateTime(new Date());
		rule3.setId(CreateRuleId.getRuleId());
		rule3.setIsInSQL(0);
		rule3.setType(RuleType.RULE_NOWIN_PROBABILITY.getValue());
		rule3.setUpdateTime(new Date());
		rule3.setOther1("50.0");// 设置概率
		ruleService.createRule(rule3);

	}

	@Test
	public void getRuleById() {

		System.out.println(JSON.toJSON(ruleService.getRuleById(1001L, 1001L)));
	}

	@Test
	public void getRulesByActivityId() {
		System.out.println(JSON.toJSON(ruleService.getRulesByActivityId(1001L)));
	}

	@Test
	public void isWin() {
	}

}
