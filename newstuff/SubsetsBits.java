package newstuff;

import java.util.*;

public class SubsetsBits {

   public void printList(List<Integer> set) {
     for (Integer entry: set) {
       System.out.print(entry + " ");
     }
     System.out.println(); 
   }
   
   
   public List<Integer> convertIntToSet(int x, List<Integer> set) {
      ArrayList<Integer> subset = new ArrayList<Integer>(); 
      
      int index = 0; 
      for (int k=x; k>0; k=k>>1) {
        System.out.println("k:" + k + " index:" + index); 
        if (( k & 1) == 1) {
          System.out.println("match k:" + k + " index:" + index); 
          Integer element = set.get(index);
          subset.add(element); 
        }  
        index++; // move to next element   
      }
     
     return subset; 
   } 

   public static void main(String[] args) {
       SubsetsBits subsets = new SubsetsBits(); 
       int n = 3; 
       
       ArrayList<Integer> set = new ArrayList<>();
       set.add(1);
       set.add(2);
       set.add(3);
       
       
       // N elements. Generate 2^n 
       int max = 1 << n; 
       System.out.println("max:" + max); 
       
       for (int k=(max-1); k>0; k--) {
            System.out.println("k=" + k); 
            List<Integer> subset = subsets.convertIntToSet(k, set);
            subsets.printList(subset); 
       }
       
      
       
     //  Set<ArrayList<Integer>> results = subsets.getAllSubsets(set); 
       
     //  for (ArrayList<Integer> oneSet: results) {
     //     subsets.printList(oneSet); 
     //  }

   }
   
    
}
