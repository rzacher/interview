/*
 * 
 * A chile is running up a staircase with n steps and can hop
 * either 1, 2 or 3 steps at a time. count how many possible
 * ways the child can run up the stairs.
 */




package com.crack; 

import java.util.*; 

public class StairClimber {

   int steps; 

  public StairClimber(int steps) {
     this.steps = steps; 
  } 

   public int countPaths() {
     int currentPosition = 0; 

     return takeSteps(currentPosition); 
   }

   int takeSteps(int currentPosition) {
      if (currentPosition == steps) {
         return 1; 
      } else if (currentPosition > steps) {
        return 0;  //busted. 
      } else {
        int returnVal = takeSteps(currentPosition + 1) 
        + takeSteps(currentPosition + 2)
        + takeSteps(currentPosition + 3);
        return returnVal;   
      }
   }



   public static void main(String[] args) {
      int steps = 3; 
      StairClimber sc = new StairClimber(steps); 

      int paths = sc.countPaths(); 
      System.out.println(paths); 
   }
}
