package com.app.ams.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
			HttpSession session = request.getSession(false);
			int login_logout;
			Attendance attendance = attendanceService.findByEmp_id(user.getId());
			login_logout = attendance.getIsLoggedIn();
			if (login_logout == 1) {
				session.setAttribute("login_logout", "Logout");
			} else if (login_logout == 0) {
				session.setAttribute("login_logout", "Login");
			}

			session.setAttribute("name", user.getUsername());
			session.setAttribute("emp_id", user.getId());
			// model.addAttribute("name", user.getUsername());
			// model.addAttribute("emp_id", user.getId());
			return "attendance";
		} else {
			model.addAttribute("error", "Your username and password is invalid.");
		}
		return "login";
	}

	@RequestMapping(value = "/attendance", method = RequestMethod.POST)
	public String attendance_login_logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();

		String login_logout = session.getAttribute("login_logout").toString();
		int update_attendance;
		// session.removeAttribute("login_logout");
		if (login_logout.equalsIgnoreCase("login")) {
			update_attendance = 0;
			session.setAttribute("login_logout", "Logout");
		} else {
			update_attendance = 1;
			session.setAttribute("login_logout", "Login");
		}
		attendanceService.setIsLoggedInByEmpId(update_attendance,
				Integer.parseInt(session.getAttribute("emp_id").toString()));
		return "attendance";
	}

	@RequestMapping(value = "/attendance", method = RequestMethod.GET)
	public String attendance_login_logout() {
		return "attendance";
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String report(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		return "report";
	}
}
