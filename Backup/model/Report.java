package com.app.ams.model;
// default package

// Generated Jan 31, 2018 8:48:00 PM by Hibernate Tools 5.0.6.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Report generated by hbm2java
 */
@Entity
@Table(name = "report", catalog = "attendance")
public class Report implements java.io.Serializable {

	private Integer id;
	private Attendance attendance;
	private Date date;
	private String day;
	private Date timeOfLogin;
	private Date timeOfLogout;
	private Integer workedHours;
	private String flag;
	private Date lastUpdated;
	private Set<Attendance> attendances = new HashSet<Attendance>(0);

	public Report() {
	}

	public Report(Attendance attendance, Date date, String day, Date timeOfLogin, Date timeOfLogout,
			Integer workedHours, String flag) {
		this.attendance = attendance;
		this.date = date;
		this.day = day;
		this.timeOfLogin = timeOfLogin;
		this.timeOfLogout = timeOfLogout;
		this.workedHours = workedHours;
		this.flag = flag;

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public Attendance getAttendance() {
		return this.attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "day", length = 45)
	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "time_of_login", length = 8)
	public Date getTimeOfLogin() {
		return this.timeOfLogin;
	}

	public void setTimeOfLogin(Date timeOfLogin) {
		this.timeOfLogin = timeOfLogin;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "time_of_logout", length = 8)
	public Date getTimeOfLogout() {
		return this.timeOfLogout;
	}

	public void setTimeOfLogout(Date timeOfLogout) {
		this.timeOfLogout = timeOfLogout;
	}

	@Column(name = "worked_hours")
	public Integer getWorkedHours() {
		return this.workedHours;
	}

	public void setWorkedHours(Integer workedHours) {
		this.workedHours = workedHours;
	}

	@Column(name = "flag", length = 45)
	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated", length = 19)
	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "report")
	public Set<Attendance> getAttendances() {
		return this.attendances;
	}

	public void setAttendances(Set<Attendance> attendances) {
		this.attendances = attendances;
	}

}
