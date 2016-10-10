package com.bp.entity;

import java.io.Serializable;

/**
 * 
 * @author current_bp
 * @createTime 20160901
 *
 */
public class Rule extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -7717888468260919986L;
	
	
	private Long activityId;//活动ID
	private Integer type;//规则类型
	private Integer rule1;
	private Integer rule2;
	private Integer rule3;
	private Integer rule4;
	
	private Integer result1;
	private Integer result2;
	private Integer result3;
	private Integer result5;
	
	private String other1;
	private String other2;
	private String other3;
	
	
	
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getRule1() {
		return rule1;
	}
	public void setRule1(Integer rule1) {
		this.rule1 = rule1;
	}
	public Integer getRule2() {
		return rule2;
	}
	public void setRule2(Integer rule2) {
		this.rule2 = rule2;
	}
	public Integer getRule3() {
		return rule3;
	}
	public void setRule3(Integer rule3) {
		this.rule3 = rule3;
	}
	public Integer getRule4() {
		return rule4;
	}
	public void setRule4(Integer rule4) {
		this.rule4 = rule4;
	}
	public Integer getResult1() {
		return result1;
	}
	public void setResult1(Integer result1) {
		this.result1 = result1;
	}
	public Integer getResult2() {
		return result2;
	}
	public void setResult2(Integer result2) {
		this.result2 = result2;
	}
	public Integer getResult3() {
		return result3;
	}
	public void setResult3(Integer result3) {
		this.result3 = result3;
	}
	public Integer getResult5() {
		return result5;
	}
	public void setResult5(Integer result5) {
		this.result5 = result5;
	}
	public String getOther1() {
		return other1;
	}
	public void setOther1(String other1) {
		this.other1 = other1;
	}
	public String getOther2() {
		return other2;
	}
	public void setOther2(String other2) {
		this.other2 = other2;
	}
	public String getOther3() {
		return other3;
	}
	public void setOther3(String other3) {
		this.other3 = other3;
	}
	
	
	
}
