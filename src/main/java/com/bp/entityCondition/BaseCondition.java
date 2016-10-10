package com.bp.entityCondition;

import java.io.Serializable;


/**
 * 
 * @author current_bp
 * @createTime 20160831
 *
 */
public class BaseCondition implements Serializable {

	private static final long serialVersionUID = 5506549329191513309L;

	private final Integer DEFAULT_PAGE_SIZE = 100;

	private Integer pageIndex;
	private Integer pageSize;
	private String orderBy;
	private String sort = "desc";

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getStartRow() {
		int size = 0;
		if (pageIndex == null || pageIndex < 1) {
			pageIndex = 1;
		}
		if (pageSize == null) {
			size = DEFAULT_PAGE_SIZE;
		} else {
			size = pageSize;
		}
		return (pageIndex - 1) * size;
	}
}
