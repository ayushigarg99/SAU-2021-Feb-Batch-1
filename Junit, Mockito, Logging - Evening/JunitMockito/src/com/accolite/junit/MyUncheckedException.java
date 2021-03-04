package com.accolite.junit;

public class MyUncheckedException extends RuntimeException {
	String message;

	public MyUncheckedException(String string) {
		this.message = string;
	}
	
	public String getException() {
		return message;
	}
	public void printException() {
		System.out.println("It is a prime number");
		
	}
	
}
