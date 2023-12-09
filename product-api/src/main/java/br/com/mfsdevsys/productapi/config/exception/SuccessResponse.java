package br.com.mfsdevsys.productapi.config.exception;

import org.springframework.http.HttpStatus;

public class SuccessResponse {
	
	private Integer status;
	private String message;
	
	public SuccessResponse() {
    }
	
	public SuccessResponse(Integer status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static SuccessResponse create (String message) {
		
		SuccessResponse success =  new SuccessResponse();
		
		success.setStatus(HttpStatus.OK.value());
		success.setMessage(message);
	   
		return success;		
	}
	
	
}
