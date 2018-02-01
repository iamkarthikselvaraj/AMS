package com.app.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ams.model.Report;

public interface ReportRepo extends JpaRepository<Report, Long> {

}
