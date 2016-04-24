package com.yuanote.domain;

/**
 * Description: 返回结果封装类
 * 
 * @author coderdaily.net
 * @date 2016年4月22日
 */
public class Result extends Enity {
	private static final long serialVersionUID = 1L;
	private int status;// 状态，0-失败，1-成功
	private String message;// 提示信息
	private Object data;// 相关数据

	public Result() {
		super();
	}

	public Result(Object data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
