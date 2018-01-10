package com.nexware.ams.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nexware.ams.service.UserService;

@Service
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) {
		// HttpServletRequest req=
		String strUserName = request.getParameter("username");
		if (userService.findByUsername(strUserName) != null) {
			// model.addAttribute("message", "You have been logged in successfully.");
			return "attendance";
		} else {
			model.addAttribute("error", "Your username and password is invalid.");
		}
		return "login";
	}

	// public stai
}
