package com.amazon.practice;


//geektogeeks set 3 
//A Java program for in-place conversion of Binary Tree to DLL

//A binary tree BDNode has data, left pointers and right pointers
class BDNode {
  int data;
  BDNode left, right;


	public BDNode(int data) 
	{
	  this.data = data;
	  left = right = null;
	}
}

class BSTtoDLL
{
BDNode root;

// head --> Pointer to head BDNode of created doubly linked list
BDNode head;

// Initialize previously visited BDNode as NULL. This is
// static so that the same value is accessible in all recursive
// calls
static BDNode prev = null;

// A simple recursive function to convert a given Binary tree 
// to Doubly Linked List
// root --> Root of Binary Tree
void BinaryTree2DoubleLinkedList(BDNode root) {
	{
	   if (root == null) {
		   return; 
	   }
	}
	BinaryTree2DoubleLinkedList(root.left);
	if (prev == null) { // first BDNode on left
		head = root; 
	} else {
		root.left = prev;
		prev.right = root; 
	}
	prev = root;  // get ready for next call. move pointer to root. 
	BinaryTree2DoubleLinkedList(root.right);
	
	
	
}
/* Function to print BDNodes in a given doubly linked list */
void printList(BDNode BDNode)
{
  while (BDNode != null) 
  {
      System.out.print(BDNode.data + " ");
      BDNode = BDNode.right;
  }
}

// Driver program to test above functions
public static void main(String[] args) 
{
  // Let us create the tree as shown in above diagram
  BSTtoDLL tree = new BSTtoDLL();
  tree.root = new BDNode(10);
  tree.root.left = new BDNode(12);
  tree.root.right = new BDNode(15);
  tree.root.left.left = new BDNode(25);
  tree.root.left.right = new BDNode(30);
  tree.root.right.left = new BDNode(36);

  // convert to DLL
  tree.BinaryTree2DoubleLinkedList(tree.root);
    
  // Print the converted List
  tree.printList(tree.head);

}
}
