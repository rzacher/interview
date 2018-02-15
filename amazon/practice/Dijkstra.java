package com.amazon.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList; 
import java.util.HashMap; 

// Implement the dijkstra algorithm to find the shortest distance between two points. 

public class Dijkstra {
	//data
	List<Vertex> vtx = new ArrayList<Vertex>(); 
	List<Edge> edges = new ArrayList<Edge>(); 
	HashMap<Integer, Vertex> visited = new  HashMap<>(); 
	Queue<Vertex> unvisited = new LinkedList<Vertex>();
	List<Vertex> predecessors = new LinkedList<>(); 
	int numVertices = 11; 
	
	public List<Vertex> run(int origin, int destination) {
		try {
			List<Vertex> bestPath = null; 
			updateDistances(origin, destination);
			bestPath = findBestPath(origin, destination);
			return bestPath; 
		} catch (Exception e) {
			e.printStackTrace(); 
			return null; 
		}
	}
	
	// Start with the origin, update the distances from the origin, then get the neighbors 
	// and repease
	private void updateDistances(int origin, int destination ) {
		Vertex v = vtx.get(0); 
		v.setDistance(0); 
		// Add the source to the unvisitied list to start the ball rolling
		Vertex sourceVertex = v; 
		unvisited.add(sourceVertex); 
		int counter = 0; 
		
		// Pop a node off the unvisited queue and loop. 
		while (!unvisited.isEmpty()) {
			//if (counter > 15) System.exit(0);
			counter++; 
			Vertex currentVertex = unvisited.remove(); 
			System.out.println("pop off unvisited" + currentVertex.getID());
			if (!visited.containsKey(currentVertex.getID())) {
				// Add the sourceVertex to the list of visited
				visited.put(currentVertex.getID(), currentVertex); 
				List<Edge> edges = currentVertex.getEdges(); 
				System.out.println("Edges size=" + edges.size()); 
				for (Edge edge: edges) {
					// Find the other vertex and update the distance
					Vertex other = findOtherVertex(currentVertex, edge); 
								
					if ((other != null) && (!visited.containsKey(other.getID()) ))  {
						System.out.println("other vertex: "  + other.getID());
						// Add the other to the unvisited nodes
						unvisited.add(other); 
						// Update the distance to the other vertex
						int distance = currentVertex.getDistance() + edge.getWeight(); 
						System.out.println("new distance " + distance); 
						// Only update if distance is shorter. 
						if (distance < other.getDistance()) {
							other.setDistance(distance);
						}
					}
				}
			}
		}
	}
	
	
	private Vertex findOtherVertex(Vertex currentVertex, Edge edge) throws NullPointerException {
		if (currentVertex == null) throw new NullPointerException("currentVertex is null");
		System.out.println("findOtherVertex current:" + currentVertex.getID() + " A ID"
		   + edge.getA().getID() + " B ID " + edge.getB().getID());  
		Vertex other; 
		if (currentVertex.getID() != edge.getA().getID()) {
			other = edge.getA();
		} else if (currentVertex.getID() != edge.getB().getID()) {
			other = edge.getB();
		} else {
			System.out.println("Error: no matching vertices");
			other = null; 
		}
		return other; 
	}
	
	// Start at end and work your way backwards along the lowest distance neighbors. 
	private List<Vertex> findBestPath(int origin, int destination) {
		Vertex currentVertex  = vtx.get(destination);
		System.out.println("Final distance is " + currentVertex.getDistance()); 
		
		// Walk your way back along the vertices with the lowest distances. 
		while (currentVertex.getID() != vtx.get(origin).getID()) {
			List<Edge> edges = currentVertex.getEdges();
			Vertex nextVertex = null;
			int distance = Integer.MAX_VALUE; 
			for (Edge edge: edges) {
			 
			  Vertex other = findOtherVertex(currentVertex, edge);
			  if (other.getDistance() < distance) {
				  nextVertex = other; 
				  distance = other.getDistance(); 
			  }
			} // end for Edge
			predecessors.add(nextVertex); 
			currentVertex = nextVertex; 
		}  // end while
		return predecessors; 
	}
	
	
	// Return the path along the predecessors. 
	private List<Vertex> getBestPath() {
		return predecessors; 
	}
	
	private void printPath() {
		for (Vertex v: predecessors) {
			System.out.println(v.getID() + " " + v.getDistance()); 
		}
	}
	
	public static void main(String[] args) {
		Dijkstra dijk = new Dijkstra(); 
		int origin = 0; 
		int destination = 10; 
		dijk.buildGraph(); 
		List<Vertex> solution = dijk.run(origin, destination); 
		// Print path
		if (solution != null) {
			System.out.println("Printing path");
			dijk.printPath(); 
		}
	}
	
	
	public void buildGraph() {
		int vindex = 0; 
		for (int i=0; i<numVertices; i++) {
		   Vertex v = new Vertex(vindex++, Integer.MAX_VALUE);
		   vtx.add(v);    
		}
		// 0 -> 1,2
		// 1 -> 3,4
		// 2 -> 4,5
		// 3 -> 6,7
		// 4 -> 6,7,8
		// 5 -> 7,8
		// 6,7 -> 9
		// 7,8 ->10
		
		connect(0,1,1);
		connect(0,2,2);
		connect(1, 3, 1);
		connect(1, 4, 2);
		connect(2, 4, 1);
		connect(2,5,2);
		connect(3,6,1);
		connect(3,7,3);
		connect(4,6,1);
		connect(4,7,2);
        connect(4,8,3);
        connect(5,7,1);
        connect(5,8,2);
        connect(6,9,1);
        connect(7,9,2);
        connect(7,10,1);
        connect(8,10,2); 
		
		// Copy the all the vertices into unvisited
		unvisited.addAll(vtx);
	}
	
	private void connect(int i, int j, int weight) {
		System.out.println("i:" + i + " j:" + j + " weight:" + weight);
		Vertex va = vtx.get(i);
		Vertex vb =  vtx.get(j); 
		if ((va == null) || (vb == null)) throw new NullPointerException("Vertex not found"); 
		
		Edge edge = new Edge(va, vb, weight);
		va.addEdge(edge);
		vb.addEdge(edge); 
		edges.add(edge); 
	}
	
	private class Vertex {
		int id;
		Integer distance;
		List<Edge> edges = new LinkedList<>(); 
		
		public Vertex(int id, Integer distance) {
			this.id = id; 
			this.distance = distance; 
		}
		
		public int getID() {
			return id; 
		}
		public void addEdge(Edge edge) {
			edges.add(edge); 
		}
		
		public List<Edge> getEdges() {
			return edges; 
		}
		
		public void setDistance(int distance) {
			this.distance = distance; 
		}
		
		public int getDistance() {
			return distance; 
		}
	}

	
	private class Edge {
		Vertex a; 
		Vertex b;
		int weight; 
		
		public Edge(Vertex a, Vertex b, int weight) {
			this.a = a; 
			this.b = b; 
			this.weight = weight; 
		}
		
		int getWeight() {return weight;}
		Vertex getA() {return a;}
		Vertex getB() {return b;}
	}
}
