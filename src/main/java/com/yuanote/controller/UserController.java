package com.yuanote.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanote.common.Md5Util;
import com.yuanote.domain.Result;
import com.yuanote.domain.User;
import com.yuanote.service.IUserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private IUserService userService;

	@ResponseBody
	@RequestMapping("/login")
	public Result login(User user,HttpSession session) {
		Result result = new Result();
		if (userValide(user) == true) {
			User tmpUser = this.userService.findUser(user.getUserName());
			if (null == tmpUser) {
				result.setMessage("用户不存在，请注册！");
			} else {
				if (!tmpUser.getPassword().equals(Md5Util.getMd5(user.getPassword()))) {
					result.setMessage("密码错误！");
				} else {
					result.setStatus(1);
					result.setData(user);
					//TODO 只有userName,password
					session.setAttribute("user", user);
					result.setMessage("恭喜，登录成功！");
				}
			}
		} else {
			result.setMessage("参数异常！");
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Result register(User user) throws Exception {
		Result result = new Result();
		boolean flag = this.userService.addUser(user);
		if (flag == true) {
			result.setStatus(1);
		}
		return result;
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
