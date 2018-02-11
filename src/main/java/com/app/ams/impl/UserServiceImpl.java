package com.app.ams.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ams.model.Attendance;
import com.app.ams.model.Report;
import com.app.ams.model.User;
import com.app.ams.repository.AttendanceRepo;
import com.app.ams.repository.ReportRepo;
import com.app.ams.repository.UserRepo;
import com.app.ams.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepository;
	@Autowired
	private ReportRepo reportRepository;
	@Autowired
	private AttendanceRepo attendanceRepository;

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<Report> getReportsByUser(User user) {
		// TODO Auto-generated method stub
		return reportRepository.findAllByUser(user);
	}

	@Override
	public Attendance getAttendance(Integer userId) {
		// TODO Auto-generated method stub
		return attendanceRepository.findByUserId(userId);
	}
	//

	@Override
	public List<Report> findByDateBetween(Date start, Date end) {
		// TODO Auto-generated method stub
		return reportRepository.findByDateBetween(start, end);
	}

	@Override
	public Report findFirstByDateAndUser(Date date, User user) {
		// TODO Auto-generated method stub
		return reportRepository.findFirstByDateAndUser(date, user);
	}

}
