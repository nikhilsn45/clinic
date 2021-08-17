package com.persistent.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.persistent.entities.Address;
import com.persistent.entities.Doctor;

public class DoctorDto {
	@NotNull
	@Size(min = 4, max = 30, message = "Username must have at least 4 characters")
	private String userName;
	
	@NotNull
	@Size(min = 4, max = 30, message = "First name must have at least 4 characters")
    private String fName;
	
	@NotNull
	@Size(min = 4, max = 30, message = "Last name must have at least 4 characters")
	private String lName;
	
	@NotNull(message = "Must not Empty")
    private String contactNo;
	
	@NotNull
	@Size(min = 4, max = 15, message = "License must have at least 4 characters")
    private String licenseNo;
	
	@NotNull
	@Size(min = 2, max = 15, message = "speciality must have at least 2 characters")
    private String speciality;
	
	@NotNull
	@Size(min = 2, max = 15, message = "city must have at least 2 characters")
    private String city;
	
	@NotNull
	@Size(min = 2, max = 15, message = "state must have at least 2 characters")
    private String state;
	
	@NotNull
	@Size(min = 4, max = 15, message = "university name must have at least 4 characters")
    private String university_name;
	
	@NotNull
	private Integer experience;
	
	@NotNull
	@Size(min = 4, max = 15, message = "organisation name must have at least 4 characters")
    private String organisation_name;
	
	@NotNull
    private Integer consultation_fee;
	
	@NotNull
	@Size(min = 4, max = 15, message = "password should be 4-15 character long")
    private String password;
	
    private String type;
    
    private String verification;
    
    public DoctorDto() {}

	
	
	public DoctorDto(String userName, String fName, String lName, String contactNo, String licenseNo, String speciality,
			String city, String state, String university_name, Integer experience, String organisation_name, Integer consultation_fee, String verification, String password, String type) {
		super();
		this.userName = userName;
		this.fName = fName;
		this.lName = lName;
		this.contactNo = contactNo;
		this.licenseNo = licenseNo;
		this.speciality = speciality;
		this.city = city;
		this.state = state;
		this.university_name = university_name;
		this.experience = experience;
		this.organisation_name = organisation_name;
		this.consultation_fee = consultation_fee;
		this.verification = verification;
		this.password = password;
		this.type = type;
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
		this.consultation_fee=doc.getConsultation_fee();
		this.experience=doc.getExperience();
		this.organisation_name=doc.getOrganisation_name();
		this.university_name=doc.getUniversity_name();
		this.verification=doc.getVerification();
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

	
	public String getUniversity_name() {
		return university_name;
	}



	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}



	public Integer getExperience() {
		return experience;
	}



	public void setExperience(Integer experience) {
		this.experience = experience;
	}



	public String getOrganisation_name() {
		return organisation_name;
	}



	public void setOrganisation_name(String organisation_name) {
		this.organisation_name = organisation_name;
	}


	public Integer getConsultation_fee() {
		return consultation_fee;
	}



	public void setConsultation_fee(Integer consultation_fee) {
		this.consultation_fee = consultation_fee;
	}



	public String getVerification() {
		return verification;
	}



	public void setVerification(String verification) {
		this.verification = verification;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
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
		doc.setConsultation_fee(consultation_fee);
		doc.setExperience(experience);
		doc.setOrganisation_name(organisation_name);
		doc.setUniversity_name(university_name);
		doc.setVerification(verification);
		
		return doc;
	}
    
}
