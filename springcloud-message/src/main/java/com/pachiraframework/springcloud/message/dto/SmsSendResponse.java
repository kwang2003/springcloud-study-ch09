package com.pachiraframework.springcloud.message.dto;

import lombok.Data;

@Data
public class SmsSendResponse {
	/**
	 * 返回消息
	 */
	private String message;
	/**
	 * 返回状态码
	 */
	private String code;
}
