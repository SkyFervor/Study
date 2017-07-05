package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbDao;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArrayList<String> a=new ArrayList<String>();

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errMsg = "";

		RequestDispatcher rd;

		String username = request.getParameter("username");
		String pass = request.getParameter("pass");

		try {
			DbDao dd = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/webDemo",
					"root", "");

			ResultSet rs = dd.query("select pass from user" + " where name = ?", username);
			if (rs.next()) {
				if (rs.getString("pass").equals(pass)) {
					HttpSession session = request.getSession(true);
					session.setAttribute("name", username);

					rd = request.getRequestDispatcher("/welcome.jsp");
					rd.forward(request, response);
				} else
					errMsg += "密码错误";
			} else
				errMsg += "用户名不存在";
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (errMsg != null && !errMsg.equals("")) {
			rd = request.getRequestDispatcher("/login.jsp");
			request.setAttribute("err", errMsg);
			rd.forward(request, response);
		}
	}
}