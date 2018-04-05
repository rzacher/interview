import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

        static int convertToInt(String input) {
            Integer value = Integer.valueOf(input); 
            return value.intValue(); 
        }
    
    static int[] getDigits(int digits) {
        //System.out.println("getDigits: " + digits); 
        //convert to String. get the chars. 
        String digstr = new Integer(digits).toString(); 
        int[] digitArray = new int[digstr.length()]; 
        for (int i=0; i<digstr.length(); i++) {
            int digit = Character.digit(digstr.charAt(i),10); 
            Integer value = Integer.valueOf(digit); 
            digitArray[i] = value; 
        }
       // System.out.println("getDigits array"); 
        for (int j=0; j<digitArray.length; j++) {
           // System.out.print(digitArray[j] + " "); 
        }
       // System.out.println(); 
        return digitArray; 
    }
    
    static int getSuperDigits(int digits, int depth) {
        //System.out.println("getSuperDigits input digits: " + digits + "depth:" + depth); 
        if (digits < 10) { 
            return digits; 
        } 
        
        depth++; 
        
            int[] digitList = getDigits(digits); 
            int sum = 0; 
            for (int i=0; i<digitList.length; i++) {
                sum += digitList[i]; 
                //System.out.println("sum:" + sum);
            }
        //System.out.println("getSuperDigits sum: " + sum); 
        return getSuperDigits(sum, depth); 
    }
    
    static int digitSum(String n, int k) {
        // Complete this function
        StringBuffer buf = new StringBuffer(); 
        for (int i=0; i<k; i++) {
            buf.append(n); 
        }
        int digits = Solution.convertToInt(buf.toString()); 
        //System.out.println(digits);
        int depth = 0; 
        int sd = getSuperDigits(digits, depth); 
        return sd; 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        int k = in.nextInt();
        int result = digitSum(n, k);
        System.out.println(result);
        in.close();
    }
}
