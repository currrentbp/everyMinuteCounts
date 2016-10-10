package com.bp.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * @author current_bp
 * @createTime 20160831
 *
 */
public class RedEnvelope extends BaseEntity implements Serializable {


	private static final long serialVersionUID = -7266908203309894880L;
	Long activityId;//活动ID
	Integer type;// 红包类型：
	
	Integer redCount;//红包总的数量
	Integer redMoneyNum;//红包总金额
	
	
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public Integer getRedCount() {
		return redCount;
	}
	public void setRedCount(Integer redCount) {
		this.redCount = redCount;
	}
	public Integer getRedMoneyNum() {
		return redMoneyNum;
	}
	public void setRedMoneyNum(Integer redMoneyNum) {
		this.redMoneyNum = redMoneyNum;
	}
	
	

	
	
	
}
