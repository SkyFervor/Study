package org.tarena.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tarena.dao.EmpDao;
import org.tarena.dao.hibernate.impl.HibernateEmpDaoImpl;
import org.tarena.entity.Emp;

public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpDao empDao = new HibernateEmpDaoImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String ename = request.getParameter("ename");
		BigDecimal salary = new BigDecimal(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));

		Emp emp = new Emp();
		emp.setId(id);
		emp.setAccount(account);
		emp.setPassword(password);
		emp.setEname(ename);
		emp.setSalary(salary);
		emp.setAge(age);

		try {
			empDao.updateEmp(emp);

			response.sendRedirect("list.do");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
