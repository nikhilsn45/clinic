package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.PatientDao;
import com.persistent.entities.Patient;

@Service
public class PatientService {
	
	@Autowired
	private PatientDao pdao;

	public PatientService(PatientDao udao) {
		this.pdao = udao;
	}

	public PatientService() {
	}
	
	public void addPatient(Patient p)
	{
		pdao.save(p);
	}

	
	public Patient findPatientByUser_Name(String un)
	{
		
		return pdao.findByUser_Name(un);
	}
	
	
	

}
