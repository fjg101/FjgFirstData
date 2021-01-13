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
		// �ܼ�¼��
		int count = dao.pageCount();
		return count;
	}

	@Override
	public Page<Product> pageCurrentService(Integer pageNo, Integer pageSize) {
		/*��ǰҳĬ�� 1		pageNo;
		ÿҳ��¼��Ĭ�� 4		pageSize
		pageCoutn%pageSize!=0
		pageSum = pageCoutn/pageSize +1 
		begin = (pageNo-1)*pageSize + 1
		end = (pageNo-1)*pageSize
		*/
		//��ȡ�ܼ�¼��
		int pageCount = dao.pageCount();
		//��ȡ��ҳ��
		Integer pageSum = pageCount / pageSize ;
		if(pageCount%pageSize!=0) {
			pageSum += 1;
		}
		//��ȡ��ʼ����
		Integer begin = (pageNo-1)*pageSize + 1;
		//��ȡ��������
		Integer end = pageNo * pageSize;
		//��ȡÿҳ����
		List<Product> items = dao.pageCurrent(begin, end);
		Page<Product> page = new Page<>(pageNo, pageSum, pageSize, pageCount, items, begin, end);
		return page;
	}
	@Override
	public Page<Product> pageNameCurrentService(Integer pageNo, Integer pageSize, String product_name) {
		/*��ǰҳĬ�� 1		pageNo;
		ÿҳ��¼��Ĭ�� 4		pageSize
		pageCoutn%pageSize!=0
		pageSum = pageCoutn/pageSize +1 
		begin = (pageNo-1)*pageSize + 1
		end = (pageNo-1)*pageSize
		 */
		//��ȡ�ܼ�¼��
		int pageCount = dao.pageNameCount(product_name);
		//��ȡ��ҳ��
		Integer pageSum = pageCount / pageSize ;
		if(pageCount%pageSize!=0) {
			pageSum += 1;
		}
		//��ȡ��ʼ����
		Integer begin = (pageNo-1)*pageSize + 1;
		//��ȡ��������
		Integer end = pageNo * pageSize;
		//��ȡÿҳ����
		List<Product> items = dao.pageNameCurrent(begin, end,product_name);
		Page<Product> page = new Page<>(pageNo, pageSum, pageSize, pageCount, items, begin, end);
		System.out.println(page);
		return page;
	}

}
