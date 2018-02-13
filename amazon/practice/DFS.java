package com.amazon.practice;

import java.util.*; 

public class DFS {
	Set<Integer> visited = new HashSet<>();
	
	public Node doSearch(Node node, int searchValue)  {
		int id = node.getID();
		if (node.getData() == searchValue) { return node;}
		
        if (!visited.contains(id)) {
        	visited.add(id); 
        	// Search the kiddies
        	List<Node> neighbors = node.getNeighbors();
        	if (neighbors.size() > 0) {
        		for (Node aNode: neighbors) {
        			Node result = doSearch(aNode, searchValue); 
        			if (result != null) {
        				return result;
        			}
        		}
        	}
        }	
        // otherwise we've already been there and didn't find the gold. 
		return null; 
	}


	
	
	public static void main(String[] args) {
		DFS dfs = new DFS(); 
		Node root = Node.buildGraph();
		int searchValue = 20; 
	    Node result = dfs.doSearch(root, searchValue); 
	    if (result == null) {
	    	System.out.println("no matching node found"); 
	    } else {
	    	System.out.println("found matching value of " + result.getID() + " " + result.getData()); 
	    }
	}
	 
	
}
