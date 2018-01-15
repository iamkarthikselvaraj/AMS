package com.app.ams.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.ams.model.Attendance;
import com.app.ams.model.EmployeeDetails;
import com.app.ams.model.User;
import com.app.ams.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	public String createEmployee(Model model, HttpServletRequest request) {
		EmployeeDetails emp_details = new EmployeeDetails("karthik", new User("karthik", new Attendance()));

		adminService.createEmployee(emp_details);
		return "createEmployee";
	}

	@RequestMapping(value = "/createEmployee", method = RequestMethod.GET)
	public String createEmployee() {

		return "createEmployee";
	}
}
