package com.amazon;

import java.util.List;
import java.util.Collection; 
import java.util.*; 


public class HeapSort {

	public static void main(String[] args) {
		List<Integer> c = new LinkedList<Integer>();
		c.add(10);
		c.add(2);
		c.add(1); 
		
		List<Integer> l = heapSort(c);
		for (Integer val : l) {
			System.out.println(val);
		}

	}

	static <E> List<E> heapSort(Collection<E> c) {
	    Queue<E> queue = new PriorityQueue<E>(c);
	    List<E> result = new ArrayList<E>();

	    while (!queue.isEmpty())
	        result.add(queue.remove());

	    return result;
	}
}

