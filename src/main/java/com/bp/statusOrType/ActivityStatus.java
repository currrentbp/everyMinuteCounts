package com.bp.statusOrType;


/**
 * 
 * @author current_bp
 * @createTime 20160831
 *
 */
public enum ActivityStatus {
	// 文件状态，0:
	ACTIVITY_NO_START(0, "活动尚未开始"), 
	ACTIVITY_IS_START(1, "活动开始"), 
	ACTIVITY_IS_OVER(2, "活动结束"), 

	OTHER(99, "其他");

	private final int value;
	private final String name;

	private ActivityStatus(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public static String getName(int value) {
		for (ActivityStatus statusType : ActivityStatus.values()) {
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