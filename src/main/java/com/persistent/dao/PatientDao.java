package com.persistent.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.persistent.entities.Patient;

public interface PatientDao extends CrudRepository<Patient,Integer>{
	
	@Query(value="select * from patient p where p.user_name= :un",nativeQuery=true)
	Patient findByUser_Name(String un);

}
