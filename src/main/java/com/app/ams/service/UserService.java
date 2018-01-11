package com.app.ams.service;

import com.app.ams.model.User;

public interface UserService {
	User findByUsername(String username);
}
