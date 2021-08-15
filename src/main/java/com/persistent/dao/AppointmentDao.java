package com.persistent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.persistent.entities.Appointment;

public interface AppointmentDao extends CrudRepository<Appointment,Integer>{
	
	public Appointment findById(int id);
	
	public List<Appointment> findByPat_userName(String userName);
	
	public List<Appointment> findByDoc_userName(String userName);
	
	@Query(value = "select AVG(rating) from Appointment a join Doctor d ON a.doctorUserName = d.id join FeedBack f ON a.feedback = f.id where d.userName =  ?1", nativeQuery = true)
	public Float findByAvgRating(String username);
	
	@Query(value="select * from Appointment",nativeQuery = true)
	public List<Appointment> getEachAndEveryAppointment();
	


}
