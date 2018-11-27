package com.fatihkabakci.treesgraphs.tree;

/**
 * 
 * @author fkabakci
 * Given an array, build a binary tree dynamically from it.
 */
public class ArrayToBinaryTree {

	public Node buildTree(int[] arr) {
		return insert(null, arr, 0);
	}
	
	private Node insert(Node root, int[] arr, int i) {
		if (i < arr.length) {
			root = new Node(arr[i]);

			int left = 2 * i + 1;
			int right = 2 * i + 2;

			root.left = insert(root.left, arr, left);
			root.right = insert(root.right, arr, right);
		}
		return root;
	}
	
	public void print(Node root) {
		if(root != null) {
			print(root.left);
			System.out.print(root.data + " ");
			print(root.right);
		}
	}
	
	public static void main(String[] args) {
		int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		ArrayToBinaryTree tree = new ArrayToBinaryTree();
		Node root = tree.buildTree(values);
		tree.print(root);
	}
}