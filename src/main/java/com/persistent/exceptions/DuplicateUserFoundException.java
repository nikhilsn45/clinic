package com.persistent.exceptions;

public class DuplicateUserFoundException extends RuntimeException{
	
	private String message;

	public DuplicateUserFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
