package com.persistent.dto;

import com.persistent.entities.Address;
import com.persistent.entities.Doctor;

public class DoctorDto {

	private String userName;
	
    private String fName;
	
	private String lName;
    
    private String contactNo;
    
    private String licenseNo;
	
    private String speciality;
    
    private String city;
    
    private String state;
    
    public DoctorDto() {}

	public DoctorDto(String userName, String fName, String lName, String contactNo, String licenseNo,
			String speciality, String city, String state) {
		super();
		this.userName = userName;
		this.fName = fName;
		this.lName = lName;
		this.contactNo = contactNo;
		this.licenseNo = licenseNo;
		this.speciality = speciality;
		this.city = city;
		this.state = state;
	}
	
	public DoctorDto(Doctor doc) {
		super();
		this.userName = doc.getUserName();
		this.fName = doc.getfName();
		this.lName = doc.getlName();
		this.contactNo = doc.getContactNo();
		this.licenseNo = doc.getLicenseNo();
		this.speciality = doc.getSpeciality();
		this.city = doc.getAddress().getCity();
		this.state = doc.getAddress().getState();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "DoctorDto [userName=" + userName + ", fName=" + fName + ", lName=" + lName 
				+ ", contactNo=" + contactNo + ", licenseNo=" + licenseNo + ", speciality=" + speciality + ", city="
				+ city + ", state=" + state + "]";
	}
    
	public Doctor conToDoctor() {
		Address ad = new Address();
		ad.setCity(this.getCity());
		ad.setState(this.getState());
		
		Doctor doc = new Doctor();
		doc.setAddress(ad);
		doc.setfName(this.getfName());
		doc.setlName(this.getlName());
		doc.setUserName(this.getUserName());
		doc.setContactNo(this.getContactNo());
		doc.setLicenseNo(this.getLicenseNo());
		doc.setSpeciality(this.getSpeciality());
		
		return doc;
	}
    
}
