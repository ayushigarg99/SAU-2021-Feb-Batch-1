package com.accolite.logger;
import org.apache.log4j.*;


public class ExceptionHandling {
	private static org.apache.log4j.Logger logger = Logger.getLogger(ExceptionHandling.class);
	public static void main(String[] args) throws Exception {
		
		ExceptionHandling exp = new ExceptionHandling();
		logger.debug("debug");
		exp.counter();
		logger.debug("debug");
		    
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
	
	public void counter() {
		for (int i = 1; i <= 100; i++) {
		    if (!isPrime(i)) 	
		      System.out.println(i);
		    else {
		    	String message = "It is a prime number";                             
		    try{
		    	throw new MyUncheckedException(message);
		    }
		    catch(MyUncheckedException e){	 
		    	logger.error(e.getMessage(), e);
		    		
		    }  
		}
	}
}
}

