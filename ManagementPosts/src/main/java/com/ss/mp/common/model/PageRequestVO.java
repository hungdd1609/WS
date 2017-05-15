package com.ss.mp.common.model;

import com.ss.mp.common.constant.Constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestVO {
	
	public int getPageNum() {
		return pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	private int pageNum = Constants.PAGE_DEFAULT_START_NUM;
	
	private int pageSize = Constants.PAGE_DEFAULT_LIMIT_NUM;
	
	private String sortBy = Constants.PAGE_DEFAULT_ORDER_BY;
	
	private String sortOrder = Constants.DESCENDING;
	
	private String searchText = "";

}
