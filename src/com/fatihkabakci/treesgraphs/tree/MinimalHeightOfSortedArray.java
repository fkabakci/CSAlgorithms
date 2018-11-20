package com.fatihkabakci.treesgraphs.tree;

/**
 * 
 * @author fkabakci
 * Sorted Array to Binary Search Tree
 */
public class MinimalHeightOfSortedArray {

	private Node root;
	
	public MinimalHeightOfSortedArray(int[] arr) {
		composeBinarySearchTree(arr, 0, arr.length - 1);
	}
	
	public void composeBinarySearchTree(int[] arr, int start, int end) {
		if(start > end)
			return;
		
		int middle = (start + end)  / 2;

		root = add(root, arr[middle]);
		
		composeBinarySearchTree(arr, start, middle - 1);
		composeBinarySearchTree(arr, middle + 1, end);
	}
	
	public Node add(Node root, int data) {
		Node newNode = new Node(data);
		
		if(root == null) {
			root = newNode;
			return root;
		}
		
		if(root.data < data)
			root.right = add(root.right, data);
		else
			root.left = add(root.left, data);
		
		return root;
	}
	
	public void print(TraversalType type) {
		if(type == TraversalType.PREORDER)
			preorder(root);
		else if(type == TraversalType.INORDER)
			inorder(root);
		else if(type == TraversalType.POSTORDER)
			postorder(root);
		else
			inorder(root);
			
	}

	private void preorder(Node root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	private void inorder(Node root) {
		if(root != null) {		
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	
	private void postorder(Node root) {
		if(root != null) {		
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		
		MinimalHeightOfSortedArray bst = new MinimalHeightOfSortedArray(arr);
		bst.print(TraversalType.INORDER);
	}
}