package com.yuanote.common;

import java.util.UUID;

/**
 * Description: 生成随机id
 * 
 * @author coderdaily.net
 * @date 2016年4月24日
 */
public class UUIDUtil {
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
}
