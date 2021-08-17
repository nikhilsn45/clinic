package com.persistent.controller;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.persistent.service.AppointmentService;
import com.persistent.service.DoctorService;
import com.persistent.service.MockAppointmentService;
import com.persistent.service.MockDocService;
import com.persistent.service.MockPatientService;
import com.persistent.service.MockUserService;
import com.persistent.service.PatientService;
import com.persistent.service.UserService;

@RunWith(SpringRunner.class) 
public class HomeControllerTest {
	
	DoctorService df = new MockDocService();
	  
	  PatientService pf = new MockPatientService();

	  UserService uf = new MockUserService();

	  AppointmentService af =  new MockAppointmentService();

	@Test
	public void testDirectingToAbout() {
		
		HomeController h = new HomeController();
		String actualResult = h.about();
		String expectedResult = "about";
		assertEquals(expectedResult,actualResult);
		
	}
	
}
