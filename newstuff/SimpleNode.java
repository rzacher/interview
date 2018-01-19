// Simple node for linkedList exercises

package com.newstuff;

public class SimpleNode {
     SimpleNode next = null;
     int data;

     public void setNext(SimpleNode next) {
        this.next = next; 
     }

     public SimpleNode getNext() {
        return next; 
     }

     public void setData(int data) {
       this.data = data; 
     }

     public int getData() {
       return data; 
     }

     public void printNode() {
       System.out.println("data:" + data);  
     }
}
