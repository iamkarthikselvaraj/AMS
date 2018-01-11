package com.app.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.ams.model.Attendance;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
	// @Query(value = "SELECT * FROM attendance WHERE emp_id = ?1", nativeQuery =
	// true)
	Attendance findByEmpId(int emp_id);
}
