package com.crack.parkinglot;
import java.util.*;

public abstract class Vehicle {

  int size;
  int spotsNeeded;
  ArrayList<Spot> spots = new ArrayList<Spot>(); 
  
  public Vehicle( int size, int spotsNeeded) {
	  this.size = size;
	  this.spotsNeeded = spotsNeeded;   
  }
  
  int getSpotsNeeded() {
    return spotsNeeded;
  } 

  Size getSize() {
    return new Size(size);
  }

  void park(ArrayList<Spot> spots) {
    for (Spot spot: spots) {
      this.spots.add(spot); 
    }
  }

  // Return the list of spots that I'm leaving
  public ArrayList<Spot> leave()  {
      // Clone the spots. empty these spots. and return the clones.
      ArrayList<Spot> spotClones = new ArrayList<Spot>(spots);
      spots.clear(); 
      return spotClones;
  }
}
