package com.app.ams.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String attendance_login_logout_Post(Model model) throws ParseException {
		User user = securityService.findLoggedInUser();
		Attendance attendance = userService.getAttendance(user.getUserId());
		String message = "";
		String css = "";
		boolean isSuccess = false;
		Date date = new Date();
		if (attendance.getLogin() == 0) {
			Report report = new Report(date, LocalDate.now().getDayOfWeek().name(), date);
			report.setUser(user);
			attendance.setReport(report);
			attendance.setLogin(1);

			message = "You have successfully logged in";
			isSuccess = true;
		} else {
			Object[] obj = TimeDiff(attendance.getReport().getTimeOfLogin(),
					new SimpleDateFormat("HH:mm:ss").parse(new SimpleDateFormat("HH:mm:ss").format(date)));
			String workedHours = obj[0].toString();
			if ((boolean) obj[1]) {
				Report report = attendance.getReport();
				report.setWorkedHours(workedHours);
				report.setTimeOfLogout(date);

				report.setUser(user);
				attendance.setReport(report);
				attendance.setLogin(0);
				message = "You have successfully logged out";
			} else {
				isSuccess = false;
				message = "You still have " + obj[2].toString()
						+ " Hours to logout, If you want to logout before please leave your comments.";
			}

		}
		if (isSuccess) {
			attendanceService.updateAttendance(attendance);
		}
		css = isSuccess ? "success" : "warning";
		model.addAttribute("css", css);
		model.addAttribute("msg", message);

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

	public Object[] TimeDiff(Date inTime, Date outTime) {
		Object obj[] = new Object[3];
		long workingHoursInMills = 32400000;
		// milliseconds
		long different = outTime.getTime() - inTime.getTime();
		long totaldiff = different;
		long timeLeft = workingHoursInMills - different;

		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		// long daysInMilli = hoursInMilli * 24;

		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;
		long leftHours = timeLeft / hoursInMilli;
		timeLeft = timeLeft % hoursInMilli;
		long elapsedMinutes = different / minutesInMilli;
		long leftMinutes = timeLeft / minutesInMilli;
		// different = different % minutesInMilli;

		boolean isWorkingHoursCompleted = totaldiff >= workingHoursInMills ? true : false;

		// if (!isWorkingHoursCompleted) {
		// reminingHours = elapsedHours - workingHoursInMills;
		// reminingMin = elapsedMinutes - 60;

		// }
		obj[0] = String.format("%d:%d", elapsedHours, elapsedMinutes);
		obj[1] = isWorkingHoursCompleted;
		obj[2] = String.format("%d:%d", leftHours, leftMinutes);
		return obj;

	}
}
