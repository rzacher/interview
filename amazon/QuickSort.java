package com.amazon;

public class QuickSort {
	int[] input = null;
	int length = 0; 
	
	QuickSort() {
		
	}
	
	public void sort(int[] input) {
		this.input = input;
		length = input.length;
		printArray();
		quicksort(0, length - 1); 
	}
	
	private void quicksort(int low, int high) {
		
		// pick the pivot
		int pivot = low + (high - low)/2;
		int pivotValue =  input[pivot];
		System.out.println("low=" + low + ", high=" + high + " pivot=" + pivotValue);
		
		int i = low;
	    int j = high;
	    
	    while (i <= j) {
		    while (input[i] < pivotValue) {
		    	i++;
		    }
		    
		    while (input[j] > pivotValue) {
		    	j--;
		    }
			
		    // we should now have two swappable elements
		    if (i <= j) {
		    	swap(i, j);
		    	i++;
		    	j--;
		    }
	    }
	    System.out.println("i=" + 1 + ", j=" + j);
	    printArray();
	    
	    if (low < j) {
	      quicksort(low, j);
	    }
	    if (i < high) {
	       quicksort(i, high);
	    }
	}
	
	public void printArray() {
	  for (int i = 0; i < input.length; i++) {
	      System.out.print(input[i] + " ");
	    }
	    System.out.println();
	}
	
	private void swap(int i, int j) {
		int temp = input[j];
		input[j] = input[i];
		input[i] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create the test array
		int[] input = new int[] {1, 15, 100, 9, 35, 5};
		QuickSort sorter = new QuickSort();
		sorter.sort(input); 
				
	  
	}

}
