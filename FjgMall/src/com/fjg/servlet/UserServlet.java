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
			//��½�ɹ�
			//�������û�����¼
			Cookie cookie = new Cookie("username", login.getUsername());
			cookie.setMaxAge(60*60*24*7);
			resp.addCookie(cookie);
			//����user��session����ǰ̨��ȡnickname
			req.getSession().setAttribute("user", login);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}else {
			//��½ʧ��
			req.setAttribute("errmsg", "�û����������������������");
			req.getRequestDispatcher("/jsp/user/login.jsp").forward(req, resp);
		}
	}
	protected void loginoutServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ɾ��session
		req.getSession().invalidate();
		//�ص���ҳ��
		resp.sendRedirect(req.getContextPath()+"/index.jsp");
	}
	protected void registAjaxServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�ֲ�ˢ���û����Ƿ����
		String username = req.getParameter("username");
		boolean regist = service.regist(username);
		if(regist) {
			//�û�������
			String msg = "�û�������";
			Gson gson = new Gson();
			String json = gson.toJson(msg);
			resp.getWriter().write(json);
		}else {
			//�û���������
			String msg = "�û���������";
			Gson gson = new Gson();
			String json = gson.toJson(msg);
			resp.getWriter().write(json);
		}
	}
	protected void registServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��֤��֤���Ƿ���ȷ
		String code = req.getParameter("code");
		//��λ�ȡ����֤�����Ϣ�أ�
		String codeSession = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
		//2.����һ�仰
		if(codeSession==null ||codeSession=="") {
			req.setAttribute("errmsg", "��֤��ʧЧ");
			req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
		}
		//3.ɾ����ԭ���洢��sessionֵ����֤��֤�����ˢ��
		req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
		if(codeSession.equalsIgnoreCase(code)) {
			//��֤����ȷ
			User user = BeanSetUtils.setAnyBean(req.getParameterMap(), new User());
			boolean regist = service.regist(user.getUsername());
			if(regist) {
				//ע��ɹ�
				//����
				int registSuccess = service.registSuccess(user);
				if(registSuccess > 0) {
					//����ɹ�
					req.getRequestDispatcher("/jsp/user/login.jsp").forward(req, resp);
				}else {
					//����ʧ��
					req.getRequestDispatcher("/jsp/user/regist.jsp").forward(req, resp);
				}
			}else {
				//ע��ʧ��
				req.setAttribute("errmsg", "�û����Ѵ��ڣ�����������");
				req.getRequestDispatcher("/jsp/user/regist.jsp").forward(req, resp);
			}
		}else {
			//��֤���������
			req.setAttribute("errmsg", "��֤�������������������");
			req.getRequestDispatcher("/jsp/user/regist.jsp").forward(req, resp);
		}
	}

}
