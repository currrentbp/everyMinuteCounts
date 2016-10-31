package com.bp.dao;

/**
 * 
 * @author current_bp
 * @createTime 20161031
 *
 */
public interface CustomerAwardDao {
	
	/**
	 * 增加一条该客户的中奖记录
	 * @param activityId
	 * @param customerId
	 * @param awardId
	 * @return
	 */
	public boolean addWinRecord(Long activityId,Long customerId,Long awardId);
	/**
	 * 增加一条没有中奖记录
	 * @param activityId
	 * @param customerId
	 * @param awardId
	 * @return
	 */
	public boolean addNotWinRecord(Long activityId,Long customerId,Long awardId);
	/**
	 * 获取该客户中奖次数
	 * @param activityId
	 * @param customerId
	 * @return
	 */
	public Integer getWinRecordCount(Long activityId,Long customerId);
	/**
	 * 获取该客户的总抽奖次数
	 * @param activityId
	 * @param customerId
	 * @return
	 */
	public Integer getAllRecordCount(Long activityId,Long customerId);

}
