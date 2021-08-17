package com.persistent.controller;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import com.persistent.entities.VerifyReq;
import com.persistent.service.AppointmentService;
import com.persistent.service.DoctorService;
import com.persistent.service.MockAppointmentService;
import com.persistent.service.MockDocService;
import com.persistent.service.MockPatientService;
import com.persistent.service.MockUserService;
import com.persistent.service.PatientService;
import com.persistent.service.UserService;

@RunWith(SpringRunner.class) 
public class AdminControllerTest {
	
	  DoctorService df = new MockDocService();
	  
	  PatientService pf = new MockPatientService();
  
	  AppointmentService af =  new MockAppointmentService();
	  
	  @Test
	  public void testVerifyDoctor() {
		  AdminController a = new AdminController(df, pf, af);
		  VerifyReq vq = new VerifyReq("pending");
		  String actualResult = a.verify_doctor(vq);
		  assertEquals("Verified doctor", actualResult);
	  }

	  	
	  @Test
	  public void testRejectDoctor() {
		  AdminController a = new AdminController(df, pf, af);
		  VerifyReq vq = new VerifyReq("pending");
		  String actualResult = a.reject_doctor(vq);
		  assertEquals("Rejected Verification of doctor", actualResult);
	  }
	  
	 
}
