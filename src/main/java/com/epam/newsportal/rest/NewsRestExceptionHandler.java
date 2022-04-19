package com.epam.newsportal.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NewsRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<NewsErrorResponse> handleException(NewsNotFoundException exc) {
		
		NewsErrorResponse error = new NewsErrorResponse(
										HttpStatus.NOT_FOUND.value(),
										exc.getMessage(),
										System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleException(MethodArgumentNotValidException exc) {
		Map<String, String> errors = new HashMap<>();
		exc.getBindingResult().getAllErrors().forEach((error) ->{
			
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<NewsErrorResponse> handleException(Exception exc) {
		
		NewsErrorResponse error = new NewsErrorResponse(
										HttpStatus.BAD_REQUEST.value(),
										exc.getMessage(),
										System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
