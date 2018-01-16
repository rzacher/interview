package com.amazon;

import java.util.Comparator;
import java.util.PriorityQueue; 

public class KthSmallest {
	
	public KthSmallest() {
		
	}
	
	// Use a min heap with only k elements. 
	public int[] getKSmallest(int[] inputArray,  int k) {
		if ((k > inputArray.length) || (k < 0)) {
			throw new IllegalArgumentException(); 
		}
		
		int arr[] = new int[k];
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new MaxHeapComparator());
		
		
		// Put the first k into a min heap, 
		for (int j=0; j<k; j++) {
			heap.add(inputArray[j]);
		}
		
		// Then add the remaining, replacing the root element if the new element
		// is smaller
		for (int l=k; l<inputArray.length; l++) {
			int val = heap.peek();
			if (inputArray[l] < val) {
				heap.poll();
				heap.add(inputArray[l]);
			}
		}
		
		// Now put the heap into a return array
		int index = k-1;
		while (heap.size() > 0) {
			arr[index] = heap.poll();
			index--; 
		}
		
		return arr; 
	}
	
	public static void main(String[] args) {
		KthSmallest ksm = new KthSmallest();
		
		int[] inputArray = {2,4,6,8,10,3,5,7,9,11, -1};
		int arr[] = ksm.getKSmallest(inputArray, 7);
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");;
		}
		
	}
	
	private class MaxHeapComparator implements Comparator<Integer> {
		public int compare(Integer x, Integer y) {
			return y-x;
		}
	}

}
