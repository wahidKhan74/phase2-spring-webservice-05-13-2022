package com.simplilearn.webservice.exception;

public class AllreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AllreadyExistException(String message) {
		super(message);
	}
}
