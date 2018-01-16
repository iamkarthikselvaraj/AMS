package com.app.ams.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ams.model.Attendance;
import com.app.ams.repository.AttendanceRepo;
import com.app.ams.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AttendanceRepo attendanceRepository;

	@Override
	public void createEmployee(Attendance attendance) {
		attendanceRepository.save(attendance);

	}
}
