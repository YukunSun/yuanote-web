package com.yuanote.mapper;

import com.yuanote.domain.User;

public interface UserMapper {

	int insertSelective(User user);

	User selectByPrimaryKey(String ynUserId);
	
	User selectByUserName(String userName);

	int updateByPrimaryKeySelective(User record);

}