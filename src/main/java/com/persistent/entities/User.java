package com.persistent.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {  //User can be a doctor or a patient

	@Id
	private String user_name;  //user_name of patient or doctor should be unique
	private String password,type;

	public User() {}
	
	public User(String user_name, String password, String type) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.type = type;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
		return "User [user_name=" + user_name + ", password=" + password + ", type=" + type + "]";
	}
	
	
	
	
}
