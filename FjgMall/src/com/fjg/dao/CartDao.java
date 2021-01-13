package com.fjg.dao;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.pojo.Cart;
import com.fjg.pojo.Product;

public interface CartDao {
	//添加 ==>商品id，用户id
	public int addCart(Product product, BigDecimal f_user_id, Cart cart);
	//删除 ==>购物车id，用户id
	public int deleteCart(BigDecimal id, BigDecimal f_user_id);
	//修改 ==>购物车id，用户id
	public int updateCart(Cart cart);
	//清空 ==>用户id
	public int clearCart(BigDecimal f_user_id);
	//查询全部 ==>购物车id，用户id
	public List<Cart> queryCart(BigDecimal f_user_id);
	//查询单个 ==>商品id，用户id
	public Cart queryCartById(BigDecimal f_product_id, BigDecimal f_user_id);
}
