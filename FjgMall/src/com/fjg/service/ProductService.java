package com.fjg.service;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.pojo.Product;

public interface ProductService {
	//增
	public int addService(Product product);
	//删
	public int deleteService(BigDecimal id);
	//改
	public int updateService(Product product);
	//查询全部
	public List<Product> queryProducts();
	//单个查询
	public Product queryProductById(BigDecimal id,BigDecimal f_user_id);
}
