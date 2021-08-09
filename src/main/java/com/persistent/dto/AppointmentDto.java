package com.persistent.dto;

import org.modelmapper.ModelMapper;

import com.persistent.entities.Appointment;

public class AppointmentDto {
	
    private String timing;
    
    private String status;
    
    private String doctorUserName;
    
    private String patientUserName;
    
    public AppointmentDto() {
		super();
	}

	public AppointmentDto(String timing, String status, String doctorUserName, String patientUserName) {
		super();
		this.timing = timing;
		this.status = status;
		this.doctorUserName = doctorUserName;
		this.patientUserName = patientUserName;
	}



	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDoctorUserName() {
		return doctorUserName;
	}

	public void setDoctorUserName(String doctorUserName) {
		this.doctorUserName = doctorUserName;
	}

	public String getPatientUserName() {
		return patientUserName;
	}

	public void setPatientUserName(String patientUserName) {
		this.patientUserName = patientUserName;
	}

	public Appointment convertToEntity()
    {
    	ModelMapper m=new ModelMapper();
    	Appointment app=m.map(this,Appointment.class);
    	return app;
    }
	
	public AppointmentDto convertToDto(Appointment a)
    {
    	ModelMapper m=new ModelMapper();
    	AppointmentDto appdto=m.map(a,AppointmentDto.class);
    	return appdto;
    }

}
