package com.persistent.service;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	public List<Appointment> getAllAptHaveFeedForDoctor(String username)
	{
		 List<Appointment> list = adao.findByDoc_userName(username);
		 List<Appointment> list1 = new ArrayList<Appointment>();
		 
		 for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Appointment appointment = (Appointment) iterator.next();
			
			if(appointment.getFeed ()!= null) {
				list1.add(appointment);
			}
		}
		return list1;
	}
	
	public Float getAvgRating(String username) {
		return adao.findByAvgRating(username);
	}
	
	/*public List<Appointment> getAppointmentByDocIdAndStatus(int docId, String status)
	{
		return adao.findByDocIdAndStatus(docId,status);   //to get all pending or accepted appointments list
	}
	
	public List<Appointment> getAppointmentByPatientIdAndStatus(int patientId, String status)
	{
		return adao.findByPatientIdAndStatus(patientId,status);  //to get the list of status of all requested appointments
	}*/
	
	public void updateAppoStatus(Appointment ap) {
		adao.save(ap);
	}
	
	public List<Appointment> getAllAppointmentDoc(String username)
	{
		return adao.findByDoc_userName(username);
	
	}
	
	public List<Appointment> getEachAndEveryAppointment()
	{
		return adao.getEachAndEveryAppointment();
	}
	

}
