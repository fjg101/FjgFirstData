package com.fjg.service;

import com.fjg.pojo.Page;
import com.fjg.pojo.Product;

public interface PageService {
	//记录总数
	public int pageCountService();
	//分页内容
	public Page<Product> pageCurrentService(Integer pageNo, Integer pageSize);
	public Page<Product> pageNameCurrentService(Integer pageNo, Integer pageSize, String product_name);
}
