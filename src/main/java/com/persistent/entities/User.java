package com.persistent.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {  //User can be a doctor or a patient

	@Id
	@NotBlank
	private String userName;  //user_name of patient or doctor should be unique
	
	@NotBlank
	@Size(min = 2, max = 20, message = "Password should be 2-20 characters long")
	private String password;
	
	@NotBlank
	private String type;

	public User() {}
	
	public User(String userName, String password, String type) {
		this.userName = userName;
		this.password = password;
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", type=" + type + "]";
	}
	
	
	
	
}
