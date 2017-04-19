package newstuff;

import java.util.*;
    final int data;
    final BTreeNode left = null;
    final BTreeNode right =  null;

    public class BTreeNode {

    public BTreeNode(int data) {
       this.data = data; 
    }

    private addLeft(int data) {
      left = new  BTreeNode(data);
    }
    
    private addRight(int data) {
      right = new BTreeNode(data);
    }
    
    public BTreeNode getLeft() {
      return left;
    }
    
    public BTreeNode getRight() {
      return right;
    }
    
    public void insert(int data) {
      if (data == this.data) {
        return; 
      } else if (data < this.data) {
        this.addL
      }
    }
}
