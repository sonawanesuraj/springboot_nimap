package com.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	// handle specific exception 
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest request)
	{
		ErrorDetails errorDetail = new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetail,HttpStatus.NOT_FOUND);
	}
	
	
}
