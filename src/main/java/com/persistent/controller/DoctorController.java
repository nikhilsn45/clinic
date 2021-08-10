package com.persistent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.persistent.convertor.AppointmentConvertor;
import com.persistent.dto.AppointmentDto;
import com.persistent.dto.DoctorDto;
import com.persistent.entities.Appointment;
import com.persistent.entities.Doctor;
import com.persistent.entities.User;
import com.persistent.service.AppointmentService;
import com.persistent.service.DoctorService;
import com.persistent.service.UserService;

@Controller
public class DoctorController {
	
	
	@Autowired
	private DoctorService docService;

    @Autowired
	private UserService creadServ;
	
	@Autowired
	private AppointmentService appserv;
	
	@Autowired
	private AppointmentConvertor appconv;
	
	
	
	@RequestMapping(path="/save_doctor", method=RequestMethod.POST)
	public String save_doctor(@ModelAttribute DoctorDto dInfo, @ModelAttribute User u)
	{
		System.out.println(dInfo);
		System.out.println(u);
		
		
		docService.addDoctor(dInfo.conToDoctor());
		creadServ.addUser(u);
		
		return "redirect:/";
	
	}
	
	@RequestMapping(path=("/doctor/{username}"), method=RequestMethod.GET)
	public String doctor_info(@PathVariable String username,Model model)
	{
		System.out.println(username);
		Doctor doc = docService.findDoctorByUserName(username);

		System.out.println("*******************\n\n\n");
		System.out.println(doc);
		
		model.addAttribute("doc",new DoctorDto(doc));
		return "doctor_info";
	}
	
	
	@RequestMapping(path=("/book_slot"), method=RequestMethod.POST)
	public String book_slot(@ModelAttribute AppointmentDto adto,Model m)
	{
		Appointment app=appconv.convertToEntity(adto);
		appserv.addAppointment(app);// saved an appointment in Appointment Table
		m.addAttribute("appointment", app);
		return "book_response";
	}
}
