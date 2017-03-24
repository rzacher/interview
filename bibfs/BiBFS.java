/**
 * Does BFS on a graph. Start form source and destination and find when there is a collision. this is much faster than 
 * starting from the source and searching to the destination. See prob 9.2 Social Network in Cracking the coding interview.
 * Scalability chapter. 
 **/
 
 package bibfs; 
 
 import java.util.*;
 
 public class BiBFS {
 
    public LinkedList<Person> findMatch(HashMap<Integer, Person> people, Integer sourcePersonID, Integer destPersonID) {
      Person sourcePerson = people.get(sourcePersonID);
      Person destPerson = people.get(destPersonID);
      
      BiBFSData sourceData = new BiBFSData("source", sourcePerson);
      BiBFSData destData = new BiBFSData("dest", destPerson);
      
      Person collision = null; 
      
      while(!sourceData.isFinished() && !destData.isFinished()) {
         collision = searchLevel(people, sourceData, destData);
         if (collision != null) {
           return mergePaths(sourceData, destData, collision.getID());  
         }
         
         collision = searchLevel(people, destData, sourceData); 
         if (collision != null) {
           return mergePaths(sourceData, destData, collision.getID());
         }
      }
      return null; 
    }
 
    // return the person where the collision occured
    public Person searchLevel(HashMap<Integer, Person> people, BiBFSData primary, BiBFSData secondary) {
      
      // Walk the list of nodes in toVisit
      int count = primary.toVisit.size();
      
      // We walk the nodes currently in the queue, but not new ones we add this cycle. 
      for (int i=0; i<count; i++) {
        PathNode currentNode = primary.toVisit.poll(); 
        System.out.println("SearchLevel for node:" + currentNode.toString()); 
        int personID = currentNode.getPerson().getID();
        
        if (secondary.visited.containsKey(personID)) { // found a collision
          return currentNode.getPerson(); 
        }
        
        // Add the friends of the person for the next level
        ArrayList<Integer> friends = currentNode.getPerson().getFriends();
        
        // Walk the friends and add the ones not yet visited to the queue
        for (int friendID : friends) {
          if (!primary.visited.containsKey(friendID)) { // friend is not yet visited
            Person friend = people.get(friendID);
            PathNode next = new PathNode(friend, currentNode);
            primary.visited.put(friendID, next); 
            primary.toVisit.add(next);
          }
        } // end for friendID
        // Added all the friends, so Mark the node as visited
        System.out.println("adding personID:" +personID + " to BFSData:" + primary.getName()); 
        primary.visited.put(personID, currentNode); 
     } //end for node walk
    
     return null; 
  }
    
  public LinkedList<Person> mergePaths(BiBFSData bfs1, BiBFSData bfs2, int collisionID) {
      System.out.println("CollisionID = " + collisionID); 
      PathNode end1 = bfs1.visited.get(collisionID); 
      PathNode end2 = bfs2.visited.get(collisionID);
       if (end1 == null) {
        System.out.println("end1 is null");
        return null; 
      }
      if (end2 == null) {
        System.out.println("end2 is null");
        return null; 
      }
      System.out.println("end1:" + end1.getPerson());
      System.out.println("end2:" + end2.getPerson());
      LinkedList<Person> pathOne = end1.collapse(false);
      LinkedList<Person> pathTwo = end2.collapse(true);
      System.out.println("pathOne size:" + pathOne.size());
      printList(pathOne);
      System.out.println("pathTwo size:" + pathTwo.size());
      printList(pathTwo); 
      
      pathOne.removeFirst(); // remove collisionID
   
      pathTwo.addAll(pathOne); 
      return pathTwo; 
  }
  
  private  void printList(List<Person> path) {
     for (Person person: path) {
        System.out.println(person.toString());
     }
  }
    
   public static void main(String[] args) {
       System.out.println("Running BiBFS main");
       BiBFS bibfs = new BiBFS(); 
       
       HashMap<Integer, Person> people = new  HashMap<Integer, Person>(); 
       Person p1 = new Person(1, "bob", "zacher");
       Person p2 = new Person(2, "marieke", "zacher");
       Person p3 = new Person(3, "ilana", "zacher");
       Person p4 = new Person(4, "sonia", "zacher");
       
       p1.addFriend(2);
       p2.addFriend(1);
       
       p2.addFriend(3); 
       p3.addFriend(2);
        
       p4.addFriend(3);
       p3.addFriend(4);  
       
       people.put(1, p1);
       people.put(2, p2);
       people.put(3, p3); 
       people.put(4, p4); 
       
       LinkedList<Person> result = bibfs.findMatch(people, 1, 4);
       if (result == null) {
         System.out.println("result is null");
         return;
       }
       System.out.println("print final result");
       for (Person person: result) {
         System.out.println(person);
       }
       return; 
   }
}
 
 
 
 
 
