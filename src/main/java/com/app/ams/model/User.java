package com.app.ams.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	private int id;
	private int userId;
	private String username;
	private String password;
	private int privilage;

	// private EmployeeDetail employeeDetail;
	// private Attendance attendance;

	public User() {

	}

	public User(String username, EmployeeDetail employeeDetail) {
		// this.employeeDetail = employeeDetail;
		this.username = username;
	}

	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "privilage")
	public int getPrivilage() {
		return privilage;
	}

	public void setPrivilage(int privilage) {
		this.privilage = privilage;
	}

	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "user_id")
	// public EmployeeDetail getEmployeeDetails() {
	// return employeeDetail;
	// }
	//
	// public void setEmployeeDetails(EmployeeDetail employeeDetail) {
	// this.employeeDetail = employeeDetail;
	// }
	//
	// // @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	// public Attendance getAttendance() {
	// return attendance;
	// }
	//
	// public void setAttendance(Attendance attendance) {
	// this.attendance = attendance;
	// }

}
