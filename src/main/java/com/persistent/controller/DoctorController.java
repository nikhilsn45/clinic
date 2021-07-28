package com.persistent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.persistent.entities.Doctor;
import com.persistent.service.DoctorService;

@Controller
public class DoctorController {
	
	
	@Autowired
	private DoctorService serv;
	
	@RequestMapping("/doctor_signup")
	public String doctor_signup()
	{
		return "doctor_signup";
	}

	@RequestMapping(path="/save_doctor", method=RequestMethod.POST)
	public String save_doctor(@ModelAttribute Doctor d)
	{
		serv.addDoctor(d);
		return "doctor_profile";
		
	
	}
	
	@RequestMapping("/user_search_results")
	public String  user_search_results(@RequestParam String type,@RequestParam String state,@RequestParam String city )
	{
		// Connect to doctor's Database
		//retrieve results and display
		return "user_search_results";
	}
}
