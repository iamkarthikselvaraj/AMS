package com.app.ams.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.app.ams.model.User;
import com.app.ams.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

	@Override
	public User findLoggedInUser() {
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();

		if (userDetails instanceof UserDetails) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User currentUser = (User) auth.getPrincipal();
			return currentUser;
			// return ((UserDetails) userDetails).getUsername();
		}

		return null;
	}

	// @Override
	// public void autologin(String username, String password) {
	// UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	// UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
	// UsernamePasswordAuthenticationToken(
	// userDetails, password, userDetails.getAuthorities());
	//
	// authenticationManager.authenticate(usernamePasswordAuthenticationToken);
	//
	// if (usernamePasswordAuthenticationToken.isAuthenticated()) {
	// SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	// logger.debug(String.format("Auto login %s successfully!", username));
	// }
	// }
}
