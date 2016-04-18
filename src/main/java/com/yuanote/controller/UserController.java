package com.yuanote.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yuanote.domain.User;
import com.yuanote.service.IUserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/getUser", method=RequestMethod.GET)  
	public String test(HttpServletRequest request, Model model) {
//		User user = this.userService.getUserById(Long.parseLong(request.getParameter("id")));
//		String userName = user.getName();
//		model.addAttribute("user", userName);
		return "dd";
	}
}
