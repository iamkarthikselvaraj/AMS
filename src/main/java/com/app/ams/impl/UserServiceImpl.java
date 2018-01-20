package com.app.ams.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ams.model.User;
import com.app.ams.repository.UserRepo;
import com.app.ams.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepository;

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
