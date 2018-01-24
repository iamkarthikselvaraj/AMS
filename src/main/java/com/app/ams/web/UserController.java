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

	@RequestMapping(value = "/login", method = RequestMethod.PUT)
	public String login(Model model, HttpServletRequest request) {
		String strUserName = request.getParameter("username");
		User user = userService.findByUsername(strUserName);
		if (user != null) {
			HttpSession session = request.getSession(false);
			int isLogin;
			Attendance attendance = attendanceService.findByUserID(user.getUserId());
			isLogin = attendance.getLogin();
			if (isLogin == (short) 1) {
				session.setAttribute("login_logout", "Logout");
			} else {
				session.setAttribute("login_logout", "Login");
			}

			session.setAttribute("name", user.getUsername());
			session.setAttribute("user_id", user.getUserId());
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
		int isLogin;
		// session.removeAttribute("login_logout");
		if (login_logout.equalsIgnoreCase("login")) {
			isLogin = 0;
			session.setAttribute("login_logout", "Logout");
		} else {
			isLogin = 1;
			session.setAttribute("login_logout", "Login");
		}
		attendanceService.setLoginByUserID(isLogin, Integer.parseInt(session.getAttribute("user_id").toString()));
		return "attendance";
	}

	@RequestMapping(value = "/attendance", method = RequestMethod.GET)
	public String attendance_login_logout() {
		User user = securityService.findLoggedInUser();
		return "attendance";
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String report(Model model, HttpServletRequest request) {

		return "report";
	}
}
