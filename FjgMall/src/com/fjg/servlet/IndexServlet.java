package com.fjg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjg.pojo.Product;
import com.fjg.service.ProductService;
import com.fjg.serviceImpl.ProductServiceImpl;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends BaseServlet {
	private ProductService service = new ProductServiceImpl();
	//²éÑ¯È«²¿
	protected void queryIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> list = service.queryProducts();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/jsp/index/index.jsp").forward(req, resp);
	}
}
