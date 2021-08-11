package com.persistent.entities;

public class AppointAJAX {

	String doc,timing,status;

	public AppointAJAX() {}
	
	public AppointAJAX(String doc, String timing, String status) {
		super();
		this.doc = doc;
		this.timing = timing;
		this.status = status;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
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

}
