package com.amazon;

public class BitShifter {
	
	public void doit() {
		int x = 1; 
		int eight = 1 << 3; 
		System.out.println("eight: " + eight); 
		
		int one = eight >> 3; 
		System.out.println("one: " + one);
		
		// represent a set with 5 members. only bit positions 1,3,5 are occupied
		int val1 = 1;
		int val2 = 1 << 2; 
		int val3 = val2 << 2;
		
		int fullset = val1 + val2 + val3; 
		// Now let's print out the bits
		
		
	}

	
	
	public static void main(String[] args) {
		BitShifter shifter = new BitShifter();
		shifter.doit(); 
	}
}

