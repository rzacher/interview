package newstuff;

import java.util.*;

public class BitSet {
    int[] bitset; 

    public BitSet(int size) {
      int numInts = size >> 5;
      System.out.println("numInts:" + numInts); 
      bitset = new int[numInts + 1]; // divide by 32
    }

    void  set(int pos) {
      int intInArray = (pos >> 5);  // divide by 32
      System.out.println("intInArray:" + intInArray); 
      int bitNumberInInt = (pos & 0x1f); //mod 32
      System.out.println("bitNumberInInt:" +  bitNumberInInt); 
      bitset[intInArray] =  bitset[intInArray] | (1 << bitNumberInInt);
    }
    
    public static void main(String[] args) {
      BitSet bs = new BitSet(32000);
      bs.set(322);  
    }
    
}
