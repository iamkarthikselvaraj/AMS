package com.app.ams.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ams.model.Attendance;
import com.app.ams.repository.AttendanceRepo;
import com.app.ams.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	private AttendanceRepo attendanceRepository;

	@Override
	public Attendance findByUserID(int emp_id) {
		return attendanceRepository.findByUserId(emp_id);
	}

	@Override
	public void setLoginByUserID(int isLogin, int user_id) {
		attendanceRepository.setLoginByUserID(isLogin, user_id);
	}

}
