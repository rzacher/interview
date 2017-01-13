/**
 * Program to calculate a Fibonacci number using dynamic programming. 
 * i.e. we store the values for earlier results to reduce Big O time. 
 **/ 

import java.util.*; 


public class Fibonacci {

  HashMap<Integer, Long> fibMap = new HashMap<>(); 

  public Fibonacci() {
  
  }

  public long getFibNum(int n) {
    if (n<=1) {
      return 1; 
    } else if (fibMap.containsKey(n)) {
      long value = fibMap.get(n);
      return value; 
    } else {
       long value = getFibNum(n-1) + getFibNum(n-2); 
       if (value < 0) {
       	 System.out.println("the value overflowed the limit for a long number");
         return 0; 
       } else {
         fibMap.put(n, value); 
         return value; 
       }
    }
  }

  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Please provide a fibonacci number");
    }

    try {
      int n = Integer.parseInt(args[0]);
      Fibonacci fib = new Fibonacci();
      long startTime = System.currentTimeMillis(); 
      long fibNum = fib.getFibNum(n); 
      long endTime = System.currentTimeMillis(); 
      long duration = (endTime - startTime)/1000; 
      System.out.println("Duration: " + duration);
      System.out.println("The " + n + "\'th fibonacci number is " + fibNum); 
    } catch (NumberFormatException ne) { 
        ne.printStackTrace(); 
        System.out.println("argument cannot be converted to a number"); 
    } 
  } // main


}
