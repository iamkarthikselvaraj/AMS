package com.app.ams.service;

import java.util.Date;
import java.util.List;

import com.app.ams.model.Attendance;
import com.app.ams.model.Report;
import com.app.ams.model.User;

public interface UserService {
	User findByEmail(String email);

	Attendance getAttendance(Integer userId);

	List<Report> getReportsByUser(User user);

	Report findFirstByDateAndUser(Date date, User user);

	List<Report> findByDateBetween(Date start, Date end);

}
