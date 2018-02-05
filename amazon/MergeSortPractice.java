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
	
	protected void merge(int low, int middle, int high) {
		 
		 // Copy both parts into the helper array
		 for (int i=low; i<=high;  i++) {
			 helper[i] =array[i];
		 }
		 
		 // Copy the smallest values from the helper array back into the original array
		 int i = low;
		 int j = middle + 1;
		 int k = low; // k is for thearray array
		 while ((i <= middle) && (j <= high)) {
			 if (helper[i] < helper[j]) {
				array[k] = helper[i];
				 i++;		 
			 } else {
				array[k] = helper[j];
				 j++;
			 }
			 k++;  
		 }
		 
		 // Now copy the remainder of one side to the rest of the array
		 while (i <= middle)  {
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
