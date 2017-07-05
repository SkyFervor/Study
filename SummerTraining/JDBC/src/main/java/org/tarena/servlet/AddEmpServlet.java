package org.tarena.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tarena.dao.EmpDao;
import org.tarena.dao.jdbc.impl.JDBCEmpDaoImpl;
import org.tarena.entity.Emp;

public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpDao empDao = new JDBCEmpDaoImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String ename = request.getParameter("ename");
		BigDecimal salary = new BigDecimal(request.getParameter("salary"));
		int age = Integer.valueOf(request.getParameter("age"));

		Emp emp = new Emp();
		emp.setEname(ename);
		emp.setSalary(salary);
		emp.setAge(age);

		try (PrintWriter out = response.getWriter()) {
			empDao.saveEmp(emp);

			response.sendRedirect("list");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
