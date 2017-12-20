package com.pachiraframework.springcloud.oauth2.config;

import java.util.Base64;

public class AuthorizationHeader {
	public static void main(String[] args) {
		String client = "client";
		String secret = "secret";
		String src = client+secret;
		String result = Base64.getEncoder().encodeToString(src.getBytes());
		System.out.println(result);
	}
}
