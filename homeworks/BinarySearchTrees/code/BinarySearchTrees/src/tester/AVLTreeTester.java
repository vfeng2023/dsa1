package tester;

import java.util.ArrayList;

import tree.AVLTree;
import tree.BinarySearchTree;

public class AVLTreeTester {
	public static final int NUM_TO_INSERT = 50;
	public static void main(String[] args) {
		
		/* Here are two test cases for your implementations. */
		/* You SHOULD create more */
		
		/*
		 * 	Correct output:
		 * 	BST Pre: 5 4 3 2 1 9 8 7 6 
		 *	BST In: 1 2 3 4 5 6 7 8 9 
		 *	BST Post: 1 2 3 4 6 7 8 9 5 
		 *	AVL Pre: 4 2 1 3 8 6 5 7 9 
		 *	AVL In: 1 2 3 4 5 6 7 8 9 
		 *	AVL Post: 1 3 2 5 7 6 9 8 4 
		 */

		//You can comment this line back in next week
		AVLTree<Integer> avl = new AVLTree<Integer>();
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		//int[] toInsert = {5,4,3,2,1,9,8,7,6};

		ArrayList<Integer> toInsert = new ArrayList<>();
		//randomly insert 20 items
		//check that in order traversal is sorted
		for(int i=0; i < NUM_TO_INSERT; i++){
			int val = (int)(Math.random()*NUM_TO_INSERT);
			toInsert.add(val);
		}
		
		
		// for(int i : toInsert) {
		// 	avl.insert(i);
		// 	//bst.insert(i);
		// 	System.out.println("Inserted " + i);
		// 	System.out.print("AVL Pre: " + avl.getPreOrder());
		// 	System.out.print("AVL In: " + avl.getInOrder());
		// 	System.out.print("AVL Post: " + avl.getPostOrder());
		// 	//System.out.print("Tree:" + avl.printTree());
		// 	avl.printTree();
		// 	//avl.printLevelOrder();
		// }
		
		/* Print out pre, in, and post-order */
		// System.out.println("Items which were inserted: " + toInsert);
		// System.out.print("BST Pre: " + bst.getPreOrder());
		// System.out.print("BST In: " + bst.getInOrder());
		// System.out.println("BST Post: " + bst.getPostOrder());
		// //test find
		// System.out.println("Testing find...");
		// for(int i:toInsert){
		// 	boolean f = bst.find(i);
		// 	if(!f){
		// 		System.out.println("Find returned false -- check find");
		// 		System.exit(0);
		// 	}
		// }
		// System.out.println("All good!");
		// //Test removal;
		// for(int i: toInsert){
		// 	bst.remove(i);
		// 	System.out.println("Removed "+ i);
		// 	System.out.print("BST Pre: " + bst.getPreOrder());
		// 	System.out.print("BST In: " + bst.getInOrder());
		// 	System.out.println("BST Post: " + bst.getPostOrder());
		// }
		//testing for avl tree
		System.out.println("Items which were inserted: " + toInsert);
		for(int i: toInsert){
			avl.insert(i);
			System.out.println("inserted: " + i);
			System.out.print("AVL Pre: " + avl.getPreOrder());
			System.out.print("AVL In: " + avl.getInOrder());
			System.out.println("AVL Post: " + avl.getPostOrder());
		}
		//test find
		System.out.println("Testing find...");
		for(int i:toInsert){
			boolean f = avl.find(i);
			if(!f){
				System.out.println("Find returned false -- check find");
				System.exit(0);
			}
		}
		System.out.println("All good!");
		//Test removal;
		for(int i: toInsert){
			avl.remove(i);
			System.out.println("Removed "+ i);
			System.out.print("AVL Pre: " + avl.getPreOrder());
			System.out.print("AVL In: " + avl.getInOrder());
			System.out.println("AVL Post: " + avl.getPostOrder());
		}
		//You can comment these lines in next week as well
		//System.out.print("AVL Pre: " + avl.getPreOrder());
		//System.out.print("AVL In: " + avl.getInOrder());
		//System.out.print("AVL Post: " + avl.getPostOrder());
		
	}
}
