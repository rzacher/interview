package com.amazon;
// From hard section 17.5 of CrackingTheCodingInterview
// Find the longest word composed of other words in the list 

import java.util.*;


public class GetLongestWord {
	public GetLongestWord() {
    }
	
	public String findLongestWord(String[] list) {
		String result =""; 
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		
		for (String val: list) {
			map.put(val, true);
		}
		
		// Break a word into two parts, if both parts are words, then we have a candidate
		for (String val: list) {
		  int length = val.length();
		  
		  for (int i=0; i<length; i++) {
			  String part1 = val.substring(0, i);
			  String part2 = val.substring(i);
			  
			  if (map.containsKey(part1) && map.containsKey(part2) && length>result.length()) {
				  result = val; 
			  }
		  }
		}
		
		return result;	
	}
	
	public static void main(String[] args) {
		String[] list = {"foo", "bar", "hat", "in", "the", "cat", "foobar", 
				"foobarcar", "car"};
		
		GetLongestWord glw = new GetLongestWord(); 
		String result = glw.findLongestWord(list);
		System.out.println(result);	
	}

}

