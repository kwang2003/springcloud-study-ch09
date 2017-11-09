package com.pachiraframework.springcloud.message.service.impl;

import java.io.StringReader;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pachiraframework.springcloud.message.dao.MessageTemplateDao;
import com.pachiraframework.springcloud.message.dto.SmsSendRequest;
import com.pachiraframework.springcloud.message.dto.SmsSendResponse;
import com.pachiraframework.springcloud.message.entity.MessageTemplate;
import com.pachiraframework.springcloud.message.service.SmsService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SmsServiceImpl implements SmsService {
	@Autowired
	private MessageTemplateDao messageTemplateDao;
	@Autowired
	private Configuration configuration;
	@Override
	@SneakyThrows
	public SmsSendResponse send(SmsSendRequest request) {
		MessageTemplate messageTemplate = messageTemplateDao.get(request.getTemplateId());
		String templateContent = messageTemplate.getContent();
		Template template = new Template(request.getTemplateId(), new StringReader(templateContent), configuration);
		StringWriter out = new StringWriter();
		template.process(request.getParams(), out);
		String content = out.toString();
		return doSend(request.getMobile(), content);
	}
	
	//改成调用实际的短息网关发送消息
	private SmsSendResponse doSend(String mobile,String content) {
		SmsSendResponse response = new SmsSendResponse();
		response.setCode("200");
		response.setMessage("发送成功");
		log.info("发送完毕，手机号：{}，发送内容：{},状态码：{}",mobile,content,response.getCode());
		return response;
	}
}
