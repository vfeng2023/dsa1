package tree;

/**
 * Self-balancing AVL Tree
 * @author Mark Floryan
 *
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
	
	@Override
	public void insert(T data) {
		this.root = insert(data, this.root);
	}
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		// if(curNode==null) return new TreeNode<T>(data);
		// else if(curNode.data.compareTo(data) < 0){
		// 	curNode.left = insert(data, curNode.left);
		// }else if(curNode.data.compareTo(data) > 0){
		// 	curNode.right = insert(data, curNode.right);
		// }else{
		// 	return curNode;
		// }
		//after the node is inserted, balances 
		curNode = super.insert(data, curNode);
		// int balance = height(curNode.right) - height(curNode.left);
		// if(balance >=2){
		// 	//tree is right heavy
		// 	//rotate right
		// }
		curNode = balance(curNode);
		//need to balance the current node
		return curNode;
	}

	@Override
	public void remove(T data) {
		this.root = remove(data, this.root);
	}
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		curNode = super.remove(data, curNode);
		curNode = balance(curNode);
		return curNode;
	}
	
	/**
	 * Balances the given node. Assumes it is the lowest unbalanced node if unbalanced
	 * @param node
	 * @return
	 */
	private TreeNode<T> balance(TreeNode<T> curNode) {
		//TODO: Implement this method
		int balance = balanceFactor(curNode);
		if(balance >= 2){
			if(balanceFactor(curNode.right) < 0){
				curNode.right = rotateRight(curNode.right);
				//System.out.println("Right rotation for right heavy tree left heavy subtree");
			}
			curNode = rotateLeft(curNode);
			//System.out.println("left rotation for right heavy tree");
		}else if(balance <= -2){
			if(balanceFactor(curNode.left) > 0){
				curNode.left = rotateLeft(curNode.left);
				//System.out.println("Left rotation for left heavy tree right heavy subtree");
			}
			curNode = rotateRight(curNode);
			//System.out.println("right rotation for left heavy tree");
		}
		return curNode;
	}
	
	private TreeNode<T> rotateRight(TreeNode<T> curNode) {
		//TODO: Implement this method
		//for left left case
		TreeNode<T> root =curNode;
		TreeNode<T> pivot = curNode.left;
		TreeNode<T> plc = pivot.right;

		root.left = plc;
		
		pivot.right = root;
		root.height = 1+Math.max(height(root.left), height(root.right));
		pivot.height = 1+Math.max(height(pivot.left), height(pivot.right));
		return pivot;
	}
	
	private TreeNode<T> rotateLeft(TreeNode<T> curNode){
		//TODO: Implement this method
		//for right right case
		TreeNode<T> root = curNode;
		TreeNode<T> pivot = root.right;
		TreeNode<T> pivotLeft = pivot.left;

		pivot.left = root;
		root.right = pivotLeft;
		root.height = 1+Math.max(height(root.left), height(root.right));
		pivot.height = 1+Math.max(height(pivot.left), height(pivot.right));
		return pivot;
	}
	
	private int balanceFactor(TreeNode<T> node) {
		if(node==null) return 0;
		//TODO: Implement this method
		return height(node.right) - height(node.left);
	}
	
	
}
