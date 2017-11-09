package com.pachiraframework.springcloud.message.entity;

import lombok.Data;

@Data
public class MessageTemplate {
	/**
	 * 模版ID
	 */
	private String id;
	/**
	 * 模版名称
	 */
	private String name;
	/**
	 * 模版内容
	 */
	private String content;
}
