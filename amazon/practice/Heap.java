package com.amazon.practice;

import java.util.*; 

public class Heap {
	int[] input; 
	ArrayList<Integer> heap = new ArrayList<Integer>();
	
    public Heap(int[] input) {
    	this.input = input;
    	heapify(); 
    }
    
   /** public void add(Integer value) {
    	// Start at the root node, do a comparison, 
    	Integer root = heap.get(0); 
    	// If less than node, add to left, 
    	if (value >= root) {
    		addLeft(0, value); 
    	} else {
    		addRight(0, value); 
    	}
    	   	// If greater than node, add to right. 
    	
    }
    **/
    Integer getLeft(int k) {
    	return heap.get(2*k);
    }
    
    Integer getRight(int k)  {
    	return heap.get(2*k + 1); 
    }
    
    // Add at the end of the array and shift up 
    public void heapify() {
    	for (int i=0; i<input.length; i++) {
    		// Add at end
    		int index = heap.size();
    		heap.add(index, input[i]);
    	}
    }
    
    public void  printArray() {
    	for (Integer value: heap) {
    		System.out.print(value + " ");
    	}
    }
    
    public static void main(String[] args) {
    	int[] input = {1,2,4,6,7,9,22};
    	Heap heap = new Heap(input);
    	heap.printArray(); 
    }
    
}
