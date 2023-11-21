package br.com.mfsdevsys.productapi.config.exception;

import java.util.Objects;

public class ExceptionDetails {
	
	private int status;
	private String message;
	
	public ExceptionDetails() {
		
	}

	public ExceptionDetails(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		return Objects.hash(message, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExceptionDetails other = (ExceptionDetails) obj;
		return Objects.equals(message, other.message) && status == other.status;
	}
	
	
	

}
