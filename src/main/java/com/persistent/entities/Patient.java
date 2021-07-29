package com.persistent.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
	
	        @Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			private int id;
	        
	        private String user_name;
			
	        private String f_name;
			
			private String l_name;
			
	        private String email_id;
	        
	        private String gender;
	        
	        private int age;
	        
	        private String city;
	        
	        private String state;
	        
	        private String contact_no;
	        
            public Patient(int id, String user_name, String f_name, String l_name, String email_id, String gender,
					int age, String city, String state, String contact_no) {
				super();
				this.id = id;
				this.user_name = user_name;
				this.f_name = f_name;
				this.l_name = l_name;
				this.email_id = email_id;
				this.gender = gender;
				this.age = age;
				this.city = city;
				this.state = state;
				this.contact_no = contact_no;
            }
            
			
			public Patient() {
			}

			

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getF_name() {
				return f_name;
			}

			public void setF_name(String f_name) {
				this.f_name = f_name;
			}

			public String getL_name() {
				return l_name;
			}

			public void setL_name(String l_name) {
				this.l_name = l_name;
			}

			public String getEmail_id() {
				return email_id;
			}

			public void setEmail_id(String email_id) {
				this.email_id = email_id;
			}

			public String getContact_no() {
				return contact_no;
			}

			public void setContact_no(String contact_no) {
				this.contact_no = contact_no;
			}

			public String getUser_name() {
				return user_name;
			}

			public void setUser_name(String user_name) {
				this.user_name = user_name;
			}

			public String getGender() {
				return gender;
			}


			public void setGender(String gender) {
				this.gender = gender;
			}


			public int getAge() {
				return age;
			}


			public void setAge(int age) {
				this.age = age;
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
				return "UserInfo [id=" + id + ", user_name=" + user_name + ", f_name=" + f_name + ", l_name=" + l_name
						+ ", email_id=" + email_id + ", contact_no=" + contact_no + "]";
			}
			
			

}
