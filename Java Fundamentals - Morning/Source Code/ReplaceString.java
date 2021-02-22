package Assignments;

import java.util.*;

public class ReplaceString {
	public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter string : ");
		String str = sc.nextLine();
		
		System.out.println("Enter string to be replaced : ");
		String toReplace = sc.nextLine();
		
		System.out.println("Enter string to be replaced with : ");
		String replaceWith = sc.nextLine();

        String new_str = str.replaceAll(toReplace, replaceWith);
       
        System.out.println("Original string: " + str);
        System.out.println("New String: " + new_str);
        sc.close();
    }
}
