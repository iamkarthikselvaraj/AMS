package com.app.ams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ams.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);

	void deleteByUserId(int id);

	@EntityGraph("userGraph")
	List<User> findAll();
}