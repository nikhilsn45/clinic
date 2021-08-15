package com.persistent.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	    
	    private String timing;
	    
	    private String status;
	    
	    @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "doctorUserName", referencedColumnName = "id")
	    private Doctor doc;
	    
	    @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "patientUserName", referencedColumnName = "id")
	    private Patient pat;
	    
	    @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "feedback", referencedColumnName = "id")
	    private FeedBack feed;
	    

		public Appointment() {
			super();
		}


		public Appointment(int id, String timing, String status, Doctor doc, Patient pat, FeedBack feed) {
			super();
			this.id = id;
			this.timing = timing;
			this.status = status;
			this.doc = doc;
			this.pat = pat;
			this.feed = feed;
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


		public FeedBack getFeed() {
			return feed;
		}


		public void setFeed(FeedBack feed) {
			this.feed = feed;
		}


		@Override
		public String toString() {
			return "Appointment [id=" + id + ", timing=" + timing + ", status=" + status + ", doc=" + doc + ", pat="
					+ pat + ", feed=" + feed + "]";
		}
	   

}
