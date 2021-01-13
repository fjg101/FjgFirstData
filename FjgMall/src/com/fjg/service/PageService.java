package com.fjg.service;

import com.fjg.pojo.Page;
import com.fjg.pojo.Product;

public interface PageService {
	//��¼����
	public int pageCountService();
	//��ҳ����
	public Page<Product> pageCurrentService(Integer pageNo, Integer pageSize);
	public Page<Product> pageNameCurrentService(Integer pageNo, Integer pageSize, String product_name);
}
