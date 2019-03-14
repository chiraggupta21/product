package com.grizzly.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class ProductAuthenticateSuccessHandler implements AuthenticationSuccessHandler{

	
	private RedirectStrategy rs=new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
		authorities.forEach(authority->{
			if(authority.getAuthority().equals("ROLE_USER"))
			{
				try {
					rs.sendRedirect(request,response,"/products/listall");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
