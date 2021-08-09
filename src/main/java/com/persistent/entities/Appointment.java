package com.persistent.entities;

import javax.persistence.*;

@Entity
public class Appointment {
	
	    @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
	    
	    private String timing;
	    
	    private String doctorUserName;
	    
	    private String patientUserName;
	    
	    private String status;
	    
	    /*@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
        @JoinColumn(name = "doctorUserName", referencedColumnName = "userName")
	    private Doctor doc;
	    
	    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
        @JoinColumn(name = "patientUserName", referencedColumnName = "userName")
	    private Patient pat;
	    */
	    

		public Appointment() {
			super();
		}


		public Appointment(int id, String timing, String doctorUserName, String patientUserName, String status) {
			super();
			this.id = id;
			this.timing = timing;
			this.doctorUserName = doctorUserName;
			this.patientUserName = patientUserName;
			this.status = status;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getTiming() {
			return timing;
		}


		public void setTiming(String timing) {
			this.timing = timing;
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


		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
	   
	   
	    
	    
	   
	    
	    

}
