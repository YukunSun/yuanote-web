package com.yuanote.service;

import java.util.List;

import com.yuanote.domain.Notebook;

public interface INotebookService {
	public void createNotebook(Notebook notebook);

	public List<Notebook> findNotebook(Notebook notebook);

	public void updateNotebook(Notebook notebook);

	public void deleteNotebook(Notebook notebook);
}
