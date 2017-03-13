/** Towers of Hanoi from Cracking the code interview
 * Use recursion to solve the towers of hanoi
 * use three towers. Move ordered disks from first tower to last tower, smallest disk on top and
 * biggest on top
**/

public class Tower {
  int id;
  Stack<Integer> disks; 

  public Tower(int id) {
    this.id = id; 
    this.disks = new Stack<Integer>(); 
  }
  
  // only push onto stack if its smaller than the top of the stack
  public void addDisk(int diskNum) throws {
    if ((!disks.isEmpty() && (disks.peek() < diskNum)) {
       System.err.println("cant add disk to stack " + diskNum);  
    } else {
       disks.push(diskNum);  
    }
  } 

  // User recusion to move, switch buffer and destination
  public moveDisks(int disks, Tower origin, Tower destination, Tower buffer) {
    
    // Move n-1 disks from origin to buffer, 
    moveDisks(disks - 1, 
    
    moveTop(destination); 
    
    // Move n-1 disks from buffer to destination
    
    
  
  
  }

  public static void main(String args[]) {
    int disks = 3; 
    
    Tower[] towers = new Tower[3];
    
    for (int i=0; i<3; i) {
       tower[i] = new Tower(i); 
    }
  
    // put disks on first tower
    for (int j=0; j<disks; j++) {
        tower[0].addDisk(j); 
    }
    
    // move the disk from origin to tower 3
    Tower buffer = tower[1];
    Tower destination = tower[2]; 
    tower[0].moveDisks(disks, buffer, destination); 
  }

}
