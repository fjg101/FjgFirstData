package com.fjg.service;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.pojo.Product;

public interface ProductService {
	//��
	public int addService(Product product);
	//ɾ
	public int deleteService(BigDecimal id);
	//��
	public int updateService(Product product);
	//��ѯȫ��
	public List<Product> queryProducts();
	//������ѯ
	public Product queryProductById(BigDecimal id,BigDecimal f_user_id);
}
