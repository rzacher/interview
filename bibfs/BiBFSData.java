// Holds data for a BFS search on part of a graph.

package bibfs;

import java.util.*; 

public class BiBFSData {
   String name;
   // queue for BFS search
   LinkedList<PathNode> toVisit = new LinkedList<PathNode>(); 
   // Map for looking up has already been visited
   HashMap<Integer, PathNode> visited = new HashMap<Integer, PathNode>();
   
   // init data
   public BiBFSData(String name, Person person) {
      this.name = name; 
      PathNode root = new PathNode(person, null); 
      // add the node to toVisit
      toVisit.add(root);
   }
  
   
   public boolean isFinished() {
     return toVisit.isEmpty(); 
   } 
   
   public String getName() {
     return name; 
   }
}


