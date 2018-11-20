package com.fatihkabakci.treesgraphs.tree;

import java.util.LinkedList;

/**
 * 
 * @author fkabakci
 * Find out the minimum depth of a binary tree (Iterative Solution)
 */
public class MinDepthOfTree {

	public int minDepth(Node root) {
		LinkedList<Node> tree = new LinkedList<Node>();
		tree.add(root);
		
		while(!tree.isEmpty()) {
			Node r = tree.remove();
			
			if(r.left == null && r.right == null)
				return r.depth;
			
			if(r.left != null) {
				r.left.depth = r.depth + 1;
				tree.add(r.left);
			}
			
			if(r.right != null) {
				r.right.depth = r.depth + 1;
				tree.add(r.right);
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.depth = 1;

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(21);
		root.left.right = new Node(22);

		root.left.left.left = new Node(211);
		root.left.left.right = new Node(212);

/*		root.right.left = new Node(31);
		root.right.right = new Node(32);

		root.right.right.left = new Node(311);
		root.right.right.right = new Node(312);*/
		
		MinDepthOfTree dt = new MinDepthOfTree();
		System.out.println(dt.minDepth(root));
	}
}