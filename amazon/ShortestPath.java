// Class to find the shortest path through  a graph. Implementation of Dijkstra's algorithm. 
//www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
package com.amazon;

import java.util.*;


public class ShortestPath {
	// Create the graph. A graph consists of vertices and edges
	HashMap<Integer, Vertex> vertices = new HashMap<Integer, Vertex>();
	HashSet<Edge> edges = new HashSet<Edge>();
	// Create two arrays, visited and unvisited Vertices
	HashMap<Integer, Vertex> visited = new HashMap<Integer, Vertex>();
	HashMap<Integer, Vertex> unvisited = new HashMap<Integer, Vertex>();
	HashMap<Integer, Integer> predecessors = new HashMap<Integer, Integer>();
	int startIndex;
	int endIndex; 


	public ShortestPath(Map<Integer, Vertex> vertices, Set<Edge> edges) {
		this.vertices.putAll(vertices); 
		this.edges.addAll(edges);  
	}

	public void doit1(int startIndex, int endIndex) {
		System.out.println("Running dijkstra algorithm");
		this.startIndex = startIndex; 
		this.endIndex = endIndex; 

		init(); 
		runDijkstra(startIndex, endIndex);
	}


	private void init() {
		//Initialize all weights to infinity
		for (Edge edge: edges) {
			edge.setWeight(Integer.MAX_VALUE);
		}
		// Put all the nodes in unvisited
		unvisited.putAll(vertices);
	}


	private void updateVertexDistances(Vertex currentVertex, Set<Edge> nearestNeighborsEdges) throws IllegalStateException {
		Vertex otherVertex = null; 

		int size = ((nearestNeighborsEdges == null) ? 0 : nearestNeighborsEdges.size()); 
		System.out.println("currentVertex: " + currentVertex.getId() + " ,num edges: " + size); 
		if (nearestNeighborsEdges != null) {
			for (Edge edge: nearestNeighborsEdges) {
				// Find the other vertex (i.e not the currentVertex at the other end of the edge
				if (currentVertex.getId() != edge.getVertexA().getId()) {
					otherVertex = edge.getVertexA();
				} else if (currentVertex.getId() != edge.getVertexB().getId()) {
					otherVertex = edge.getVertexB();
				} else {
					throw new IllegalStateException("neither vertex matches current vertex");
				}
	
				// Now add the distance from the edge to the source distance to update the otherVertex distance
				int newDistance = currentVertex.getDistance() + edge.getWeight();
				// only update if the new distance is less than the old distance
				if (newDistance < otherVertex.getDistance()) {
					System.out.println("Updating distance for vertex:" + otherVertex.getId() + " ,distance:" + newDistance); 
					otherVertex.setDistance(newDistance); 
					predecessors.put(otherVertex.getId(), currentVertex.getId()); 
				}
			}
		}    
	}
	/**
	 * Returns a list of Vertices to define the path
	 */
	public List<Vertex> getShortestPath() {
		LinkedList<Vertex> result = new LinkedList<Vertex>(); 
		System.out.println("Shortest path distance: " + vertices.get(endIndex).getDistance());
		int currentId = endIndex;
		System.out.println(currentId); 
	
		while(predecessors.get(currentId) != null) {
			 int nextId = predecessors.get(currentId); 	
			 System.out.println(nextId); 
			 currentId = nextId; 
	    }
	   
		
		result.add(visited.get(endIndex));
		return result;
	}
	
	/**
	 * Find the min distance among the unvisited nodes and return him
	 * @return Vertex 
	 */
	private Vertex findMinDistanceVertex() {
		int minDistance = Integer.MAX_VALUE;
		Vertex bestChoice = null;
		
		for (Vertex vertex: unvisited.values()) {
			System.out.println("findMinDistanceVertex ID: " + vertex.getId());
			if (vertex.getDistance() < minDistance) {
				minDistance = vertex.getDistance();
				bestChoice = vertex; 
			}
		}
		if (bestChoice != null) {
			System.out.println("min distance node id: " + bestChoice.getId()); 
		}
		return bestChoice; 
	}
	
	/**
	 * 
	 * @param startVertex
	 * @param endVertex
	 */
	private void runDijkstra(int startVertex, int endVertex) {
		// Move the source node into visited
		Vertex source = vertices.get(startVertex);
		source.setDistance(0);

		Vertex nextVertex = source; 
		// in a loop,
		while (nextVertex != null) {
			// pick a node and add to visited
			visited.put(nextVertex.getId(), nextVertex);
			// remove from unvisited
			unvisited.remove(nextVertex.getId(), nextVertex);

			// find nearest neighbors
			Set<Edge> nearestNeighborsEdges = nextVertex.getEdges(); 
			// update distance on nearest neighbors
			
			updateVertexDistances(nextVertex, nearestNeighborsEdges);
			// select vertex with minimum distance in unvisited set
			nextVertex = findMinDistanceVertex(); 
			// rinse and repeat
			System.out.println("");
		}

	}

    public void createGraph() {
    	System.out.println("Creating graph");
    	Vertex source = new Vertex(0, Integer.MAX_VALUE); 
    	vertices.put(0, source); 
    	// add v1
    	Vertex v1 = new Vertex(1, Integer.MAX_VALUE);
    	vertices.put(1, v1); 
    	Edge edge1 = new Edge(source, v1, 2);
    	source.addEdge(edge1);
    	v1.addEdge(edge1);
    	// add v2 
    	Vertex v2 = new Vertex(2, Integer.MAX_VALUE);
    	vertices.put(v2.getId(), v2); 
    	Edge edge2 = new Edge(source, v2, 3);
    	source.addEdge(edge2);
    	v2.addEdge(edge2);
    	// add v3 which connects to both v1 and v2 - i.e. a diamond shape
    	Vertex v3 = new Vertex(3, Integer.MAX_VALUE);
    	vertices.put(v3.getId(), v3); 
    	Edge edge31 = new Edge(v3, v1, 2);
    	v1.addEdge(edge31);
    	v3.addEdge(edge31);
    	Edge edge32 = new Edge(v3, v1, 2);
    	v2.addEdge(edge32);
    	v3.addEdge(edge32);
    	
    	// add all the vertices to unvisited
    	unvisited.putAll(vertices);
    }

	public static void main(String[] args) {
		System.out.println("Running ShortestPath");
		HashMap<Integer, Vertex> vertices = new HashMap<Integer, Vertex>();
		HashSet<Edge> edges = new HashSet<Edge>();

		ShortestPath sp = new ShortestPath(vertices, edges); 
		sp.createGraph();
		int startVertex = 0;
		int endVertex = 3; 
		sp.doit1(startVertex, endVertex); 
		sp.getShortestPath();
	}

	// A vertex has an id and a list of edges that define it's neighbors
	private class Vertex {
		int id;
		HashSet<Edge> edges; 
		int distance; 

		public Vertex(int id, int distance) {
			this.id = id;
			this.distance = distance; 
			edges = new HashSet<Edge>(); 
		}

		public int getId() {
			return id; 
		}

		public void setDistance(int distance) {
			this.distance = distance; 
		}

		public int getDistance() {
			return distance; 
		}
		
		public void addEdge(Edge edge) {
			edges.add(edge);
		}

		public void removeEdge(Edge edge) {
			throw new UnsupportedOperationException(); 
		}

		public Set<Edge> getEdges() {
			return edges; 
		}

	} // end Vertex

	// An edge 
	private class Edge {
		Vertex a; 
		Vertex b;
		int weight; 

		public Edge(Vertex a, Vertex b, int weight) {
			this.a = a;
			this.b = b; 
			this.weight = weight; 
		}   

		public int getWeight() {
			return weight; 
		}

		public void setWeight(int weight) {
			this.weight = weight; 
		}

		public Vertex getVertexA() {
			return a; 
		} 

		public Vertex getVertexB() {
			return b; 
		}

	}  // end Edge
}

