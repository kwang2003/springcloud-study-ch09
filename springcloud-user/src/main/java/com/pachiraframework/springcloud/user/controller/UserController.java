package com.pachiraframework.springcloud.user.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pachiraframework.springcloud.user.service.MessageService;
import com.pachiraframework.springcloud.user.service.MessageService.SmsSendRequest;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private MessageService messageService;
	@RequestMapping(value= {"regist/sms"})
	public ResponseEntity<SmsSendResponse> sms(String mobile){
		Random random = new Random();
		int next = random.nextInt(10000000);
		String code = ""+(10000000-next);
		ResponseEntity<SmsSendResponse> response = doSend(mobile, code);
		return response;
	}
	
	public ResponseEntity<SmsSendResponse> doSend(String  mobile,String code) {
		final String sendUrl = "http://message-service/message/sms/send";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("mobile", mobile);
		map.add("templateId", "CHECK_CODE");
		map.add("params['code']", code);
		log.info("发送参数：{}",map);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<SmsSendResponse> response = restTemplate.postForEntity(sendUrl, request, SmsSendResponse.class);
		return response;
	}
	
	@RequestMapping(value= {"regist/sms2"})
	public ResponseEntity<SmsSendResponse> sms2(String mobile){
		Random random = new Random();
		int next = random.nextInt(10000000);
		String code = ""+(10000000-next);
		ResponseEntity<SmsSendResponse> response = doSendFeign(mobile, code);
		return response;
	}
	public ResponseEntity<SmsSendResponse> doSendFeign(String  mobile,String code) {
		SmsSendRequest request = new SmsSendRequest();
		request.setMobile(mobile);
		request.setTemplateId("CHECK_CODE");
		Map<String, Object> params = new HashMap<>();
		params.put("code", code);
		request.setParams(params);
		return messageService.send(request);
	}
	
	@Data
	public static class SmsSendResponse {
		/**
		 * 返回消息
		 */
		private String message;
		/**
		 * 返回状态码
		 */
		private String code;
	}

}
