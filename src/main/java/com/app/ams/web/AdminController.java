package com.app.ams.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.ams.model.Privilege;
import com.app.ams.model.User;
import com.app.ams.service.AdminService;
import com.app.ams.validator.UserValidator;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	// @RequestMapping(method = RequestMethod.POST)
	public String createEmployee(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model,
			HttpServletRequest req) {
		userValidator.validate(user, bindingResult);
		// String p = req.getParameter("privilege");
		List<Privilege> privileges = adminService.getPrivilegeList();
		model.addAttribute("privilegeList", privileges);
		if (bindingResult.hasErrors()) {
			return "createUser";
		}

		adminService.createUser(user);

		model.addAttribute("userForm", new User());
		return "createUser";
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public String createEmployee(Model model) {
		model.addAttribute("userForm", new User());
		List<Privilege> privileges = adminService.getPrivilegeList();
		model.addAttribute("privilegeList", privileges);
		return "createUser";
	}

	@RequestMapping(value = "/listUsers", method = RequestMethod.GET)
	public ModelAndView listUsers(@ModelAttribute("user") User user) {
		List<User> users = adminService.findAllUsers();
		ModelAndView map = new ModelAndView("listUsers");
		map.addObject("users", users);
		// model.addAttribute("users", users);
		return map;
	}

	// delete user
	@RequestMapping(value = "/users/{id}/delete", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id) {
		adminService.deleteByUserId(id);
		return "listUsers";

	}

}
