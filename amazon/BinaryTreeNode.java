package amazon;


public class BinaryTreeNode<N extends Number> {
		N n;
		BinaryTreeNode leftChild;
		BinaryTreeNode rightChild;
		
		public BinaryTreeNode(N n) {
			this.n = n;
		}
		
		public N getData() { return n; }
		
		public void setLeftChild(BinaryTreeNode<N> node) {
			this.leftChild = node; 
		}
		
		public void setRightChild(BinaryTreeNode<N> node) {
			this.rightChild = node; 
		}
		
		public BinaryTreeNode getLeftChild() {
			return leftChild;  
		}
		
		public BinaryTreeNode getRightChild() {
			return rightChild; 
		}
}
