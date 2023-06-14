package tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements Tree<T>{
	
	@Override
	/**
	 * Inserts a data into the tree. Duplicate values are not allowed in the tree
	 * @param data
	 */
	public void insert(T data) {
		this.root = insert(data, root);
	}
	
	/**
	 * Helper method for inserting recursively
	 * @param data
	 * @param curNode
	 * @return a reference to the new root of the subtree
	 */
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		//Implement this method DONE
		//if currnode is null, that means the locations has been found
		if(curNode==null){
			return new TreeNode<T>(data);
		}
		//find the parent node which is the data's would be parent
		//set the parents child to a recursive call of the child
		//Update height
		if(data.compareTo(curNode.data) < 0){
			curNode.left = insert(data, curNode.left);
		}else if(data.compareTo(curNode.data) > 0){
			curNode.right = insert(data, curNode.right);
		}else{}
		int leftheight = height(curNode.left);
		int rightheight = height(curNode.right);
		curNode.height = 1 + Math.max(leftheight,rightheight);
		return curNode;
	}

	@Override
	public boolean find(T data) {
		return find(data, root);
	}
	
	private boolean find(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		if(curNode==null) return false;
		if(curNode.data.compareTo(data)==0){
			return true;
		}else if(data.compareTo(curNode.data) < 0){
			return find(data, curNode.left);
		}else{
			return find(data, curNode.right);
		}


		//return false;
	}

	@Override
	public void remove(T data) {
		this.root = remove(data, root);
	}
	
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		if(curNode==null) return null;
		//find the element
		if(data.compareTo(curNode.data) < 0){
			curNode.left = remove(data, curNode.left);
		}else if(data.compareTo(curNode.data) > 0){
			curNode.right = remove(data, curNode.right);
		}else{
			//if 0 children, just return null;
			if(curNode.left==null && curNode.right==null){
				return null;
			}
			//if two children find the rightmost node in left subtree to be sucessor
			else if(curNode.left!=null && curNode.right!=null){
				TreeNode<T> prevEl = curNode.left;
				while(prevEl.right!=null){
					prevEl = prevEl.right;
				}
				curNode.data = prevEl.data;
				curNode.left = remove(curNode.data, curNode.left);
			}
			//overite current value
			//remove the overwritten value from the left subtree

			//if only one child
			else{
				if(curNode.right!=null) return curNode.right;
				if(curNode.left!=null) return curNode.left;
			}
			//return the child
		}
		int leftheight = height(curNode.left);
		int rightheight = height(curNode.right);
		curNode.height = 1 + Math.max(leftheight,rightheight);
		return curNode;
	}
	
	/**
	 * Returns the max item in the given subtree
	 */
	public T findMax() {
		return findMax(this.root);
	}
	private T findMax(TreeNode<T> curNode) {
		//TODO: Implement this method
		//go right
		if(curNode==null) return null;
		TreeNode<T> p = curNode;
		while(p.right!=null){
			p = p.right;
		}
		return p.data;
	}
}
