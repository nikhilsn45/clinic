package com.persistent.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.persistent.entities.DoctorInfo;

public interface DoctorDao extends CrudRepository<DoctorInfo,Integer>{

	DoctorInfo findById(int id);
	//Custom Queries to be written for below functions:
	//findByCity
    //FinfByCityAndSpeciality
	//findByCityAndStateAndSpeciality

	List<DoctorInfo> findBySpecialityOrStateAndCity(String speciality, String state, String city);

}
