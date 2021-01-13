package com.fjg.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjg.pojo.Page;
import com.fjg.pojo.Product;
import com.fjg.service.PageService;
import com.fjg.serviceImpl.PageServiceImpl;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/PageServlet")
public class PageServlet extends BaseServlet {
	
	private PageService service = new PageServiceImpl();
	protected void pageProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置当前页
		Integer pageNo = 1;
		//req.getHeader("referer")如果直接在地址栏跳转为null
		if(req.getHeader("referer")!=null) {			
			pageNo = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
		}else {
			pageNo = 1;
		}
		//设置每页记录数
		Integer pageSize = req.getParameter("pageSize") == null ? Page.PAGE_SIZE : Integer.parseInt(req.getParameter("pageSize"));
		//获取分页对象
		Page<Product> page = service.pageCurrentService(pageNo, pageSize);
		StringBuffer pageUrl = new StringBuffer("PageServlet?hide=pageProducts");
		page.setPageUrl(pageUrl);
		req.setAttribute("page", page);
		req.getRequestDispatcher("/jsp/manager/product_manager.jsp").forward(req, resp);;
	}
	protected void pageIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置当前页
		Integer pageNo = 1;
		if(req.getHeader("referer")!=null) {			
			pageNo = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
		}else {
			pageNo = 1;
		}
		//设置每页记录数
		Integer pageSize = req.getParameter("pageSize") == null ? Page.PAGE_SIZE : Integer.parseInt(req.getParameter("pageSize"));
		//获取分页对象
		Page<Product> page = service.pageCurrentService(pageNo, pageSize);
		StringBuffer pageUrl = new StringBuffer("PageServlet?hide=pageIndex");
		
		page.setPageUrl(pageUrl);
		req.setAttribute("page", page);
		req.getRequestDispatcher("/jsp/index/index.jsp").forward(req, resp);;
	}
	protected void pageNameIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取搜索框名字
		String product_name = req.getParameter("searchName");
		//设置当前页
		//设置当前页
		Integer pageNo = 1;
		if(req.getHeader("referer")!=null) {			
			pageNo = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
		}else {
			pageNo = 1;
		}
		//设置每页记录数
		Integer pageSize = req.getParameter("pageSize") == null ? Page.PAGE_SIZE : Integer.parseInt(req.getParameter("pageSize"));
		//获取分页对象
		Page<Product> page = service.pageNameCurrentService(pageNo, pageSize,product_name);
		StringBuffer pageUrl = new StringBuffer("PageServlet?hide=pageNameIndex&searchName="+product_name);
		page.setPageUrl(pageUrl);
		req.setAttribute("page", page);
		req.getRequestDispatcher("/jsp/index/index.jsp").forward(req, resp);
	}

}
