package com.persistent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping({"/","/home"})//  src/main/webapp/views/home.jsp will be called
	public String home()
	{
		return "mainpage";
	}
	
	@RequestMapping("/doctor_signup")
	public String doctor_signup()
	{
		return "doctor_signup";
	}
	
	@RequestMapping("/user_signup")//user_signup.jsp called
	public String user_signup()
	{
		return "user_signup";
	}
	
	

}
