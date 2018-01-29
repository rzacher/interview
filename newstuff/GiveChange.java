/**
A vending machine needs to give  N cents  change.
It has  n_5  nickels, n_10 dimes, and n_25 quarters.  
Quarters  have priority over dimes, dimes have priority over  nickels. 
Create an algorithm that returns a change or fails if change is not possible.  
**/

package com.newstuff; 

import java.io.IOException;
import java.util.*; 

public class GiveChange {
    int nickels;
    int dimes; 
    int quarters;

    public GiveChange(int nickels, int dimes, int quarters) {
       this.nickels = nickels;
       this.dimes = dimes; 
       this.quarters = quarters; 
    } 


    int[] makeChange(double total) throws IOException {
      if (total < 0) {
         throw new IOException("total is less than 0"); 
      }
      
      // Convert change to cents
      int totalCents = (int) (total * 100); 

      // check that change is possible
      if (totalCents % 5 != 0) {
        throw new IOException("total not divisible by 5"); 
      }
     

      // Assume that we have enough of each species
      int requestedQuarters = totalCents/25; 
      int remainderQuarters = totalCents - requestedQuarters*25; 
      int requestedDimes = remainderQuarters/10; 
      int remainderDimes = remainderQuarters - requestedDimes*10; 
      int requestedNickels = remainderDimes/5; 
      int remainderNickels = remainderDimes - requestedNickels*5; 
 
      if (remainderNickels > 0) {
          throw new  IOException("Error making change");    
      }
      
      int[] result= {requestedQuarters, requestedDimes, requestedNickels}; 
      return result;    
    }

    public static void main(String[] args) {
       if (args.length < 1) {
         System.out.println("please provide a total");
         System.exit(1); 
       }
       try {
	       double total = Double.parseDouble(args[0]); 
	       GiveChange gc = new GiveChange(20, 20 ,20); 
	       int[] result = gc.makeChange(total); 
	       
	       System.out.println("Quarters: " + result[0]);
	       System.out.println("Dimes: " + result[1]);
	       System.out.println("Nickel: " + result[2]);
       } catch (IOException e) {
    	   System.out.println("Caught IOException"); 
       }
    }
}
