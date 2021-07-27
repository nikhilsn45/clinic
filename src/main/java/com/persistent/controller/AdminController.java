package com.persistent.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class AdminController {
	
		
		@RequestMapping("/admin")
		public String home()
		{
			//@ModelAttribute Doctor d
			//admin will access the Database to check and verify doctors by contacting DoctorService
			return "admin";
		}

}
