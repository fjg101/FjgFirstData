package com.fjg.service;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.pojo.Cart;
import com.fjg.pojo.Product;

public interface CartService {
	//添加 ==>商品id，用户id
	public int addCartService(Product product, BigDecimal f_user_id, Cart cart);
	//删除 ==>购物车id，用户id
	public int deleteCartService(BigDecimal id, BigDecimal f_user_id);
	//修改 ==>购物车id，用户id
	public int updateCartService(Cart cart);
	//清空 ==>用户id
	public int clearCartService(BigDecimal f_user_id);
	//查询 ==>购物车id，用户id
	public List<Cart> queryCartService(BigDecimal f_user_id);
	//查询单个 ==>商品id，用户id
	public Cart queryCartById(BigDecimal f_product_id, BigDecimal f_user_id);
}
