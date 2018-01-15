package com.app.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ams.model.EmployeeDetail;

public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetail, Long> {

}
