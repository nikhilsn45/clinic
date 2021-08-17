
  package com.persistent.controller;
  
  import  static org.junit.Assert.assertEquals;
  
  import java.util.ArrayList; 
  import java.util.List;
  
  import org.junit.jupiter.api.Test; 
  import org.junit.runner.RunWith; 
  //import org.mockito.Mock; 
  import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import com.persistent.dto.AppointmentDto;
import com.persistent.dto.DoctorDto;
import com.persistent.entities.AppointAJAX;
import com.persistent.entities.Appointment;
import com.persistent.entities.Doctor;
import com.persistent.entities.FeedBack;
import com.persistent.entities.Patient;
import com.persistent.entities.SearchAJAX;
import com.persistent.service.AppointmentService;
import com.persistent.service.DoctorService;
import com.persistent.service.MockAppointmentService;
import com.persistent.service.MockDocService; 
 import com.persistent.service.MockPatientService; 
 import com.persistent.service.MockUserService; 
 import com.persistent.service.PatientService; 
 import com.persistent.service.UserService; 
 
 
  @RunWith(SpringRunner.class) 
  
  
  public class PatientControllerTest { 
	  DoctorService df = new MockDocService();
  
	  PatientService pf = new MockPatientService();
   
	  UserService uf = new MockUserService();
  
	  AppointmentService af =  new MockAppointmentService();
  
	  @Test 
	  public void testDoctorSearch() {
	  
		  PatientController p = new PatientController(pf,uf,df,af); 
		  SearchAJAX T = new SearchAJAX("MBBS","MH","Pune"); 
		  List<DoctorDto> actualResult = new ArrayList<DoctorDto>(p.user_search_results(T)); 
		  int expectedResult = 3;
		  assertEquals(expectedResult, actualResult.size()); 
		 
	  	}
	  
	  @Test 
	  public void toTestDoctorSearch() {
	  
		  PatientController p = new PatientController(pf,uf,df,af); 
		  //Model model = new Model();
		  SearchAJAX T = new SearchAJAX("MBBS","MH","Pune"); 
		  List<DoctorDto> actualResult = new ArrayList<DoctorDto>(p.user_search_results(T)); 
		  int expectedResult = 3;
		  assertEquals(expectedResult, actualResult.size()); 
	  
	  	}
	 
	 
	  @Test
	  public void testFeedbackSubmit() {
		  PatientController pc = new PatientController(pf,uf,df,af);
		  FeedBack feed = new FeedBack(5,"Good",4);
		  String actualResult = pc.feedbacksubmit(feed, 5);
		  String expectedResult = "redirect:/feedback?success";
		  assertEquals(expectedResult, actualResult);
	  }
	  
	  @Test
	  public void testReturningFeedback() {
		  PatientController pc = new PatientController(pf,uf,df,af);
		  String actualResult = pc.feedback("id");
		  assertEquals("FeedBack", actualResult);
	  }
}
	  
  
  
 