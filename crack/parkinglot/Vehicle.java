import java.util.*;

public abstract class Vehicle {

  Size size;
  int spotsNeeded;
  ArrayList<Spot> spots = new ArrayList<Spot>(); 
  
  int getSpotsNeeded() {
    return spotsNeeded;
  } 

  Size getSize() {
    return size;
  }

  void park(ArrayList<Spot> spots) {
    for (Spot spot: spots) {
      this.spots.add(spot); 
  }

  // Return the list of spots that I'm leaving
  public ArrayList<Spot> leave()  {
      // Clone the spots. empty these spots. and return the clones.
      ArrayList<Spot> spotClones = new ArrayList<Spot>(spots);
      spots.clear(); 
      return spotClones;
  }
}
