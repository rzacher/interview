package com.amazon;
import java.util.*;

public class BalancedBinaryTree extends BinaryTree { 
	
	public BalancedBinaryTree(Integer t) {
		super(t);
	}


	public int getHeight(BinaryTree node) {
		if (node == null) {
			return 0;
		}
		
		int height = max( getHeight(node.leftChild), getHeight(node.rightChild) ) + 1;
		return height;
	}
	
	int max(int height1, int height2) {
		if (height1 >= height2) {
			return height1;
		} else {
			return height2;
		}
	}
	
	public boolean isBalanced(BinaryTree node) {
		if (node == null) {
			return true; 
		}
		int heightDiff = getHeight(node.leftChild) - getHeight(node.rightChild);
			
		if (Math.abs(heightDiff) > 1) {
			return false;
		} else {
		    return true;
		}
	}
	
	public void printInOrderTraversal(BinaryTree node) {
		if (node == null) {
			return;
		}
		
		printInOrderTraversal(node.leftChild);
		System.out.print(node.t + " ");
		printInOrderTraversal(node.rightChild);
		return; 
	}
	
	public void inOrderTraversal(BinaryTree node, ArrayList<Integer> numbers) {
		if (node == null) {
			return;
		}
		
		inOrderTraversal(node.leftChild, numbers);
		numbers.add(new Integer(node.t)); 
		inOrderTraversal(node.rightChild, numbers);
		return; 
	}
	
	public BinaryTree rebalance(BinaryTree node) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		inOrderTraversal( node, numbers); 
		for (Integer number : numbers) {
			System.out.print(number + " ");
		}
		
		// Now reinsert the numbers
		int start = 0;
		int end = numbers.size() - 1;
		int mid = (int) Math.ceil(((double)end - start)/2.0);
		
		// Create a new BinaryTree
		// get the middle node as the root
		int midVal = numbers.get(mid);
		BinaryTree root = new BinaryTree(midVal);
		
		balanceTree(root, numbers, start, mid-1); 
		balanceTree(root, numbers, mid+1, end);
		return root;
	}
	
	public void balanceTree(BinaryTree node, ArrayList<Integer> numbers, int start, int end) {
		if (start == end) {
			return;
		}
		
		// Now reinsert the numbers
		int mid = (int) Math.ceil(((double)end - start)/2.0);
       
        if (mid <  0) {
        	return;
        }
        System.out.println("mid=" + mid);
        if (start < end) {
			// Create a new BinaryTree
			// get the middle node as the root
			int midVal = numbers.get(mid);
			System.out.println("midVal=" + midVal);
			
			node.addChild(midVal);
			balanceTree(node, numbers, start, mid-1); 
			balanceTree(node, numbers, mid+1, end);
        }
		return;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BalancedBinaryTree root = new BalancedBinaryTree(100);
		root.addChild(110);
		root.addChild(50);
		root.addChild(25);
		root.addChild(75);
		root.addChild(80);
		
		int value = 26; 
		System.out.println("Found value " + value + " = " + root.containsValue(value));
		
		System.out.println("Height is " + root.getHeight(root));
		
		System.out.println("IsBalanced = " + root.isBalanced(root));
		
		System.out.println("In order traversal"); 
		root.printInOrderTraversal(root); 
		System.out.println();
		
		System.out.println("Rebalance"); 
		root.rebalance(root); 
		
	}
}
