package amazon;

import java.util.HashMap; 
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
		                 {"bobby", "robert"}};
		 
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
		    NameSet set1 = nameSet.get(key1); 
		
			// point the key for the smaller set to the bigger set
		}
		
		
	}
	
	public static void main(String[] args) {
		try {
		DeDupNames ddn = new DeDupNames();
		String[][] names = ddn.testCreateNameList(); 
		ddn.buildNameSets(names);
		ddn.buildNameSets(names);
		ddn.mergeNameSets(names); 
		} catch (Exception e) {
			System.out.println("Caught exception" + e.getMessage()); 
			e.printStackTrace();
		}
	}
	
	// Maintains an  equivalence class for names. 
	private class NameSet {
		HashMap<String, String> names = new HashMap<String, String>(); 
		
		// Add an entry 
		public void add(String[] entry) {
			names.put(entry[0], entry[1]); 
		}
	}

}

