package com.amazon.practice;

import java.util.ArrayList;
import java.util.List;


public  class Node {
	int id; 
	int data; 
	List<Node> neighbors = new ArrayList<>();
	
	public Node(int id, int data) { this.id = id; this.data = data; System.out.println("id:" + id + " data:" + data); }
	
	public int getID() {return id;}	
	public int getData() { return data; }
	
	public void addNeighbor(Node node) throws NullPointerException {
		if (node == null) {throw new NullPointerException("bad node"); }
		
		neighbors.add(node); 
	}
	
	public List<Node> getNeighbors() {return neighbors;}
	
	// Begin DFS
	public static Node buildGraph() {
		int data = 10; 
		int nodeIndex = 0 ; 
		Node root = new Node(nodeIndex, data); 
		Node kid1 = new Node(++nodeIndex, data+=10);
		Node kid2 = new Node(++nodeIndex, data+=10);
		root.addNeighbor(kid1);
		root.addNeighbor(kid2); 
		Node kid11 = new Node(++nodeIndex, data+=10);
		Node kid12 = new Node(++nodeIndex, data+=10);
		kid1.addNeighbor(kid11);
		kid1.addNeighbor(kid12);
		Node kid21 = new Node(++nodeIndex, data+=10);
		Node kid22 = new Node(++nodeIndex, data+=10);
		kid2.addNeighbor(kid21);
		kid2.addNeighbor(kid22);
		return root; 
	}  // end buildGraph
	
} // end Node


