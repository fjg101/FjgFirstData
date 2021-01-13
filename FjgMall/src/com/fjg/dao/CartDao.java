package com.fjg.dao;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.pojo.Cart;
import com.fjg.pojo.Product;

public interface CartDao {
	//��� ==>��Ʒid���û�id
	public int addCart(Product product, BigDecimal f_user_id, Cart cart);
	//ɾ�� ==>���ﳵid���û�id
	public int deleteCart(BigDecimal id, BigDecimal f_user_id);
	//�޸� ==>���ﳵid���û�id
	public int updateCart(Cart cart);
	//��� ==>�û�id
	public int clearCart(BigDecimal f_user_id);
	//��ѯȫ�� ==>���ﳵid���û�id
	public List<Cart> queryCart(BigDecimal f_user_id);
	//��ѯ���� ==>��Ʒid���û�id
	public Cart queryCartById(BigDecimal f_product_id, BigDecimal f_user_id);
}
