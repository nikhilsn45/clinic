package com.persistent.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.controller.PatientController;
import com.persistent.dao.AppointmentDao;
import com.persistent.entities.Appointment;

@Service
public class AppointmentService {
	
	Logger logger = LoggerFactory.getLogger(AppointmentService.class);
	
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
		logger.trace("Returns all appointments for particular username.");
		return adao.findByPat_userName(username);
	}
	
	public List<Appointment> getAllAptHaveFeedForDoctor(String username)
	{
		logger.trace("Returns list of appointments for which feedback is given.");
		 List<Appointment> list = adao.findByDoc_userName(username);
		 List<Appointment> list1 = new ArrayList<Appointment>();
		 
		 for (Iterator<Appointment> iterator = list.iterator(); iterator.hasNext();) {
			Appointment appointment = (Appointment) iterator.next();
			
			if(appointment.getFeed ()!= null) {
				list1.add(appointment);
			}
		}
		return list1;
	}
	
	public Float getAvgRating(String username) {
		logger.trace("Returns average rating of doctor based on feedback ratings.");
		return adao.findByAvgRating(username);
	}
	
	public void updateAppoStatus(Appointment ap) {
		adao.save(ap);
	}
	
	public List<Appointment> getAllAppointmentDoc(String username)
	{
		return adao.findByDoc_userName(username);
	
	}
	
	public List<Appointment> getEachAndEveryAppointment()
	{
		logger.trace("Returns all appointment list.");
		return adao.getEachAndEveryAppointment();
	}
	

}
