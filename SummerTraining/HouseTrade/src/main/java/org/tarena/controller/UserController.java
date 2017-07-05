package org.tarena.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tarena.dao.UserDao;
import org.tarena.entity.User;

@Controller
public class UserController {
	@Resource(name = "userDao")
	private UserDao userDao;

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		// 获取登录信息
		String account = request.getParameter("account");
		String password = request.getParameter("password");

		// 根据account从数据库读取User
		User user = userDao.findUserByAccount(account);

		// 验证失败，User不存在或密码不一致
		if (user == null || !user.getPassword().equals(password)) {
			request.setAttribute("result", "账号或密码错误");
			return "forward:/login.jsp"; // 转发失败信息到登陆页面
		}
		// 验证成功，将account写入Session
		HttpSession session = request.getSession(true);
		session.setAttribute("account", account);
		return "redirect:/"; // 重定向到主页
	}

	@RequestMapping("/register")
	public String register(HttpServletRequest request) {
		// 获取注册信息
		String account = request.getParameter("account");
		String password = request.getParameter("password");

		// 根据account从数据库读取User
		User user = userDao.findUserByAccount(account);

		// User已存在
		if (user != null) {
			request.setAttribute("result", "-1");
			return "forward:/register.jsp"; // 转发失败信息到注册页面
		}
		// User不存在，正常注册
		User newUser = new User();
		newUser.setAccount(account);
		newUser.setPassword(password);
		userDao.saveUser(newUser);

		request.setAttribute("result", "1");
		return "forward:/register.jsp";
	}
}
