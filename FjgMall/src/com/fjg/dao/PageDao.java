package com.fjg.dao;

import java.util.List;

import com.fjg.pojo.Product;

public interface PageDao {
	//��¼����
	public int pageCount();
	//��ҳ����
	public List<Product> pageCurrent(Integer begin, Integer end);
	public List<Product> pageNameCurrent(Integer begin, Integer end, String product_name);
	public int pageNameCount(String product_name);
}
