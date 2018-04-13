package com.newstuff;

import java.util.Arrays;

/*
Pythagorean Triplet in an array

Given an array of integers, write a function that returns true if 
there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
*/

public class PythagoreanTriplet {
	static void  printTriplet(int a, int b, int c) {
		System.out.println(a + " " + b + " " + c); 
	}
	
	static void findTripletsBrute(int[] input) {
		System.out.println("Brute"); 
		int length = input.length; 
		for (int i=0; i<length; i++) {
			for (int j=0; j< length; j++) {
				for (int k=0; k<length; k++) {
					if (isTriplet(input[i], input[j], input[k])) {
						printTriplet(input[i], input[j], input[k]); 
					}
				}
			}
		}
	}
	
	static void findTripletsBetter(int[] input) {
		System.out.println("Better"); 
		// Sort the array
		Arrays.sort(input); 
		
		// square the elements. 
		for (int i=0; i< input.length; i++) {
			int val = input[i];
			input[i]=val*val; 
		}
		
		// Start with the largest element as c
		for (int n=input.length-1; n>0; n-- ) {
			int c = input[n];
		  // from begin and end, work from ends to center. 
		  for (int j=n-1; j>0; j--) {
			  int b = input[j];
			  for (int k=0; k<j; k++) {
				 int a = input[k]; 
				 if (isSquaredTriplet(a,b,c)) {
					 System.out.println(a + " " + b + " " + c); 
				 }  
			  }  // end k
		  } //end j
		}// end n
		
		
	}
	
	static void testConditional() {
	  int a=1;
	  int b=0;
	  
	  int result = a==1?1:2;
	  System.out.println("result=" + result);
	  
	}
	
	static boolean isTriplet(int a, int b, int c) { 
		if (a*a + b*b == c*c) return true;
		else return false; 
		//return (pythag = true? true: false);  
	}
	
	static boolean isSquaredTriplet(int a, int b, int c) { 
		if (a + b == c) return true;
		else return false; 
		//return (pythag = true? true: false);  
	}
	
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7,8,9,10,11,12, 13, 14, 15,16,17,18,19,20,21,22,23,24};
		findTripletsBrute(input);
		findTripletsBetter(input);
		testConditional(); 
		
	}

}
