package com.nexware.ams.service;

import com.nexware.ams.model.User;

public interface UserService {

	User findByUsername(String username);
}
