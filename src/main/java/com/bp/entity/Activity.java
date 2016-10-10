package com.bp.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * @author current_bp
 * @createTime 20160830
 *
 */
public class Activity extends BaseEntity implements Serializable {


	private static final long serialVersionUID = -7266908203309894880L;
	Integer type;// 活动类型：1：红包，2：。。。。。
	String [] times;//时间段如：0700-0859
	String startDate;//开始日期，如：20160101
	String endDate;//结束日期，如：20170101
	Integer[] frequency;//频次：周几开始活动:1,2,3,4,5,6,7
	
	
	
	
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String[] getTimes() {
		return times;
	}
	public void setTimes(String[] times) {
		this.times = times;
	}
	public Integer[] getFrequency() {
		return frequency;
	}
	public void setFrequency(Integer[] frequency) {
		this.frequency = frequency;
	}
	
	

	
	
	
}
