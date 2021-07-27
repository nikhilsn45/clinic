package com.persistent.entities;
import javax.persistence.*;

@Entity
public class Doctor {
	
	    @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int license_no;
		
        private String f_name;
		
		private String l_name;
		
        private String speciality;
		
		private String contact_no;
		
		private String state;
		
        private String city;
		
		private String password;

		public Doctor() {
		}
		
		public Doctor(int license_no, String f_name, String l_name, String speciality, String contact_no, String state,
				String city, String password) {
			super();
			this.license_no = license_no;
			this.f_name = f_name;
			this.l_name = l_name;
			this.speciality = speciality;
			this.contact_no = contact_no;
			this.state = state;
			this.city = city;
			this.password = password;
		}



		public int getLicense_no() {
			return license_no;
		}


		public void setLicense_no(int license_no) {
			this.license_no = license_no;
		}


		public String getSpeciality() {
			return speciality;
		}


		public void setSpeciality(String speciality) {
			this.speciality = speciality;
		}


		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
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


		public String getContact_no() {
			return contact_no;
		}

		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public void setContact_no(String contact_no) {
			this.contact_no = contact_no;
		
		}
		
		public String getState() {
			return state;
		}


		public void setState(String state) {
			this.state = state;
		}
		

		
		

}
