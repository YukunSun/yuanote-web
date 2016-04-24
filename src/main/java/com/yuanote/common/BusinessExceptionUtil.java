package com.yuanote.common;

/**
 * Description:业务异常封装类
 * 
 * @author coderdaily.net
 * @date 2016年4月22日
 */
public class BusinessExceptionUtil extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessExceptionUtil(String message) {
		// TODO 显式调用父类构造方法
		super(message);
	}

	public BusinessExceptionUtil(String message, Throwable cause) {
		super(message, cause);
	}

}
