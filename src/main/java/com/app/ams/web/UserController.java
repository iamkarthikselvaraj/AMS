package com.app.ams.web;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String attendance_login_logout_Post(@ModelAttribute("attendance") Attendance attendance, Model model) {
		User user = securityService.findLoggedInUser();
		Date date = new Date();
		if (attendance.getLogin() == 0) {
			Report report = new Report(date, LocalDate.now().getDayOfWeek().name(), date);
			report.setUser(user);
			attendance.setReport(report);
			attendance.setLogin(1);
		} else {
			Attendance a = user.getAttendance();
			System.out.println(a.getReport().getId());
			// Report report = userService.findByAttendance(attendance);

			// System.out.println(report.getTimeOfLogin());
			attendance.setLogin(0);
		}
		attendanceService.updateAttendance(attendance);
		user.setAttendance(attendance);

		model.addAttribute("attendance", user.getAttendance());
		return "attendance";
	}

	@RequestMapping(value = "/attendance", method = RequestMethod.GET)
	public String attendance_login_logout(Model model, final RedirectAttributes redirectAttributes) {
		User user = securityService.findLoggedInUser();
		Attendance attendance = user.getAttendance();
		redirectAttributes.addFlashAttribute("attendance", attendance);

		return "attendance";
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String report(Model model, HttpServletRequest request) {
		User user = securityService.findLoggedInUser();
		List<Report> reports = userService.getReportsByUser(user);
		model.addAttribute("reports", reports);
		return "report";
	}
}
