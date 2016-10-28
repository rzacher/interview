package amazon;

import java.util.ArrayList;

public class BaseFirstSearch {
	/*      0 
	 *     / \ 
	 *    1   2 
	 *   /     \ \
	 *  3       4 5
	 */
	public static int GRAPH_SIZE = 6;
	
	public ArrayList<Node> nodeStorage = new ArrayList<Node>();
	public boolean[] V = new boolean[GRAPH_SIZE];
		
	// nodes are represented by an id
	public Node createGraph() {
		int id = 0;
		Node root = new Node(id);
		nodeStorage.add(0, root);
		Node node1 = new Node(1);
		nodeStorage.add(1, node1);
		root.addNeighbor(1);
		Node node2 = new Node(2);
		nodeStorage.add(2, node2);
		root.addNeighbor(2);
		Node node3 = new Node(3);
		nodeStorage.add(3, node3);
		node1.addNeighbor(3);
		Node node4 = new Node(4);
		nodeStorage.add(4, node4);
		node2.addNeighbor(4);
		Node node5 = new Node(5);
		nodeStorage.add(5, node5);
		node2.addNeighbor(5);
		
		return root; 
	}

}
