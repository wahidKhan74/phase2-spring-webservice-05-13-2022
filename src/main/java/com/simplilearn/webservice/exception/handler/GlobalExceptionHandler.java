package com.simplilearn.webservice.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.simplilearn.webservice.exception.AllreadyExistException;
import com.simplilearn.webservice.exception.InvalidException;
import com.simplilearn.webservice.exception.NotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	ExceptionResponse response;

	// Not Found Exception
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionResponse> notFound(NotFoundException ex) {
		response = new ExceptionResponse(ex.getMessage(), HttpStatus.NOT_FOUND.name(), ex.getClass().getSimpleName(),
				new Date());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	// Invalid data Exception
	@ExceptionHandler(InvalidException.class)
	public ResponseEntity<ExceptionResponse> invalidException(InvalidException ex) {
		response = new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.name(), ex.getClass().getSimpleName(),
				new Date());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

	// Already Exist Exception
	@ExceptionHandler(AllreadyExistException.class)
	public ResponseEntity<ExceptionResponse> allreadyExistException(AllreadyExistException ex) {
		response = new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.name(), ex.getClass().getSimpleName(),
				new Date());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}
}
