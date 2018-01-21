package com.app.ams.model;
// Generated Jan 20, 2018 7:35:45 PM by Hibernate Tools 5.2.6.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Privilege generated by hbm2java
 */
@Entity
@Table(name = "privilege", catalog = "attendance")
public class Privilege implements java.io.Serializable {

	private Integer privilegeId;
	private int privilege;
	private String access;
	private Date lastUpdated;
	private Set<User> users = new HashSet<User>(0);

	public Privilege() {
	}

	public Privilege(int privilege) {
		this.privilege = privilege;
	}

	public Privilege(int privilege, String access, Date lastUpdated, Set<User> users) {
		this.privilege = privilege;
		this.access = access;
		this.lastUpdated = lastUpdated;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "privilege_id", unique = true, nullable = false)
	public Integer getPrivilegeId() {
		return this.privilegeId;
	}

	public void setPrivilegeId(Integer privilegeId) {
		this.privilegeId = privilegeId;
	}

	@Column(name = "privilege", nullable = false)
	public int getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	@Column(name = "access", length = 45)
	public String getAccess() {
		return this.access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated", length = 19)
	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "privilege")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Privilege [privilegeId=" + privilegeId + ", privilege=" + privilege + ", access=" + access
				+ ", lastUpdated=" + lastUpdated + ", users=" + users + "]";
	}

}
