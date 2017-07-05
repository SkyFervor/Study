package org.tarena.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tarena.dao.EmpDao;
import org.tarena.dao.hibernate.impl.HibernateEmpDaoImpl;

public class DeleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpDao empDao = new HibernateEmpDaoImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		int id = Integer.parseInt(request.getParameter("id"));

		try {
			empDao.deleteEmpById(id);

			response.sendRedirect("list.do");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
