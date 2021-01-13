package com.fjg.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.fjg.dao.OrderDao;
import com.fjg.daoImpl.OrderDaoImpl;
import com.fjg.pojo.Order;

public class OrderTest {
//	@Test
//	public void test01() {
//		//add
//		OrderDao dao = new OrderDaoImpl();
//		int addOrder = dao.addOrder(new BigDecimal(4), new BigDecimal(13520), "f210111005");
//		System.out.println(addOrder);
//	}
//	@Test
//	public void test02() {
//		//add
//		OrderDao dao = new OrderDaoImpl();
//		dao.updateOrder(new BigDecimal(6), "ÒÑ·¢»õ");
//	}
	@Test
	public void test03() {
		OrderDao dao = new OrderDaoImpl();
		List<Order> list = dao.queryOrder();
		System.out.println(list);
	}
}
