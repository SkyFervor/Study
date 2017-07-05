package org.tarena.servlet;

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

import org.tarena.entity.Emp;

public class LoginCheckFilter implements Filter {
	public static final int HAS_LOGGED = 1;
	public static final int NOT_LOGGED = 2;

	private String[] ignoreUrlArray;

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// 获取web.xml中的init-param，即不过滤的URL列表
		String ignoreUrl = fConfig.getInitParameter("ignoreUrl");
		ignoreUrlArray = ignoreUrl.split(",");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 转换并设置request、response
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpRequest.setCharacterEncoding("utf-8");
		httpResponse.setContentType("text/html;charset=utf-8");

		// 不处理忽略的URL
		String requestUrl = httpRequest.getRequestURI();
		if (isIgnore(requestUrl, httpRequest.getContextPath())) {
			chain.doFilter(request, response);
			return;
		}

		// 读取Session并验证account是否存在
		HttpSession session = httpRequest.getSession(false);
		switch (loginCheck(session)) {
		// 通过验证，doFilter()
		case HAS_LOGGED:
			chain.doFilter(request, response);
			break;
		// 未通过验证，重定向到登陆页面
		case NOT_LOGGED:
			httpResponse.sendRedirect("login.jsp");
			break;
		}
	}

	private boolean isIgnore(String url, String contextPath) {
		// 根目录，允许访问
		if (url.equals(contextPath) || url.equals(contextPath + "/")) {
			return true;
		}

		// ignoreURL检查
		for (String ignoreUrl : ignoreUrlArray) {
			if (url.equals(contextPath + ignoreUrl))
				return true;
		}

		return false;
	}

	private int loginCheck(HttpSession session) {
		if (session == null)
			return NOT_LOGGED;

		Object accountObj = session.getAttribute("emp");
		if (accountObj == null)
			return NOT_LOGGED;
		else {
			String account = ((Emp) accountObj).getAccount();
			if (account.isEmpty() || account.toString().equals("null"))
				return NOT_LOGGED;
		}
		return HAS_LOGGED;
	}

	@Override
	public void destroy() {
	}
}
