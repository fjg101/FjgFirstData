package com.fjg.dao;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.pojo.Order;

public interface OrderDao {
	//生成订单
	public int addOrder(Order order);
	//处理订单
	public int updateOrder(Order order);
	//查看订单
	public List<Order> queryOrder();
}
