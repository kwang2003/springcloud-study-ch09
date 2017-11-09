package com.pachiraframework.springcloud.message.dto;

import java.util.Map;

import lombok.Data;

/**
 * 发送sms消息对象
 * @author wangxuzheng
 *
 */
@Data
public class SmsSendRequest {
	/**
	 * 短信模版ID
	 */
	private String templateId;
	/**
	 * 要发送的手机号
	 */
	private String mobile;
	/**
	 * 模版中携带的参数信息
	 */
	private Map<String, Object> params;
}
