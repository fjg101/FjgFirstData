package com.fjg.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjg.pojo.Order;
import com.fjg.service.CartService;
import com.fjg.service.OrderService;
import com.fjg.serviceImpl.CartServiceImpl;
import com.fjg.serviceImpl.OrderServiceImpl;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
	private OrderService service = new OrderServiceImpl();
	protected void insertOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Random r = new Random();
		int nextInt = r.nextInt(10000);
		StringBuffer order_nos = new StringBuffer("f211322");
		order_nos.append(nextInt);
		String order_no = order_nos.toString();
		//获取订单金额
		String price = req.getParameter("order_price");
		int parseInt = Integer.parseInt(price);
		BigDecimal order_price = new BigDecimal(parseInt);
		//获取当前用户id
		String userIds = req.getParameter("f_user_id");
		Integer userId = Integer.parseInt(userIds);
		BigDecimal f_user_id = new BigDecimal(userId); 
		Order order = new Order();
		order.setF_user_id(f_user_id);
		order.setOrder_no(order_no);
		order.setOrder_price(order_price);
		service.addOrderService(order);
		//清空购物车
		CartService cs = new CartServiceImpl();
		cs.clearCartService(f_user_id);
		resp.sendRedirect(req.getContextPath()+"/CartServlet?hide=queryCarts");
	}
	protected void updateOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取id
		String ids = req.getParameter("id");
		Integer parseInt = Integer.parseInt(ids);
		BigDecimal id = new BigDecimal(parseInt);
		//设置order
		Order order = new Order();
		order.setId(id);
		order.setOrder_status("已发货");
		service.updateOrderService(order);
		resp.sendRedirect(req.getContextPath()+"/OrderServlet?hide=queryOrders");
	}
	protected void queryOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Order> list = service.queryOrder();
		System.out.println(list);
		req.getSession().setAttribute("order", list);
		req.getRequestDispatcher("/jsp/order/order.jsp").forward(req, resp);
	}

}
