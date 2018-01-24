package com.app.ams.service;

import com.app.ams.model.User;

public interface SecurityService {
	User findLoggedInUser();

	// void autologin(String username, String password);
}
