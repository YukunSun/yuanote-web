package com.yuanote.mapper;

import com.yuanote.domain.User;

public interface UserMapper {
	void insertSelective(User user);
	
	User selectByName(String userName);
	
	void updateByPrimaryKeySelective(User user);
}