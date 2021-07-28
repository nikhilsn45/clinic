package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.CreadDao;
import com.persistent.entities.DoctorInfo;
import com.persistent.entities.User;
import com.persistent.entities.UserInfo;

@Service
public class UserCreadService {
	
	@Autowired
	private CreadDao udao;

	public UserCreadService(CreadDao udao) {
		this.udao = udao;
	}

	public UserCreadService() {
	}
	
	public void addUser(User u)
	{
		udao.save(u);
	}
	
	public User getUser(String user_name)
	{
		return null;//udao.findByUser_Name(user_name);
	}

	
	
	

}
