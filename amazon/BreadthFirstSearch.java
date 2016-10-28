package amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends BaseFirstSearch {
	
	public BreadthFirstSearch() { super(); }
	
	public void doBFS(Node node) {
	  // Get neighbors, visit each neighbor and put it on the queue
	  // After all the neighbors are visited, do a BFS on their children if the child is not already visited. 
	  Queue<Integer> queue = new LinkedList<Integer>();
	  
	  // Mark the node as visited
	  queue.add(node.getId()); 
	  V[node.getId()] = true; 
	  
	  // Get the children, mark as visited, put on queue, then do a BFS on their children
	  while (!queue.isEmpty()) {
		  Integer id = queue.remove(); 
		  // Mark as visited
		  
		  // Get the node
		  Node nNode = nodeStorage.get(id);
		  System.out.println("visited node = " + id);
		  //Mark as visited
		  V[id] = true; 
		  // Add the children to the queue
		  ArrayList<Integer> children = (ArrayList<Integer>) nNode.getNeighbors();
		  for (Integer childId : children) {
			  if (V[childId] == false) { // Only add children not yet visited. 
			    queue.add(childId); 
			  }
		  }
	  }
	}
	 
	
	public static void main(String[] args) {
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		Node root = bfs.createGraph(); 
		bfs.doBFS(root);
	}

}
