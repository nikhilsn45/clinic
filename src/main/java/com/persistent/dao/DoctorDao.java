package com.persistent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.persistent.entities.DoctorInfo;

public interface DoctorDao extends CrudRepository<DoctorInfo,Integer>{

	DoctorInfo findById(int id);
	//Custom Queries to be written for below functions:
	//findByCity
    //FinfByCityAndSpeciality
	//findByCityAndStateAndSpeciality

	List<DoctorInfo> findBySpecializationOrStateAndCity(String speciality, String state, String city);
	
	@Query(value="select * from doctor_info di where di.user_name= :un",nativeQuery=true)
	DoctorInfo findByUser_Name(String un);

}
