import java.util.*;


// http://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
public class MinimumSumPartition {

  int findMin(int[] input, int size) {
  
    int sumTotal = 0; 
     
    for (int i=0; i<size; i++) {
      sumTotal += input[i];
    }
    
    return findMinRec(input, size, 0, sumTotal);
  }
  
  int findMinRec(int[] input, int i, int sumCalculated, int sumTotal) {
  
     if (i == 0)  // We're on the first element
       return Math.abs((sumTotal - sumCalculated) - sumCalculated);
    
    // For every item arr[i], we have two choices
    // (1) We do not include it first set
    // (2) We include it in first set
    // We return minimum of two choices
    return Math.min(findMinRec(input, i-1, sumCalculated + input[i-1], sumTotal), 
               findMinRec(input, i-1, sumCalculated, sumTotal));
  
  }


  public static void main(String args[]) {
      int[] input = {2,5,6,11};
      int n = 4; 
      
      MinimumSumPartition msp = new MinimumSumPartition(); 
      
      int answer = msp.findMin(input, 4);
      
      System.out.println("answer = " + answer);
  }

}

