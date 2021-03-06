package com.app.ams.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.ams.model.User;
import com.app.ams.service.UserService;

@Component
public class UserValidator implements Validator {
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;

		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		// if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
		// errors.rejectValue("username", "Size.userForm.username");
		// }
		if (userService.findByEmail(user.getEmail()) != null) {
			errors.rejectValue("email", "Duplicate.userForm.email");
		}

		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		// if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
		// errors.rejectValue("password", "Size.userForm.password");
		// }

		// if (!user.getPasswordConfirm().equals(user.getPassword())) {
		// errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		// }
	}
}
