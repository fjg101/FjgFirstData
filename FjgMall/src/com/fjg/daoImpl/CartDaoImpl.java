package com.fjg.daoImpl;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.dao.CartDao;
import com.fjg.pojo.Cart;
import com.fjg.pojo.Product;
import com.fjg.utils.UpdateUtil;
import com.fjg.utils.queryUtil;

public class CartDaoImpl implements CartDao{

	@Override
	public int addCart(Product product, BigDecimal f_user_id, Cart cart) {
		// 添加
		String sql = "insert into f_cart (id,f_user_id,f_product_id,cart_name,cart_num,cart_price,price_total) values (f_cart_seq.nextval,?,?,?,?,?,?)";
		int update = UpdateUtil.update(sql, f_user_id,product.getId(),product.getProduct_name(),cart.getCart_num(),product.getProduct_price(), cart.getPrice_total());
		return update;
	}

	@Override
	public int deleteCart(BigDecimal id, BigDecimal f_user_id) {
		// 删除
		String sql = "delete from f_cart where id = ? and f_user_id = ?";
		int update = UpdateUtil.update(sql, id, f_user_id);
		return update;
	}

	@Override
	public int updateCart(Cart cart) {
		// 更新
		String sql = "update f_cart set cart_num = ?, price_total = ? where id = ? and f_user_id = ?";
		int update = UpdateUtil.update(sql, cart.getCart_num(), cart.getPrice_total(), cart.getId(), cart.getF_user_id());
		return update;
	}

	@Override
	public int clearCart(BigDecimal f_user_id) {
		// 清空
		String sql = "delete from f_cart where f_user_id = ?";
		int update = UpdateUtil.update(sql, f_user_id);
		return update;
	}

	@Override
	public List<Cart> queryCart(BigDecimal f_user_id) {
		// 查询
		String sql = "select id,f_user_id,f_product_id,cart_name,cart_num,cart_price,price_total from f_cart where f_user_id = ?";
		List<Cart> list = queryUtil.getInstance(Cart.class, sql, f_user_id);
		return list;
	}

	@Override
	public Cart queryCartById(BigDecimal f_product_id, BigDecimal f_user_id) {
		// 单个查询
		String sql = "select id,f_user_id,f_product_id,cart_name,cart_num,cart_price,price_total from f_cart where f_user_id = ? and f_product_id = ?";
		List<Cart> list = queryUtil.getInstance(Cart.class, sql, f_user_id, f_product_id);
		if(list.size()>0) {
			return list.get(0);			
		}else {
			return null;
		}
	}

}
