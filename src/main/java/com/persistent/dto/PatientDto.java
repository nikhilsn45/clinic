package com.persistent.dto;

import com.persistent.entities.Address;
import com.persistent.entities.Patient;

public class PatientDto {
	
	private String userName;
	
    private String fName;
	
	private String lName;
    
    private String contactNo;
    
    private String gender;
    
    private Integer age;

    private String emailId;
    
    private String city;
    
    private String state;

    public PatientDto() {
    	
    }
    
	public PatientDto(String userName, String fName, String lName, String contactNo, String gender,
			Integer age, String emailId, String city, String state) {
		super();
		this.userName = userName;
		this.fName = fName;
		this.lName = lName;
		this.contactNo = contactNo;
		this.gender = gender;
		this.age = age;
		this.emailId = emailId;
		this.city = city;
		this.state = state;
	}
	
	public PatientDto(Patient p) {
		this.userName = p.getUserName();
		this.fName = p.getfName();
		this.lName = p.getlName();
		this.contactNo = p.getContactNo();
		this.gender = p.getGender();
		this.age = p.getAge();
		this.emailId = p.getEmailId();
		this.city = p.getAddress().getCity();
		this.state = p.getAddress().getState();
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
		return "PatientDto [userName=" + userName + ", fName=" + fName + ", lName=" + lName 
				+ ", contactNo=" + contactNo + ", gender=" + gender + ", age=" + age + ", emailId=" + emailId
				+ ", city=" + city + ", state=" + state + "]";
	}
	
	public Patient conToPatient() {
		Address ad = new Address();
		ad.setCity(this.getCity());
		ad.setState(this.getState());
		
		Patient pat = new Patient();
		pat.setAddress(ad);
		pat.setfName(this.getfName());
		pat.setlName(this.getlName());
		pat.setUserName(this.getUserName());
		pat.setContactNo(this.getContactNo());
		pat.setAge(this.getAge());
		pat.setEmailId(this.getEmailId());
		pat.setGender(this.getGender());
		
		return pat;
	}
    
    
}
