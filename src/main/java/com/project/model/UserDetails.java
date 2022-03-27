package com.project.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
	@Id
	@Column(name = "UserID", nullable = false, columnDefinition = "VARCHAR(10)")
	private String userid;

	@Column(name = "Name", nullable = false, columnDefinition = "VARCHAR(20)")
	private String name;

	@Column(name = "EMAIL_ID", nullable = false, columnDefinition = "VARCHAR(50)", unique = true)
	private String emailId;

	@Column(name = "PH_NO", nullable = false)
	private String ph_no;

	@Column(name = "ADDRESS", nullable = false, columnDefinition = "VARCHAR(100)")
	private String address;

	@Column(name = "DATE_OF_REG", nullable = false, columnDefinition = "DATE")
	private LocalDate dateOfReg;

	@Column(name = "USER_PASS", nullable = false, columnDefinition = "VARCHAR(20)")
	private String password;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_id() {
		return emailId;
	}

	public void setEmail_id(String email_id) {
		this.emailId = email_id;
	}

	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPh_no() {
		return ph_no;
	}

	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUser_pass() {
		return password;
	}

	public void setUser_pass(String user_pass) {
		this.password = user_pass;
	}

	public LocalDate getDateOfReg() {
		return dateOfReg;
	}

	public void setDateOfReg(LocalDate dateOfReg) {
		this.dateOfReg = dateOfReg;
	}

	@Override
	public String toString() {
		return "UserDetails [userid=" + userid + ", name=" + name + ", email_id=" + emailId + ", ph_no=" + ph_no
				+ ", address=" + address + ", dateOfReg=" + dateOfReg + ", user_pass=" + password + "]";
	}

}
