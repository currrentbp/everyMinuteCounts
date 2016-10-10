package com.bp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author current_bp
 * @createTime 20160831
 *
 */
public class BaseEntity implements Serializable{
	private static final long serialVersionUID = 7500081377611777223L;
	
	Long id;
	String name;
	Integer status;
	Integer isInSQL = 0;//0：表示不在数据库中，1：在数据库
	
	Date createTime;// 创建时间
	Date updateTime;// 修改时间
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIsInSQL() {
		return isInSQL;
	}
	public void setIsInSQL(Integer isInSQL) {
		this.isInSQL = isInSQL;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	
	
}
