package com.bp.entityCondition;


/**
 * 
 * @author current_bp
 * @createTime 20160831
 *
 */
public class ActivityCondition extends BaseCondition{

	private static final long serialVersionUID = 13237982086356548L;
	
	Integer[] frequency;//频次：周几
	
	Integer status;//状态
	
	String date;//符合活动的日期
	
	String[] timePeriod;//时间段

	public Integer[] getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer[] frequency) {
		this.frequency = frequency;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String[] getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(String[] timePeriod) {
		this.timePeriod = timePeriod;
	}

	
	

	
	

}
