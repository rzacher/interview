package com.newstuff;

// Use the sieve of eratosthenes. 
// Find the list of primes less than max
public class PrimeNumber {
	 
	// set all flags to true other than 0 and 1
	private void init(boolean[] flags) {
		flags[0] = false; 
		flags[1] = false; 
		
		for (int i=2; i<flags.length; i++) {
			flags[i] = true; 
		}
	}
	
	int[] doSieve(boolean[] flags, int max) {
		int current = 2; 
		while (current <= max) {
			// Set all multiples of this prime to false, 
			// leave the prime itself true
			for (int i=2*current; i<max; i+=current) {
				flags[i] = false; 
			}
			
			current = getNextPrime(current, max); 
		}
		
	}
	
	public int[] getPrimes(int max) {
		
		boolean[] flags = new boolean[max+1]; 
		init(flags);
		int[] primes = doSieve(flags, max); 
		return primes; 
	}
	
	public static void main(String[] args) {
		int max = 20; 
		PrimeNumber pn = new PrimeNumber();
		int[] primes = pn.getPrimes(max); 
		
	}

}
