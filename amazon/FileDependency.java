package com.amazon;

/**
https://www.electricmonk.nl/log/2008/08/07/dependency-resolving-algorithm/
Suppose we have five objects which all depend on some of the other objects. 
The objects could be anything, but in this case let's say they're very simple 
software packages (no minimal versions, etc) that depend on other packages which 
must be installed first. How does one find the right order of installing the packages?
Take, for instance, the following scenario: Software package 'a' depends on 'b' and 'd'.
 'b' depends on 'c' and 'e'. 'c' depends on 'd' and 'e'. 'd' depends on nothing, nor does 'e'.
 
 see also https://www.geeksforgeeks.org/topological-sorting/
**/

import java.util.*; 
public class FileDependency {
	// Use a resolved to store the result. 
   LinkedList<Integer> resolved = new LinkedList<Integer>();
   HashSet<Integer> visited = new HashSet<>();
	
   // build the graph. Return the root node. 
	public Node buildGraph() {
		Node a = new Node(1); 
		Node b = new Node(2); 
		Node c = new Node(3);
		Node d = new Node(4);
		
		// make a diamond dependency
		//       b
		//  a         d
		//       c
		a.addEdge(b);
		a.addEdge(c);
		b.addEdge(d);
		c.addEdge(d);
		return a; 
	}
	
	
	public void doSort(Node node, LinkedList<Integer> resolved) {
		int id = node.getID();
		System.out.println("doSort on node " + id);
		if (!visited.contains(id)) {
			System.out.println("process node " + id);
			visited.add(id);
		
			List<Edge> edges = node.getEdges();
			for (Edge edge: edges) {
				Node otherNode = edge.getOtherNode(node);
				doSort(otherNode, resolved);
			}
			resolved.push(id);
		}
	}
	
	public void printResolved(LinkedList<Integer> resolved) {
		while (!resolved.isEmpty()) {
			System.out.print(resolved.removeLast());
		}
	}
	// do a depth first walk of the dependency graph. When we reach a node with no dependencies left, 
	// we have a leaf node and can add it to the list of resolved nodes.  
	
	public void run(Node root) {
	   doSort(root, resolved); 
	   printResolved(resolved);
	}
	
	public static void main(String[] args) {
	  try {
		  System.out.println("Running FileDependency"); 
		  FileDependency df = new FileDependency(); 
		  Node root = df.buildGraph(); 
		  df.run(root);
		  
		  
	  } catch (Exception e) {
		  e.printStackTrace(); 
	  }
	}
	
	class Node {
		int id; 
		List<Edge> edges = new LinkedList<>(); 
		public Node(int id) { this.id = id; }
		public void addEdge(Node other) {
			Edge edge = new Edge(this, other); 
			edges.add(edge); 
		}
		public List<Edge> getEdges() {return edges;}
		public int getID() {return id;}
	}
	
	class Edge {
		Node a;
		Node b; 
		public Edge(Node a, Node b) {this.a = a; this.b = b;}
		public Node getOtherNode(Node node) throws IllegalArgumentException {
			if (node.getID() == a.getID()) {
				return b; 
			} else if (node.getID() == b.getID()) {
				return a;
			} else {
				throw new IllegalArgumentException("Edge node not matching");
			}
		}
	}

}
