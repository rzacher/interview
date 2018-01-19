/*Find the n'th to last element of a linked list by using two pointers
First move reference pointer to n nodes from head. Now move both pointers 
one by one until reference pointer reaches end. Now main pointer will 
point to nth node from the end. Return main pointer.
advancing together separated by k elements. 
 */
 
package com.newstuff; 
import java.util.*; 

public class NthToLast {

   public NthToLast() {

   }

   public String nthToLast(LinkedList<String> list, int n) {
     if ((list == null) || (list.size() == 0)) {
        return null; 
     } 

     if (n > list.size()) {
        System.out.println("n is larger than the list size");
        return null; 
     } 

     ListIterator<String> head1 = list.listIterator(); 

     ListIterator<String> head2 = list.listIterator(); 

     int k = 0; 
     
     //  Move the head1 iterator n spaces
     while (head1.hasNext()) {
       head1.next(); 
       k++; 
       if (k == n-1) {
         break; 
       }
     } 

     String last = null; 
     while (head1.hasNext()) {
         head1.next(); 
         last = head2.next(); 
     } 
     
     return last; 
   }


   public static void main(String[] args) {

   LinkedList<String> linkedList = new LinkedList<String>(); 

    // Add elements to LinkedList
    linkedList.add("Delhi");
    linkedList.add("Agra");
    linkedList.add("Mysore");
    linkedList.add("Chennai");
    linkedList.add("Pune");  
    linkedList.add("NewYork");

    NthToLast ntl = new NthToLast(); 

    int n = 3; 
    String target = ntl.nthToLast(linkedList, n); 
    System.out.println("The " + n + "\'th to last is " + target); 

   }
}
