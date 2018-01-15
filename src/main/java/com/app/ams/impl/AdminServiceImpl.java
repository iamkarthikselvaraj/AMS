package com.app.ams.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ams.model.EmployeeDetails;
import com.app.ams.repository.EmployeeDetailsRepo;
import com.app.ams.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private EmployeeDetailsRepo employeeDetailsRepository;

	@Override
	public void createEmployee(EmployeeDetails emp_details) {
		employeeDetailsRepository.save(emp_details);

	}
}
