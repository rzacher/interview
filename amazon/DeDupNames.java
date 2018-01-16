package com.amazon;

import java.util.Collection;
import java.util.HashMap; 
import java.util.HashSet;
import java.util.List; 

/**
 * Given a list of names with synonyms, dedup the list until for each name, you can 
 * look up the full list of names. 
 * @author rzacher
 *
 */

public class DeDupNames {
	HashMap<String, NameSet> nameSets = new HashMap<String, NameSet>(); 
	
	public String[][] testCreateNameList(){
		System.out.println("testCreateNameList"); 
		String[][] names = {{"robert", "bob"},
				         {"robert", "roberto"},
		                 {"mary", "marieke"},
		                 {"miriam", "mary"},
		                 {"bobby", "robert"},
		                 {"robby", "bobby"}};
		 
		return names;         
	}
	
	/**
	 * Read in the names, for each name, create a name set if one doesn't already 
	 * exist
	 * @param names
	 */
	public void buildNameSets(String[][] names) {
		System.out.println("mergeNameSets");
		for (String[] entry: names) {
			// Try either name to find the name set and add it
			if ( nameSets.containsKey(entry[0])) {
			   NameSet nameSet  = nameSets.get(entry[0]); 
			   nameSet.add(entry); 
			} else {
				 // if one doesn't exist, create it, and add to the names map
				NameSet nameSet = new NameSet();
				nameSet.add(entry);
				nameSets.put(entry[0], nameSet);
			}
			
			if (nameSets.containsKey(entry[1])) {
				NameSet nameSet  = nameSets.get(entry[1]); 
				nameSet.add(entry);
			} else {
			    // if one doesn't exist, create it, and add to the names map
				NameSet nameSet = new NameSet();
				nameSet.add(entry);
				nameSets.put(entry[1], nameSet); 
			}
		}
	}
	
	public void mergeNameSets(String[][] names) {
		System.out.println("mergeNameSets");
		// Get the keys for each entry
		for (String[] entry: names) {
		    String key1 = entry[0];
		    String key2 = entry[1];
			// for each key, get the nameset and merge the smaller set into the bigger set.
		    NameSet set1 = nameSets.get(key1); 
		    NameSet set2 = nameSets.get(key2); 
		    
		    // Merge the smaller set to the bigger set
		    if (set1.size() >= set2.size()) {
		    	set1.merge(set2);
		    	// point the key for the smaller set to the bigger set
		    	nameSets.put(key2, set1); 
		    } else {
		    	set2.merge(set1);
		    	nameSets.put(key1, set2); 
		    }
		}
	}
	
	public void printUniqueNameSets() {
		// put the NameSets into a set and print the set elements
		HashSet<NameSet> setOfNameSets = new HashSet<NameSet>(); 
	    Collection<NameSet> values = nameSets.values();
	    
	    for (NameSet value: values) {
	    	setOfNameSets.add(value); 
	    }
	    
	    Object[] nsArray =  setOfNameSets.toArray();
	    
	    for (int i=0; i<nsArray.length; i++) {
	    	((NameSet)nsArray[i]).printNames(); 
	    }
	    
		
	}
	
	public static void main(String[] args) {
		try {
		DeDupNames ddn = new DeDupNames();
		String[][] names = ddn.testCreateNameList(); 
		ddn.buildNameSets(names);
		ddn.buildNameSets(names);
		ddn.mergeNameSets(names); 
		ddn.printUniqueNameSets(); 
		
		} catch (Exception e) {
			System.out.println("Caught exception" + e.getMessage()); 
			e.printStackTrace();
		}
	}
	
	// Maintains an  equivalence class for names. 
	private class NameSet {
		HashSet<String> names = new HashSet<String>(); 
		
		// Add an entry 
		public void add(String[] entry) {
			names.add(entry[0]); 
			names.add(entry[1]); 
		}
		
		public void add(String entry) {
			names.add(entry); 
		}
		
		public HashSet<String> getNames() {
			// return a clone
			return (HashSet<String>) names.clone(); 
		}
		
		public void merge(NameSet otherSet) {
			HashSet<String> namesClone = otherSet.getNames(); 
		
			for (String name: namesClone) {
				names.add(name); 	
			}
		}
		
		public int size() {
			return names.size(); 
		}
		
		public void printNames() {
			for (String name: getNames()) {
				System.out.print(name + " ");
			}
			System.out.println(); 
		}
	}

}


