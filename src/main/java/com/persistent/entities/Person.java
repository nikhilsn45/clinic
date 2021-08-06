package com.persistent.entities;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {
	
    protected String userName;
	
    protected String fName;
	
    protected String lName;
    
    protected String contactNo;

	public Person(String userName, String fName, String lName, String contactNo) {
		super();
		this.userName = userName;
		this.fName = fName;
		this.lName = lName;
		this.contactNo = contactNo;
	}

	public Person() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Person [userName=" + userName + ", fName=" + fName + ", lName=" + lName 
				+ ", contactNo=" + contactNo + "]";
	}
    
    
}
