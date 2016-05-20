package com.yuanote.interceptor;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yuanote.domain.User;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("=========LoginInterceptor========");
		User user = (User) request.getSession().getAttribute("user");
		if (null == user) {
			response.setCharacterEncoding("utf-8");
			Writer writer = response.getWriter();
			writer.write("{\"status\":0,\"message\":\"请先进行登录.\"}");
			return false;
		}
		return true;
	}
}
