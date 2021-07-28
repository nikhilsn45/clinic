package com.persistent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.persistent.entities.DoctorInfo;
import com.persistent.entities.User;
import com.persistent.entities.UserInfo;
import com.persistent.service.DoctorService;
import com.persistent.service.UserCreadService;

@Controller
public class DoctorController {
	
	
	@Autowired
	private DoctorService serv;
	
	@Autowired
	private UserCreadService creadServ;
	
	@RequestMapping(path="/save_doctor", method=RequestMethod.POST)
	public String save_doctor(@ModelAttribute DoctorInfo dInfo, @ModelAttribute User u)
	{
		System.out.println(dInfo);
		System.out.println(u);
		
		serv.addDoctor(dInfo);
		creadServ.addUser(u);
		
		return "redirect:/doctorHome";//"user_home.jsp" called
	
	}
	
	@RequestMapping(path="/doctorHome", method=RequestMethod.GET)
	public String doctor_home(@ModelAttribute DoctorInfo d)
	{
		return "doctor_home";//"user_home.jsp" called
	}
	
}
