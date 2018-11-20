package com.fatihkabakci.treesgraphs.tree;

/**
 * 
 * @author fkabakci
 * Check if a binary search tree is a valid one
 * Solution: Inorder traversal
 * when you go to left branch, set max to root.data
 * when you go to right branch, set min to root.data
 * when you visit the node, compare min < root.data < max
 */
public class DetermineBinarySearchTreeMinMaxSolution {
	
	boolean b1 = true, b2 = true;
	
	public boolean isValidBST(Node root, Integer min, Integer max) {		
		if(root != null) {
			b1 = isValidBST(root.left, min, root.data);
			if(min != null)
				if(root.data <= min)
					return false;
			if(max != null)
				if(root.data >= max)
					return false;
			b2 = isValidBST(root.right, root.data, max);
		}
		return b1 & b2;
	}
	
	public boolean isValidBST(Node root) {
		return isValidBST(root, null, null);
	}
	
	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(5);
		root.right = new Node(15);

		root.right.left = new Node(6);
		root.right.right = new Node(20);

		DetermineBinarySearchTreeMinMaxSolution bts = new DetermineBinarySearchTreeMinMaxSolution();
		System.out.println(bts.isValidBST(root));
	}
}