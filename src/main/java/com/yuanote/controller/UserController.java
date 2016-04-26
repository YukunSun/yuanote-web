package com.yuanote.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanote.common.MD5Util;
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
	public Result login(User user) {
		Result result = new Result();
		if (userValide(user) == true) {
			User tmpUser = this.userService.findUser(user.getUserName());
			if (null == tmpUser) {
				result.setMessage("用户不存在，请注册！");
			} else {
				if (!tmpUser.getPassword().equals(new MD5Util(user.getPassword()).getResult())) {
					result.setMessage("密码错误！");
				} else {
					result.setMessage("恭喜，登录成功！");
				}
			}
		} else {
			result.setMessage("参数异常！");
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public Result register(User user) throws Exception {
		user.setUserName("zhangsan");
		user.setPassword("ppp");
		boolean flag = this.userService.addUser(user);
		return new Result(flag);
	}


	private boolean userValide(User user) {
		String userName = user.getUserName();
		String password = user.getPassword();
		if (null == userName || "".equals(userName) || null == password || "".equals(password)) {
			return false;// 参数异常	
		}
		return true;
	}

	// TODO 修改密码
}
