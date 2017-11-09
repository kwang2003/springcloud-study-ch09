package com.pachiraframework.springcloud.oauth2.config;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

public class PublicKeyTest {
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("kevin_key.jks");
		KeyPair keyPair = new KeyStoreKeyFactory(resource, "123456".toCharArray()).getKeyPair("kevin_key");
		RSAPublicKey key = (RSAPublicKey)keyPair.getPublic();
		System.out.println(key);
		String verifierKey = "-----BEGIN PUBLIC KEY-----\n" + new String(Base64.encode(key.getEncoded()))
				+ "\n-----END PUBLIC KEY-----";
		System.out.println(verifierKey);
	}
}
