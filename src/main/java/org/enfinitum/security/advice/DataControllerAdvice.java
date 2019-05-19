package org.enfinitum.security.advice;

import org.enfinitum.security.Exception.ApiError;
import org.enfinitum.security.Exception.DataNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DataControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(DataNotFoundException ex) {

		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
		apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<Object>(apiError, apiError.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ApiError errorDetails = new ApiError(HttpStatus.NOT_ACCEPTABLE);
		errorDetails.setMessage(ex.getBindingResult().toString());
		return buildResponseEntity(errorDetails);
	}
}
