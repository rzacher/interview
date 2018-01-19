package com.newstuff; 

import java.util.*;

public class Lambda {
	
	
   private int operate(int a, int b, MathOperation mathOperation){
      return mathOperation.operation(a, b);
   }
   
   interface MathOperation {
      int operation(int a, int b);
   }
   
   interface GreetingService {
     void sayMessage(String message); 
   } S

    public static void main(String[] args) {
        Lambda tester = new Lambda(); 
        
		System.out.println("Running Lambda expressions");
		
		MathOperation addition = (int a, int b) -> a + b; 
		MathOperation multiplication = (int a, int b) -> a * b;
		
		System.out.println("10 + 5 = " + tester.operate(10, 5, addition)); 
		System.out.println("10 * 5 = " + tester.operate(10, 5, multiplication));
		
		GreetingService service1 = (message) -> System.out.println("Message: " + message); 
		service1.sayMessage("Hi Bob"); 
    }
}

