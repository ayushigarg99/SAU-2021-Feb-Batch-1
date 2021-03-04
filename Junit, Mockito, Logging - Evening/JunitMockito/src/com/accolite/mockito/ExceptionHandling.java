package com.accolite.mockito;

import org.mockito.Mockito;

public class ExceptionHandling {
	
	public static void main(String[] args) throws Exception {
		
		ExceptionHandling exp = Mockito.mock(ExceptionHandling.class);
		
		Mockito.when(exp.counter()).thenReturn("Counting Completes");
		
		System.out.println(exp.counter());	    
	}
	
	public boolean isPrime(int num) {
		
		  if (num <= 1)
		    return false;
		  if ((num % 2) == 0) 
		    return (num == 2);
		  for (int i = 3; i <= (int) (Math.sqrt(num) + 1); i += 2)
		    if ((num % i) == 0)
		      return false;

		  return true;
		  
	}
	
	public String counter() {
		for (int i = 1; i <= 100; i++) {
		    if (!isPrime(i)) 
		    	
		      System.out.println(i);
		   
		    else {
		    	String message = "It is a prime number";
		    try{
		    	throw new MyUncheckedException(message);
		    }
		   
		    catch(MyUncheckedException e){
		    	        
		    	System.out.println(e.getException());	
		    }  
		}
	}
		return "Counter Method Ends";
}
}

