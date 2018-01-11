package com.app.ams.service;

import com.app.ams.model.Attendance;

public interface AttendanceService {
	Attendance findByEmp_id(int emp_id);
}
