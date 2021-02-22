package Assignments;

import java.io.*;

class Employee implements java.io.Serializable {
	
	   @SuppressWarnings("unused")
	private static final long SerialVersionUID = 10l;
	   public String name;
	   public String address;
	   public transient int SSN;
	   public int number;
	   public transient String dept;
	   
	   public void mailCheck() {
	      System.out.println("Mailing a check to " + name + " " + address);
	   }
	}

public class Serialization {

   public static void main(String [] args) {
      Employee e = new Employee();
      e.name = "Ayushi Garg";
      e.address = "Jaipur";
      e.SSN = 10101;
      e.number = 1001;
      e.dept = "Finance";
      try {
         FileOutputStream fileOut =
         new FileOutputStream("C://Users//prade//OneDrive//Desktop//java/employee.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in C://Users//prade//OneDrive//Desktop//java/employee.ser");
      } catch (IOException i) {
         i.printStackTrace();
      }
      
      
   }
}