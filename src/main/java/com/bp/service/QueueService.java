package com.bp.service;

/**
 * 
 * @author current_bp
 * @createTime 20161011
 *
 */
public interface QueueService {
	/*
	 * 所有操作都是从队列头或者尾部开始
	 */
	
	/**
	 * 在一个活动队列中增加一个人
	 * @param activityId
	 * @param customer
	 * @return
	 */
	public boolean addPerson(Long activityId,Long customer);
	
	/**
	 * 从队列头部移除一个人
	 * @param activityId
	 * @return
	 */
	public boolean removePerson(Long activityId);
	
	/**
	 * 从队列头部 获取一个人
	 * @param activityId
	 * @return
	 */
	public Long getPerson(Long activityId);

}
