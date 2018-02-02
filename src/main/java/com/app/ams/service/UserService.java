package com.app.ams.service;

import java.util.List;

import com.app.ams.model.Report;
import com.app.ams.model.User;

public interface UserService {
	User findByUsername(String username);

	List<Report> getReportsByUser(User user);

	// Report findByAttendance(Attendance attendance);
}
