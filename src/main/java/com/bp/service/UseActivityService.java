package com.bp.service;


/**
 * 
 * @author current_bp
 * @createTime 20161018
 * 
 *
 */
public interface UseActivityService {
	
	/**
	 * 参与活动，获得奖品，可能为没中奖
	 * Participate in the activity
	 * @param activityId
	 * @param customerId
	 * @return
	 */
	public Long getAward(Long activityId,Long customerId);
	
	/*
	1）每个客户参与活动，会在队列中排队，
	2）激活名额控制的线程，
	3）名额控制线程会查询名额是否能继续减少下去，
	4）如果不能，则直接将剩下的人，置为不中奖名额
	5）如果能就继续减少名额，直到没有名额或者没有人了，
	6）如果没有人了，就将线程设为等待，
	7）如果是没有名额了，继续进行4）步骤
	 */
	
	/**
	 * 参与活动
	 * @param activityId
	 * @param customerId
	 * @return
	 */
	public boolean participateActivity(Long activityId,Long customerId);
	
	

}
