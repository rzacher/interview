package com.amazon;

public class MyLinkedList {
	 private Node head; 
	 private Node last; 
	 int size; 
	 
	 
	  private class Node { 
        int data; 
        Node next; 
	 }
     
     public MyLinkedList(int data) {
    	 head = new Node(); 
    	 head.data = data; 
    	 head.next = null; 
    	 last = head; 
    	 size = 1; 
     }
	
     public void addNode(int data) {
    	 Node nextNode = new Node();
    	 nextNode.data = data; 
    	 nextNode.next = null;
    	 last.next = nextNode; 
    	 last = nextNode;
    	 size++;
     }
     
     public void printList() { 
    	if (head == null) {
    		return;
    	}
    	 
    	Node currentNode = head;
    	
    	while (currentNode != null) {
    		System.out.println(currentNode.data);
    		currentNode = currentNode.next; 
    	}
     }
     
     public void reverseList() {
    	 Node currentNode = head; 
    	 Node nextNode = head.next; 
    	 head.next = null; // Set to null since this is now the tail
    	 Node nextNextNode = null; 
    	 Node loopNode; 
    	 
    	 while (nextNode != null) {
    		 loopNode =  nextNode.next;
    		 nextNode.next = currentNode;
    		 currentNode = nextNextNode; 	 
    	 }
    	 
    	 
     }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyLinkedList head = new MyLinkedList(7);
		head.addNode(5);
		head.addNode(6);
		head.addNode(8); 
		head.printList();
	}

}
