package com.persistent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.persistent.entities.Patient;

public interface PatientDao extends CrudRepository<Patient,Integer>{
	
	Patient findByUserName(String un);
	
	@Query(value="select * from Patient",nativeQuery = true)
	public List<Patient> getEachAndEveryPatient();
}
