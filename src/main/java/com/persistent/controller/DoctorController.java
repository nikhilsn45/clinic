package com.persistent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.persistent.entities.DoctorInfo;
import com.persistent.entities.User;
import com.persistent.service.DoctorService;
import com.persistent.service.UserService;

@Controller
public class DoctorController {
	
	
	@Autowired
	private DoctorService serv;
	
	@Autowired
	private UserService creadServ;
	
	@RequestMapping(path="/save_doctor", method=RequestMethod.POST)
	public String save_doctor(@ModelAttribute DoctorInfo dInfo, @ModelAttribute User u)
	{
		System.out.println(dInfo);
		System.out.println(u);
		
		serv.addDoctor(dInfo);
		creadServ.addUser(u);
		
		return "redirect:/home";
	
	}
	
	@RequestMapping(path="/doctor_home", method=RequestMethod.GET)
	public String doctor_home(@ModelAttribute DoctorInfo d)
	{
		
		return "doctor_home";//"user_home.jsp" called
	}
	
}
