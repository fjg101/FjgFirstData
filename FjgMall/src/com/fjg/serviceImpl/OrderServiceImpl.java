package com.fjg.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.dao.OrderDao;
import com.fjg.daoImpl.OrderDaoImpl;
import com.fjg.pojo.Order;
import com.fjg.service.OrderService;

public class OrderServiceImpl implements OrderService{

	private OrderDao dao = new OrderDaoImpl();
	@Override
	public int addOrderService(Order order) {
		// add
		int addOrder = dao.addOrder(order);
		return addOrder;
	}

	@Override
	public int updateOrderService(Order order) {
		// update
		int updateOrder = dao.updateOrder(order);
		return updateOrder;
	}

	@Override
	public List<Order> queryOrder() {
		// select
		List<Order> list = dao.queryOrder();
		return list;
	}

}
