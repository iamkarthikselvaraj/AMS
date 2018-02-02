package com.app.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.app.ams.model.Attendance;
import com.app.ams.model.User;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {

	Attendance findByUserId(Integer user);

	@Transactional
	@Modifying
	@Query(value = "update attendance a set a.login = ?1 where a.user_id=?2", nativeQuery = true)
	void setLoginByUserID(int isLogin, int user_id);

}
