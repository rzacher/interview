package newstuff;

import java.util.*;

public class Subsets {

   public void printList(ArrayList<Integer> set) {
     for (Integer entry: set) {
       System.out.print(entry + " ");
     }
     System.out.println(); 
   }
   
   // For each element, there is one set with the element, one without and one set composed only of that element, 
   // combined with all the subsets
   public Set<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> set) {
     Set<ArrayList<Integer>> allSubsets = new HashSet<ArrayList<Integer>>();
     
     // if the set is empty, return an empty set
     if (set.size() == 0) {
       ArrayList<Integer> emptySet = new ArrayList<Integer>(); 
       allSubsets.add(emptySet); 
     } else {
         Integer element; 
         // pop the first element of the set, 
         Iterator<Integer> iter = set.iterator(); 
         
         if (iter.hasNext()) {
            element = iter.next(); 
            set.remove(element);
     
            // get all the subsets without that element,
            Set<ArrayList<Integer>> subsetsWithoutElement = getAllSubsets(set); 
             
            // This is the merge step 
            allSubsets = addOneElementToSubsets(subsetsWithoutElement, element);
         }  
     }
     
     return allSubsets; 
   }
   
   public Set<ArrayList<Integer>> addOneElementToSubsets(Set<ArrayList<Integer>> subsetsWithElement, Integer element) {     
     Set<ArrayList<Integer>> mergedSubsets = new HashSet<ArrayList<Integer>>(); 
     // for each subset, make a copy of the original subset.
     // Add the element to the copy. 
     // return both the original and the modified copy
     for (ArrayList<Integer> set: subsetsWithElement) {
       ArrayList<Integer> setPlusElement = new ArrayList<Integer>(); 
       setPlusElement.addAll(set); // Make a copy of the set
       // Add the element
       setPlusElement.add(element); 
       // add the new set to mergedsubsets
       mergedSubsets.add(setPlusElement); 
       // Add the original set to mergedSubsets
       mergedSubsets.add(set); 
     }
     
     return mergedSubsets; 
   }

   public static void main(String[] args) {
       Subsets subsets = new Subsets(); 
       
       ArrayList<Integer> set = new ArrayList<>();
       set.add(1);
       set.add(2);
       set.add(3);
       
       Set<ArrayList<Integer>> results = subsets.getAllSubsets(set); 
       
       for (ArrayList<Integer> oneSet: results) {
          subsets.printList(oneSet); 
       }

   }
   
    
}
