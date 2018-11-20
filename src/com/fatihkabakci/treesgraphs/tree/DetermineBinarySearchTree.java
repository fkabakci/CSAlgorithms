package com.fatihkabakci.treesgraphs.tree;

/**
 * 
 * @author fkabakci
 * Check if a binary search tree is a valid one
 * Solution: Inorder traversal
 */
public class DetermineBinarySearchTree {
	
	boolean b1 = true, b2 = true;
	Integer data = null;
	
	public boolean isValidBST(Node root) {
		if(root != null) {
			b1 = isValidBST(root.left);
			if(data != null && data >= root.data)
				return false;
			data = root.data;
			b2 = isValidBST(root.right);
		}
		return b1 & b2;
	}
	
	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(5);
		root.right = new Node(15);

		root.right.left = new Node(6);
		root.right.right = new Node(20);

		DetermineBinarySearchTree bts = new DetermineBinarySearchTree();
		System.out.println(bts.isValidBST(root));
	}
}