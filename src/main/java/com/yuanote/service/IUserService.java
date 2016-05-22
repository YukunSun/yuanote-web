package com.yuanote.service;

import com.yuanote.domain.User;

public interface IUserService {

	public boolean addUser(User user) throws Exception;

	public User findUser(String userName);
}
