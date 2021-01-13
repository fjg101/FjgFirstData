package com.fjg.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjg.pojo.Product;
import com.fjg.service.ProductService;
import com.fjg.serviceImpl.ProductServiceImpl;
import com.fjg.utils.BeanSetUtils;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/manager/ProductServlet")
public class ProductServlet extends BaseServlet {
	
	private ProductService service = new ProductServiceImpl();
	//��ѯȫ��
	protected void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> list = service.queryProducts();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/jsp/manager/product_manager.jsp").forward(req, resp);
	}
	//��ѯ����
	protected void queryProductById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ids = req.getParameter("id");
		BigDecimal id = new BigDecimal(ids);
		//userId�ݶ�Ϊ1
		BigDecimal f_user_id = new BigDecimal(1);
		Product product = service.queryProductById(id, f_user_id);
		req.setAttribute("product", product);
		req.getRequestDispatcher("/jsp/manager/product_edit.jsp").forward(req, resp);
		
	}
	//��
	protected void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = BeanSetUtils.setAnyBean(req.getParameterMap(), new Product());
		//userId�ݶ�Ϊ1
		product.setF_user_id(new BigDecimal(1));
		int addService = service.addService(product);
		if(addService>0) {
			//����ɹ�
			//ˢ����Ʒҳ��
			resp.sendRedirect(req.getContextPath()+"/PageServlet?hide=pageProducts");
		}else {
			//����ʧ��
			req.getRequestDispatcher("/jsp/manager/product_edit.jsp").forward(req, resp);;
		}
	}
	//ɾ
	protected void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ids = req.getParameter("id");
		BigDecimal id = new BigDecimal(ids);
		service.deleteService(id);
		resp.sendRedirect(req.getContextPath()+"/PageServlet?hide=pageProducts");
	}
	//��
	protected void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = BeanSetUtils.setAnyBean(req.getParameterMap(), new Product());
//		System.out.println(product);
		service.updateService(product);
//		System.out.println(updateService);
		resp.sendRedirect(req.getContextPath()+"/PageServlet?hide=pageProducts");
	}

}
