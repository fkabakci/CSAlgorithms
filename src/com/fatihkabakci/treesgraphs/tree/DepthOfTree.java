package com.fatihkabakci.treesgraphs.tree;

/**
 * 
 * @author fkabakci
 * Find out the maximum depth of a binary tree
 */
public class DepthOfTree {

	public int depth(Node root, int depth) {
		if (root == null)
			return depth;

		int d1 = depth(root.left, depth + 1);
		int d2 = depth(root.right, depth + 1);

		return Math.max(d1, d2);
	}

	public int depth(Node root) {
		return depth(root, 0);
	}

	public static void main(String[] args) {
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(21);
		root.left.right = new Node(22);

		root.left.left.left = new Node(211);
		root.left.left.right = new Node(212);

		root.right.left = new Node(31);
		root.right.right = new Node(32);

		root.right.right.left = new Node(311);
		root.right.right.right = new Node(312);
		
		DepthOfTree dt = new DepthOfTree();
		System.out.println(dt.depth(root));
	}

}
