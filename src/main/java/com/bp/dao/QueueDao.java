package com.bp.dao;

/**
 * 
 * @author current_bp
 * @createTime 20161011
 *
 */
public interface QueueDao {
	/*
	 * 所有操作都是从队列头或者尾部开始
	 */

	/**
	 * 在一个活动队列中增加一个人
	 * 
	 * @param activityId
	 * @param customer
	 * @return
	 */
	public boolean addPerson(Long activityId, Long customer);

	/**
	 * 移除一个人
	 * 
	 * @param activityId
	 * @return
	 */
	public String removePerson(Long activityId);

	/**
	 * 从队列头部 获取一个人，可能队列中没有人
	 * 
	 * @param activityId
	 * @return
	 */
	public Long getPerson(Long activityId);
}
