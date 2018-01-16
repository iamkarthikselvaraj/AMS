package com.app.ams.service;

import com.app.ams.model.Attendance;

public interface AttendanceService {
	Attendance findByUserID(int user_id);

	void setIsLoggedInByUserID(int is_logged_in, int user_id);
}
