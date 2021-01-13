package com.fjg.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.dao.CartDao;
import com.fjg.daoImpl.CartDaoImpl;
import com.fjg.pojo.Cart;
import com.fjg.pojo.Product;
import com.fjg.service.CartService;

public class CartServiceImpl implements CartService{

	private CartDao dao = new CartDaoImpl();
	@Override
	public int addCartService(Product product, BigDecimal f_user_id, Cart cart) {
		// 增加
		int addCart = dao.addCart(product, f_user_id, cart);
		return addCart;
	}

	@Override
	public int deleteCartService(BigDecimal id, BigDecimal f_user_id) {
		// 删除
		int deleteCart = dao.deleteCart(id, f_user_id);
		return deleteCart;
	}

	@Override
	public int updateCartService(Cart cart) {
		// 修改
		int updateCart = dao.updateCart(cart);
		return updateCart;
	}

	@Override
	public int clearCartService(BigDecimal f_user_id) {
		// 清空
		int clearCart = dao.clearCart(f_user_id);
		return clearCart;
	}

	@Override
	public List<Cart> queryCartService(BigDecimal f_user_id) {
		// 查询全部
		List<Cart> list = dao.queryCart(f_user_id);
		return list;
	}

	@Override
	public Cart queryCartById(BigDecimal f_product_id, BigDecimal f_user_id) {
		// 单值查询
		Cart cart = dao.queryCartById(f_product_id, f_user_id);
		return cart;
	}

}
