package com.amigoscode.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

@Configuration
public class PasswordConfig {

	private final int STRENGTH = 10;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(STRENGTH, new SecureRandom());
	}
}
