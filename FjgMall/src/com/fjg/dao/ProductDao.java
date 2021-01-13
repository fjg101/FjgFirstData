package com.fjg.dao;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.pojo.Product;

public interface ProductDao {
	//��
	public int addDao(Product product);
	//ɾ
	public int deleteDao(BigDecimal id);
	//��
	public int updateDao(Product product);
	//��ѯȫ��
	public List<Product> selectProducts();
	//������ѯ
	public Product selectProductById(BigDecimal id,BigDecimal f_user_id);
}
