package com.santosh.main.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.santosh.main.common.Provider;
import com.santosh.main.model.UserVO;
import com.santosh.main.service.UserService;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	
	@Autowired
	UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		try {
			DefaultOidcUser oauthUser = (DefaultOidcUser) authentication.getPrincipal();
			UserVO userVO =userService.getUser(oauthUser.getEmail());
			String email=oauthUser.getEmail();
			String name=oauthUser.getName();
			if(userVO==null) {
				userService.addUser(email, name, Provider.GOOGLE);
			}
			super.onAuthenticationSuccess(request, response, authentication);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
