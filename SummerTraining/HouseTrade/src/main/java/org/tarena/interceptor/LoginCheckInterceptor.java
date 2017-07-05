package org.tarena.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		// 取session
		HttpSession session = request.getSession(false);
		// session为空，未登录
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return false;
		}

		// 取user
		Object userObj = session.getAttribute("account");
		// user为空，未登录
		if (userObj == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return false;
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView mv) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object obj, Exception exception) throws Exception {

	}
}
