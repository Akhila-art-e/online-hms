package com.project.vo;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserVO {

	private String userID;
	
	@NotBlank(message = "Email Id should not be blank")
	@NotNull(message = "Email ID should not be null")
	@Email(message = "Email format is not valid")
	private String emailID;
	
	@NotBlank(message = "Password should not be blank")
	@NotNull(message = "Password Should not be null")
	private String password;
	
	@NotBlank(message = "Confirm Password should not be blank")
	@NotNull(message = "Confirm password should not be null")
	private String retypePassword;
	
	@NotBlank(message = "Name should not be blank")
	@NotNull(message = "Name should not be null")
	@Pattern(regexp = "(^[\\p{L} .'-]+$)", message = "Name should not have special symbols")
	private String name;
	
	@NotBlank(message = "Phone number should not be blank")
	@NotNull(message = "Phone number should not be null")
	@Pattern(regexp="(^$|[0-9]{10})")
	private String phoneNo;
	
	
	@NotBlank(message = "Address should not be blank")
	@NotNull(message = "Address should not be null")
	private String address;

	private LocalDate regDate = LocalDate.now(); 
	
	public UserVO(String userID, String emailID, String password, String retypePassword, String name, String phoneNo,
			LocalDate regDate, String address) {
		super();
		this.userID = userID;
		this.emailID = emailID;
		this.password = password;
		this.retypePassword = retypePassword;
		this.name = name;
		this.phoneNo = phoneNo;
		this.regDate = regDate;
		this.address = address;
	}
	
	public UserVO() {
		
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
