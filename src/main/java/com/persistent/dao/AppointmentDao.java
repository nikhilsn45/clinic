package com.persistent.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.persistent.entities.Appointment;

public interface AppointmentDao extends CrudRepository<Appointment,Integer>{
	
	public Appointment findById(int id);
	
	public List<Appointment> findByDoctorUserNameAndStatus(int docun, String status);
	
	public List<Appointment> findByPatientUserNameAndStatus(int patientun, String status);


}
