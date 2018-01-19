package com.newstuff;

import java.util.*;
import java.lang.*;


// Program to test Math.sign method
public class Sign {


  public static void main(String[] args) {
     int a = 100; 
     int b = 200;
     
     int[] array = {a,b}; 
     double  sign =  Math.signum((double) (b-a));
     int index = (int) (0.5 + sign/2);
     System.out.println(index);
     System.out.println(array[index]);
  }
}
