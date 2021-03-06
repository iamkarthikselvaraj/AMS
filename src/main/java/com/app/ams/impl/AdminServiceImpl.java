package com.app.ams.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.ams.model.Attendance;
import com.app.ams.model.Privilege;
import com.app.ams.model.Report;
import com.app.ams.model.User;
import com.app.ams.repository.AttendanceRepo;
import com.app.ams.repository.PrivilegeRepo;
import com.app.ams.repository.ReportRepo;
import com.app.ams.repository.UserRepo;
import com.app.ams.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AttendanceRepo attendanceRepository;
	@Autowired
	private PrivilegeRepo privilegeRepository;
	@Autowired
	private UserRepo userRepository;
	@Autowired
	private ReportRepo reportRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void createEmployee(Attendance attendance) {
		attendanceRepository.save(attendance);

	}

	@Override
	public List<Privilege> getPrivilegeList() {
		return privilegeRepository.findAll();
	}

	@Override
	public void createUser(Attendance attendance) {
		attendance.getUser().setPassword(bCryptPasswordEncoder.encode(attendance.getUser().getPassword()));
		attendanceRepository.save(attendance);

	}

	@Override
	public Privilege getPrivilegeById(int pid) {
		return privilegeRepository.findByprivilegeId(pid);
	}

	@Override
	public List<User> findAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public void deleteByUserId(int id) {
		userRepository.deleteByUserId(id);

	}

	@Override
	public List<Report> getAllReport() {
		return reportRepository.findAll();
	}

}
