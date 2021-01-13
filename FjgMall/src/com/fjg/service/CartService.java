package com.fjg.service;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.pojo.Cart;
import com.fjg.pojo.Product;

public interface CartService {
	//��� ==>��Ʒid���û�id
	public int addCartService(Product product, BigDecimal f_user_id, Cart cart);
	//ɾ�� ==>���ﳵid���û�id
	public int deleteCartService(BigDecimal id, BigDecimal f_user_id);
	//�޸� ==>���ﳵid���û�id
	public int updateCartService(Cart cart);
	//��� ==>�û�id
	public int clearCartService(BigDecimal f_user_id);
	//��ѯ ==>���ﳵid���û�id
	public List<Cart> queryCartService(BigDecimal f_user_id);
	//��ѯ���� ==>��Ʒid���û�id
	public Cart queryCartById(BigDecimal f_product_id, BigDecimal f_user_id);
}
