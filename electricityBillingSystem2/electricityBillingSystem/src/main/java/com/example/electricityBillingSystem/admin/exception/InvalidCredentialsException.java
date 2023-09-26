package com.example.electricityBillingSystem.admin.exception;

public class InvalidCredentialsException extends Exception{
	
	private String msg;

	public InvalidCredentialsException() {
		super();
	}

	public InvalidCredentialsException(String msg) {
		super();
		this.msg = msg;
	}
	

}
