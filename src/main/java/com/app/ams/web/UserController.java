package com.app.ams.web;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.ams.model.Attendance;
import com.app.ams.model.Report;
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

		if (attendance.getLogin() == 0) {

			Report report = new Report(new Date(), LocalDate.now().getDayOfWeek().name(), new Date(), new Date(), 0,
					"");
			report.setUser(user);
			attendance.setReport(report);
			attendance.setLogin(1);
		} else {

			attendance.setLogin(0);
		}
		attendanceService.updateAttendance(attendance);
		user.setAttendance(attendance);

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
