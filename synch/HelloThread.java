package synch;

public class HelloThread extends Thread{
	
	public void run() {
		System.out.println("Hi Bob");
		try {
		  Thread.sleep(5000);
		} catch (InterruptedException ie) {
			
		}
		System.out.println("Hi Bob");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloThread myThread = new HelloThread();
		myThread.start();
	}

}
