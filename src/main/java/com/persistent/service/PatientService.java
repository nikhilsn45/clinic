package com.persistent.service;

import java.util.List;

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

	
	public Patient findPatientByUserName(String un)
	{
		
		return pdao.findByUserName(un);
	}
	
	public List<Patient> getEachAndEveryPatient()
	{
		return pdao.getEachAndEveryPatient();
	}
	

}
