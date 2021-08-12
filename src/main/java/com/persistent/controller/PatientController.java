package com.persistent.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.persistent.exceptions.NoDoctorFoundException;
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

	@RequestMapping(path="/save_patient", method=RequestMethod.POST)
	public String save_patient(@ModelAttribute PatientDto uInfo,@ModelAttribute User u)
	{	
		logger.trace("Save patient method called");
		System.out.println(uInfo);
		System.out.println(u);

		serv.addPatient(uInfo.conToPatient());
		creadServ.addUser(u);
		logger.info("Patient saved to database");
        
		return "redirect:/";//redirected to user dashboard
	}
	
	@RequestMapping(path="/profile/{username}", method=RequestMethod.GET)
	public String user_profile(@PathVariable String username, Model model)
	{
		logger.info("User reached his/her profile page");
		System.out.println(username);
		List<Appointment> appoints= appServ.getAllAppointment(username);
		List<Map<String,String>> maps = new ArrayList<Map<String,String>>();
		List<Map<String,String>> mapsaccepted = new ArrayList<Map<String,String>>();
		
		for (Iterator iterator = appoints.iterator(); iterator.hasNext();) {
			Appointment appointment = (Appointment) iterator.next();
			Map<String,String> map = new HashMap<>();
			map.put("timing", appointment.getTiming());
			map.put("fName", appointment.getDoc().getfName());
			map.put("contact", appointment.getDoc().getContactNo().toString());
			map.put("address", appointment.getDoc().getAddress().getCity() + ", " + appointment.getDoc().getAddress().getState());
			map.put("status", appointment.getStatus());
			if(appointment.getStatus().equals("pending"))
				maps.add(map);
			else
				mapsaccepted.add(map);
			
		}
		
		System.out.println(maps);
		model.addAttribute("pat",new PatientDto(serv.findPatientByUserName(username)));
		model.addAttribute("appoints", maps);
		model.addAttribute("appointsAccept", mapsaccepted);
		logger.trace("The user details and the appointment details are sent to the patient_profile html page");
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

			System.out.println("*******************\n\n\n");
			System.out.println(model.getAttribute("pat"));
			System.out.println(doc);
			
			model.addAttribute("doc",new DoctorDto(doc));
			return "doctor_info";
		}
		

		@RequestMapping(path=("/doctor/book_slot"), method=RequestMethod.POST)
		public @ResponseBody String book_slot(AppointAJAX appoint)
		{	
			logger.info("Slot booking function called");
			System.out.println(appoint.getDoc());
			
			Doctor d = docServ.findDoctorByUserName(appoint.getDoc());//To display required doctor's details
			Patient p = serv.findPatientByUserName("uday");//To display required patient's details
			
			
			Appointment ap = new AppointmentDto(appoint.getTiming(),appoint.getStatus()).convertToEntity();
			ap.setDoc(d);
			ap.setPat(p);
			
			appServ.addAppointment(ap);// saved an appointment in Appointment Table
			logger.info("Appointment details saved in database");
			
			return "Your Appointment is booked";
		}

}
