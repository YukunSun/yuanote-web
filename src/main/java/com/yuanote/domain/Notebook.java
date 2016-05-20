package com.yuanote.domain;

import java.util.Date;

/**
 * Description: notebook实体类
 * 
 * @author coderdaily.net
 * @date 2016年5月19日
 */
public class Notebook {
	private Long sid;
	private String userId;
	private Long notebookTypeId;
	private String notebookName;
	private String notebookDesc;
	private Date notebookCreateTime;

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getNotebookTypeId() {
		return notebookTypeId;
	}

	public void setNotebookTypeId(Long notebookTypeId) {
		this.notebookTypeId = notebookTypeId;
	}

	public String getNotebookName() {
		return notebookName;
	}

	public void setNotebookName(String notebookName) {
		this.notebookName = notebookName;
	}

	public String getNotebookDesc() {
		return notebookDesc;
	}

	public void setNotebookDesc(String notebookDesc) {
		this.notebookDesc = notebookDesc;
	}

	public Date getNotebookCreateTime() {
		return notebookCreateTime;
	}

	public void setNotebookCreateTime(Date notebookCreateTime) {
		this.notebookCreateTime = notebookCreateTime;
	}

}
