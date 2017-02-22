package newstuff;

import java.util.*;

// Give the permutations of a string
public class Permutations {
    String source; 

    public Permutations() {
    }

    public List<String> getPermutations(String word) {
    
      if (word.length() == 0) {
        return null; 
      }
      
      List<String> mergedWords = new LinkedList<String>();
      // remove the first char 
      char first = word.charAt(0);
      char[] firstArray = {first}; 
      
      if (word.length() < 2) {
        mergedWords.add(new String(firstArray));
        return mergedWords; 
      }
      
      String remainder = word.substring(1, word.length()); 
      System.out.println("remainder:" + remainder);
      // Get the permuations for the remainder of the string
      List<String> permutations = getPermutations(remainder);  
      
      // Insert the first char in all positions for each permutation
      
      for (String perm: permutations) {
         for (int i=0; i<perm.length() + 1; i++) {
            StringBuilder sb = new StringBuilder(perm); 
            sb.insert(i, first);
            mergedWords.add(sb.toString()); 
         }
      }
       
      return mergedWords; 
    }

    public static void main(String args[]) {
      String source = "abc";
      
      Permutations perms = new Permutations(); 
      
      List<String> permList = perms.getPermutations(source); 
      
      for (String word: permList) {
        System.out.println(word); 
      }
    
    }
}
