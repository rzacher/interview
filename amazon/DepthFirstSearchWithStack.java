package amazon;

import java.util.ArrayList;
import java.util.Stack; 

public class DepthFirstSearchWithStack extends BaseFirstSearch {
    Stack<Node> stack = new Stack<>(); 
	
	DepthFirstSearchWithStack() { super(); }
		
	private void doDFS(Node node) {
	     // Mark the node visited 
	     V[node.getId()] = true; 
	     System.out.println("Visited node = " + node.getId());
	     stack.push(node);
	     
	     // Get the Children, for each child do a DFS, marking node visited. Then do the next child
	     while(!stack.isEmpty()) {
	         Node currentNode = stack.pop();
	         System.out.println("Adding to stack:" + currentNode.getId()); 
	         
	         ArrayList<Integer> neighbors = currentNode.getNeighbors();
	         // Walk the neighbors. Add the unvisited to the stack
	         //for (Integer id : neighbors) {
	         // Start from the right, so the last member on the stack is on the left. 
	         for (int i=neighbors.size()-1; i >= 0; i--) {
	             Integer id = neighbors.get(i); 
		         //System.out.println("neighbor id = " + id);
		         Node nNode = nodeStorage.get(id);
		         // push nodes onto stack 
		         if (V[nNode.getId()] != true) {
		            // Mark it as visited
		            V[nNode.getId()] = true; 
		            // Add to stack 
		            stack.push(nNode); 
	              }
	          }  
	      }
	 }
	
	public static void main(String[] args) {
		DepthFirstSearchWithStack dfs = new DepthFirstSearchWithStack();
		Node root = dfs.createGraph(); 
		dfs.doDFS(root);
	}
	
    
}


