package com.amazon; 

import java.util.*; 

//http://www.peachpit.com/articles/article.aspx?p=101142&seqNum=2
	
public class AStarSearch  {
	
	int SIZE = 10; 
	AStarNode[][] nodes = null; 
	
	// build a rectangular grid 
	public void buildGraph() {
		nodes  = new AStarNode[SIZE][SIZE];
		
		for (int x=0; x<SIZE; x++) {
			for (int y=0; y<SIZE; y++) {
				 nodes[x][y]= new AStarNodeEuclid(x,y);
			}
		}
		
		// Set the neighbors for all nodes
		for (int x=0; x<SIZE; x++) {
			for (int y=0; y<SIZE; y++) {
				 AStarNode currentNode = nodes[x][y];
				 System.out.println("Adding neighbors for node " + currentNode.getX() + " " + currentNode.getY());
				 addNeighbors(currentNode, x,y);
			}
		}
		
	}
	
	private void addNeighbors(AStarNode node, int x, int y) {
		for (int dx = -1; dx<=1; dx++) {
			for (int dy=-1; dy<=1; dy++) {
				if (! ((dx==0)&&(dy==0)) ) {  // don't add this node itself
					int newx = x + dx;
					int newy = y + dy;
					if ( ((0<=newx) && (newx < SIZE)) && ((0<=newy) && (newy < SIZE)) ) {
						node.addNeighbor(nodes[newx][newy]);
					}
				}
			}
		}
		
	}
	
	public Set<AStarNode> run() { 
		Set<AStarNode> result = findPath(0,0,9,9); 
	
		for (AStarNode asn: result) {
			System.out.println(asn.getX() + " " + asn.getY());
		}
		return result; 
	}
	
	public Set<AStarNode> findPath(int startx, int starty, int goalx, int goaly) {
		AStarNode startNode = nodes[startx][starty];
		AStarNode goalNode = nodes[goalx][goaly]; 
		
		startNode.setEstimatedCost(goalNode); 
		startNode.setPathParent(null); 
		
		PriorityQueue<AStarNode> openList = new PriorityQueue<>();
		HashSet<AStarNode> visitedList = new HashSet<>(); 
		
		// walk the openList, find the best node from the PriorityQueue, 
		// get its neighbors, put them on the queue and continue. This is like a breadth first search 
		// using a priority queue. 
		openList.add(startNode);
		AStarNode currentNode = null; 
		while (!openList.isEmpty()) {
			System.out.println("================"); 
			System.out.println("openList size " + openList.size());
			currentNode = openList.remove(); 
			System.out.println("currentNode:" + currentNode.getX() + " " + currentNode.getY());
			visitedList.add(currentNode);
		    List<AStarNode> neighbors = currentNode.getNeighbors(); 
		    // Process neighbors, set the estimatedCost.
		    // Add to openList if not already visited. 
		    double currentCost = currentNode.getCost(); 
		    System.out.println("currentCost " + currentCost); 
		    AStarNode bestNeighborNode = null; 
		    double lowestNeighborCost = Double.MAX_VALUE; 
		    for (AStarNode node: neighbors) {
		    	// Check if this is the goal
		    	if (node  == goalNode) {
		    		System.out.println("found goal"); 
		    		return visitedList; 
		    	} else {
		    		if (!visitedList.contains(node)) {  // inefficient for linked list
		    			System.out.println("neighbor:" + node.getX() + " " + node.getY()); 
		    			// TODO pick the best of the neighbors 
		    			node.setCostFromStart(currentNode);
		    			node.setEstimatedCost(goalNode);
		    			node.setPathParent(currentNode); 
		    		
		    			System.out.println("neighborCost " + node.getCost() + " " +  node.getCostFromStart() + " " + node.getEstimatedCost()); 
		    			// Adding node to neighbor list
		    			if ( (!openList.contains(node)) ) {
		    				System.out.println("Add to open list " + node.getX() + " " + node.getY());
		    				if (node.getCost() < lowestNeighborCost) {
		    					lowestNeighborCost = node.getCost(); 
		    					bestNeighborNode = node; 
		    				}
		    			}
		    			System.out.println("end openList size " + openList.size());
		    		}
		    	}
		    } // end for neighbors list
		    // Add the best node to the list
		    openList.add(bestNeighborNode); 
		} // end while !openList
		
		return visitedList; 
		
	}
	public static void main(String[] args) {
		System.out.println("Running AStarSearch");
		AStarSearch ass = new AStarSearch(); 
		ass.buildGraph();
		ass.run(); 
		System.out.println("Finished AStarSearch");
	}

}
