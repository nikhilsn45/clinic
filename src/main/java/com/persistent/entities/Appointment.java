package com.persistent.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Appointment {
	
	    @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
	    
	    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
        @JoinColumn(name = "doctorUserName", referencedColumnName = "userName")
	    private Doctor doc;
	    
        private String doctorName;
	    
	    private String doctorSpeciality;
	    
	    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
        @JoinColumn(name = "patientUserName", referencedColumnName = "userName")
	    private Patient pat;
	    
	    private String patientName;
	    
	    private int patientAge;
	    
	    private String date;
	    
	    private String timing;
	
	    private String status;
	    
		public Appointment() {
			super();
		}

		public Appointment(int id, Doctor doc, String doctorName, String doctorSpeciality, Patient pat,
				String patientName, int patientAge, String date, String timing, String status) {
			super();
			this.id = id;
			this.doc = doc;
			this.doctorName = doctorName;
			this.doctorSpeciality = doctorSpeciality;
			this.pat = pat;
			this.patientName = patientName;
			this.patientAge = patientAge;
			this.date = date;
			this.timing = timing;
			this.status = status;
		}


		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public Doctor getDoc() {
			return doc;
		}


		public void setDoc(Doctor doc) {
			this.doc = doc;
		}


		public Patient getPat() {
			return pat;
		}


		public void setPat(Patient pat) {
			this.pat = pat;
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
		
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}



		public String getDoctorName() {
			return doctorName;
		}



		public void setDoctorName(String doctorName) {
			this.doctorName = doctorName;
		}



		public String getDoctorSpeciality() {
			return doctorSpeciality;
		}



		public void setDoctorSpeciality(String doctorSpeciality) {
			this.doctorSpeciality = doctorSpeciality;
		}



		public String getPatientName() {
			return patientName;
		}



		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}



		public int getPatientAge() {
			return patientAge;
		}



		public void setPatientAge(int patientAge) {
			this.patientAge = patientAge;
		}
	   
	   
	    
	    
	   
	    
	    

}
