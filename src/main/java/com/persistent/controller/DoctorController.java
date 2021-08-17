package com.persistent.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.persistent.dto.DoctorDto;
import com.persistent.entities.Appointment;
import com.persistent.entities.Doctor;
import com.persistent.entities.UpdateReq;
import com.persistent.entities.User;
import com.persistent.exceptions.DuplicateUserFoundException;
import com.persistent.service.AppointmentService;
import com.persistent.service.DoctorService;
import com.persistent.service.UserService;

@Controller
public class DoctorController {

	
	Logger logger = LoggerFactory.getLogger(DoctorController.class);
	

	@Autowired
	private DoctorService docService;

	@Autowired
	private UserService creadServ;

	@Autowired
	private AppointmentService appServ;
	
	

	public DoctorController(DoctorService docService, UserService creadServ, AppointmentService appServ) {
		super();
		this.docService = docService;
		this.creadServ = creadServ;
		this.appServ = appServ;
	}

	@RequestMapping("/doctor_signup")
	public String doctor_signup(DoctorDto doctorDto, Model model)
	{
		logger.trace("Doctor signup page called.");
		model.addAttribute("doctorDto",doctorDto);
		return "doctor_signup";
	}

	@RequestMapping(path="/doctor_signup", method=RequestMethod.POST)
	public String save_doctor(@Valid @ModelAttribute DoctorDto doctorDto, BindingResult result,Model model)
	{
		
		System.out.println(doctorDto);
		System.out.println();

		model.addAttribute("doctorDto",doctorDto);
		
		// add exception here
		Doctor d = docService.findDoctorByUserName(doctorDto.getUserName());
		if(d != null) {
			logger.error("Username already exists in the database!!");
			result.rejectValue("userName", null, "Username already exists.");
		}	
		
		if (result.hasErrors()) {
            return "doctor_signup";
        }
		
		docService.addDoctor(doctorDto.conToDoctor());

		creadServ.addUser(new User(doctorDto.getUserName(),doctorDto.getPassword(),doctorDto.getType()));

		logger.info("Doctor saved to database");


		return "redirect:/doctor_signup?success";

	}

	@RequestMapping("/doctor_home")
	public String docHome(Model model)
	{
		logger.info("Doctor logged in.");
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication;
		
		Doctor doc = docService.findDoctorByUserName(user.getUsername());
		System.out.println(doc);
		DoctorDto docDto = new DoctorDto(doc);
		model.addAttribute("doc",docDto);
		logger.trace("Fetching appointments.");
		//System.out.println("Started Fetching Appointments");
		
		List<Appointment> appoints= appServ.getAllAppointmentDoc(doc.getUserName());
		System.out.println(appoints);
		
		List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> mapsaccepted = new ArrayList<Map<String,Object>>();

		logger.trace("Filtering appointment list based on status.");
		//System.out.println("Started Filtering Appointments List");
		for (Iterator<Appointment> iterator = appoints.iterator(); iterator.hasNext();) {
			Appointment appointment = (Appointment) iterator.next();
			Map<String,Object> map = new HashMap<>();
			map.put("id", appointment.getId());
			map.put("timing", appointment.getTiming());
			map.put("name", appointment.getPat().getfName()+" "+appointment.getPat().getlName());
			map.put("age", appointment.getPat().getAge());
			map.put("contact", appointment.getPat().getContactNo().toString());
			map.put("address", appointment.getPat().getAddress().getCity() + ", " + appointment.getPat().getAddress().getState());
			map.put("status", appointment.getStatus());
			if(appointment.getStatus().equals("pending"))
				maps.add(map);
			else
				mapsaccepted.add(map);
			
		}
		
		System.out.println(maps);
		model.addAttribute("appoints", maps);
		model.addAttribute("appointsAccept", mapsaccepted);
		return "doctor_home";
	}

	@RequestMapping(path="/accept_appo_status", method=RequestMethod.POST)
	public @ResponseBody String alter_appo_status(UpdateReq uq)
	{
		//System.out.println("Entered for Accepting Appointment");
		System.out.println(uq);
		Appointment apppooo =appServ.getAppointment(uq.getReq());
		apppooo.setStatus("accepted");
		appServ.updateAppoStatus(apppooo);
		logger.info("Appointment accepted.");

		return "Accepted Appointment";

	}

	@RequestMapping(path="/reject_appo_status", method=RequestMethod.POST)
	public @ResponseBody String reject_appo_status(UpdateReq uq)
	{
		//System.out.println("Entered for Rejecting Appointment");
		System.out.println(uq);
		Appointment apppooo =appServ.getAppointment(uq.getReq());
		apppooo.setStatus("rejected");
		appServ.updateAppoStatus(apppooo);
		logger.info("Appointment rejected.");

		return "Rejected Appointment";

	}


}
