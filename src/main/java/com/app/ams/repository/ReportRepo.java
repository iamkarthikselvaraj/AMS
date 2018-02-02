package com.app.ams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ams.model.Report;
import com.app.ams.model.User;

public interface ReportRepo extends JpaRepository<Report, Long> {
	List<Report> findAllByUser(User User);

	// Report findByAttendance(Attendance attendance);
}
