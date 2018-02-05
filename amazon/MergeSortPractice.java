package com.amazon;

import java.util.*;

public class MergeSortPractice {
	int[] array; 
	int[] helper; 
    int size; 
	
	public MergeSortPractice(int[] array) {
		this.array = array; 
		size = array.length; 
		helper = new int[size]; 
	}
	
	public int[] sort() {
		System.out.println("Sort array");
		mergesort(0, size-1); 
		return this.array; 
	}
	
	// Use the helper array to sort into the main array
	private void merge(int low, int middle, int high) {
		// First copy the array from low to high into the helper
		for (int i=low; i<high; i++) {
			helper[i]=array[i];
		}
		// Now sort back into the main array, the smaller element on the left
	    int i = low; 
	    int j = middle+ 1; 
	    int k = low; 
	    while ((i<= middle) && (j <= high)) {
			if (helper[i] < helper[j]) {
				array[k] = helper[i];
				i++;  
			} else {
				array[k] = helper[j];
				j++; 
			}
			k++;
	    }
	    // Now copy remainders 
	    while (i <= middle) {
	    	array[k] = helper[i];
			i++; 
			k++; 
	    }  
	    while (j <= high) {
	    	array[k] = helper[j];
			j++; 
			k++;
	    }
	}
	private void mergesort(int low, int high) {
		if (low < high) {
			System.out.println(low + " " + high);
			int middle = low + (high-low)/2; 
		    mergesort(low, middle); 
		    mergesort(middle+1, high);
		    merge(low, middle, high);  
		}
	}
	
	public static void main(String[] args) {
	   int[] array = {7,20,4,85,33,5,10,9};	
	   System.out.println("input array");
	   for (int i=0; i<array.length; i++) {
		   System.out.println(array[i] + " ");
	   }
	   
	   MergeSortPractice msp = new MergeSortPractice(array); 
	   int[] result = msp.sort();
	   System.out.println("print result"); 
	   for (int i=0; i<result.length; i++) {
		   System.out.println(result[i] + " ");
	   }
	}

}
