package com.newstuff;

import java.util.Arrays;
import java.util.Collections;

public class KthLargest {
	
	Integer[] kthLargest(int k, int[] input) {
		// sort the array, 
		Integer[] whatever = Arrays.stream( input).boxed().toArray( Integer[]::new );
		Arrays.sort(whatever, Collections.reverseOrder());
		
		return whatever; 
	}
	
	void printArray(Integer[] array, int k) {
		for (int i=0; i<k; i++) {
			System.out.print(array[i] + " ");
		}
		
		//return the k largest
		System.out.println(); 
	}
	public static void main(String[] args) {
	  int[] input = {3,8,44,5,88,23,64,14,22};
	  int k = 3; 
	  KthLargest kl = new KthLargest(); 
	  Integer[] result = kl.kthLargest(k, input); 
	  
	  kl.printArray(result, k); 
		
	}

}
