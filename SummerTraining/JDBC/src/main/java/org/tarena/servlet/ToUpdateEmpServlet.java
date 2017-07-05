package org.tarena.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tarena.dao.EmpDao;
import org.tarena.dao.jdbc.impl.JDBCEmpDaoImpl;
import org.tarena.entity.Emp;

public class ToUpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpDao empDao = new JDBCEmpDaoImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Emp emp = empDao.findEmpById(id);
			request.setAttribute("emp", emp);

			request.getRequestDispatcher("updateEmp.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
