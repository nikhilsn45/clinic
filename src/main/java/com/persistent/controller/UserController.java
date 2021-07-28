package com.persistent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.persistent.entities.User;
import com.persistent.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService serv;
	
	@RequestMapping("/user_signup")//user_signup.jsp called
	public String doctor_signup()
	{
		return "user_signup";
	}

	@RequestMapping(path="/save_user", method=RequestMethod.POST)
	public String save_doctor(@ModelAttribute User u)
	{
		serv.addUser(u);
		
		return "user_profile";//"user_profile.jsp" called
	}

}
