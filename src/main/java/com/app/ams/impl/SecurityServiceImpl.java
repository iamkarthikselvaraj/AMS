package com.app.ams.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.app.ams.model.MyUserDetails;
import com.app.ams.model.User;
import com.app.ams.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Override
	public User findLoggedInUser() {
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if (userDetails != null) {
			return userDetails.getUser();
		}
		return null;
	}
}
