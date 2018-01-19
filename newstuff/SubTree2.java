package com.newstuff; 

import java.util.*;
import com.amazon.BinaryTree;
import com.amazon.BinaryTreeNode; 


public class SubTree2  {

   public static void main(String[] args) {
       SubTree st = new SubTree();
   
       BinaryTree bigTree = new BinaryTree(5);
       bigTree.addChild(1, null);
       bigTree.addChild(7, null);
       bigTree.addChild(3, null);
       bigTree.addChild(4, null); 
       bigTree.addChild(14, null); 
       StringBuilder bigTreeStr = new StringBuilder();
       //st.traverseInOrder(bigTree.root, bigTreeStr); 
       System.out.println("bigTree string: " + bigTreeStr); 
       
       
       BinaryTree smallTree = new BinaryTree(1);
       smallTree.addChild(3, null);
       smallTree.addChild(4, null);
       StringBuilder smallTreeStr = new StringBuilder();
       //st.traverseInOrder(smallTree.root, smallTreeStr);  
       System.out.println("smallTree string: " + smallTreeStr);
       
      // boolean containsTree = bigTreeStr.toString().indexOf(smallTreeStr.toString()) >= 0 ;  
      // System.out.println("contains subtree " + containsTree);      
   }
   
}
