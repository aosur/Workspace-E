package com.amigoscode.app.security;

import static com.amigoscode.app.security.ApplicationUserRole.ADMIN;
import static com.amigoscode.app.security.ApplicationUserRole.STUDENT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/", "/js/*","css/*").permitAll()
				.antMatchers("/api/v1/students", "/api/v1/students/*").hasRole(STUDENT.name())
				.anyRequest()
				.authenticated()
			.and()
			.httpBasic();
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
		UserDetails adminUser = User.builder()
			.username("admin")
			.password(encoder.encode("123"))
			.roles(ADMIN.name()) //ROLE_ADMIN
			.build();
		
		UserDetails studentUser = User.builder()
			.username("student")
			.password(encoder.encode("123"))
			.roles(STUDENT.name()) //ROLE_STUDENT
			.build();
		
		UserDetails admintraineeUser = User.builder()
				.username("admintrainee")
				.password(encoder.encode("123"))
				.roles(STUDENT.name()) //ROLE_ADMINTRAINEE
				.build();
		
		return new InMemoryUserDetailsManager(
					adminUser,
					studentUser,
					admintraineeUser
				);
	}
	

}