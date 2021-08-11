package com.persistent.exceptions;

public class NoDoctorFoundException extends RuntimeException{
	
	private String message;

	public NoDoctorFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
