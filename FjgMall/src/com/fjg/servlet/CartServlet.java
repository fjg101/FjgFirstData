package com.fjg.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjg.pojo.Cart;
import com.fjg.pojo.Product;
import com.fjg.pojo.User;
import com.fjg.service.CartService;
import com.fjg.service.ProductService;
import com.fjg.serviceImpl.CartServiceImpl;
import com.fjg.serviceImpl.ProductServiceImpl;
import com.fjg.utils.BeanSetUtils;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends BaseServlet {

	private CartService service = new CartServiceImpl();
	protected void insertCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//加入购物车
		ProductService ps = new ProductServiceImpl();
		String ids = req.getParameter("id");
		String user_id = req.getParameter("f_user_id");
		BigDecimal id = new BigDecimal(ids);
		BigDecimal f_user_id = new BigDecimal(user_id);
		Product product = ps.queryProductById(id, f_user_id);
		//获取当前登录用户的id
		User user = new User();
		Object object = req.getSession().getAttribute("user");
		if(object==null) {
			resp.sendRedirect(req.getContextPath()+"/jsp/user/login.jsp");
		}else {
			user = (User) object;
			BigDecimal id2 = user.getId();			
			//查询购物车是否已经添加了该商品
			Cart cart = service.queryCartById(id, id2);
			if(cart == null) {
				//购物车未添加该商品
				cart = new Cart(new BigDecimal(1),product.getProduct_price());
				//将该商品加入购物车
				service.addCartService(product, id2, cart);
			}else {
				//购物车添加了该商品
				cart.setCart_num(cart.getCart_num().add(new BigDecimal(1)));
				cart.setPrice_total(cart.getCart_num().multiply(cart.getCart_price()));
				//更新购物车该商品的数量和总金额
				service.updateCartService(cart);
			}
		}
		resp.sendRedirect(req.getHeader("Referer"));
	}
	protected void queryCarts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取当前登录用户的id
		User user = new User();
		Object object = req.getSession().getAttribute("user");
		if(object==null) {
			resp.sendRedirect(req.getContextPath()+"/jsp/user/login.jsp");
		}else {			
			user = (User) object;
			BigDecimal id2 = user.getId();
			//查询购物车全部商品
			List<Cart> list = service.queryCartService(id2);
			//将商品列表传入前台
			req.getSession().setAttribute("cartSum", list.size());
			req.getSession().setAttribute("cart", list);
			req.getRequestDispatcher("/jsp/cart/cart.jsp").forward(req, resp);
		}
	}
	protected void updateCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取当前登录用户的id
		User user = new User();
		Object object = req.getSession().getAttribute("user");
		if(object==null) {
			resp.sendRedirect(req.getContextPath()+"/jsp/user/login.jsp");
		}else {
			user = (User) object;
			BigDecimal id2 = user.getId();
			//更新购物车商品
			String product_id = req.getParameter("cartUpdate");
			BigDecimal f_product_id = new BigDecimal(product_id);
			String cart_nums = req.getParameter("cart_num");
			BigDecimal cart_num = new BigDecimal(cart_nums);
			Cart cart = service.queryCartById(f_product_id, id2);
			cart.setCart_num(cart_num);
			cart.setPrice_total(cart.getCart_num().multiply(cart.getCart_price()));
			service.updateCartService(cart);
			resp.sendRedirect(req.getContextPath()+"/CartServlet?hide=queryCarts");
		}
	}	
	protected void deleteCartById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取当前登录用户的id
		User user = new User();
		Object object = req.getSession().getAttribute("user");
		if(object==null) {
			resp.sendRedirect(req.getContextPath()+"/jsp/user/login.jsp");
		}else {
			user = (User) object;
			BigDecimal id2 = user.getId();
			//删除购物车商品
			String ids = req.getParameter("id");
			BigDecimal id = new BigDecimal(ids);
			service.deleteCartService(id, id2);
			resp.sendRedirect(req.getContextPath()+"/CartServlet?hide=queryCarts");
		}
	}	
	protected void clearCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取当前登录用户的id
		User user = new User();
		Object object = req.getSession().getAttribute("user");
		if(object==null) {
			resp.sendRedirect(req.getContextPath()+"/jsp/user/login.jsp");
		}else {
			user = (User) object;
			BigDecimal id2 = user.getId();
			//清空购物车商品
			service.clearCartService(id2);
			resp.sendRedirect(req.getContextPath()+"/CartServlet?hide=queryCarts");		
		}
	}	

}
