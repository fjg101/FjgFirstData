package com.fjg.dao;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.pojo.Order;

public interface OrderDao {
	//���ɶ���
	public int addOrder(Order order);
	//������
	public int updateOrder(Order order);
	//�鿴����
	public List<Order> queryOrder();
}
