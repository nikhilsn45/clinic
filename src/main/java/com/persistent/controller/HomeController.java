package com.persistent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.persistent.entities.Doctor;
import com.persistent.entities.Patient;
import com.persistent.entities.User;
import com.persistent.exceptions.DetailsNotFoundException;
import com.persistent.exceptions.IncorrectPasswordException;
import com.persistent.exceptions.UserNotFoundException;
import com.persistent.service.DoctorService;
import com.persistent.service.PatientService;
import com.persistent.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private DoctorService dserv;
	
	@Autowired
	private PatientService pserv;
	
	@Autowired
	private UserService userv;
	
	public HomeController() {
	}

	@RequestMapping("/")
	public String home()
	{
		return "mainpage";
	}
	
	
	@RequestMapping("/doctor_signup")
	public String doctor_signup()
	{
		return "doctor_signup";
	}
	
	@RequestMapping("/patient_signup")
	public String user_signup()
	{
		return "patient_signup";
	}
	
	@RequestMapping("/about")
	public String about()
	{
		return "about";
	}
	
	@RequestMapping("/home")
	public String login_user(@ModelAttribute User u,Model m)
	{	
		//if(userv.getUserByUserNameAndPassword(u.getUserName(), u.getPassword()) == null)
			//throw new UserNotFoundException(u.getUserName() + " not found in database!!!");

		if(userv.getUserByUserName(u.getUserName()) == null)
			throw new UserNotFoundException(u.getUserName() + " not found in database!!!");
		else if(!(userv.checkPasswordForUserName(u.getUserName()).equals(u.getPassword())))
			throw new IncorrectPasswordException("Incorrect Password!!");
		
		System.out.println("entered");
		System.out.println(u);
		if((u.getType()).equals("doctor")) 
		{
			System.out.println("Doctor Service Called");
			Doctor d1 =dserv.findDoctorByUserName(u.getUserName());
			if(d1!= null) {
				System.out.println(d1);
				m.addAttribute("doc", d1);
				return "doctor_home";
				
			}
			else 
				throw new DetailsNotFoundException("There are no details for this doctor in the database");
				
		}
		else
		{
			if((u.getType()).equals("patient"))
			{
				System.out.println("Patient Service Called");
				Patient p1 =pserv.findPatientByUserName(u.getUserName());
				if(p1 != null) {
					System.out.println(p1);
					m.addAttribute("pat", p1);
					return "patient_home";
						
				}
				else 
					throw new DetailsNotFoundException("There are no details for this patient in the database");
			}
			else
				return "error";
		}
		
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
