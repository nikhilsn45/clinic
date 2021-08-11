package com.persistent.exceptions;

public class DetailsNotFoundException extends RuntimeException{
	
	private String message;

	public DetailsNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
