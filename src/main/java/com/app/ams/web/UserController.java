package com.app.ams.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.ams.model.Attendance;
import com.app.ams.model.User;
import com.app.ams.service.AttendanceService;
import com.app.ams.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private AttendanceService attendanceService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) {
		String strUserName = request.getParameter("username");
		User user = userService.findByUsername(strUserName);
		if (user != null) {

			int login_logout;
			Attendance attendance = attendanceService.findByEmp_id(user.getId());
			login_logout = attendance.getIsLoggedIn();
			if (login_logout == 1) {
				model.addAttribute("login_logout", "Logout");
			} else if (login_logout == 0) {
				model.addAttribute("login_logout", "Login");
			}
			model.addAttribute("name", user.getUsername());
			model.addAttribute("emp_id", user.getId());
			return "attendance";
		} else {
			model.addAttribute("error", "Your username and password is invalid.");
		}
		return "login";
	}

	@RequestMapping(value = "/attendance", method = RequestMethod.POST)
	public String attendance_login_logout(Model model, HttpServletRequest request) {

		// attendanceService.setIsLoggedInByEmpId(emp_id);

		String strUserName = request.getParameter("username");
		User user = userService.findByUsername(strUserName);
		if (user != null) {

			int login_logout;
			Attendance attendance = attendanceService.findByEmp_id(user.getId());
			login_logout = attendance.getIsLoggedIn();
			if (login_logout == 1) {
				model.addAttribute("login_logout", "Logout");
			} else if (login_logout == 0) {
				model.addAttribute("login_logout", "Login");
			}
			model.addAttribute("name", user.getUsername());
			return "attendance";
		} else {
			model.addAttribute("error", "Your username and password is invalid.");
		}
		return "attendance";
	}

}
