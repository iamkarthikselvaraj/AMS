package com.app.ams.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ams.model.Report;
import com.app.ams.model.User;
import com.app.ams.repository.ReportRepo;
import com.app.ams.repository.UserRepo;
import com.app.ams.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepository;
	@Autowired
	private ReportRepo reportRepository;

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<Report> getReportsByUser(User user) {
		// TODO Auto-generated method stub
		return reportRepository.findAllByUser(user);
	}

	// @Override
	// public Report findByAttendance(Attendance attendance) {
	//
	// return reportRepository.findByAttendance(attendance);
	// }
}
