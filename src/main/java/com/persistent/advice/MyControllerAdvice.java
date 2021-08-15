package com.persistent.advice;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.persistent.exceptions.NoDoctorFoundException;
import com.persistent.exceptions.DuplicateUserFoundException;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(DuplicateUserFoundException.class)
	public ResponseEntity<String> handleDuplicateUserFound(DuplicateUserFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(NoDoctorFoundException.class)
	public ResponseEntity<String> handleNoDoctorFound(NoDoctorFoundException e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<String> handleSQLException(SQLException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleAnyException(Exception e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
	}
}
