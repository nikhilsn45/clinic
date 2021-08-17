package com.persistent.service;

import java.util.ArrayList;
import java.util.List;

import com.persistent.entities.Address;
import com.persistent.entities.Doctor;
//import com.persistent.service.DoctorService;

public class MockDocService extends DoctorService {

	@Override
	public List<Doctor> findBySpecialityAndAddress(String specialization, String state, String city) {
		Address a1 = new Address(4,"Pune","MH");
		Address a2 = new Address(5,"Pune","MH");
		Address a3 = new Address(6,"Pune","MH");
		Doctor d1 = new Doctor("Smit", "Smit", "Mune", "123", 4, "1123", "MBBS","SPPU",5,"Apollo",400,"pending", a1);
		Doctor d2 = new Doctor("Nikhli", "Nikhil", "Nakod", "123", 5, "1123", "MBBS","SPPU",4,"Apollo",500,"verified", a2);
		Doctor d3 = new Doctor("Messi", "Lionel", "Messi", "123", 6, "1123", "MBBS","SPPU",5,"Apollo",600,"verified", a3);
		List<Doctor> l1 = new ArrayList<Doctor>();
		l1.add(d1);
		l1.add(d2);
		l1.add(d3);
		return l1;
		
		
	}

	@Override
	public Doctor findDoctorByUserName(String un) {
			Address a1 = new Address(4,"Pune","MH");	
			Doctor d1 = new Doctor("Smit", "Smit", "Mune", "123", 4, "1123", "MBBS","SPPU",5,"Apollo",400,"verified", a1);
			
		return d1;
	}

	@Override
	public void addDoctor(Doctor d) {
		// TODO Auto-generated method stub
		//super.addDoctor(d);
	}
	
	

}
