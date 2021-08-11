package com.persistent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.AppointmentDao;
import com.persistent.entities.Appointment;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentDao adao;
	
	public void addAppointment(Appointment a)
	{
		adao.save(a);
	}
	
	public Appointment getAppointment(int id)
	{
		return adao.findById(id);
	}
	
	public List<Appointment> getAllAppointment(String username)
	{
		return adao.findByPat_userName(username);
	}
	
	/*public List<Appointment> getAppointmentByDocIdAndStatus(int docId, String status)
	{
		return adao.findByDocIdAndStatus(docId,status);   //to get all pending or accepted appointments list
	}
	
	public List<Appointment> getAppointmentByPatientIdAndStatus(int patientId, String status)
	{
		return adao.findByPatientIdAndStatus(patientId,status);  //to get the list of status of all requested appointments
	}*/
	
	
	
	

}
