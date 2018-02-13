package com.amazon;

public class QuickSortPractice {
	int[] input;

	
	public QuickSortPractice(int[] input) {
		this.input = input; 
	}
	
	public void printArray(int[] array) {
		for (int i=0; i<array.length; i++) {
			System.out.println(" " + array[i]);
		}
	}
	
	public void sort() {
		int length = input.length; 
		quicksort(0, length-1);
		return; 
	}
	
	private void swap(int i, int j) {
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp; 
	}
	
	private void quicksort(int low, int high) {
		System.out.println("low:"+ low + " high:"+high);
		int middle = low + (high-low)/2; 
		int pivot = input[middle];
		// sort around the pivot, then repeat with each half
		int i = low; 
		int j = high; 
		
		while (i<=j) {
			while (input[i]<pivot) {
				i++; 
			}
			while (input[j]>pivot) {
				j--; 
			}
			if (i <= j) {
			  swap(i,j);
			  i++;
			  j--; 
			}
		}
		// now do it again on the left and right halves
		if (low < j) {
		  quicksort(low, j);
		}
		if (i<high) {
		  quicksort(i, high); 
		}
		
	}
	
	public static void main(String[] args) {
		int[] input = {10, 60, 40, 20, 70, 5, 80};
		System.out.println("running quicksort");
		
	   QuickSortPractice qsp = new QuickSortPractice(input);
	   qsp.sort();
	   qsp.printArray(input);
       return; 
	}

}
