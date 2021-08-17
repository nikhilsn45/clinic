package com.persistent.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.persistent.dto.DoctorDto;
import com.persistent.dto.PatientDto;
import com.persistent.entities.Appointment;
import com.persistent.entities.Doctor;
import com.persistent.entities.Patient;
import com.persistent.entities.VerifyReq;
import com.persistent.service.AppointmentService;
import com.persistent.service.DoctorService;
import com.persistent.service.PatientService;

@Controller
public class AdminController {

		
	Logger logger = LoggerFactory.getLogger(AdminController.class);

	
	@Autowired
	private DoctorService docService;
	
	@Autowired
	private PatientService pserv;
	
	@Autowired
	private AppointmentService appserv;
	
	
	

		
		public AdminController(DoctorService docService, PatientService pserv, AppointmentService appserv) {
		super();
		this.docService = docService;
		this.pserv = pserv;
		this.appserv = appserv;
	}


		@RequestMapping("/admin")
		public String home(Model m)
		{

			logger.info("Admin logged in");
			//@ModelAttribute Doctor d
			//admin will access the Database to check and verify doctors by contacting DoctorService

			List<Doctor> docList=docService.getEachAndEveryDoctor();
			List<Patient> patList=pserv.getEachAndEveryPatient();
			List<Appointment> appList=appserv.getEachAndEveryAppointment();
			List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();
			
			List<DoctorDto> docpend = new ArrayList<DoctorDto>();
			List<DoctorDto> docacce = new ArrayList<DoctorDto>();
			List<PatientDto> patdto = new ArrayList<PatientDto>();
			
			logger.trace("Started filtering doctor's list according to verification status.");
			System.out.println("Started Filtering doctors List");
			for (Iterator<Doctor> iterator = docList.iterator(); iterator.hasNext();) {
				Doctor doctor = (Doctor) iterator.next();
				DoctorDto ddto=new DoctorDto(doctor);
				
				if(doctor.getVerification().equals("pending"))
					docpend.add(ddto);
				else
					docacce.add(ddto);
			}
			
			logger.trace("List of all the registered patients.");
			for (Iterator<Patient> iterator = patList.iterator(); iterator.hasNext();) {
				Patient patient = (Patient) iterator.next();
				PatientDto pdto=new PatientDto(patient);
				patdto.add(pdto);

			}
			
			logger.trace("List of all the appointments.");
			for (Iterator<Appointment> iterator = appList.iterator(); iterator.hasNext();) {
				Appointment appointment = (Appointment) iterator.next();
				Map<String,Object> map = new HashMap<>();
				map.put("id", appointment.getId());
				map.put("timing", appointment.getTiming());
				map.put("docname", appointment.getDoc().getfName()+" "+appointment.getDoc().getlName());
				map.put("doccontact", appointment.getDoc().getContactNo().toString());
				map.put("docaddress", appointment.getDoc().getAddress().getCity() + ", " + appointment.getPat().getAddress().getState());
				map.put("patname", appointment.getPat().getfName()+" "+appointment.getPat().getlName());
				map.put("patcontact", appointment.getPat().getContactNo().toString());
				map.put("pataddress", appointment.getPat().getAddress().getCity() + ", " + appointment.getPat().getAddress().getState());
				map.put("status", appointment.getStatus());
				map.put("feed", appointment.getFeed());
				maps.add(map);
			}
			m.addAttribute("docpend", docpend);//Pending Doctors list
			m.addAttribute("docacce", docacce);//Verified Doctors list
			
			m.addAttribute("patList", patdto);//All Patients List
			m.addAttribute("appList", maps);//All Appointments List

			return "admin_home";
		}
		
		
		@RequestMapping("/verify_doctor")
		public @ResponseBody String verify_doctor(VerifyReq uq)
		{
			Doctor d=docService.findDoctorByUserName(uq.getReq());
			d.setVerification("Verified");
			docService.addDoctor(d);
			logger.trace("Doctor verified.");
			return "Verified doctor";
		}
		
		@RequestMapping("/reject_doctor")
		public @ResponseBody String reject_doctor(VerifyReq uq)
		{
			Doctor d=docService.findDoctorByUserName(uq.getReq());
			d.setVerification("Rejected");
			docService.addDoctor(d);
			logger.trace("Doctor rejected.");
			return "Rejected Verification of doctor";
		}
		
		
		
		

}
