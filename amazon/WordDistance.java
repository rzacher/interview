
package amazon;

import java.util.*;


public class WordDistance {
	public WordDistance() {}
	
	
	public int findShortestDistance(String[] input, String word1, String word2) {
	
		int result = Integer.MAX_VALUE;
		ArrayList<ArrayList<Integer>> locationArray = populateLocations(input, word1, word2);
		result = findMin(locationArray.get(0), locationArray.get(1));
		
		
		return result; 
	}
	
	// make a list of locations by index for each word
	private ArrayList<ArrayList<Integer>> populateLocations(String[] input, String word1, String word2) {
		ArrayList<ArrayList<Integer>> locationArray = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> location1 = new ArrayList<Integer>();
		ArrayList<Integer> location2 = new ArrayList<Integer>();
		
		for (int i=0; i<input.length; i++) {
			if (input[i].equals(word1)) {
				location1.add(i);
			} 
			if (input[i].equals(word2)) {
				location2.add(i);
			}
		}
		
	    locationArray.add(location1);
	    locationArray.add(location2); 
	    return locationArray; 
	}
	
	// find the shortest distance between the two word lists. One for each word. 
	private int findMin(ArrayList<Integer> word1Locations, ArrayList<Integer> word2Locations) {
		if ((word1Locations == null) || (word2Locations == null)) {
			throw new NullPointerException("");
		}
		
		if ((word1Locations.size() == 0) || (word2Locations.size() == 0)) {
			throw new IllegalArgumentException("one of the location arrays is empty");
		}
		
		int min = Integer.MAX_VALUE;
		int l1Index = 0;
		int l2Index = 0;
		
	
		
		Integer[] locations1 = new Integer[word1Locations.size()];
		word1Locations.toArray(locations1);
		
		Integer[] locations2 = new Integer[word2Locations.size()];
		word2Locations.toArray(locations2);
		
		printLocations("locations1", locations1);
		printLocations("locations2", locations2);
		
		int location1 = locations1[l1Index];
		int location2 = locations2[l2Index];
		
		int distance = getDistance(location1, location2);
		int currentDistance = Math.abs(distance);
		min = (currentDistance<min) ? currentDistance : min;
		
		while ((l1Index < locations1.length) || (l2Index < locations2.length)) {
			if (distance > 0) { //location2 is larger, so advance location1
				if (l1Index < locations1.length-1) {
					l1Index++;
					location1 = locations1[l1Index];
				} else {
					return min; 
				}
			}  else if (distance < 0) {
				if (l2Index < locations2.length-1) {
					l2Index++; 
					location2 = locations2[l2Index];
				} else {
					return min;
				}
			} 
			
			
		    System.out.println("location1: " + location1 + " location2: " + location2);
		    distance = getDistance(location1, location2);
			currentDistance = Math.abs(distance);
			System.out.println("CurrentDistance: " + currentDistance);
			min = (currentDistance<min) ? currentDistance : min;
			System.out.println();
		}
		
		return min; 
	}

	private void printLocations(String title, Integer[] locations) {
		System.out.println(title);
		for (int i=0; i<locations.length; i++) {
			System.out.print(locations[i] + " ");
		}
		System.out.println();
	}; 
	
	int getDistance(int location1, int location2) {
		if (!isValid(location1) || !isValid(location2)) {
			return Integer.MAX_VALUE;
		} else {
			return location2 - location1; 
			
		}
	}
	
	boolean isValid(int location1) {
		if (location1 >= 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	public static void main(String[] args) {
		String paragraph = "The dog was cute, but the cat was cuter. The dog has a nasty bark and" + 
	      " the cat would meow when it was hungry. The shortest distance is cat dog";
	    String[] input = paragraph.split(" ");
	    
		WordDistance wd = new WordDistance(); 
		int min = wd.findShortestDistance(input, "dog", "cat");
		System.out.println("min:" + min);
		
		return; 
	}

}









