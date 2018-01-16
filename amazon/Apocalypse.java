package com.amazon;

import java.util.*; 


public class Apocalypse {
	HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>(); 
	
	public double runNFamilies(int n) {
		int boys = 0;;
		int girls = 0;
		for (int i=0; i<n; i++) {
			int[] genders = runOneFamily();
			girls += genders[0];
			boys += genders[1];
		}
		
		return girls/(double) (boys + girls); 
	}
	
	int[] runOneFamily() {
		Random random = new Random();
		int boys = 0;
		int girls = 0;
		while (girls == 0) {
			 if (random.nextBoolean()) {
				 girls += 1;
			 } else {
				 boys += 1; 
			 }
		}
		
		int[] genders = {boys, girls};
		int familySize = boys + girls; 
		//System.out.println(familySize);
	    if (counts.containsKey(familySize)) {
	    	Integer value = counts.get(familySize);
	    	value++; 
	    	counts.put(familySize, value);
	    } else {
	    	counts.put(familySize, 1);
	    }
	    	
		return genders; 
	}
	
	public void printHashMap() {
		Set<Integer> keys = counts.keySet();
		
		for (Integer key: keys) {
			System.out.println(key + ":" + counts.get(key)); 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apocalypse test = new Apocalypse();
		double ratio = test.runNFamilies(Integer.parseInt(args[0]));
		System.out.println("ratio=" + ratio); 
		test.printHashMap(); 
	}

}

