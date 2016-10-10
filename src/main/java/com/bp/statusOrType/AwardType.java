package com.bp.statusOrType;


/**
 * 
 * @author current_bp
 * @createTime 20160901
 *
 */
public enum AwardType {
	// 奖品类型
	AWARD_REDENVELOPE(1, "红包"), 

	OTHER(99, "其他");

	private final int value;
	private final String name;

	private AwardType(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public static String getName(int value) {
		for (AwardType statusType : AwardType.values()) {
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