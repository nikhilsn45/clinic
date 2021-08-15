package com.persistent.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.persistent.entities.Appointment;
import com.persistent.entities.Doctor;
import com.persistent.entities.Patient;


import com.persistent.exceptions.DuplicateUserFoundException;

import com.persistent.service.AppointmentService;

import com.persistent.service.DoctorService;
import com.persistent.service.PatientService;
import com.persistent.service.UserService;

@Controller
public class HomeController {
	
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private DoctorService dserv;
	
	@Autowired
	private PatientService pserv;
	
	@Autowired
	private UserService userv;
	
	@Autowired
	private AppointmentService appServ;
	
	public HomeController() {
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request)
	{
		logger.trace("-----------------------------------------------------------------------------------------");
		logger.info("Homepage called.");
		return "mainpage";
	}
	
	@RequestMapping("/about")
	public String about()
	{
		logger.info("About page called");
		return "about";
	}
	

	/*@RequestMapping("/home")
	public String login_user(@ModelAttribute User u,Model m)
	{	
		//if(userv.getUserByUserNameAndPassword(u.getUserName(), u.getPassword()) == null)
			//throw new UserNotFoundException(u.getUserName() + " not found in database!!!");

		if(userv.getUserByUserName(u.getUserName()) == null) {
			logger.error("Username not found in database");
			throw new UserNotFoundException(u.getUserName() + " not found in database!!!");
		}
		else if(!(userv.checkPasswordForUserName(u.getUserName()).equals(u.getPassword()))) {
			logger.error("Incorrect Password!!");
			throw new IncorrectPasswordException("Incorrect Password!!");
		}
		
		logger.info("User logged in");
		//System.out.println("entered");
		System.out.println(u);
		if((u.getType()).equals("doctor")) 
		{
			logger.info("Doctor Service called");
			//System.out.println("Doctor Service Called");
			Doctor d1 =dserv.findDoctorByUserName(u.getUserName());
			if(d1!= null) {
				System.out.println(d1);
				m.addAttribute("doc", d1);
				return "doctor_home";
				
			}
			else {
				logger.error("There are no details for this doctor in the database");
				throw new DetailsNotFoundException("There are no details for this doctor in the database");
			}
		}
		else
		{
			if((u.getType()).equals("patient"))
			{
				logger.info("Patient service called");
				//System.out.println("Patient Service Called");
				Patient p1 =pserv.findPatientByUserName(u.getUserName());
				if(p1 != null) {
					System.out.println(p1);
					m.addAttribute("pat", p1);
					return "patient_home";
						
				}
				else {
					logger.error("There are no details for this patient in the database");
					throw new DetailsNotFoundException("There are no details for this patient in the database");
				}
			}
			else
				return "error";
		}*/
		

	@RequestMapping("/")
	public String defaultAfterLogin(HttpServletRequest request) {

		 Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 User user = (User) authentication;
		 logger.trace("User authenticated");
		 
		 System.out.println("cread " + user.getAuthorities());
	        
		 if (user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_doctor"))) {
			 logger.trace("User directed to doctor homepage");
			 return "redirect:/doctor_home";
			}
		 else if(user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_admin"))) {
			 logger.trace("User directed to admin homepage");
			 return "redirect:/admin";
		 }
		 logger.trace("User directed to patient homepage");
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
