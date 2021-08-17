package com.persistent.service;

import com.persistent.entities.Address;
import com.persistent.entities.Patient;

public class MockPatientService extends PatientService{

	@Override
	public Patient findPatientByUserName(String un) {
		Address a = new Address(4,"Pune","MH");
		Patient p1 = new Patient("uday", "uday", "lastname", "123", 4, "M", 20, "uday@gmail.com", a);
		return p1;
	}

		
}
