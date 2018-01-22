package com.app.ams.service;

import java.util.List;

import com.app.ams.model.Attendance;
import com.app.ams.model.Privilege;
import com.app.ams.model.User;

public interface AdminService {
	void createEmployee(Attendance attendance);

	void createUser(User user);

	void deleteByUserId(int id);

	Privilege getPrivilegeById(int pid);

	List<Privilege> getPrivilegeList();

	List<User> findAllUsers();
}
