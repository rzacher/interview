package com.newstuff;

public class FibonacciLoop {
	
	// Get the n'th fibonacci number
	public int getNum(int n) {
		if ((n==0) || (n==1)) return 1; 
		
		int previous = 0;
		int current = 1; 
		for (int i=2; i<=n; i++) {
			 
			int tmp = current + previous; 
		    previous = current;
		    current = tmp; 
		    System.out.println("i:" + i + " " + current);
		}
		return current; 
		
	}
	
	public static void main(String[] args) {
		FibonacciLoop fl = new FibonacciLoop();
		int n = 20; 
		int fn = fl.getNum(n); 
		System.out.println("The " + n + "\'th fibonacci number is " + fn ); 
	}

}
