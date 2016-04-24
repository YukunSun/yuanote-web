package com.yuanote.service.impl;

import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanote.common.BusinessExceptionUtil;
import com.yuanote.common.UUIDUtil;
import com.yuanote.domain.User;
import com.yuanote.mapper.UserMapper;
import com.yuanote.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public User findUser(String userName) {
		User user = this.userMapper.selectByUserName(userName);
		return user;
	}

	@Override
	public boolean addUser(User user) throws Exception {
		if (checkUserName(user)) {
			user.setUserId(UUIDUtil.getUUID());
			this.userMapper.insertSelective(user);
		} else {
			return false;
		}
		return true;
	}

	/**
	 * 判断是否合法
	 * 
	 * @param user-必填
	 * @return
	 */
	private boolean checkUserName(User user) {
		String name = user.getUserName();
		if (user == null || name == null || "".equals(name)) {
			throw new BusinessExceptionUtil("参数异常：用户名为空！");
		}
		User tmpUser = this.findUser(name);
		if (null != tmpUser) {
			return false;
		}
		return true;
	}

	@Override
	public Map<String, Object> checkUser(User user) {
		if (user == null) {

		}

		return null;
	}

}
