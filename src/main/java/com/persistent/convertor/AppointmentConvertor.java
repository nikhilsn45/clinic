package com.persistent.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.persistent.dto.AppointmentDto;
import com.persistent.entities.Appointment;
import com.persistent.entities.Doctor;
import com.persistent.entities.Patient;
import com.persistent.service.DoctorService;
import com.persistent.service.PatientService;

@Component
public class AppointmentConvertor {
	
	@Autowired 
	private DoctorService dserv;
	
	@Autowired
	private PatientService pserv;
	
	public Appointment convertToEntity(AppointmentDto adto)
    {
    	Appointment app=new Appointment();
    	Doctor d=dserv.findDoctorByUserName(adto.getDoctorUserName());
    	app.setDoc(d);
    	app.setDoctorName(d.getfName()+" "+d.getlName());
    	app.setDoctorSpeciality(d.getSpeciality());
    	Patient p=pserv.findPatientByUserName(adto.getPatientUserName());
    	app.setPat(p);
    	app.setPatientName(p.getfName()+" "+p.getlName());
    	app.setPatientAge(p.getAge());
    	app.setStatus(adto.getStatus());
    	app.setTiming(adto.getTiming());
    	app.setDate(adto.getDate());
    	return app;
    }
	
	public AppointmentDto convertToDto(Appointment a)
    {
    	AppointmentDto appdto=new AppointmentDto();
    	appdto.setDoctorUserName(a.getDoc().getUserName());
    	appdto.setPatientUserName(a.getPat().getUserName());
    	appdto.setTiming(a.getTiming());
    	appdto.setStatus(a.getStatus());
    	appdto.setDate(a.getDate());
    	return appdto;
    }
	
	

}
