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
	public Attendance findByEmp_id(int emp_id) {
		// TODO Auto-generated method stub
		return attendanceRepository.findByEmpId(emp_id);
	}
}
