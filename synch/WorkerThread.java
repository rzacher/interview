package com.synch;

import java.util.Random;

public class WorkerThread extends Thread {
	
	SynchronizedCounter counter = null; 
	public WorkerThread(SynchronizedCounter counter) {
		this.counter = counter; 
	}
	
	public void run() {	
		for (int i=0; i<10; i++) {
		    counter.incrementDecrement();
		}
	}
	
	

}
