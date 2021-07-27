package com.persistent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home")//  src/main/webapp/views/home.jsp will be called
	public String home()
	{
		return "home";
	}
	
	

}
