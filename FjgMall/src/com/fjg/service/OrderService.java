package com.fjg.service;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.pojo.Order;

public interface OrderService {
	//���ɶ���
	public int addOrderService(Order order);
	//������
	public int updateOrderService(Order order);
	//�鿴����
	public List<Order> queryOrder();
}
