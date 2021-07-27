package com.persistent.dao;

import org.springframework.data.repository.CrudRepository;

import com.persistent.entities.Doctor;

public interface DoctorDao extends CrudRepository<Doctor,Integer>{

	Doctor findById(int id);
	//Custom Queries to be written for below functions:
	//findByCity
    //FinfByCityAndSpeciality
	//findByCityAndStateAndSpeciality

	

}
