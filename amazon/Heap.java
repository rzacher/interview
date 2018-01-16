package com.amazon;

import java.util.ArrayList;

public class Heap {
	int[] input = null;
	ArrayList array = new ArrayList<Integer>(); 
	// If k = parent location, then children are at
	// and 2k+1 and 2k+2

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6}; 
		Heap heap = new Heap(array); 
	
	}
	
	public Heap(int[]  input) {
		this.input = input; 
		heapify(); 
	}
	
	private void heapify() {
		for (int i=0; i<input.length; i++) {
			  System.out.println("Inserting " + input[i]);
			  insert(input[i]); 
			}
	}
	// add a new element
	public void insert(int id) {
		// Add the number at the end of the list
	    array.add(new Integer(id));
		int position = array.size() - 1;
		shiftUp(position);
		printArray(); 
	}
	
	public int removeTop() throws IndexOutOfBoundsException {
		int retVal; 
		if (array.size() == 0) {
			throw new IndexOutOfBoundsException("msg");
		} else {
			// Get a copy of the top element
			retVal = (Integer) array.get(0);
			// Get the last element and place it at the top
			Integer newTop = (Integer) array.remove(array.size() - 1);
			array.set(0, newTop);
			shiftDown();
		}
		printArray(); 
		return retVal;
	}
	
	// Take the top element and move it down
	private void shiftDown() {
		int currentPos = 0;
		int length = array.size(); 
		
		int w = 2 * currentPos + 1;
		while (w < length) {
			if (w + 1 < length) { // there a second child
				Integer leftChild = (Integer) array.get(w);
				Integer rightChild = (Integer) array.get(w+ 1);
				if (rightChild > leftChild) {
					w = w + 1;
				}
				
				if ((Integer) array.get(w) > (Integer)array.get(currentPos)) {
				  swapValues(w, currentPos); 
				  currentPos = w; 
				  w = 2 * currentPos + 1; // Get ready for the next row
				} else {
					return; // the array has heap property
				}
			}
		}
		return; 
	}
	
	// Compare the node with it's parent, if it's larger, move it up the chain until
	// it can't go farther. 
	private void shiftUp(int position) {
		int currentPos = position;
		while (currentPos > 0) { // we're as high as we can go
			int parentPos = (currentPos - 1)/2;
			// compare with parent and swap if child is bigger
			if ((Integer) array.get(currentPos) > (Integer)array.get(parentPos)) {
				swapValues(currentPos, parentPos);
				currentPos = parentPos;
			} else {
				break; // we're done
			}
		}
	}

	private void swapValues(int position1, int position2) {
		Integer value1 = (Integer) array.get(position1);
		array.set(position1, array.get(position2));
		array.set(position2, value1);
	}
	
	private void printArray() {
		for (int i=0; i<=array.size()-1; i++) {
			System.out.print((Integer)array.get(i) + " ");
		}
		System.out.println(); 
	
	}
}
