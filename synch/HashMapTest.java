package com.synch;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {
	 HashMap<Integer, Integer> foobar;
	
	public HashMapTest() {
	    foobar = new HashMap<Integer, Integer>(2);
	}
	public void run() {
	  Integer key = new Integer(1);
	  Integer value = new Integer(2);
	  Integer value2 = new Integer(3);
	  foobar.put(key, value); 
	  foobar.put(key, value2); 
	  System.out.println("Value is " +  foobar.get(key));
	  Set<Integer> keys = foobar.keySet(); 
	  for (Integer keyVal : keys) { 
		  System.out.println("Key=" + keyVal); 
	  }
	  
	}


public static void main(String[] args) {
	HashMapTest dl = new HashMapTest();
	dl.run();
  }
	
}
