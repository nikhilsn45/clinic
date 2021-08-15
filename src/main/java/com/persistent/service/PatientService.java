package com.persistent.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.controller.PatientController;
import com.persistent.dao.PatientDao;
import com.persistent.entities.Patient;

@Service
public class PatientService {
	
	Logger logger = LoggerFactory.getLogger(PatientService.class);
	
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
		logger.trace("Returns patient object for particular username.");
		return pdao.findByUserName(un);
	}
	
	public List<Patient> getEachAndEveryPatient()
	{
		logger.trace("Returns all patients list.");
		return pdao.getEachAndEveryPatient();
	}
	

}
