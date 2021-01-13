package com.fjg.serviceImpl;

import java.util.List;

import com.fjg.dao.PageDao;
import com.fjg.daoImpl.PageDaoImpl;
import com.fjg.pojo.Page;
import com.fjg.pojo.Product;
import com.fjg.service.PageService;

public class PageServiceImpl implements PageService{

	PageDao dao = new PageDaoImpl();
	@Override
	public int pageCountService() {
		// 总记录数
		int count = dao.pageCount();
		return count;
	}

	@Override
	public Page<Product> pageCurrentService(Integer pageNo, Integer pageSize) {
		/*当前页默认 1		pageNo;
		每页记录数默认 4		pageSize
		pageCoutn%pageSize!=0
		pageSum = pageCoutn/pageSize +1 
		begin = (pageNo-1)*pageSize + 1
		end = (pageNo-1)*pageSize
		*/
		//获取总记录数
		int pageCount = dao.pageCount();
		//获取总页数
		Integer pageSum = pageCount / pageSize ;
		if(pageCount%pageSize!=0) {
			pageSum += 1;
		}
		//获取开始索引
		Integer begin = (pageNo-1)*pageSize + 1;
		//获取结束索引
		Integer end = pageNo * pageSize;
		//获取每页内容
		List<Product> items = dao.pageCurrent(begin, end);
		Page<Product> page = new Page<>(pageNo, pageSum, pageSize, pageCount, items, begin, end);
		return page;
	}
	@Override
	public Page<Product> pageNameCurrentService(Integer pageNo, Integer pageSize, String product_name) {
		/*当前页默认 1		pageNo;
		每页记录数默认 4		pageSize
		pageCoutn%pageSize!=0
		pageSum = pageCoutn/pageSize +1 
		begin = (pageNo-1)*pageSize + 1
		end = (pageNo-1)*pageSize
		 */
		//获取总记录数
		int pageCount = dao.pageNameCount(product_name);
		//获取总页数
		Integer pageSum = pageCount / pageSize ;
		if(pageCount%pageSize!=0) {
			pageSum += 1;
		}
		//获取开始索引
		Integer begin = (pageNo-1)*pageSize + 1;
		//获取结束索引
		Integer end = pageNo * pageSize;
		//获取每页内容
		List<Product> items = dao.pageNameCurrent(begin, end,product_name);
		Page<Product> page = new Page<>(pageNo, pageSum, pageSize, pageCount, items, begin, end);
		System.out.println(page);
		return page;
	}

}
