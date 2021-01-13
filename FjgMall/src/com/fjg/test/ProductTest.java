package com.fjg.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.fjg.dao.ProductDao;
import com.fjg.daoImpl.ProductDaoImpl;
import com.fjg.pojo.Product;
import com.fjg.service.ProductService;
import com.fjg.serviceImpl.ProductServiceImpl;

public class ProductTest {
	@Test
	public void test01() {
		ProductDao dao = new ProductDaoImpl();
		List<Product> list = dao.selectProducts();
		System.out.println(list);
	}
	@Test
	public void test02() {
		ProductDao dao = new ProductDaoImpl();
		Product product = dao.selectProductById(new BigDecimal(1), new BigDecimal(1));
		System.out.println(product);
	}
	@Test
	public void test03() {
		ProductService service = new ProductServiceImpl();
		Product product = service.queryProductById(new BigDecimal(1), new BigDecimal(1));
		System.out.println(product);
	}

}
