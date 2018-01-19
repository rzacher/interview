package com.newstuff;

import java.util.*;

public class ArrayTest {

    public void printArray(int[] array) {
        for (int val : array) {
          System.out.print(val + " "); 
        }
    }

    public void printSimpleArray() {
        int [] arrayOne = {1,2,3,4};
        
        printArray(arrayOne);
        System.out.println();  
    }


    public void print2DArray() {
      int[][] deltas = {
        {-1,-1}, {-1, 0}, {-1,1}
      };
      
      for (int[] delta: deltas) {
         printArray(delta); 
      } 
    }
    public static void main(String[] args) {
       ArrayTest test = new ArrayTest();
       
       test.printSimpleArray(); 
       test.print2DArray(); 
    }
}
