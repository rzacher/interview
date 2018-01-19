/** Towers of Hanoi from Cracking the code interview
 * Use recursion to solve the towers of hanoi
 * use three towers. Move ordered disks from first tower to last tower, smallest disk on top and
 * biggest on top
**/

package com.newstuff; 

import java.util.*;

public class Tower {
  int id;
  Stack<Integer> disks; 

  public Tower(int id) {
    this.id = id; 
    this.disks = new Stack<Integer>(); 
  }
  
  // only push onto stack if its smaller than the top of the stack
  public void addDisk(int diskNum) {
    if (!disks.isEmpty() && (disks.peek() <= diskNum)) {
       System.err.println("cant add disk " + diskNum + " to tower " + id);  
    } else {
       disks.push(diskNum);  
    }
  } 

  public void moveTopTo(Tower t) {
    Integer disk = disks.pop();
    t.addDisk(disk);
  }
  
  public void printDisks() {
     while (!disks.isEmpty()) {
       Integer disk = disks.pop();
       System.out.print("tower:" + id + " disk:" + disk + " "); 
     }
     System.out.println();
  }

  // User recusion to move, switch buffer and destination
  public void moveDisks(int disks, Tower destination, Tower buffer) {
    System.out.println("in moveDisks");
   // printDisks(); 
    if (disks > 0) {
        // Move n-1 disks from origin to buffer, using destination as a buffer
        moveDisks(disks - 1, buffer,  destination);
        
        moveTopTo(destination); 
        
        // Move n-1 disks from buffer to destination, using origin as a buffer
        buffer.moveDisks(disks - 1, destination, this);
    }
  }

  public static void main(String args[]) {
    int disks = 5; 
    int NUM_TOWERS = 3;
    
    Tower[] towers = new Tower[NUM_TOWERS];
    
    for (int i=0; i<NUM_TOWERS; i++) {
       towers[i] = new Tower(i); 
    }
  
    // put disks on first tower. smaller numbers on top
    System.out.println("Init tower[0] with disks");
    for (int j=disks-1; j>=0; j--) {
        towers[0].addDisk(j); 
    }
    //towers[0].printDisks(); 
    
    // move the disk from origin to tower 3
    Tower buffer = towers[1];
    Tower destination = towers[2]; 
    towers[0].moveDisks(disks, destination, buffer); 
    
    // print the disks on the tower
    System.out.println("completed. disks on destination");
    destination.printDisks();  
  }

}
