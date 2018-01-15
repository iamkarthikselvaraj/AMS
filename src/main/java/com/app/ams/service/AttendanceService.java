package com.app.ams.service;

import com.app.ams.model.Attendance;

public interface AttendanceService {
	Attendance findByUserID(int emp_id);

	void setIsLoggedInByEmpId(int is_logged_in, int emp_id);
}
