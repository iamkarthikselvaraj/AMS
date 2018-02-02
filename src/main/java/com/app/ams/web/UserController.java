package com.app.ams.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
	public String attendance_login_logout_Post(Model model) throws ParseException {
		User user = securityService.findLoggedInUser();
		Attendance attendance = userService.getAttendance(user.getUserId());

		Date date = new Date();
		if (attendance.getLogin() == 0) {
			Report report = new Report(date, LocalDate.now().getDayOfWeek().name(), date);
			report.setUser(user);
			attendance.setReport(report);
			attendance.setLogin(1);
		} else {
			// long diff = date.getTime() -
			// attendance.getReport().getTimeOfLogin().getTime();
			String workedHours = TimeDiff(attendance.getReport().getTimeOfLogin(),
					new SimpleDateFormat("HH:mm:ss").parse(new SimpleDateFormat("HH:mm:ss").format(date)));
			// System.out.println(diff);
			Report report = attendance.getReport();
			report.setWorkedHours(workedHours);
			report.setTimeOfLogout(date);

			report.setUser(user);
			attendance.setReport(report);
			attendance.setLogin(0);
		}
		attendanceService.updateAttendance(attendance);

		model.addAttribute("attendance", attendance);
		return "attendance";
	}

	@RequestMapping(value = "/attendance", method = RequestMethod.GET)
	public String attendance_login_logout(Model model) {
		User user = securityService.findLoggedInUser();
		Attendance attendance = userService.getAttendance(user.getUserId());
		model.addAttribute("attendance", attendance);

		return "attendance";
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String report(Model model, HttpServletRequest request) {
		User user = securityService.findLoggedInUser();
		List<Report> reports = userService.getReportsByUser(user);
		model.addAttribute("reports", reports);
		return "report";
	}

	public String TimeDiff(Date inTime, Date outTime) {

		// milliseconds
		long different = outTime.getTime() - inTime.getTime();

		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		// long daysInMilli = hoursInMilli * 24;

		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;

		long elapsedMinutes = different / minutesInMilli;
		different = different % minutesInMilli;

		// long elapsedSeconds = different / secondsInMilli;

		return String.format("%d:%d", elapsedHours, elapsedMinutes);

	}
}
