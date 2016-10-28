package synch;

public class RunnableTest implements Runnable {
	
	public RunnableTest() {
		
	}
	
   public void run() {
	   System.out.println("Hi Bob");
   }
	
	
	public static void main(String[] args) {
		Thread myThread = new Thread(new RunnableTest());
		myThread.start();
	}

}
