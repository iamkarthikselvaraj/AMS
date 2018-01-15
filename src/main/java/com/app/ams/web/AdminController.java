package com.app.ams.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.ams.model.EmployeeDetail;
import com.app.ams.model.User;
import com.app.ams.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	public String createEmployee(Model model, HttpServletRequest request) {
		EmployeeDetail emp_details = new EmployeeDetail("karthik");
		User user = new User("karthik", emp_details);
		adminService.createEmployee(user);
		return "createEmployee";
	}

	@RequestMapping(value = "/createEmployee", method = RequestMethod.GET)
	public String createEmployee() {

		return "createEmployee";
	}
}
