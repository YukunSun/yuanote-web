package com.yuanote.service;

import java.util.Map;

import com.yuanote.domain.User;

public interface IUserService {

	public boolean addUser(User user) throws Exception;

	public Map<String, Object> checkUser(User user);

	public User findUser(String userName);
}
