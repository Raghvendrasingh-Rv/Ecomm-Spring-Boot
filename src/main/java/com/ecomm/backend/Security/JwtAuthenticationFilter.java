package com.ecomm.backend.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
	@Autowired
	private JwtHelper jwtHelper;
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestToken = request.getHeader("Authorization");
		logger.info("message {}", requestToken);

		String username = null;
		String jwtToken = null;

		if (requestToken != null && requestToken.trim().startsWith("Bearer")) {
			jwtToken = requestToken.substring(7);

			try {
				username = this.jwtHelper.getUsername(jwtToken);

			} catch (ExpiredJwtException e) {
				logger.info("Invalid token message", "Jwt token expire");
			} catch (MalformedJwtException e) {
				logger.info("Invalid token message", "Invalid Jwt token");
			} catch (IllegalArgumentException e) {
				logger.info("Invalid token message", "Unable to get token");
			}

			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

				if (this.jwtHelper.validationToken(jwtToken, userDetails)) {
					UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails,
							null, userDetails.getAuthorities());

					SecurityContextHolder.getContext().setAuthentication(auth);
				} else {
					logger.info("Not Validate Message", "Invalid Jwt Token");
				}
			} else {
				logger.info("Not Validate Message", "username is null or auth is already there");
			}

		} else {
			logger.info("Token message {}", "token does not start with bearer");
		}

		filterChain.doFilter(request, response);
	}

}
