package bibfs;

import java.util.*;

public class PathNode {
   Person person;
   PathNode previousNode;
   
   public PathNode(Person person, PathNode previousNode) {
      this.person = person;
      this.previousNode = previousNode;
   } 
   
   
   public LinkedList<Person> collapse(boolean startsWithSource) {
      LinkedList<Person> path = new LinkedList<Person>(); 
      PathNode node = this; 
      while (node != null) {
        System.out.println("Adding node to path:" + node.person); 
        if (startsWithSource) {
          path.addFirst(node.person);
        } else {  
          path.addLast(node.person); 
        } 
        
        node = node.previousNode;    
      }
     return path;
   }
  
   public Person getPerson() {
     return person;
   }
   
   public PathNode getPreviousNode() {
     return previousNode; 
   }
   
   public String toString() {
     return person.toString();
   }

}
