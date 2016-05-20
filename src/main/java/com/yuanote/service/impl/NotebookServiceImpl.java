package com.yuanote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanote.domain.Notebook;
import com.yuanote.mapper.NotebookMapper;
import com.yuanote.service.INotebookService;

@Service
public class NotebookServiceImpl implements INotebookService {
	@Autowired
	private NotebookMapper notebookMapper;

	@Override
	public void createNotebook(Notebook notebook) {
		this.notebookMapper.insertSelective(notebook);
	}

	@Override
	public List<Notebook> findNotebook(Notebook notebook) {
//		Long sid = notebook.getSid();
		return this.notebookMapper.selectByCriteria(notebook);
	}

	@Override
	public void updateNotebook(Notebook notebook) {
		this.notebookMapper.updateByPrimaryKey(notebook);
	}

	@Override
	public void deleteNotebook(Notebook notebook) {
		Long sid = notebook.getSid();
		this.notebookMapper.deleteByPrimaryKey(sid);
	}

}
