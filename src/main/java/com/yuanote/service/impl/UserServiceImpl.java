package com.yuanote.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanote.common.BusinessExceptionUtil;
import com.yuanote.common.Md5Util;
import com.yuanote.common.UUIDUtil;
import com.yuanote.domain.Notebook;
import com.yuanote.domain.NotebookType;
import com.yuanote.domain.User;
import com.yuanote.mapper.NotebookTypeMapper;
import com.yuanote.mapper.UserMapper;
import com.yuanote.service.INotebookService;
import com.yuanote.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private NotebookTypeMapper notebookTypeMapper;
	@Autowired
	private INotebookService notebookService;

	@Override
	public User findUser(String userName) {
		User user = this.userMapper.selectByName(userName);
		return user;
	}

	@Override
	public boolean addUser(User user) throws Exception {
		if (checkUserName(user)) {
			user.setUserId(UUIDUtil.getUUID());
			user.setPassword(Md5Util.getMd5(user.getPassword()));
			this.userMapper.insertSelective(user);
			//FIXME 回滚失败
			initNotebook(user);
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

	/**
	 * 初始化笔记本
	 * 
	 * @param user
	 */
	private void initNotebook(User user) throws Exception{
		if (null == user) {
			throw new BusinessExceptionUtil("参数异常！");
		}
		String userId = user.getUserId();
		List<NotebookType> notebookTypes = this.notebookTypeMapper.selectByCriteria(null);
		//为每种笔记类型创建一个默认笔记本
		for (NotebookType type : notebookTypes) {
			Notebook notebook = new Notebook();
			notebook.setUserId(userId);
			notebook.setNotebookTypeId(type.getSid());
			//TODO 好像并没什么用
			notebook.setNotebookName(type.getNotebookTypeName());
			notebook.setNotebookDesc("created when sys init");
			notebook.setNotebookCreateTime(new Date());
			this.notebookService.createNotebook(notebook);
		}
	}

}
