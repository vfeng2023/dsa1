package tree;

import java.util.LinkedList;

public class BinaryTree<T> {

	protected TreeNode<T> root = null;
	
	/* Traversal methods */
	public String getInOrder() {
		return getInOrder(root)+"\n";
	}
	private String getInOrder(TreeNode<T> curNode) {
		//TODO: return the in order traversal of this tree, space separated
		if(curNode==null) return "";
		//traverse left, then root, then right
		return getInOrder(curNode.left) +curNode.data + " " + getInOrder(curNode.right);
	}
	
	public String getPreOrder() {
		return getPreOrder(root)+"\n";
	}
	private String getPreOrder(TreeNode<T> curNode) {
		//TODO: return the pre order traversal of this tree, space separated
		//root left right
		if(curNode==null) return "";
		return curNode.data + " "+getPreOrder(curNode.left) +getPreOrder(curNode.right);
	}
	
	public String getPostOrder() {
		return getPostOrder(root)+"\n";
	}
	private String getPostOrder(TreeNode<T> curNode) {
		//TODO: return the post order traversal of this tree, space separated
		//return left right root
		if(curNode==null) return "";
		return getPostOrder(curNode.left)+ getPostOrder(curNode.right) +" "+ curNode.data;
	}

	//------------------------------------------------------------------------
	//EVERYTHING BELOW THIS POINT IS IMPLEMENTED FOR YOU
	//YOU SHOULD STILL LOOK AT THIS CODE
	//------------------------------------------------------------------------
	
	/* A somewhat more pretty print method for debugging */
	public void printTree() {
		printTree(this.root, 0);
		System.out.println("\n\n");
	}
	private void printTree(TreeNode<T> curNode, int indentLev) {
		if(curNode == null) return;
		for(int i=0; i<indentLev; i++) {
			if(i == indentLev - 1) System.out.print("|-----");
			else System.out.print("      ");
			//else System.out.print("\t");
		}
		System.out.println("("+curNode.data+", "+ curNode.height+")");
		printTree(curNode.left, indentLev+1);
		printTree(curNode.right, indentLev+1);
	}
	
	//TODO: Look at these methods and think about how they might be useful for this assignment
	public int height() {
		return height(root);
	}
	
	/* Computes the height of the tree on the fly */
	protected int height(TreeNode<T> node) {
		if(node == null) return 0;
		return node.height;
	}
	public void printLevelOrder(){
		LinkedList<TreeNode<T>> q = new LinkedList<>();
		q.addLast(root);
		while(q.size() > 0){
			TreeNode<T> node = q.removeFirst();
			if(node.left!=null){
				q.addLast(node.left);
			}
			if(node.right!=null){
				q.add(node.right);
			}
			System.out.print("("+node.data+ ", "+node.height+") ");
		}
		System.out.println();
	}
	// public int recursiveHeight(){

	// }
	// private int helper(TreeNode<T> node){
	// 	if(node==null) return -1;

	// }
}
