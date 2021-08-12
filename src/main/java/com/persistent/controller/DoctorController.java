package com.persistent.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.persistent.dto.AppointmentDto;
import com.persistent.dto.DoctorDto;
import com.persistent.entities.Appointment;
import com.persistent.entities.Doctor;
import com.persistent.entities.Patient;
import com.persistent.entities.User;
import com.persistent.service.AppointmentService;
import com.persistent.service.DoctorService;
import com.persistent.service.PatientService;
import com.persistent.service.UserService;

@Controller
public class DoctorController {
	
	Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private DoctorService docService;
	
	@Autowired
	private PatientService pserv;
	
	@Autowired
	private UserService creadServ;
	
	@Autowired
	private AppointmentService appserv;
	
	@RequestMapping(path="/save_doctor", method=RequestMethod.POST)
	public String save_doctor(@ModelAttribute DoctorDto dInfo, @ModelAttribute User u)
	{
		logger.trace("Save doctor method called");
		System.out.println(dInfo);
		System.out.println(u);
		
		
		docService.addDoctor(dInfo.conToDoctor());
		creadServ.addUser(u);
		logger.info("Doctor saved to database");
		
		return "redirect:/";
	
	}
	
//@RequestParam String doctorUserName,@RequestParam String status,@RequestParam String patientUserName,@RequestParam String timing,	
	
}
