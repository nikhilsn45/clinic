package com.persistent.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
		
		Logger logger = LoggerFactory.getLogger(PatientController.class);
		
		@RequestMapping("/admin")
		public String home()
		{
			logger.info("Admin page called");
			//@ModelAttribute Doctor d
			//admin will access the Database to check and verify doctors by contacting DoctorService
			return "admin_home";
		}

}
