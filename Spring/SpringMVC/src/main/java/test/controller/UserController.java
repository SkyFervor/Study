package test.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import test.model.Other;
import test.model.User;
import test.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login")
	@ResponseBody
	public String login(@ModelAttribute User user, @RequestParam Other other, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String result = "failure";

		System.out.println(user.getId() + "\t" + user.getUserName() + "\t" + user.getPassword());
		System.out.println(other.getValue());
		if ("zsh".equals(user.getUserName()) && "zsh".equals(user.getPassword()))
			result = "success";
		return result;
	}

	@RequestMapping(value = "/get")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		User userInfo = userService.getUser(id);
		ModelAndView mv = new ModelAndView("/userinfo");
		mv.addObject("user", userInfo);
		return mv;
	}
}
