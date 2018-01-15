package com.app.ams.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_details")
public class EmployeeDetails {

	private int id;
	private String empCode;
	@Column(name = "name")
	private String name;
	@Column(name = "father_name")
	private String father_name;
	@Column(name = "email")
	private String email;
	@Column(name = "present_address")
	private String present_address;
	@Column(name = "permanent_address")
	private String permanent_address;
	@Column(name = "mobile_number")
	private String mobile_number;
	@Column(name = "designation")
	private String designation;
	@Column(name = "gender")
	private String gender;
	@Column(name = "doj")
	private Date doj;
	@Column(name = "dob")
	private Date dob;
	private User user;

	public EmployeeDetails(String name, User user) {
		super();
		this.name = name;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "emp_code")
	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPresent_address() {
		return present_address;
	}

	public void setPresent_address(String present_address) {
		this.present_address = present_address;
	}

	public String getPermanent_address() {
		return permanent_address;
	}

	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@OneToOne(mappedBy = "employeeDetails")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
