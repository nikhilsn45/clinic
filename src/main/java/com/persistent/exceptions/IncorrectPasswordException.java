package com.persistent.exceptions;

public class IncorrectPasswordException extends RuntimeException{
	
	private String message;

	public IncorrectPasswordException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
