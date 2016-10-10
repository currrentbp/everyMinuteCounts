package com.bp.service;

import com.bp.entity.Activity;
import com.bp.entity.Customer;

/**
 * 
 * @author current_bp
 * @createTime 20160901
 * @category 客户抽奖记录
 *
 */
public interface CustomerAwardRecordService {
	
	/*
	 * 1、抽奖记录
	 * 2、每天抽奖记录
	 * 3、每月抽奖记录
	 * 4、中奖记录
	 * 5、没中奖记录
	 */
	
	/**
	 * 设置该客户抽奖次数
	 * @param activity
	 * @param customer
	 * @return
	 */
	public boolean setAllRecord(Activity activity,Customer customer);
	/**
	 * 设置该客户今天抽奖次数
	 * @param activity
	 * @param customer
	 * @return
	 */
	public boolean setEveryDayRecord(Activity activity,Customer customer);
	/**
	 * 设置该客户本月抽奖次数
	 * @param activity
	 * @param customer
	 * @return
	 */
	public boolean setEveryMonthRecord(Activity activity,Customer customer);
	
	/**
	 * 设置该客户中奖总次数
	 * @param activity
	 * @param customer
	 * @return
	 */
	public boolean setAwardRecord(Activity activity,Customer customer);
	/**
	 * 设置该客户每天中奖此数据
	 * @param activity
	 * @param customer
	 * @return
	 */
	public boolean setEveryDayAwardRecord(Activity activity,Customer customer);
	/**
	 * 设置该客户每月中奖次数
	 * @param activity
	 * @param customer
	 * @return
	 */
	public boolean setEveryMonthAwardRecord(Activity activity,Customer customer);
	/**
	 * 设置该客户没中奖总记录
	 * @param activity
	 * @param customer
	 * @return
	 */
	public boolean setNoAwardRecord(Activity activity,Customer customer);
	
	/**
	 * 获取该客户的每天的抽奖记录
	 * @param activity
	 * @param customer
	 * @return
	 */
	public Integer getPersonEveryDayRecord(Activity activity,Customer customer);
	/**
	 * 获取该客户每月的抽奖记录
	 * @param activity
	 * @param customer
	 * @return
	 */
	public Integer getPersonEveryMonthRecord(Activity activity,Customer customer);
	/**
	 * 获取该客户的总抽奖记录
	 * @param activity
	 * @param customer
	 * @return
	 */
	public Integer getPersonRecord(Activity activity,Customer customer);
	
	
	/**
	 * 获取该客户的每天中奖记录
	 * @param activity
	 * @param customer
	 * @return
	 */
	public Integer getPersonEveryDayAwardRecord(Activity activity,Customer customer);
	/**
	 * 获取该客户每月的中奖记录
	 * @param activity
	 * @param customer
	 * @return
	 */
	public Integer getPersonEveryMonthAwardRecord(Activity activity,Customer customer);
	/**
	 * 获取该客户中奖记录
	 * @param activity
	 * @param customer
	 * @return
	 */
	public Integer getPersonAwardRecord(Activity activity,Customer customer);
	
	
	
	
	
	
	
	
	
	
	
	
	
}
