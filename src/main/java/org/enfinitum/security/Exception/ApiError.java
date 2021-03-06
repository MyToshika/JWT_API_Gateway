package org.enfinitum.security.Exception;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {

	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	
	private String message;
	private String debugMessage;

	private ApiError() {
	}

	public ApiError(HttpStatus status) {
		this();
		this.setStatus(status);
	}

	public ApiError(HttpStatus status, Throwable ex) {
		this();
		this.setStatus(status);
		this.setMessage("Unexpected error");
		this.setDebugMessage(ex.getLocalizedMessage());
	}

	public ApiError(HttpStatus status, String message, Throwable ex) {
		this();
		this.setStatus(status);
		this.setMessage(message);
		this.setDebugMessage(ex.getLocalizedMessage());
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}
}
