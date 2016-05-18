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
	private String userSid;
	private Long notebookTypeSid;
	private String notebookName;
	private String notebookDesc;
	private Date notebookcreateTime;

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getUserSid() {
		return userSid;
	}

	public void setUserSid(String userSid) {
		this.userSid = userSid;
	}

	public Long getNotebookTypeSid() {
		return notebookTypeSid;
	}

	public void setNotebookTypeSid(Long notebookTypeSid) {
		this.notebookTypeSid = notebookTypeSid;
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

	public Date getNotebookcreateTime() {
		return notebookcreateTime;
	}

	public void setNotebookcreateTime(Date notebookcreateTime) {
		this.notebookcreateTime = notebookcreateTime;
	}

}
