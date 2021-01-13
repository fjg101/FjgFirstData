package com.fjg.service;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.pojo.Order;

public interface OrderService {
	//生成订单
	public int addOrderService(Order order);
	//处理订单
	public int updateOrderService(Order order);
	//查看订单
	public List<Order> queryOrder();
}
