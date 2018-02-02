package com.app.ams.model;
// default package

// Generated Feb 2, 2018 9:18:58 AM by Hibernate Tools 5.0.6.Final

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Attendance generated by hbm2java
 */
@Entity
@Table(name = "attendance", catalog = "attendance")
public class Attendance implements java.io.Serializable {

	private int userId;
	private Report report;
	private User user;
	private Integer login;
	private Date lastUpdated;

	public Attendance() {
	}

	public Attendance(User user, Integer login) {
		this.user = user;
		this.login = login;
	}

	public Attendance(Report report, User user, Integer login, Date lastUpdated) {
		this.report = report;
		this.user = user;
		this.login = login;
		this.lastUpdated = lastUpdated;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "user_id", unique = true, nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "report_id")

	public Report getReport() {
		return this.report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "login")
	public Integer getLogin() {
		return this.login;
	}

	public void setLogin(Integer login) {
		this.login = login;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated", length = 19)
	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
