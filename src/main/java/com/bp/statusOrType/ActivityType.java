package com.bp.statusOrType;


/**
 * 
 * @author current_bp
 * @createTime 20160831
 *
 */
public enum ActivityType {
	// A red envelope
	ACTIVITY_RED_ENVELOPE(1, "红包"), 

	OTHER(99, "其他");

	private final int value;
	private final String name;

	private ActivityType(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public static String getName(int value) {
		for (ActivityType statusType : ActivityType.values()) {
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