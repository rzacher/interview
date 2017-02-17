package newstuff;

import java.util.*;

public class Subsets {

   public void printSet(ArrayList<Integer> set) {
     for (Integer entry: set) {
       System.out.print(entry + " ");
     }
     System.out.println(); 
   }
   
   // For each element, there is one set with the element, one without and one set composed only of that element, 
   // combined with all the subsets
   public ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> set) {
     // pop the first element of the set, 
     Integer element = set.removeFirst(); 
     // get all the subsets without that element,
     ArrayList<ArrayList<Integer>> subsets = getAllSubsets(set); 
     
     // form three subsets, with element, without element, and single element set
 
     // one set of sets without new element
     // just the subsets from above. 
     
     // one set of sets with new element
     // clone the subsets above and add the element
     ArrayList<ArrayList<Integer>> subsetsWithElement = subsets.clone(); 
     addOneElementToSubsets(subsetsWithElement, element); 
     
     // single element set
     ArrayList<Integer> singleSet = new ArrayList<>() {element}; 
   }
   
   public void addOneElementToSubsets( ArrayList<ArrayList<Integer>> subsetsWithElement, Integer element) {
     
   }

   public static void main(String[] args) {
       Subsets subsets = new Subsets(); 
       
       ArrayList<Integer> set = new ArrayList<>() {1,2,3};
       
       ArrayList<ArrayList<Integer>> results = subsets.getAllSubsets(set, 0); 
       
       for (ArrayList<Integer> set: results) {
          subsets.printSet(set); 
       }

   }
   
    
}
