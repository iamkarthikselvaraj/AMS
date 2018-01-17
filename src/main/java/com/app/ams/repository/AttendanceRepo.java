package com.app.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.app.ams.model.Attendance;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
	// @Query(value = "SELECT * FROM attendance WHERE emp_id = ?1", nativeQuery =
	// true)
	Attendance findByUserId(int user_id);

	@Transactional
	@Modifying
	@Query(value = "update attendance a set a.is_logged_in = ?1 where a.user_id=?2", nativeQuery = true)
	void setIsLoggedInByUserID(int is_logged_in, int user_id);
}
