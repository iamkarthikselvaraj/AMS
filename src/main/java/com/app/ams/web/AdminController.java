package com.app.ams.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.ams.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	public String createEmployee(Model model, HttpServletRequest request) throws ParseException {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		// EmployeeDetail emp_details = new EmployeeDetail(request.getParameter("name"),
		// request.getParameter("father_name"), request.getParameter("email"),
		// request.getParameter("present_address"),
		// request.getParameter("permanent_address"),
		// request.getParameter("mobile"), "", "",
		// format.parse(request.getParameter("doj")),
		// format.parse(request.getParameter("dob")));
		// User user = new User(emp_details.getName(), emp_details);
		// Attendance attendance = new Attendance(user);
		// adminService.createEmployee(attendance);
		return "createEmployee";
	}

	@RequestMapping(value = "/createEmployee", method = RequestMethod.GET)
	public String createEmployee() {

		return "createEmployee";
	}
}
