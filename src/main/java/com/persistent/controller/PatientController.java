package com.persistent.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.persistent.dto.AppointmentDto;
import com.persistent.dto.DoctorDto;
import com.persistent.dto.PatientDto;
import com.persistent.entities.AppointAJAX;
import com.persistent.entities.Appointment;
import com.persistent.entities.Doctor;
import com.persistent.exceptions.DuplicateUserFoundException;
import com.persistent.exceptions.NoDoctorFoundException;

import com.persistent.entities.FeedBack;

import com.persistent.entities.Patient;
import com.persistent.entities.SearchAJAX;
import com.persistent.entities.User;
import com.persistent.service.AppointmentService;
import com.persistent.service.DoctorService;
import com.persistent.service.PatientService;
import com.persistent.service.UserService;

@Controller
public class PatientController {

	
	Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private PatientService serv;

	@Autowired
	private UserService creadServ;

	@Autowired
	private DoctorService docServ;

	@Autowired
	private AppointmentService appServ;
	
	
	
	public PatientController(PatientService serv, UserService creadServ, DoctorService docServ,
			AppointmentService appServ) {
		super();
		this.serv = serv;
		this.creadServ = creadServ;
		this.docServ = docServ;
		this.appServ = appServ;
	}

	@RequestMapping("/patient_signup")
	public String user_signup(PatientDto pat,Model model)
	{
		logger.trace("Patient signup page called.");
		model.addAttribute("patientDto",pat);
		return "patient_signup";
	}

	@RequestMapping(path="/patient_signup", method=RequestMethod.POST)
	public String save_patient(@Valid @ModelAttribute PatientDto patientDto, BindingResult result,Model model)
	{	
		System.out.println(patientDto);
		model.addAttribute("patientDto",patientDto);
		
		Patient p = serv.findPatientByUserName(patientDto.getUserName());
		if(p != null) {
			logger.error("Username already exists in the database!!");
			result.rejectValue("userName", null, "Username already exists.");
			
        }

        if (result.hasErrors()) {
            return "patient_signup";
        }

		serv.addPatient(patientDto.conToPatient());
		creadServ.addUser(new User(patientDto.getUserName(),patientDto.getPassword(),patientDto.getType()));

		logger.info("Patient saved to database");

		return "redirect:/patient_signup?success";//redirected to user dashboard

	}

	@RequestMapping("/patient_home")
	public String patHome(Model model)
	{
		logger.info("Patient logged in.");
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication;
		
		Patient pat = serv.findPatientByUserName(user.getUsername());
		PatientDto patDto = new PatientDto(pat);
		
		model.addAttribute("pat",patDto);
		return "patient_home";
	}

	@RequestMapping(path="/profile/{username}", method=RequestMethod.GET)
	public String user_profile(@PathVariable String username, Model model)
	{
		logger.info("User reached his/her profile page");
		System.out.println(username);
		List<Appointment> appoints= appServ.getAllAppointment(username);
		List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> mapsaccepted = new ArrayList<Map<String,Object>>();
		
		logger.trace("Appointment list is filtered based on status.");

		for (Iterator<Appointment> iterator = appoints.iterator(); iterator.hasNext();) {
			Appointment appointment = (Appointment) iterator.next();
			Map<String,Object> map = new HashMap<>();
			map.put("id", appointment.getId());
			map.put("timing", appointment.getTiming());
			map.put("fName", appointment.getDoc().getfName());
			map.put("contact", appointment.getDoc().getContactNo().toString());
			map.put("address", appointment.getDoc().getAddress().getCity() + ", " + appointment.getDoc().getAddress().getState());
			map.put("status", appointment.getStatus());
			map.put("feed", appointment.getFeed());
			if(appointment.getStatus().equals("pending"))
				maps.add(map);
			else
				mapsaccepted.add(map);

		}

		System.out.println(maps);
		model.addAttribute("pat",new PatientDto(serv.findPatientByUserName(username)));
		model.addAttribute("appoints", maps);
		model.addAttribute("appointsAccept", mapsaccepted);
		return "patient_profile";
	}

	@PostMapping("/search")
	public @ResponseBody List<DoctorDto> user_search_results(SearchAJAX t) {

		//getuser filtered list from database
		System.out.println(t.type+ " " + t.state + " " + t.city);
		List<Doctor> d = docServ.findBySpecialityAndAddress(t.type,t.state,t.city);
		List<DoctorDto> doctors = new ArrayList<DoctorDto>();
		for (Doctor doctor : d) {
			doctors.add(new DoctorDto(doctor));
		}
		logger.info("Doctor search called based on the speciality and address");
		System.out.println(doctors);
		if(doctors.size() == 0) {
			logger.error("There are no doctors of this speciality in the given area!!");
			throw new NoDoctorFoundException("There are no doctors of this speciality in your area!!");
		}
		
		//List<DoctorInfo> users = Arrays.asList(new DoctorInfo(),new DoctorInfo());
		return doctors;
	}

	@RequestMapping(path=("/doctor/{username}"), method=RequestMethod.GET)
	public String doctor_info(@ModelAttribute("pat") PatientDto pat,@PathVariable String username,Model model)
	{
		logger.info("Checkout doctor function called");
		System.out.println(username);
		Doctor doc = docServ.findDoctorByUserName(username);
		List<Appointment> list = appServ.getAllAptHaveFeedForDoctor(username);
		Float avg = appServ.getAvgRating(username);

		System.out.println("*******************\n\n\n");
		System.out.println(model.getAttribute("pat"));
		System.out.println(doc);
		System.out.println(list);
		System.out.println(avg);

		model.addAttribute("doc",new DoctorDto(doc));
		model.addAttribute("appointments",list);
		model.addAttribute("avg",avg);
		return "doctor_info";
	}


	@RequestMapping(path=("/doctor/book_slot"), method=RequestMethod.POST)
	public @ResponseBody String book_slot(AppointAJAX appoint)
	{	
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication;
			
		System.out.println(user);
		logger.trace("Slot booking function called");
		System.out.println(appoint.getDoc());
			
		Doctor d = docServ.findDoctorByUserName(appoint.getDoc());//To display required doctor's details
		Patient p = serv.findPatientByUserName(user.getUsername());//To display required patient's details
			
			
		Appointment ap = new AppointmentDto(appoint.getTiming(),appoint.getStatus()).convertToEntity();
		ap.setDoc(d);
		ap.setPat(p);
			
		appServ.addAppointment(ap);// saved an appointment in Appointment Table
		logger.trace("Request for appointment has been sent.");
			
		return "Request for appointment has been sent!";
	}

	@RequestMapping(path="/feedback", method=RequestMethod.GET)
	public String feedback(String id)
	{
		logger.info("Feedback page called.");
		return "FeedBack";
	}

	@RequestMapping(path="/feedback_submit", method=RequestMethod.POST)
	public String feedbacksubmit(FeedBack feed, Integer apointment)
	{
		Appointment apt = appServ.getAppointment(apointment);
		apt.setFeed(feed);

		appServ.addAppointment(apt);
		System.out.println(apt);
		System.out.println(feed);
		logger.info("Feedback submitted.");
		return "redirect:/feedback?success";
	}


}
