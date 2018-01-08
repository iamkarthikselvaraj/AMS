package com.nexware.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexware.ams.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
