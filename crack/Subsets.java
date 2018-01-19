package com.crack;
import java.util.*;
/*
 * Base on page 323 of cracking the code. 
 */
public class Subsets {
	public Subsets() {}
	
	ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> inSet) {
		ArrayList<ArrayList<Integer>> allSets = new ArrayList<ArrayList<Integer>>();
		
	   // Generate all possible combinations of 0 and 1's to represent the set membership
		int max = 1 << inSet.size();
		System.out.println("Set max 2^n = " + max);
		
		// Now create a set for each binary number
		for (int k=0; k<max; k++) {
			ArrayList<Integer> subset = convertIntToSet(k, inSet);
			allSets.add(subset); 
		}
		
		return allSets;	
	}
	
	public ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> inSet) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		
		int index = 0; 
		
		System.out.println("x = " + x);
		int m = x;
		m = m >> 1;
		int n = x;
		n >>= 1; 
		System.out.println("m=" + m + " n=" + n);
		

		for (int k = x; k > 0; k = (k >> 1)) {
		  if ((k & 1) == 1) {
			  subset.add(index);
		  }
		  index++;
		}
		
		return subset;
	}
	
	public void printSubsets(ArrayList<ArrayList<Integer>> subsets) {
		System.out.println("Printing subsets");
		for (ArrayList<Integer>  subset : subsets) {
			for (int i=0; i<subset.size(); i++) {
				System.out.print(subset.get(i) + " "); 
			}
			System.out.println(); 
		}
		
		
	}
	
	public static void main(String[] args) {
		Subsets sets = new Subsets();
		ArrayList<Integer> inSet = new ArrayList<Integer>();
		inSet.add(new Integer(1));
		inSet.add(new Integer(2));
		inSet.add(new Integer(3));
		
		ArrayList<ArrayList<Integer>> subsets = sets.getSubsets2(inSet);
		sets.printSubsets(subsets); 
		
	}

}
