package newstuff;

// Use the sieve of eratosthenes. 
// Find the list of primes less than max
public class PrimeNumber {
	 
	 boolean[] flags; 
	 
	// set all flags to true other than 0 and 1
	private void init(boolean[] flags) {
		flags[0] = false; 
		flags[1] = false; 
		
		for (int i=2; i<flags.length; i++) {
			flags[i] = true; 
		}
	}
	
	// walk the flags and find the next true
	private int getNextPrime(int current, int max) {
	  boolean nextFlag=false;
	  current +=1; // advance to next
	  
	  while ((nextFlag == true) && (current <= max)){
	     nextFlag = flags[current];
	     current++;
	  }
	  return current;
	}
	
	private int[] doSieve(boolean[] flags, int max) {
		int current = 2; 
		int[] primes = new int[max];
		int primeIndex = 1; 
		primes[0] = 1;
		primes[primeIndex] = current;
		  
		while (current <= max) {
			// Set all multiples of this prime to false, 
			// leave the prime itself true
			for (int i=2*current; i<max; i+=current) {
				flags[i] = false; 
			}
			current = getNextPrime(current, max); 
			System.out.println("Current: " + current);
			primes[primeIndex++] = current;      
		}
		return primes; 
	}
	
	public int[] getPrimes(int max) {
		flags = new boolean[max+1]; 
		init(flags);
		int[] primes = doSieve(flags, max); 
		return primes; 
	}
	
	public static void main(String[] args) {
        System.out.println("Running");
		int max = 7; 
		PrimeNumber pn = new PrimeNumber();
		int[] primes = pn.getPrimes(max); 
		for (int i=0; i< primes.length; i++) {
		   System.out.println(primes[i] + " "); 
		}
	}

}
