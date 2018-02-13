package com.amazon;

public class MergeSort {
	int[] input;
	int[] helper;
	int length = 0; 
	
	public MergeSort(int[] input) {
		this.input = input;
		length = input.length;
	    helper = new int[length];
		
	}
	
	public int[] sort(int[] input) {
	   // Split the array in half, recursively, when we
	   // get down to 1 element arrays, then merge the results. 
	  mergesort(0, input.length-1);
	  return input; 
	}
	
	protected void mergesort(int low, int high) {
		if (low < high ) { // More sorting to do
            // lets subdivide further
			int middle = low + (high - low)/ 2;
			mergesort(low, middle);
			mergesort(middle+1, high);
			merge(low, middle, high);
		}
	} 
	
	 protected void merge(int low, int middle, int high) {
		 
		 // Copy both parts into the helper array
		 for (int i=low; i<=high;  i++) {
			 helper[i] = input[i];
		 }
		 
		 // Copy the smallest values from the helper array back into the original array
		 int i = low;
		 int j = middle + 1;
		 int k = low; // k is for the input array
		 while ((i <= middle) && (j <= high)) {
			 if (helper[i] < helper[j]) {
				 input[k] = helper[i];
				 i++;		 
			 } else {
				 input[k] = helper[j];
				 j++;
			 }
			 k++;  
		 }
		 
		 // Now copy the remainder of one side to the rest of the array
		 while (i <= middle)  {
			 input[k] = helper[i];
			 i++;
			 k++;
		 }
		 
		 while (j <= high) {
			 input[k] = helper[j];
			 j++;
			 k++;
		 }	  
	 }
		
	 protected void printResult() {
		 for (int i=0; i<length; i++) {
			 System.out.print(input[i] + " ");
		 }
	 }
		

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create the test array
		int[] input = new int[] {7,20,4,85,33,5,10,9};
		
		MergeSort mergeSort = new MergeSort(input);
		mergeSort.sort(input);
		mergeSort.printResult();
	}

}
