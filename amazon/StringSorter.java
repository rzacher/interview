package com.amazon;

import java.util.*;

public class StringSorter {

public void StringSorter() {}
	
	public Collection<Character>  treeMapSort(String input) {
		Map<Character, Character> tree = new TreeMap<Character, Character>();
		
		for (int i=0; i<input.length(); i++) {
			tree.put(input.charAt(i), input.charAt(i));
		}
		
		// return the values
		Collection<Character> result = tree.values(); 
		for (char value : result )
		{ 
			System.out.print(value); 
		}
		
		return result;
	}
	
	public Object[]  treeSetSort(String input) {
		Set<Character> tree = new TreeSet<Character>();
		
		for (int i=0; i<input.length(); i++) {
			tree.add(input.charAt(i));
		}
		
		// return the values
		Object[] result = tree.toArray(); 
		for (int i=0; i< result.length; i++ )
		{ 
			System.out.print(result[i]); 
		}
		
		return result;
	}
	
	
	// main method
	public static void main(String[] args) {
		String test = "my name is bob. I live in arlington and have pet chickens";
	
		StringSorter sorter = new StringSorter();

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i=0; i<test.length(); i++) {
			char key =  test.charAt(i); 
			//System.out.print(key);
			if (map.containsKey(key)) {
			    int count = map.get(key); 
			    System.out.println("key=" + key + " count=" + count);
			    count += 1; 
			    map.put(key, count);
			} else {
				int count = 1; 
				map.put(key, count);
				System.out.println("key=" + key + " count=" + count);
			}
		}
		
		Set<Character> keys = map.keySet(); 
		//Collection<Character> output = sorter.treeMapSort(key);
		//Object[] output2 = sorter.treeSetSort(keys);
		Set<Character> sortedKeys = new TreeSet<Character>(keys); 
		for (Character key : sortedKeys) {
			//System.out.print(key);
		}
		
		System.out.println(); 
		// Look up the keys in sort order in the hash map, then get the count for a key. then print out "count" letters for the key.
		for (Character key : sortedKeys) {
			Integer count = map.get(key);
			//System.out.print("count=" + count + " "); 
			for (Integer i=0; i<count; i++) {
				System.out.print(key); 
			}
		}
	}
	
	
}
