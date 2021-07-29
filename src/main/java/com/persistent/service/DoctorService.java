package com.persistent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.persistent.dao.DoctorDao;
import com.persistent.entities.DoctorInfo;


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
	
	public void addDoctor(DoctorInfo d)
	{
		dao.save(d);
	}
	
	public void addDoctors(List<DoctorInfo> l)
	{
		dao.saveAll(l);
	}
	
	public void updateDoctor(DoctorInfo d)
	{
		dao.save(d);
	}
	
	public DoctorInfo findDoctorById(int id)
	{
		
		return dao.findById(id);
	}
	
	public DoctorInfo findDoctorByUser_Name(String un)
	{
		
		return dao.findByUser_Name(un);
	}
	
	
	public List<DoctorInfo> findBySpecializationAndStateAndCity(String specialization, String state, String city) {

		return dao.findBySpecializationOrStateAndCity(specialization,state,city);
	}
}
