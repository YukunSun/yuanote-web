package com.yuanote.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanote.domain.Notebook;
import com.yuanote.domain.Result;
import com.yuanote.domain.User;
import com.yuanote.service.INotebookService;

@Controller
@RequestMapping("notebook")
public class NotebookController {
	@Autowired
	private INotebookService notebookService;

	@ResponseBody
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public Result listNotebook(HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Notebook notebook = new Notebook();
		if (null != user) {
			String userId = user.getUserId();
			notebook.setUserId(userId);
		}
		List<Notebook> lists = this.notebookService.findNotebook(notebook);
		return new Result(lists);
	}
}
