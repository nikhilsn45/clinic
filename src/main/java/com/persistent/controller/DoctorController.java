package com.persistent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String book_slot(@ModelAttribute Appointment app,Model m)
	{
		appserv.addAppointment(app);// saved an appointment in Appointment Table
		Doctor d=docService.findDoctorByUserName(app.getDoctorUserName());//To display required doctor's details
		Patient p=pserv.findPatientByUserName(app.getPatientUserName());//To display required patient's details
		m.addAttribute("doc",d);
		m.addAttribute("pat",p);
		
		return "book_response";
	}
	
//@RequestParam String doctorUserName,@RequestParam String status,@RequestParam String patientUserName,@RequestParam String timing,	
	
}
