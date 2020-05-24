package com.test.utils;

import java.util.List;

import com.test.domain.User;

public class PageBean<T> {
	//当前页
	private Integer currentPage;
	//总记录数
	private Integer totalCount;
	//总页数
	private Integer totalPage;
	//每页显示记录数
	private Integer pageSize;
	//每页显示数据
	private List<T> list;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	} 
	
	

}
