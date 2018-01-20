package com.app.ams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ams.model.Privilege;

public interface PrivilegeRepo extends JpaRepository<Privilege, Long> {
	List<Privilege> findAll();

	Privilege findByprivilegeId(int pid);
}
