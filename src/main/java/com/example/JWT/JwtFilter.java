package com.example.JWT;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*
@Component
public class JwtFilter extends OncePerRequestFilter {

	
	Claims claims = null;
	private String userName = null;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private CustomerUsersDetailsService service;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (httpServletRequest.getServletPath().matches("/user/login|/user/signup|/user/forgotPassword")) {
			filterChain.doFilter(httpServletRequest, httpServletResponse);
		} else {
			String authorizationHeader = httpServletRequest.getHeader("Authorization");
			String token = null;
			if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
				token = authorizationHeader.substring(7);

				userName = jwtUtils.extractUserName(token);
				claims = jwtUtils.extractAllClaims(token);

			}
			if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = service.loadUserByUsername(userName);
				if (jwtUtils.validateToken(token, userDetails)) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

				}
			}
			filterChain.doFilter(httpServletRequest, httpServletResponse);
		}
	}

	public Boolean isAdmin() {
		return "admin".equalsIgnoreCase((String) claims.get("role"));
	}

	public Boolean isUser() {
		return "user".equalsIgnoreCase((String) claims.get("role"));
	}

	public String getCurrentUser() {
		return userName;
	}

	
	
}*/
