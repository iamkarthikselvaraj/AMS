package com.app.ams.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ams.model.User;
import com.app.ams.repository.UserRepository;
import com.app.ams.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public void createEmployee(User user) {
		userRepository.save(user);

	}
}
