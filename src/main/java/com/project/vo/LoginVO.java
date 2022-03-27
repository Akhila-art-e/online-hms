package com.project.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class LoginVO {
	
	@NotNull(message = "email id should not be null")
	@Email(message = "email id should be in proper format")
	private String email;
	
	@NotNull(message = "Password should not be null")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginVO [email=" + email + ", password=" + password + "]";
	}

}
