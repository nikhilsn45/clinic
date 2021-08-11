package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.UserDao;
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
	
	public void addUser(User u)
	{
		udao.save(u);
	}
	
	/*public User getUserByUserNameAndPassword(String un, String p)
	{
		return udao.findUserByUserNameAndPassword(un,p);
	}*/
	
	public User getUserByUserName(String un) {
		return udao.findUserByUserName(un);
	}

	public String checkPasswordForUserName(String un) {
		User u = getUserByUserName(un);
		return u.getPassword();
	}
	
	

}
