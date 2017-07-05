package org.tarena.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tarena.dao.EmpDao;
import org.tarena.dao.hibernate.impl.HibernateEmpDaoImpl;
import org.tarena.entity.Emp;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpDao empDao = new HibernateEmpDaoImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 取账号密码
		String account = request.getParameter("account");
		String password = request.getParameter("password");

		try {
			// 查找Emp
			Emp emp = empDao.findEmpByAccount(account);

			// 验证失败，将结果转发给登录页面
			if (emp == null || !emp.getPassword().equals(password)) {
				request.setAttribute("result", "账号或密码错误");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				return;
			}

			// 验证成功，将emp存入session，重定向到欢迎页面
			HttpSession session = request.getSession(true);
			session.setAttribute("emp", emp);
			response.sendRedirect("welcome.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
