package com.amazon.practice;
//Given a linked list which is sorted, how will you insert in sorted way

public class InsertNode {
	
	public Node root = null;
	
	class Node {
		public int data;
		Node next; 
		
		Node(int data, Node next) {
			this.data = data; 
			this.next = next; 
		}
		void addNext(Node next) {
		   this.next = next; 	
		}
		Node addNode(int data) {
			Node node = new Node(data, null);
			this.next = node; 
			return node; 
		}
	}
	
	public Node initRoot(int data) {
		root = new Node(data, null); 
		return root; 
	}
	
	public void printList(Node node) {
		if (node != null) {
			System.out.print(node.data + " "); 
		}
		
		while (node.next != null) { 
			System.out.print(node.next.data + " ");
			node = node.next; 
		}
		System.out.println(); 
	}
	
	// insert into the correct location
	public Node insertNode(int data) {
		Node node = root; 
		Node prev = node; 
		while (node.data < data) {
			System.out.println(node.data);
			prev = node; 
			node = node.next; 
		}
		
	   // we're reached the location
	   Node next = node; 
	   // Attach a new Node to node
	   Node newNode = prev.addNode(data);
	   System.out.println(data); 
	   printList(root); 
	   
	   newNode.addNext(next);
	   return node; 
	}
	
	public static void main(String[] args) {
		System.out.println("running InsertNode"); 
		
		InsertNode insertNode  = new InsertNode();
		Node root = insertNode.initRoot(1); 
		
		root.addNode(2).addNode(4).addNode(7).addNode(9); 
		insertNode.printList(root); 
		insertNode.insertNode(5);
		insertNode.printList(root);
		
	}

}
