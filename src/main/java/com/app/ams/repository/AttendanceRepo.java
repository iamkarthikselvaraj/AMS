package com.app.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.ams.model.Attendance;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
	// @Query(value = "SELECT * FROM attendance WHERE emp_id = ?1", nativeQuery =
	// true)
	Attendance findByEmpId(int emp_id);

	@Query(value = "update attendance a set a.is_logged_in = ?1 where a.emp_id=?2", nativeQuery = true)
	void setIsLoggedInByEmpId(int is_logged_in, int emp_id);
}
