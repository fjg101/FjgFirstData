package com.fjg.daoImpl;

import java.math.BigDecimal;
import java.util.List;

import com.fjg.dao.OrderDao;
import com.fjg.pojo.Order;
import com.fjg.utils.UpdateUtil;
import com.fjg.utils.queryUtil;

public class OrderDaoImpl implements OrderDao{

	@Override
	public int addOrder(Order order) {
		// 生成订单
		String sql = "insert into f_order (id,f_user_id,order_no,order_date,order_price,order_status)values(f_order_seq.nextval,?,?,sysdate,?,'未发货')";
		int update = UpdateUtil.update(sql, order.getF_user_id(),order.getOrder_no(),order.getOrder_price());
		return update;
	}

	@Override
	public int updateOrder(Order order) {
		// 处理订单
		String sql = "update f_order set order_status = ? where id = ?";
		int update = UpdateUtil.update(sql, order.getOrder_status(),order.getId());
		return update;
	}
	@Override
	public List<Order> queryOrder() {
		// 查看订单
		String sql = "select id,f_user_id,order_no,order_price,order_date,order_status from f_order";
		List<Order> list = queryUtil.getInstance(Order.class, sql);
		return list;
	}

}
