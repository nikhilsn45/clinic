package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.UserDao;
import com.persistent.entities.Doctor;
import com.persistent.entities.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao udao;

	public UserService(UserDao udao) {
		this.udao = udao;
	}

	public UserService() {
	}
	
	public void addUser(User d)
	{
		udao.save(d);
	}

	
	
	

}
