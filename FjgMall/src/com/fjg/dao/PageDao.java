package com.fjg.dao;

import java.util.List;

import com.fjg.pojo.Product;

public interface PageDao {
	//记录总数
	public int pageCount();
	//分页内容
	public List<Product> pageCurrent(Integer begin, Integer end);
	public List<Product> pageNameCurrent(Integer begin, Integer end, String product_name);
	public int pageNameCount(String product_name);
}
