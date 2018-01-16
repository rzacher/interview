package com.synch;

import java.util.Random;

public class SynchronizedCounter {
	int c = 0; 
	
	public  void incrementDecrement() {
		Random random = new Random();
		c++;
		try {
			Thread.sleep((long) (1000 * random.nextFloat()) );
		} catch (InterruptedException ie) {
			
		}
		c--;
		print();
	}
	
	public void decrement() {
		c--; 
	}
	
	public void print() {
		System.out.println("c=" + c);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SynchronizedCounter counter = new SynchronizedCounter();
		 
			WorkerThread worker1 = new WorkerThread(counter);
			WorkerThread worker2 = new WorkerThread(counter);
		    worker1.start();
		    worker2.start(); 

	}

}
