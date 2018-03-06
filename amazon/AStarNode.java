package com.amazon;

import java.util.*; 

public abstract class AStarNode implements Comparable<AStarNode> {
	AStarNode pathParent = null; 
    double costFromStart = Integer.MAX_VALUE;
    double costEstimated = Integer.MAX_VALUE; 
    int x;
    int y;
    List<AStarNode> neighbors = new LinkedList<>(); 
    
    
    public AStarNode(int x, int y) {
    	this.x = x;
    	this.y = y; 
    	
    }
    
    public double getCost() {return costFromStart + costEstimated;}
    public double getCostFromStart() {return costFromStart; }
    public void setCostFromStart(AStarNode fromNode) {
    	System.out.println("setCostFromStart " + fromNode.getCostFromStart() + " " + getStepCost(fromNode)); 
    	costFromStart = fromNode.getCostFromStart() + getStepCost(fromNode); 
    }
    public double getStepCost(AStarNode node) { 
    	int dx = this.x - node.getX();
    	int dy = this.y - node.getY();
    	
    	double cost = Math.sqrt((dx*dx) + (dy*dy));
    	System.out.println("getStepCost dx:" + dx + " dy:" + dy + " stepCost:" + cost); 
    	return cost; 
    }
  
    public double getEstimatedCost() {return costEstimated;}
    public abstract void setEstimatedCost(AStarNode node); 
    public void setPathParent(AStarNode node) {pathParent = node;}
    
    public void addNeighbor(AStarNode node) throws NullPointerException {
    	if (node == null) throw new NullPointerException("nulll node"); 
    	System.out.println("Adding neighbor " + node.getX() + " " + node.getY());
    	neighbors.add(node); 
    }
    
    public List<AStarNode> getNeighbors() {return neighbors;}
    
    public int getX() { return x; }
    public int getY() {return y;}
    
    public int compareTo(AStarNode other) { 
    	double otherCost = other.getCost(); 
    	if (getCost() < otherCost) return 1;
    	else if (getCost() == otherCost) return 0;
    	else return 1; 
    }

}
