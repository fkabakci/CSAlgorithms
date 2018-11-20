package com.fatihkabakci.treesgraphs.tree;

import java.util.ArrayList;

/**
 * 
 * @author fkabakci 
 * Find out kth smallest element in binary search tree
 * Solution: Inorder traversal, save nodes into a list. Then check the list.
 */
public class KthSmallestOneBST {
	ArrayList<Integer> l = new ArrayList<Integer>();

	public void kthSmallest(Node root, int index) {
		if (root != null) {
			kthSmallest(root.left, index);
			l.add(root.data);
			kthSmallest(root.right, index);
		}
	}

	public int kthSmallestBST(Node root, int index) {
		kthSmallest(root, index);
		return l.get(index);
	}

	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(5);
		root.right = new Node(15);

		root.right.left = new Node(12);
		root.right.right = new Node(20);

		KthSmallestOneBST bst = new KthSmallestOneBST();
		System.out.println(bst.kthSmallestBST(root, 1));
	}
}