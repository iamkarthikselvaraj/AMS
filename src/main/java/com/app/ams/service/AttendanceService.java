package com.app.ams.service;

import com.app.ams.model.Attendance;

public interface AttendanceService {
	Attendance findByUserID(int user_id);

	void setLoginByUserID(int isLogin, int user_id);
}
