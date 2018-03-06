package com.amazon;

import java.math.*;

public class AStarNodeEuclid extends AStarNode {
	// Get the euclidean distance between this node and the end node
	public void setEstimatedCost(AStarNode node) {
		int xDistance =  this.x - node.getX();
		int yDistance = this.y - node.getY();
		
		this.costEstimated = Math.sqrt(xDistance*xDistance + yDistance*yDistance); 
		System.out.println("costEstimated: " + this.costEstimated); 
	}
	
   public AStarNodeEuclid(int x, int y) {
	   super(x,y);
   }
}
