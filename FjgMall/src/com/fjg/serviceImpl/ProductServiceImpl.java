package com.fjg.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.dao.ProductDao;
import com.fjg.daoImpl.ProductDaoImpl;
import com.fjg.pojo.Product;
import com.fjg.service.ProductService;

public class ProductServiceImpl implements ProductService{

	private ProductDao dao = new ProductDaoImpl();
	@Override
	public int addService(Product product) {
		// 增
		int addDao = dao.addDao(product);
		return addDao;
	}

	@Override
	public int deleteService(BigDecimal id) {
		// 删除
		int deleteDao = dao.deleteDao(id);
		return deleteDao;
	}

	@Override
	public int updateService(Product product) {
		// 改
		int updateDao = dao.updateDao(product);
		return updateDao;
	}

	@Override
	public List<Product> queryProducts() {
		// 查询全部
		List<Product> list = dao.selectProducts();
		return list;
	}

	@Override
	public Product queryProductById(BigDecimal id, BigDecimal f_user_id) {
		// 查询单个
		Product product = dao.selectProductById(id, f_user_id);
		return product;
	}

}
