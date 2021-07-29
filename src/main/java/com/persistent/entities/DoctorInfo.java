package com.persistent.entities;
import javax.persistence.*;

@Entity
public class DoctorInfo {
	
	    @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
	    
		private String license_no;
	    
	    private String user_name;
		
		private String f_name;
		
		private String l_name;
		
        private String specialization;
		
		private String contact_no;
		
		private String state;
		
        private String city;

		public DoctorInfo() {
		}

		public DoctorInfo(int id, String license_no, String user_name, String f_name, String l_name, String specialization,
				String contact_no, String state, String city) {
			super();
			this.id = id;
			this.license_no = license_no;
			this.user_name = user_name;
			this.f_name = f_name;
			this.l_name = l_name;
			this.specialization = specialization;
			this.contact_no = contact_no;
			this.state = state;
			this.city = city;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getLicense_no() {
			return license_no;
		}

		public void setLicense_no(String license_no) {
			this.license_no = license_no;
		}

		public String getUser_name() {
			return user_name;
		}

		public void setUser_name(String user_name) {
			this.user_name = user_name;
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

		public String getSpecialization() {
			return specialization;
		}

		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}

		public String getContact_no() {
			return contact_no;
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

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		@Override
		public String toString() {
			return "DoctorInfo [id=" + id + ", license_no=" + license_no + ", user_name=" + user_name + ", f_name="
					+ f_name + ", l_name=" + l_name + ", specialization=" + specialization + ", contact_no=" + contact_no
					+ ", state=" + state + ", city=" + city + "]";
		}
				
		
}
