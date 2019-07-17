package com.wwegoo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.wwegoo.model.ExceptionHandlerModel;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	private static final String DEFAULT_EXCEPTION = "default_exception";

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionHandlerModel> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionHandlerModel exceptionResponse = new ExceptionHandlerModel(new Date(), DEFAULT_EXCEPTION,
				ex.getMessage());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public final ResponseEntity<ExceptionHandlerModel> handleCategoryNotFoundException(CategoryNotFoundException ex, WebRequest request) {
		ExceptionHandlerModel exceptionResponse = new ExceptionHandlerModel(new Date(), CategoryNotFoundException.DEFAULT_EXCEPTION, ex.getMessage());
		return new ResponseEntity<>(exceptionResponse, ex.getHttpStatus());
	}     
}
