package com.persistent.dao;

import org.springframework.data.repository.CrudRepository;

import com.persistent.entities.Patient;

public interface PatientDao extends CrudRepository<Patient,Integer>{
	
	Patient findByUserName(String un);

}
