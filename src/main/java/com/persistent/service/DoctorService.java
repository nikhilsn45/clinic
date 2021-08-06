package com.persistent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.persistent.dao.DoctorDao;
import com.persistent.entities.Doctor;


@Service
public class DoctorService {
	
	@Autowired
	private DoctorDao dao;
	
	public DoctorService(DoctorDao dao) {
		this.dao = dao;
	}

	public DoctorService() {
	}

	public void deleteDoctor(int id)
	{
		dao.deleteById(id);
	}
	
	public void addDoctor(Doctor d)
	{
		dao.save(d);
	}
	
	public void addDoctors(List<Doctor> l)
	{
		dao.saveAll(l);
	}
	
	public void updateDoctor(Doctor d)
	{
		dao.save(d);
	}
	
	public Doctor findDoctorById(int id)
	{
		
		return null;//dao.findById(id);
	}
	
	public Doctor findDoctorByUserName(String un)
	{
		
		return dao.findByUserName(un);
	}
	
	
	public List<Doctor> findBySpecialityAndAddress(String specialization, String state, String city) {

		return dao.findBySpecialityAndAddress_CityAndAddress_State(specialization,city,state);
	}
}
