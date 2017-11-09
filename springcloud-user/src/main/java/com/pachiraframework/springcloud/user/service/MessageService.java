package com.pachiraframework.springcloud.user.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pachiraframework.springcloud.user.controller.UserController.SmsSendResponse;

import lombok.Data;

@FeignClient("message-service")
public interface MessageService {
	@RequestMapping(method=RequestMethod.POST,value="/message/sms/send2")
	public ResponseEntity<SmsSendResponse> send(SmsSendRequest request);
	
	@Data
	public static class SmsSendRequest {
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
}
