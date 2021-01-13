package com.fjg.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fjg.pojo.User;

public class ManagerFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Object users = session.getAttribute("user");
		User user = new User();
		if(users==null) {
			resp.sendRedirect(req.getContextPath()+"/jsp/user/login.jsp");
		}else {
			user = (User) users;
			if(user.getUsername().equals("admin")) {
				//是管理员可以通过
				chain.doFilter(request, response);
			}else {
				//不是管理员
				resp.sendRedirect(req.getContextPath()+"/jsp/user/login.jsp");
			} 
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
