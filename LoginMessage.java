package com.main.message;

public class LoginMessage {
	String message;
	Boolean status;

	public LoginMessage() {
		super();
		
	}

	public LoginMessage(String message, Boolean status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
