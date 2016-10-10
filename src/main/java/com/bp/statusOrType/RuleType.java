package com.bp.statusOrType;


/**
 * 
 * @author current_bp
 * @createTime 20160831
 *
 */
public enum RuleType {
	// 规则类型
//	RULE_WIN_PROBABILITY(10001, "中奖概率"), 
	RULE_NOWIN_PROBABILITY(10002, "不中奖概率"),
	RULE_WIN_EACH_AWARD_PROBABILITY(10003,"每种奖品的中奖概率"),
	
	
	RULE_ALL_AWARD_NUM(20001, "活动总名额"),
	RULE_ONE_DAY_AWARD_NUM(20002,"每个活动日的名额"),
	RULE_ONE_TIME_AWARD_NUM(20003,"每个时间段的名额"),
	RULE_ONE_PERSON_ALL_AWARD_NUM(20004,"每个人活动期间总中奖名额"),
	RULE_ONE_PERSON_ONE_DAY_AWARD_NUM(20005,"每个人每天中奖名额"),
	
	RULE_AWARD(30001,"奖品类型"),
	

	OTHER(99, "其他");

	private final int value;
	private final String name;

	private RuleType(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public static String getName(int value) {
		for (RuleType statusType : RuleType.values()) {
			if (statusType.value == value) {
				return statusType.name;
			}
		}

		return null;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
}