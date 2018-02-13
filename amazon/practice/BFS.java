package com.amazon.practice;

import java.util.*; 

public class BFS {
	Set<Integer> visited = new HashSet<Integer>(); 
	Queue<Node> queue = new LinkedList<Node>();
	
	public Node doSearch(Node node, int searchValue) throws NullPointerException {
		Node result = null; 
		// Check the current node
		if (node == null) throw new NullPointerException("bad node");
		
		System.out.println("Searching node " + node.getID()); 
		if (node.getData() == searchValue) {
			result = node; 
			return result; 
		} 
		
		// Mark this node a visited 
		visited.add(node.getID());
		List<Node> neighbors = node.getNeighbors();
		// Put its kiddies on the queue
		for (Node aNode: neighbors) {
			if (!visited.contains(aNode.getID())) {
				queue.add(aNode); 
			}
		}
		// Now process the queue
		while (!queue.isEmpty()) {
			// pop the queue and continue search
			Node qNode = queue.remove();
			result = doSearch(qNode, searchValue); 
			if (result != null) {
				return result; 
			}
		}
		// outta luck
		return result; 
	
	} // endSearch
	
	public static void main(String[] args) {
		BFS bfs = new BFS();
		Node root = Node.buildGraph(); 
		int searchValue = 30; 
		Node result = bfs.doSearch(root, 30);
		if (result != null) {
			System.out.println("id:" + result.getID() + "data:" + result.getData());
		} else {
			System.out.println("outta luck");
		}
		
	}

}
