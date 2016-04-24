package com.yuanote.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanote.domain.Result;
import com.yuanote.domain.User;
import com.yuanote.service.IUserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public String test(HttpServletRequest request, Model model) {
		// User user =
		// this.userService.getUserById(Long.parseLong(request.getParameter("id")));
		// String userName = user.getName();
		// model.addAttribute("user", userName);
		return "dd";
	}

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");

		return "";
	}

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Result register(User user) throws Exception {
		boolean flag = this.userService.addUser(user);
		return new Result(flag);
	}

	// TODO 修改密码

}
