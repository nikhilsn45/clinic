package com.persistent.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.persistent.service.DoctorService;
import com.persistent.service.PatientService;

@Controller
public class HomeController {
	
	@Autowired
	private DoctorService dserv;
	
	@Autowired
	private PatientService pserv;
	
	public HomeController() {
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request)
	{
		return "mainpage";
	}
	
	@RequestMapping("/about")
	public String about()
	{
		return "about";
	}
	
	@RequestMapping("/")
	public String defaultAfterLogin(HttpServletRequest request) {

		 Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 User user = (User) authentication;
		 
		 System.out.println("cread " + user.getAuthorities());
	        
		 if (user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_doctor"))) {
			 return "redirect:/doctor_home";
			}
		 else if(user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_admin")))
			 return "redirect:/admin";
		return "redirect:/patient_home";
	        
	}
	
	public DoctorService getDserv() {
		return dserv;
	}

	public void setDserv(DoctorService dserv) {
		this.dserv = dserv;
	}

	public PatientService getPserv() {
		return pserv;
	}

	public void setPserv(PatientService pserv) {
		this.pserv = pserv;
	}
	
	
	

}
