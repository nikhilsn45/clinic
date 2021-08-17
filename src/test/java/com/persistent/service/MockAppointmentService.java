package com.persistent.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.persistent.dao.AppointmentDao;
import com.persistent.entities.Address;
import com.persistent.entities.Appointment;
import com.persistent.entities.Doctor;
import com.persistent.entities.FeedBack;
import com.persistent.entities.Patient;

public class MockAppointmentService extends AppointmentService {



	@Override
	public void addAppointment(Appointment a) {
		
		//super.addAppointment(a);
	}
	
	@Override
	public void updateAppoStatus(Appointment a) {
		
	}
	
	@Override
	public Appointment getAppointment(int id) {
		Address a2 = new Address(5,"Pune","MH");
		Doctor d2 = new Doctor("Nikhli", "Nikhil", "Nakod", "123", 5, "1123", "MBBS","SPPU",4,"Apollo",500,"verified", a2);
		
		Address a = new Address(4,"Pune","MH");
		Patient p1 = new Patient("uday", "uday", "lastname", "123", 4, "M", 20, "uday@gmail.com", a);
		
		FeedBack f2 = new FeedBack(5, "Good", 4);
		
		Appointment ap2 = new Appointment(2,"9:30","pending",d2,p1,f2 );
		return ap2; 
		//return null;
	}
	
	

	@Override
	public List<Appointment> getAllAppointment(String username) {
		Address a1 = new Address(4,"Pune","MH");
		Address a2 = new Address(5,"Pune","MH");
		Address a3 = new Address(6,"Pune","MH");
		Doctor d1 = new Doctor("Smit", "Smit", "Mune", "123", 4, "1123", "MBBS","SPPU",5,"Apollo",400,"verified", a1);
		Doctor d2 = new Doctor("Nikhli", "Nikhil", "Nakod", "123", 5, "1123", "MBBS","SPPU",4,"Apollo",500,"verified", a2);
		Doctor d3 = new Doctor("Messi", "Lionel", "Messi", "123", 6, "1123", "MBBS","SPPU",5,"Apollo",600,"verified", a3);
		
		Address a = new Address(4,"Pune","MH");
		Patient p1 = new Patient("uday", "uday", "lastname", "123", 4, "M", 20, "uday@gmail.com", a);
		
		FeedBack f1 = new FeedBack(4, "Good", 4);
		FeedBack f2 = new FeedBack(5, "Good", 4);
		FeedBack f3 = new FeedBack(6, "Good", 4);
		
		Appointment ap1 = new Appointment(1,"9:30","accepted",d1,p1,f1 );
		Appointment ap2 = new Appointment(2,"9:30","pending",d2,p1,f2 );
		Appointment ap3 = new Appointment(3,"9:30","accepted",d3,p1,f3 );
		
		List<Appointment> al1 = new ArrayList<Appointment>();
		al1.add(ap1);
		al1.add(ap2);
		al1.add(ap3);
		
		return al1; 
	}
	
	
	
	
	

}
