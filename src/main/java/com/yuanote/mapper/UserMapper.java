package com.yuanote.mapper;

import com.yuanote.domain.User;

public interface UserMapper {
	User selectByName(String userName);
	
	void insertSelective(User user);
	
	void updateByPrimaryKeySelective(User user);
}