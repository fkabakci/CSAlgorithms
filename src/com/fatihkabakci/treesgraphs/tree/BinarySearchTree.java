package com.fatihkabakci.treesgraphs.tree;

/**
 * 
 * @author fkabakci
 * Find out the depth of the node of a given value in binary search tree
 */
public class BinarySearchTree {

	public int depth(Node root, int data) {
		return search(root, data, 0);
	}
	
	public int search(Node root, int data, int depth) {
		if(root == null)
			return -1;
		
		if(root.data == data)
			return depth;
		
		if(root.data <= data)
			return search(root.right, data, depth + 1);
		else
			return search(root.left, data, depth + 1);
	}
	
	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(8);
		root.right = new Node(15);

		root.right.left = new Node(13);
		root.right.right = new Node(16);
		
		root.left.left = new Node(6);
		root.left.right = new Node(9);
		
		BinarySearchTree bst = new BinarySearchTree();
		int result = bst.depth(root, 7);
		System.out.println(result);
		
	}
}
