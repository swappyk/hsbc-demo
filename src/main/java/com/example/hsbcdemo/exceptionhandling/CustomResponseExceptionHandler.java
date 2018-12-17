package com.example.hsbcdemo.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.hsbcdemo.customexception.EmployeeNotFoundException;
import com.example.hsbcdemo.customexception.GenericException;

@ControllerAdvice
@RestController
public class CustomResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

		GenericException exception = new GenericException(101, ex.getMessage());

		return new ResponseEntity<Object>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
