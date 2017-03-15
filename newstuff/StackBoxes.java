// Stack boxes with width, height and depth. 
// Bottom boxes must be larger in all dimensions than a box above it. 
// Find the stack with the largest height. 

package newstuff; 


import java.util.*;


public class StackBoxes {
     ArrayList<Box> boxes = new ArrayList<Box>(); 

   public int createStack() {
       // Sort the boxes by height as a short cut. 
       Collections.sort(boxes, new BoxComparator());
       
       int maxHeight = 0;    
        
       // Try each box as the bottom
       for (int i=0; i< boxes.size(); i++) {
         Box box = boxes.get(i); 
         System.out.println("Testing bottom box " + box.h + ", " + box.w + ", " + box.d); 
         int height = createStack(boxes, i); 
         System.out.println("height:" + height);
         maxHeight = Math.max(height, maxHeight); 
       }
       
       return maxHeight; 
   }


   int createStack(ArrayList<Box> boxes, int bottomIndex) {
      int maxHeight = 0; 
      Box bottom = boxes.get(bottomIndex); 
       
      for (int i=bottomIndex+1; i<boxes.size(); i++) {
         Box top = boxes.get(i);
        
         if (isSmaller(bottom, top)) {
             System.out.println("Adding box h=" + top.h); 
             int height = bottom.h + createStack(boxes, i); 
             maxHeight = Math.max(height, maxHeight); 
         }
      }
       
      return maxHeight; 
   }

   private  boolean isSmaller(Box bottom, Box top) {
     return ( (top.w < bottom.w) && (top.d < bottom.d) && (top.h < bottom.h) ); 
  
   
   }

  class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box a, Box b) {
      return (b.h - a.h); 
    }
  }

  public void createBoxes() {
      Box b1 = new Box(1,1,1); 
      Box b2 = new Box(2,2,2); 
      Box b3 = new Box(3,3,3); 
      Box b4 = new Box(4,2,1); 
      boxes.add(b1);
      boxes.add(b2);
      boxes.add(b3);
      boxes.add(b4);  
  } 


  class Box {
    public int w, d, h; 
    
    public Box(int w, int d, int h) {
      this.w = w; 
      this.d = d; 
      this.h = h; 
    }
  }
  


   public static void main(String[] args) {
     
      
      StackBoxes sb = new StackBoxes();
      sb.createBoxes(); 
      
      int maxHeight = sb.createStack(); 
      System.out.println("Max height:" + maxHeight); 
   }
} 

