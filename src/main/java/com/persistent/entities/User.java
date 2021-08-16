package com.persistent.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {  //User can be a doctor or a patient

	@Id
	private String userName;  //user_name of patient or doctor should be unique
	
	private String password;
	
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
