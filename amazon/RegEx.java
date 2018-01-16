package com.amazon;

import java.util.regex.*;

public class RegEx {
	
	public void run() {
		System.out.println("Running regEx"); 
		// String to be scanned to find the pattern.
	      String line1 = "This order was placed for QT3000! OK?";
	      String pattern1 = "(.*)(\\d+)(.*)";  // QT3000
	      String pattern2 = "([p][l](.*)[d])";  // placed
	      String pattern3 = "[!]";  // !
	      
	      // Try ip  matching 
	      String line2 = "10.10.15.221"; 
	      String pattern4 = "(\\d{1,2,3})(\\.)(\\d{1,2,3})(\\.)(\\d{1,2,3})(\\.)(\\d{3})";
 
	      // use this section to set the line and pattern to use
	      String line = line2;
	      String pattern = pattern4; 
	      
	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher m = r.matcher(line);
	      if (m.find( )) {
	         System.out.println("Found value: " + m.group(0) );
	         System.out.println("Found value: " + m.group(1) );
	         System.out.println("Found value: " + m.group(2) );
	      }else {
	         System.out.println("NO MATCH");
	      }
	
	}

	public static void main(String[] args) {
		RegEx re = new RegEx(); 
		re.run(); 
	}

}

