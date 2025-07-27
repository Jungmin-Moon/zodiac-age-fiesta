package com.zodiacagefiesta.security;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		for (GrantedAuthority gAuth: authorities) {
			String r = gAuth.getAuthority();
			
			if(r.equals("USER") || r.equals("ADMIN")) {
				response.sendRedirect("/profile");
			} 
		}
	}
}
