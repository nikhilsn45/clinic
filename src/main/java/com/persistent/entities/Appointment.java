package com.persistent.entities;

import javax.persistence.*;

import org.modelmapper.ModelMapper;

import com.persistent.dto.AppointmentDto;

@Entity
public class Appointment {
	
	    @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
	    
	    private String timing;
	    
	    private String status;
	    
	    @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "doctorUserName", referencedColumnName = "id")
	    private Doctor doc;
	    
	    @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "patientUserName", referencedColumnName = "id")
	    private Patient pat;
	    

		public Appointment() {
			super();
		}
	   
		public Appointment(int id, String timing, String status, Doctor doc, Patient pat) {
			super();
			this.id = id;
			this.timing = timing;
			this.status = status;
			this.doc = doc;
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

}
