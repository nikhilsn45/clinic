package com.persistent.controller;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.persistent.dto.DoctorDto;
import com.persistent.entities.UpdateReq;
import com.persistent.entities.User;
import com.persistent.service.AppointmentService;
import com.persistent.service.DoctorService;
import com.persistent.service.MockAppointmentService;
import com.persistent.service.MockDocService;
import com.persistent.service.MockPatientService;
import com.persistent.service.MockUserService;
import com.persistent.service.PatientService;
import com.persistent.service.UserService;

@RunWith(SpringRunner.class) 
public class DoctorControllerTest {

	
	 DoctorService df = new MockDocService();
	  
	  PatientService pf = new MockPatientService();
  
	  UserService uf = new MockUserService();
 
	  AppointmentService af =  new MockAppointmentService();
	  
	  
	  @Test
	  public void testAcceptAppointment() {
		  DoctorController d = new DoctorController(df, uf, af);
		  UpdateReq uq = new UpdateReq(2);
		  String actualResult = d.alter_appo_status(uq);
		  assertEquals("Accepted Appointment", actualResult);
		  
	  }
	  
	  @Test
	  public void testRejectAppointment() {
		  DoctorController d = new DoctorController(df, uf, af);
		  UpdateReq uq = new UpdateReq(2);
		  String actualResult = d.reject_appo_status(uq);
		  assertEquals("Rejected Appointment", actualResult);
		  
	  }
	  

}
