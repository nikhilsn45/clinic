package com.persistent.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.persistent.entities.Address;
import com.persistent.entities.Patient;

public class PatientDto {
	
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
    
	@NotNull(message = "Must not Empty")
    private String gender;
    
	@NotNull(message = "Must not Empty")
    private Integer age;

	
	@Email
    private String emailId;
    
	@NotNull
	@Size(min = 2, max = 15, message = "city must have at least 2 characters")
    private String city;
    
	@NotNull
	@Size(min = 2, max = 15, message = "state must have at least 2 characters")
    private String state;
	
	@NotNull
	@Size(min = 4, max = 15, message = "password should be 4-15 character long")
	private String password;
	
	private String type;

    public PatientDto() {
    	
    }
    
	public PatientDto(String userName, String fName, String lName, String contactNo, String gender,
			Integer age, String emailId, String city, String state, String password, String type) {
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
		this.password = password;
		this.type = type;
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
