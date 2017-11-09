package com.pachiraframework.springcloud.message.service;

import com.pachiraframework.springcloud.message.dto.SmsSendRequest;
import com.pachiraframework.springcloud.message.dto.SmsSendResponse;

public interface SmsService {
	public SmsSendResponse send(SmsSendRequest request);
}
