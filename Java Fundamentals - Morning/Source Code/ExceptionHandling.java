package Assignments;


@SuppressWarnings("serial")
class MyUncheckedException extends RuntimeException {
	   private String message = new String("It is an prime number");

   

	public String message() {
        return this.message;
    }
	}

public class ExceptionHandling {
	
	public static void main(String[] args) throws Exception {
		  
		  for (int i = 1; i <= 100; i++) {
		    if (!isPrime(i)) 
		      System.out.println(i);
		    else {
		    try{
		    	throw new MyUncheckedException(); 
		    }
		    catch(MyUncheckedException e){
		    	System.out.println(e.message() +" "+ i);
		    }
		    }
		    
		  }
	}  
		  
	public static boolean isPrime(int num) {
		  if (num <= 1)
		    return false;
		  if ((num % 2) == 0) 
		    return (num == 2);
		  for (int i = 3; i <= (int) (Math.sqrt(num) + 1); i += 2)
		    if ((num % i) == 0)
		      return false;

		  return true;
		  
		}
}

