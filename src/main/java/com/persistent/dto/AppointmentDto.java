package com.persistent.dto;

public class AppointmentDto {
	
	
	private String date;
	
    private String timing;
    
    private String status;
    
    private String doctorUserName;
    
    private String patientUserName;
    
    public AppointmentDto() {
		super();
	}

	public AppointmentDto(String date, String timing, String status, String doctorUserName, String patientUserName) {
		super();
		this.date = date;
		this.timing = timing;
		this.status = status;
		this.doctorUserName = doctorUserName;
		this.patientUserName = patientUserName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

}
