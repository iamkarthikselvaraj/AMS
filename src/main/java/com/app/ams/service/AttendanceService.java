package com.app.ams.service;

import com.app.ams.model.Attendance;

public interface AttendanceService {
	Attendance findByEmp_id(int emp_id);

	void setIsLoggedInByEmpId(int is_logged_in, int emp_id);
}
