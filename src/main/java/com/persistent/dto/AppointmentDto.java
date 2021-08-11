package com.persistent.dto;

import org.modelmapper.ModelMapper;

import com.persistent.entities.Appointment;

public class AppointmentDto {
	
    private String timing;
    
    private String status;
    
    public AppointmentDto() {
		super();
	}

	public AppointmentDto(String timing, String status) {
		super();
		this.timing = timing;
		this.status = status;
		
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

	public Appointment convertToEntity()
    {
    	ModelMapper m=new ModelMapper();
    	Appointment app=m.map(this,Appointment.class);
    	return app;
    }

}
