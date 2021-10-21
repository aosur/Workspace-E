package com.amigoscode.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.nio.channels.Channels;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import static com.amigoscode.app.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/", "/js/**","/css/**").permitAll()
				.anyRequest()
				.authenticated()
			.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/courses", true)
			.and()
			.rememberMe()
				.tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(20))
				.key(new SecureRandom().toString())
			.and()
			.logout()
				.logoutUrl("/logout")
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout", HttpMethod.GET.toString()))
				.logoutSuccessUrl("/login")
				.clearAuthentication(true)
				.deleteCookies("JSESSIONID", "remember-me")
				.invalidateHttpSession(true)
				;




	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
		UserDetails adminUser = User.builder()
			.username("admin")
			.password(encoder.encode("123"))
			.authorities(ADMIN.getGrantedAuthorities()) //ROLE_ADMIN
			.build();
		
		UserDetails studentUser = User.builder()
			.username("student")
			.password(encoder.encode("123"))
			.authorities(STUDENT.getGrantedAuthorities()) //ROLE_STUDENT
			.build();
		
		UserDetails admintraineeUser = User.builder()
				.username("admintrainee")
				.password(encoder.encode("123"))
				.authorities(ADMINTRAINEE.getGrantedAuthorities()) //ROLE_ADMINTRAINEE
				.build();
		
		return new InMemoryUserDetailsManager(
					adminUser,
					studentUser,
					admintraineeUser
				);
	}
	

}
