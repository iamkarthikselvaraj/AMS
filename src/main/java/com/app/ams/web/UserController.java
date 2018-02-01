package com.app.ams.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.ams.model.Attendance;
import com.app.ams.model.User;
import com.app.ams.service.AttendanceService;
import com.app.ams.service.SecurityService;
import com.app.ams.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private AttendanceService attendanceService;
	@Autowired
	private SecurityService securityService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/attendance", method = RequestMethod.POST)
	public String attendance_login_logout_Post(@ModelAttribute("attendanceForm") Attendance attendance, Model model) {
		User user = securityService.findLoggedInUser();
		int isLogin;
		if (attendance.getLogin() == 0) {
			isLogin = 1;
			// Report report = new Report(attendance, new Date(), "", new Date(), new
			// Date(), 0, "");
			// attendanceService.createReport(report);
		} else {
			isLogin = 0;
		}
		user.getAttendance().setLogin(isLogin);
		attendanceService.setLoginByUserID(isLogin, user.getUserId());
		model.addAttribute("attendance", user.getAttendance());
		return "attendance";
	}

	@RequestMapping(value = "/attendance", method = RequestMethod.GET)
	public String attendance_login_logout(Model model) {
		User user = securityService.findLoggedInUser();
		Attendance attendance = user.getAttendance();

		model.addAttribute("attendance", attendance);
		return "attendance";
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String report(Model model, HttpServletRequest request) {

		return "report";
	}
}
