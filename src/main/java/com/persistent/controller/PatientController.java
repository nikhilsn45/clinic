package com.persistent.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.persistent.dto.DoctorDto;
import com.persistent.dto.PatientDto;
import com.persistent.entities.Doctor;
import com.persistent.entities.Respond;
import com.persistent.entities.User;
import com.persistent.service.DoctorService;
import com.persistent.service.PatientService;
import com.persistent.service.UserService;

@Controller
public class PatientController {
	
	@Autowired
	private PatientService serv;
	
	@Autowired
	private UserService creadServ;
	
	@Autowired
	private DoctorService docServ;

	@RequestMapping(path="/save_patient", method=RequestMethod.POST)
	public String save_patient(@ModelAttribute PatientDto uInfo,@ModelAttribute User u)
	{
		System.out.println(uInfo);
		System.out.println(u);

		serv.addPatient(uInfo.conToPatient());
		creadServ.addUser(u);
        
		return "redirect:/";//redirected to user dashboard
	}
	

		@PostMapping("/search")
    public @ResponseBody List<DoctorDto> user_search_results(Respond t) {

        //getuser filtered list from database
		System.out.println(t.type+ " " + t.state + " " + t.city);
		List<Doctor> d = docServ.findBySpecialityAndAddress(t.type,t.state,t.city);
		List<DoctorDto> doctors = new ArrayList<DoctorDto>();
		for (Doctor doctor : d) {
			doctors.add(new DoctorDto(doctor));
		}
		System.out.println(doctors);
        //List<DoctorInfo> users = Arrays.asList(new DoctorInfo(),new DoctorInfo());
        return doctors;
    }

}
