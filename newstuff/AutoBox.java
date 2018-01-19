package com.newstuff;

import java.util.*;

public class AutoBox {
	Integer y;
	int x;
	
	public void testAutoBoxing() {
		List<Integer> myList = new LinkedList<>();
		myList.add(1);
		myList.add(2);
		
		for (Integer val : myList) {
			if (val == 1) {
				System.out.println("Autoboxing worked");
				System.out.println("Expecting 2 = " + (val + 1)); 
			}
		}
	}
	
	/*
	public void testInitValues() {
		Integer foo = null;
		
		if (foo == 0) {
			System.out.println("foo is null");
		}
	}
	*/
	
	public void testIntInit() {
		System.out.println("The value of class data int x is " + x);
		System.out.println("The value of class data y is " + y);
	}
	
	public void testUnBoxing() {
		List<Double> myList = new ArrayList<>();
		myList.add(3.14);
		
		double pi = myList.get(0);
		System.out.println("Pi = " + pi);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AutoBox test = new AutoBox(); 		
		test.testAutoBoxing();
		//test.testInitValues();
		test.testUnBoxing(); 
		test.testIntInit();
	}

}
