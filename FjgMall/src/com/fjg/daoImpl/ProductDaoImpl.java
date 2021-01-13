package com.fjg.daoImpl;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.dao.ProductDao;
import com.fjg.pojo.Product;
import com.fjg.utils.UpdateUtil;
import com.fjg.utils.queryUtil;

public class ProductDaoImpl implements ProductDao{

	@Override
	public int addDao(Product product) {
		// 增
		String sql = "insert into f_product(id,f_user_id,product_name,product_price,product_sales,product_stock,product_img)values(f_product_seq.nextval,?,?,?,?,?,?)";
		int update = UpdateUtil.update(sql, product.getF_user_id(),product.getProduct_name(),product.getProduct_price(),product.getProduct_sales(),product.getProduct_stock(),product.getProduct_img());
		return update;
	}

	@Override
	public int deleteDao(BigDecimal id) {
		// 删
		String sql = "delete from f_product where id = ?";
		int update = UpdateUtil.update(sql, id);
		return update;
	}

	@Override
	public int updateDao(Product product) {
		// 改
		String sql = "update f_product set product_name=?,product_price=?,product_sales=?,product_stock=?,product_img=? where id = ? and f_user_id = ?";
		int update = UpdateUtil.update(sql, product.getProduct_name(),product.getProduct_price(),product.getProduct_sales(),product.getProduct_stock(),product.getProduct_img(),product.getId(),product.getF_user_id());
		return update;
	}

	@Override
	public List<Product> selectProducts() {
		// 查询全部
		String sql = "select id,f_user_id,product_name,product_price,product_sales,product_stock,product_img from f_product";
		List<Product> list = queryUtil.getInstance(Product.class, sql);
		return list;
	}

	@Override
	public Product selectProductById(BigDecimal id,BigDecimal f_user_id) {
		// 查询单个
		String sql = "select id,f_user_id,product_name,product_price,product_sales,product_stock,product_img from f_product where id = ? and f_user_id = ?";
		List<Product> list = queryUtil.getInstance(Product.class, sql, id,f_user_id);
		return list.get(0);
		
	}

}
