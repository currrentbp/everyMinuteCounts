package com.bp.entity;

import java.io.Serializable;


/**
 * 
 * @author current_bp
 * @createTime 20160830
 *
 */
public class CreateActivityId implements Serializable{

	private static final long serialVersionUID = 7377743967570174579L;
	
	public static Long activityId = 1000L;
	
	public synchronized static Long getActivityId(){
		return activityId++;
	}


}
