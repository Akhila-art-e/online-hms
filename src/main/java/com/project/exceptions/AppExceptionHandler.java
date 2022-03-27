package com.project.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.project.exceptions.vo.ApiError;

@ControllerAdvice
public class AppExceptionHandler {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ApiError>> handleMethoArgumentExceptoin(
			MethodArgumentNotValidException exception,
			WebRequest webrequest
	) {
		
		List<ApiError> errors = exception.getFieldErrors()
		    	.stream().map(result -> {
		    		ApiError apiError = new ApiError();
		    		apiError.setMessage(result.getDefaultMessage());
		    		apiError.setStatus(getStatusCode(result.getField()));
		    		return apiError;
		    	})
		    	.collect(Collectors.toList());
		return new ResponseEntity<List<ApiError>>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OHISBusinessException.class)
	public ResponseEntity<List<ApiError>> handleOHISBusinessExceptoin(
			OHISBusinessException exception,
			WebRequest webrequest
	) {
		
		ApiError apiError = new ApiError();
		apiError.setMessage(exception.getMessage());
		apiError.setStatus(exception.getStatusCode());
		
		List<ApiError> errors = new ArrayList<>();
		errors.add(apiError);
		
		return new ResponseEntity<List<ApiError>>(errors, HttpStatus.BAD_REQUEST);
	}

	private String getStatusCode(String field) {
		switch (field) {	
		case "emailID":
			return "601";
			
		case "password":
			return "603";
		
		case "name":
			return "602";
			
		case "retypePassword":
			return "604";
			
		case "address":
			return "605";
			
		case "phoneNo":
			return "606";

		default:
			return "0";
		}
	}
}
