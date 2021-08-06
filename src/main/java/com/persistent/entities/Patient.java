package com.persistent.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Patient extends Person {
			
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String gender;

	private Integer age;

	private String emailId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId", referencedColumnName = "id")
	private Address address;

	public Patient(String userName, String fName, String lName, String contactNo, int id, String gender, Integer age,
			String emailId, Address address2) {
		super(userName, fName, lName, contactNo);
		this.id = id;
		this.gender = gender;
		this.age = age;
		this.emailId = emailId;
		address = address2;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", gender=" + gender + ", age=" + age + ", emailId=" + emailId + ", address="
				+ address + "]";
	}
	

}
