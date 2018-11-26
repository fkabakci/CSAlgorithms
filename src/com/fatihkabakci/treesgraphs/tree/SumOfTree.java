package com.fatihkabakci.treesgraphs.tree;

/**
 * 
 * @author fkabakci
 * Find out sum of the all nodes of the binary tree
 */
public class SumOfTree {

	public int sumOfTree(Node root) {
		if(root == null)
			return 0;
		
		int sum = root.data + sumOfTree(root.left) + sumOfTree(root.right);
		
	    return sum;
	 
	}
	public static void main(String[] args) {
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.right.left = new Node(4);
		root.right.right = new Node(5);
		
		SumOfTree t = new SumOfTree();
		int sum = t.sumOfTree(root);
		System.out.println(sum);
	}
}