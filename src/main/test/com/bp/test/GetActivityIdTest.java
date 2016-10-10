package com.bp.test;

import org.junit.Test;

import com.bp.entity.CreateActivityId;

public class GetActivityIdTest {

	@Test
	public void getActivityId() {
		CreateActivityId ca = new CreateActivityId();
		for (int i = 0; i < 10; i++)
			System.out.println("id:" + ca.getActivityId());
	}
}
