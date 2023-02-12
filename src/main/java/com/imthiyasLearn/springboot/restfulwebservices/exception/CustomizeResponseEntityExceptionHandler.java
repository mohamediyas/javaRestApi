package com.imthiyasLearn.springboot.restfulwebservices.exception;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.imthiyasLearn.springboot.restfulwebservices.user.UserNotFoundException;



@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		
		ErrorDetails details = new ErrorDetails(LocalDate.now(),ex.getMessage(), request.getDescription(false));
		
	     return	new ResponseEntity<>(details,HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		
	}
	
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		
		ErrorDetails details = new ErrorDetails(LocalDate.now(),ex.getMessage(), request.getDescription(false));
		
	     return	new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
		
		
		
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		ErrorDetails details = new ErrorDetails(LocalDate.now(),ex.getMessage(), request.getDescription(false));
		
	     return	new ResponseEntity<>(details,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}
