package com.app.ams.web;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
			HttpServletRequest req) throws ParseException {
		userValidator.validate(user, bindingResult);
		String p = req.getParameter("privileg");
		if (bindingResult.hasErrors()) {
			List<Privilege> privileges = adminService.getPrivilegeList();
			model.addAttribute("privilegeList", privileges);
			return "createUser";
		}
		Privilege privilege = new Privilege();
		// adminService.getPrivilegeById(Integer.parseInt(p));
		privilege.setPrivilegeId(Integer.parseInt(p));
		user.setPrivilege(privilege);
		// user.getPrivilege().setPrivilege();
		adminService.createUser(user);
		// Attendance attendance = new Attendance(user, 0);
		// adminService.createEmployee(attendance);

		return "createUser";
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public String createEmployee(Model model) {
		model.addAttribute("userForm", new User());
		List<Privilege> privileges = adminService.getPrivilegeList();
		model.addAttribute("privilegeList", privileges);
		return "createUser";
	}
}
