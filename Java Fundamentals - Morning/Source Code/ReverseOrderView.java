package Assignments;

import java.util.*;

public class ReverseOrderView {
	public static void main(String args[]) 
    {  
        Map<String, String> map =  new TreeMap<String, String>(Collections.reverseOrder()); 
  
        map.put("1", "Welcome"); 
        map.put("2", "to"); 
        map.put("3", "Accolite"); 
         
        Set set = map.entrySet(); 
        Iterator i = set.iterator(); 
  
        while (i.hasNext()) { 
            Map.Entry me = (Map.Entry)i.next(); 
            System.out.print(me.getKey() + ": "); 
            System.out.println(me.getValue()); 
        } 
    } 

}
