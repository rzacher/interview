package amazon;

public class BinaryTree {
	public final BinaryTreeNode<Integer> root; 
	
	public BinaryTree(Integer t) {
		this.root = new BinaryTreeNode<Integer>(t); 
	}
	
    public void addChild(Integer value,  BinaryTreeNode<Integer> node ) {
		if (node == null) {
			// start at the root
			node = this.root; 
		}
		 if (value.compareTo((Integer) node.getData()) > 0) {
			 if (node.getRightChild() == null) {
				 node.setRightChild(new BinaryTreeNode<Integer>(value)); 
			 } else {
				 // add to the right child
				 addChild(value, node.getRightChild());
			 }
		 } else if (value.compareTo((Integer) node.getData()) == 0) {
			 // do nothing, we already have that node
			 return; 
		 } else {
			 if (node.getLeftChild() == null) {
				 node.setLeftChild(new BinaryTreeNode<Integer>(value)); 
			 } else {
				 // add to the left child
				 addChild(value, node.getLeftChild());
			 }
		 }
		 return; 
	}
	

// Walk the tree and find the value if it exists, otherwise return false
	public boolean containsValue(Integer value, BinaryTreeNode<Integer> node) {
		if (node == null)
			node = this.root;
		
		int compVal = value.compareTo((Integer) node.getData());
		if (compVal == 0) {
			return true; 
		} else if (compVal > 0) {
			if (node.getRightChild() == null) {
				return false; 
			} else {
		      return containsValue(value, node.getRightChild());
			}
		} else {
			 if (node.getLeftChild() == null) {
				return false; 
			 } else {
			    return containsValue(value, node.getLeftChild());
			 }
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(100);
		root.addChild(110, null);
		root.addChild(50, null);
		root.addChild(25, null);
		root.addChild(75, null);
		
		int value = 26; 
		System.out.println("Found value " + value + " = " + root.containsValue(new Integer(value), null));

	    value = 50; 
		System.out.println("Found value " + value + " = " + root.containsValue(new Integer(value), null));

	}
}
