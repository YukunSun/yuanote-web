package com.yuanote.domain;

/**
 * Description:基本用户信息
 * 
 * @author coderdaily.net
 * @date 2016年4月22日
 */
public class User {
	private String userId;// 用户id

	private String userName;// 用户名

	private String password;// 密码

	private String userDesc;// 用户描述

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}
	
}