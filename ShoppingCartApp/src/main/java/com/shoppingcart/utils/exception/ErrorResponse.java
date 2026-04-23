package com.shoppingcart.utils.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

	private String errorMessage;
	private Integer status;
	private LocalDateTime timestamp;
	
	public ErrorResponse(String errorMessage, Integer status) {
		this.errorMessage=errorMessage;
		this.status=status;
		this.timestamp= LocalDateTime.now();
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
