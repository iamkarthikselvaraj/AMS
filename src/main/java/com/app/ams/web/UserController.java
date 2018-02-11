package com.app.ams.web;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.Interval;
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
		// if(attendance.getReport().)
		Date date = new Date();
		if (attendance.getLogin() == 0) {
			Report report = userService.findFirstByDateAndUser(new Date(), user);
			if (report == null) {
				report = new Report(date, LocalDate.now().getDayOfWeek().name(), date);
				report.setUser(user);
				attendance.setReport(report);
				attendance.setLogin(1);

				message = "You have successfully logged in";
				isSuccess = true;
			} else {
				message = "You can not login immediately after logout";
				isSuccess = false;
			}
		} else {
			Object[] obj = TimeDiff(attendance.getReport().getTimeOfLogin(), date);
			String workedHours = obj[0].toString();
			if ((boolean) obj[1]) {
				Report report = attendance.getReport();
				report.setWorkedHours(workedHours);
				report.setTimeOfLogout(date);

				report.setUser(user);
				attendance.setReport(report);
				attendance.setLogin(0);
				isSuccess = true;
				message = "You have successfully logged out";
			} else {
				isSuccess = false;
				model.addAttribute("showComments", "showComments");
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

	@RequestMapping(value = "/attendance/Comments", method = RequestMethod.POST)
	public String attendance_logout_Comments(HttpServletRequest request, Model model) throws ParseException {

		User user = securityService.findLoggedInUser();
		Attendance attendance = userService.getAttendance(user.getUserId());
		String message = "";
		String css = "";
		boolean isSuccess = false;
		Date date = new Date();
		if (attendance.getLogin() == 0) {

		} else {
			String comments = request.getParameter("Comments");
			Report report = attendance.getReport();
			report.setWorkedHours("9:0");
			report.setTimeOfLogout(date);
			report.setComments(comments);
			report.setUser(user);
			attendance.setReport(report);
			attendance.setLogin(0);
			isSuccess = true;
			message = "You have successfully logged out";

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
		long workingHours = 32400000;
		Interval interval;
		if ((outTime.getTime() > (inTime.getTime() + workingHours))) {
			interval = new Interval(inTime.getTime(), outTime.getTime());
			org.joda.time.Period period = interval.toPeriod();
			if (period.getDays() > 0) {
				obj[0] = String.format("%d:%d", "09", "00");
			} else {
				obj[0] = String.format("%d:%d", period.getHours(), period.getMinutes());
			}
			System.out.printf("%d years, %d months, %d days, %d hours, %d minutes, %d seconds%n", period.getYears(),
					period.getMonths(), period.getDays(), period.getHours(), period.getMinutes(), period.getSeconds());
			obj[1] = true;
			obj[2] = "";
		} else {
			interval = new Interval(outTime.getTime(), inTime.getTime() + workingHours);
			org.joda.time.Period period = interval.toPeriod();
			System.out.printf("%d years, %d months, %d days, %d hours, %d minutes, %d seconds%n", period.getYears(),
					period.getMonths(), period.getDays(), period.getHours(), period.getMinutes(), period.getSeconds());
			obj[0] = "";
			obj[1] = false;
			obj[2] = String.format("%d:%d", period.getHours(), period.getMinutes());
		}
		return obj;

	}

}
