package com.persistent.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.controller.AdminController;
import com.persistent.dao.DoctorDao;
import com.persistent.entities.Doctor;


@Service
public class DoctorService {
	
	Logger logger = LoggerFactory.getLogger(DoctorService.class);
	
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
	
	public Doctor findDoctorByUserName(String username)
	{
		logger.trace("Returns doctor object for particular username.");
		return dao.findByUserName(username);
	}
	
	
	public List<Doctor> findBySpecialityAndAddress(String specialization, String state, String city) {

		List <Doctor> dList = dao.findBySpecialityAndAddress_CityAndAddress_State(specialization,city,state);
		dList = dList.stream().filter(d -> d.getVerification().equals("Verified")).collect(Collectors.toList());
		logger.trace("Returns only verified doctors list when patient searches.");
		return dList;
	}
	
	public List<Doctor> getEachAndEveryDoctor()
	{
		logger.trace("Returns all doctors list.");
		return dao.getEachAndEveryDoctor();
	}
}
