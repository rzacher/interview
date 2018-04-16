package com.newstuff;

import com.newstuff.FindLoop;

// Use the runner method to find a loop in a linked list

public class FindLoop {
	Node root; 
	
	class Node {
		int data; 
		Node next; 
	
	
		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		int getData() {
			return data; 
		}
		
		Node addNode(int data) {
			Node node = new Node(data, null);
			this.next = node; 
			return node; 
		}
		
		void setNext(Node next) {
			this.next = next; 
		}
	} 
	
	
	public void buildList()  {
		root = new Node(1, null);
		Node node3 = root.addNode(2).addNode(3);
		
		Node node6 = node3.addNode(4).addNode(5).addNode(6); 
		node6.setNext(node3);
	}
	
	Node getRoot( ) {
		return root; 
	}	
		
	
	Node advanceSlow(Node node) {
		if (node == null) return null;
		
		Node next = node.next;
	    return next; 
	}
	
	Node advanceFast(Node node) {
		if (node == null) return null;
		
		// advance once
		Node next = node.next;
		if (next == null) return next; 
		// advance the second step.
		next = next.next; 
	    return next; 
	}
	
	
	// Use a racer pointer to determine if we have a loop
	public boolean isLoop(Node root) {
		Node fast, slow; 
		fast = root; 
		slow = root; 
 
		while (slow != null && fast != null) {
		  System.out.println("data: " + slow.getData() + " " + fast.getData()); 
		  slow = advanceSlow(slow);
		  fast = advanceFast(fast); 
		  if ((slow != null) && (slow == fast)) {
			  return true; 
		  }
		}
		return false; 
	}
	
	public static void main(String[] args) {
		FindLoop fl = new FindLoop();
		fl.buildList();
		Node root = fl.getRoot(); 
		System.out.println("is loop = "  + fl.isLoop(root)); 
	}
}
