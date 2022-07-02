package com.santosh.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.santosh.main.security.CustomOAuth2UserService;
import com.santosh.main.security.OAuth2LoginSuccessHandler;
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomOAuth2UserService oAuth2UserService;
	
	@Autowired
	private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
//			.antMatchers("/", "/login", "/oauth/**").permitAll()
			.anyRequest().authenticated()
			.and().oauth2Login()
			.userInfoEndpoint().userService(oAuth2UserService)
			.and()
			.successHandler(oAuth2LoginSuccessHandler)
			.and().logout().permitAll();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/addbook")
	    .antMatchers("/updatebook")
	    .antMatchers("/getbook/**")
	    .antMatchers("/deletebook");
	}
}
