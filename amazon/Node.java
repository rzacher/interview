package com.amazon;

import java.util.ArrayList;

public class Node {
	int id;
	ArrayList<Integer> neighbors = null; 
	
	public Node(int id) {
		this.id = id; 
		neighbors = new ArrayList<Integer>(); 
	}
	
	public void addNeighbor(int id) {
		neighbors.add(new Integer(id)); 
	}

	public ArrayList<Integer> getNeighbors() {
		ArrayList<Integer> clone = (ArrayList<Integer>) neighbors.clone();
		return clone;
	}
	
	public int getId() { return id; }
}
