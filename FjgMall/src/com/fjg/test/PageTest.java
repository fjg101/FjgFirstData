package com.fjg.test;

import java.util.List;

import org.junit.Test;

import com.fjg.dao.PageDao;
import com.fjg.daoImpl.PageDaoImpl;
import com.fjg.pojo.Page;
import com.fjg.pojo.Product;
import com.fjg.service.PageService;
import com.fjg.serviceImpl.PageServiceImpl;

import oracle.net.aso.l;

public class PageTest {
	@Test
	public void test01() {
		PageDao dao = new PageDaoImpl();
		int count = dao.pageCount();
		System.out.println(count);
	}
	@Test
	public void test02() {
		PageDao dao = new PageDaoImpl();
		List<Product> list = dao.pageCurrent(1, 10);
		System.out.println(list);
		System.err.println(list.size());
	}
	@Test
	public void test03() {
		PageService service = new PageServiceImpl();
		Page<Product> page = service.pageCurrentService(1, 4);
		System.out.println(page);
	}
	@Test
	public void test04() {
		PageService service = new PageServiceImpl();
		Page<Product> page = service.pageNameCurrentService(1, 4, "С");
		System.out.println(page);
	}
	@Test
	public void test05() {
		PageDao dao = new PageDaoImpl();
		int pageNameCount = dao.pageNameCount("С");
		System.out.println(pageNameCount);
	}
}
