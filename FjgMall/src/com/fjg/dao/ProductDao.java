package com.fjg.dao;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.pojo.Product;

public interface ProductDao {
	//增
	public int addDao(Product product);
	//删
	public int deleteDao(BigDecimal id);
	//改
	public int updateDao(Product product);
	//查询全部
	public List<Product> selectProducts();
	//单个查询
	public Product selectProductById(BigDecimal id,BigDecimal f_user_id);
}
