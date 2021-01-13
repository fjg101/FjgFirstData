package com.fjg.servlet;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjg.pojo.User;
import com.fjg.service.UserService;
import com.fjg.serviceImpl.UserServiceImpl;
import com.fjg.utils.BeanSetUtils;
import com.google.gson.Gson;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	
	private UserService service = new UserServiceImpl();
	protected void loginServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = BeanSetUtils.setAnyBean(req.getParameterMap(), new User());
		User login = service.login(user);
		if(login != null) {
			//登陆成功
			//设置免用户名登录
			Cookie cookie = new Cookie("username", login.getUsername());
			cookie.setMaxAge(60*60*24*7);
			resp.addCookie(cookie);
			//设置user的session方便前台获取nickname
			req.getSession().setAttribute("user", login);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}else {
			//登陆失败
			req.setAttribute("errmsg", "用户名或密码错误，请重新输入");
			req.getRequestDispatcher("/jsp/user/login.jsp").forward(req, resp);
		}
	}
	protected void loginoutServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//删除session
		req.getSession().invalidate();
		//回到主页面
		resp.sendRedirect(req.getContextPath()+"/index.jsp");
	}
	protected void registAjaxServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//局部刷新用户名是否可用
		String username = req.getParameter("username");
		boolean regist = service.regist(username);
		if(regist) {
			//用户名可用
			String msg = "用户名可用";
			Gson gson = new Gson();
			String json = gson.toJson(msg);
			resp.getWriter().write(json);
		}else {
			//用户名不可用
			String msg = "用户名不可用";
			Gson gson = new Gson();
			String json = gson.toJson(msg);
			resp.getWriter().write(json);
		}
	}
	protected void registServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//验证验证码是否正确
		String code = req.getParameter("code");
		//如何获取到验证码的信息呢？
		String codeSession = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
		//2.加上一句话
		if(codeSession==null ||codeSession=="") {
			req.setAttribute("errmsg", "验证码失效");
			req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
		}
		//3.删除掉原来存储的session值，验证验证码二次刷新
		req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
		if(codeSession.equalsIgnoreCase(code)) {
			//验证码正确
			User user = BeanSetUtils.setAnyBean(req.getParameterMap(), new User());
			boolean regist = service.regist(user.getUsername());
			if(regist) {
				//注册成功
				//插入
				int registSuccess = service.registSuccess(user);
				if(registSuccess > 0) {
					//插入成功
					req.getRequestDispatcher("/jsp/user/login.jsp").forward(req, resp);
				}else {
					//插入失败
					req.getRequestDispatcher("/jsp/user/regist.jsp").forward(req, resp);
				}
			}else {
				//注册失败
				req.setAttribute("errmsg", "用户名已存在，请重新输入");
				req.getRequestDispatcher("/jsp/user/regist.jsp").forward(req, resp);
			}
		}else {
			//验证码输入错误
			req.setAttribute("errmsg", "验证码输入错误，请重新输入");
			req.getRequestDispatcher("/jsp/user/regist.jsp").forward(req, resp);
		}
	}

}
