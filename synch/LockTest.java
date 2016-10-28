package synch;

import java.util.Random;

public class LockTest extends Thread  {
	
   Object lockObject = null;
   int id; 

   public LockTest(Object lock, int id) {
	   this.lockObject = lock;
	   this.id = id; 
   }
  
   public void run() {
	   for (int i=1; i<5; i++) {
		   getLock(); 
	   }
	   
   }
   
   
	public void getLock() { 
		// Randomize the wait time
		Random rand = new Random();
		long waitTime = 0; 
		do {
		   waitTime = (long) ((float)rand.nextInt() * 5000)/ Integer.MAX_VALUE ;
		} while (waitTime < 0);
		
		System.out.println("Thread id=" + id + " wait time = " + waitTime);
		try {
		  Thread.sleep(waitTime/2); 
		} catch (InterruptedException ie) {
			
		}
		
		synchronized(lockObject) {
			
			try {
		       lockObject.wait(waitTime);
			} catch (InterruptedException ie) {
				
			}
			String name = Thread.currentThread().getName();
			System.out.println("Thread = " + name);
		}
	}
	
	public static void main(String[] args) {
		Object lock = new Object(); 
		
		 {
			LockTest lockTest1 = new LockTest(lock, 1);
			LockTest lockTest2 = new LockTest(lock, 2);
			lockTest1.start();
			lockTest2.start(); 
		}
	}   

}
