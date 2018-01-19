package com.newstuff;


/** Partition the list around x. All members less than x on one side and the  rest 
 * on the other side. 
 **/

public class PartitionList {
    
    public PartitionList() {
       
    } 
   
    // partition the list around x 
    public SimpleNode doPartition(SimpleNode sourceList, int x) {
       SimpleNode frontList = null; 
       SimpleNode backList = null; 
       SimpleNode frontListHead = null;
       SimpleNode backListHead = null; 

       // Walk the elements. All less than nodes go into the frontList. The rest into the backList
       SimpleNode current = sourceList;
       while (current != null) {
          System.out.println("processing node data " + current.getData()); 
          SimpleNode sn = new SimpleNode();
          sn.setData(current.getData());
          if (current.getData() < x) {
              System.out.println("adding node to front " + current.getData());
              if (frontListHead == null) {
                  frontListHead = sn;
                  frontList = sn;  
              } else {
                  frontList.setNext(sn); 
                  frontList = sn; 
              }
          } else {
              if (backListHead == null) {
                  backListHead = sn;
                  backList = sn; 
              } else {
                  backList.setNext(sn); 
                  backList = sn; 
              }
          }
          current = current.getNext(); 
       } // end while

       System.out.println("Frontlist");
       printList(frontListHead);
       System.out.println("Backlist");
       printList(backListHead);

       // Now stitch them together
       SimpleNode finalList = new SimpleNode();
       SimpleNode finalListHead = finalList; 

       // Add the frontList
       SimpleNode next = frontListHead;
       while (next != null) {
         // Create a new node for the final list
         SimpleNode sn = new SimpleNode(); 
         sn.setData(next.getData()); 
         next = next.getNext(); 
         finalList.setNext(sn);
         finalList = sn; 
       }  
   
       // Add the backList
       next = backListHead; 
       while (next != null) {
         // Create a new node for the final list
         SimpleNode sn = new SimpleNode(); 
         sn.setData(next.getData()); 
         next = next.getNext();
         finalList.setNext(sn);
         finalList = sn;
       }

       //return the final partition list
       return finalListHead; 
    } // end doPartition

    public void printList(SimpleNode list) {
       SimpleNode current = list;
       while (current != null) {
          current.printNode();
          current = current.getNext(); 
       }
  
    }

    public static void main(String[] args) {
      SimpleNode sourcelist = null; 
      SimpleNode current = null; 

      for (int i=10; i>0; i--) {
         SimpleNode sn = new SimpleNode(); 
         sn.setData(i);
         if (sourcelist == null) {
            sourcelist = sn;
            current = sourcelist;
         } else {
           current.setNext(sn);
           // reset current to point to next
           current = sn;
         }
         //sn.printNode(); 
      }

     
     PartitionList pl = new PartitionList();
     SimpleNode list = pl.doPartition(sourcelist, 5);
      
      // print the list
      System.out.println("Printing final list");
      current = list; 
      while (current != null) {
        current.printNode();
        current = current.getNext(); 
      }
    }
}
