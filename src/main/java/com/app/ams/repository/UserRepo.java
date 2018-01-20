package com.app.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ams.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
