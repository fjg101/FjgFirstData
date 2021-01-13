package com.fjg.pojo;

import java.util.List;

public class Page<T> {
	//设置默认的每页记录数
	public static final Integer PAGE_SIZE = 4;
	//当前页
	private Integer pageNo;
	//总页数
	private Integer pageSum;
	//每页记录数
	private Integer pageSize = Page.PAGE_SIZE;
	//总记录数
	private Integer pageCount;
	//记录内容
	private List<T> items;
	//开始索引
	private Integer begin;
	//结束索引
	private Integer end;
	//分页地址
	private StringBuffer pageUrl;
	public StringBuffer getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(StringBuffer pageUrl) {
		this.pageUrl = pageUrl;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSum() {
		return pageSum;
	}
	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	public Page(Integer pageNo, Integer pageSum, Integer pageSize, Integer pageCount, List<T> items, Integer begin,
			Integer end, StringBuffer pageUrl) {
		super();
		this.pageNo = pageNo;
		this.pageSum = pageSum;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.items = items;
		this.begin = begin;
		this.end = end;
		this.pageUrl = pageUrl;
	}
	public Page(Integer pageNo, Integer pageSum, Integer pageSize, Integer pageCount, List<T> items, Integer begin,
			Integer end) {
		super();
		this.pageNo = pageNo;
		this.pageSum = pageSum;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.items = items;
		this.begin = begin;
		this.end = end;
	}
	public Page() {
		super();
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSum=" + pageSum + ", pageSize=" + pageSize + ", pageCount=" + pageCount
				+ ", items=" + items + ", begin=" + begin + ", end=" + end + ", pageUrl=" + pageUrl + "]";
	}
	
	
}
