package com.accolite.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.mockito.Mockito;


public class ExceptionHandling {
	
	public static void main(String[] args) throws Exception {
		//MyUncheckedException e = Mockito.mock(MyUncheckedException.class);
		ExceptionHandling exp = new ExceptionHandling();
		//Mockito.when(e.getException()).thenReturn("It is a prime number");
		exp.counter();
		    
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
	
	
	@Test
	public void counter() {
		for (int i = 1; i <= 100; i++) {
		    if (!isPrime(i)) 
		    	
		      System.out.println(i);
		   
		    else {
		    	String message = "It is a prime number";
		    	 //fail("Failed");                                // Junit Testing
		    try{
		    	throw new MyUncheckedException(message);
		    }
		   
		    catch(MyUncheckedException e){
		    	assertEquals(message,e.getException());         // Junit Testing
		    	System.out.println(e.getException());	
		    }  
		}
	}
}
}

