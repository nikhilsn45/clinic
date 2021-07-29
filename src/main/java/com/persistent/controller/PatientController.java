package com.persistent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.persistent.entities.DoctorInfo;
import com.persistent.entities.User;
import com.persistent.entities.Patient;
import com.persistent.service.DoctorService;
import com.persistent.service.UserService;
import com.persistent.service.PatientService;

@Controller
public class PatientController {
	
	@Autowired
	private PatientService serv;
	
	@Autowired
	private UserService creadServ;
	
	@Autowired
	private DoctorService docServ;

	@RequestMapping(path="/save_patient", method=RequestMethod.POST)
	public String save_patient(@ModelAttribute Patient uInfo,@ModelAttribute User u)
	{
		System.out.println(uInfo);
		System.out.println(u);
		
		serv.addPatient(uInfo);
		creadServ.addUser(u);
		
		/*model.addAttribute("uInfo",uInfo);
		  redirectAttributes.addFlashAttribute("uInfo", uInfo);*/
        
		return "redirect:/home";//redirected to user dashboard
	}
	
	
	/*@RequestMapping(path="/dashboard", method=RequestMethod.GET)
	public String user_home(@ModelAttribute Patient uInfo,Model model)
	{
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        if(flashMap != null){
            UserInfo uInfo =  (UserInfo) flashMap.get("uInfo");
            System.out.println(uInfo);
            model.addAttribute("uInfo", uInfo);
            return "user_home";
        }
        else{
            return "refreshNotAllowed";
        }
		System.out.println(uInfo);
		model.addAttribute("uInfo",uInfo);
		
		return "user_home";
	}*/
	
	@RequestMapping(path="/profile", method=RequestMethod.GET)
	public String user_profile(@ModelAttribute Patient uInfo)
	{
		System.out.println(uInfo);
		return "patient_profile";
	}
	
	
	
	@PostMapping("/search")
    public ResponseEntity<?> user_search_results(@RequestParam("type") String type,@RequestParam("state") String state,@RequestParam("city") String city) {

        //getuser filtered list from database
		List<DoctorInfo> users = docServ.findBySpecializationAndStateAndCity(type,state,city);
        //List<DoctorInfo> users = Arrays.asList(new DoctorInfo(),new DoctorInfo());

        return ResponseEntity.ok(users);

    }

}
