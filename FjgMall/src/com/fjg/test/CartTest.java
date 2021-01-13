package com.fjg.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.fjg.dao.CartDao;
import com.fjg.daoImpl.CartDaoImpl;
import com.fjg.pojo.Cart;


public class CartTest {
	@Test
	public void test01() {
		//≤È—Ø
		CartDao dao = new CartDaoImpl();
		List<Cart> list = dao.queryCart(new BigDecimal(4));
		System.out.println(list);
	}
	
}
