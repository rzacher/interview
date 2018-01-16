package com.synch;

// example from official java tutorials 
public class SimpleThreads {
	public static void threadMessage(String message) {
		String name = Thread.currentThread().getName();
		System.out.println("Thread name = " + name);
	}
	
	private static class InnerClass implements Runnable {
	   public void run() {
		  String importantInfo[] = {
				  "A", 
				  "B",
				  "C" 
		  }; 
		  try {
			  for (int i = 0; i < importantInfo.length; i++ ) {
				  Thread.sleep(4000);
				  threadMessage(importantInfo[i]);
			  }
		  } catch (InterruptedException e) {
			  threadMessage("I wasnt' done");
		  }
	   }
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		long  patience = 1000 * 60  * 60; 
		threadMessage("Waiting for MessageLoop thread to finish");
		long startTime = System.currentTimeMillis(); 
		Thread t = new Thread(new InnerClass());
	        t.start();
	    threadMessage("Wait for MessageLoop to finish");
	    
	    while (t.isAlive()) {
	    	threadMessage("Still waiting");
	    	t.join(1000); // wait up to 1 sec.
	    	if (( (System.currentTimeMillis() - startTime) > patience) 
	    		&& t.isAlive()) {
	    		  
	    			
	    		}
	    	}
	    	
	    } // end main  
	   
} 

