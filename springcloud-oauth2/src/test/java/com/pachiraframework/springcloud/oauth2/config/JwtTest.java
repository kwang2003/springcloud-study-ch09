package com.pachiraframework.springcloud.oauth2.config;

import org.junit.Test;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;

public class JwtTest {
	@Test
	public void test() {
		String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MTAxNzQ2MDYsInVzZXJfbmFtZSI6ImFkbWluIiwiYXV0aG9yaXRpZXMiOlsiYWRtaW4iXSwianRpIjoiNTJhOGM5MTUtMTE2OS00YzU5LWI0MmEtZGY4ZDM0Y2QwZWU0IiwiY2xpZW50X2lkIjoiY2xpZW50Iiwic2NvcGUiOlsiYXBwIl19.GecJM-FHApwznyYl-D3IjB0TpjhdhUXfYv782kfS9vdT0VZsu2HN-MGb-N-6Hf0efZ_mmz54IahJaq3KTw251v4L2O5A1r_iMuUP7GXs_qPHAGn3K1b4l-mNnpJdH5hhS5zYIRqOX2a8DXyI4zD7g8BQL-9PiR3kj9k_z9nW8vY9l2_x5Kyoc-sehxxQ5uQHM3xu6DzOwBpbbER7U_NnUwmcz5nS9YyAexSDnBbZAVpQavL2s1yYQVMJ5Dreq2asXHFbeQHXu5UqVbbTFuOgAylbFJ9K-3nsGAKT9NbzqBPRovI3s_X9HgjrzJHAuojBMeK0QMbvYSbUg2HB7MNNJw";
		Jwt jwt = JwtHelper.decode(token);
		System.out.println(jwt.toString());
	}

}
