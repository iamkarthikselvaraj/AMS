package com.app.ams.service;

import com.app.ams.model.Attendance;
import com.app.ams.model.Report;

public interface AttendanceService {

	void createReport(Report report);

	void updateAttendance(Attendance attendance);

	void setLoginByUserID(int isLogin, int user_id);
}
