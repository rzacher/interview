package com.amazon;

import java.util.ArrayList;

public class DepthFirstSearch extends BaseFirstSearch {
	
	DepthFirstSearch() { super(); }
		
	private void doDFS(Node node) {
	 // Mark the node visited 
	 V[node.getId()] = true; 
	 System.out.println("Visited node = " + node.getId());
	 // Get the Children, for each child do a DFS, marking node visited. Then do the next child
	 ArrayList<Integer> neighbors = node.getNeighbors();
	 
		 for (Integer id : neighbors) {
			 System.out.println("neighbor id = " + id);
			 Node nNode = (Node) nodeStorage.get(id);
			 if (V[id] != true) {
			    doDFS(nNode); 
			 }
		 }
	}
	
	public static void main(String[] args) {
		DepthFirstSearch dfs = new DepthFirstSearch();
		Node root = dfs.createGraph(); 
		dfs.doDFS(root);
	}
	
    
}


