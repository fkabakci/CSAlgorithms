package com.fatihkabakci.treesgraphs.tree;

/**
 * @author fkabakci
 * Given a binary tree, find all possible sum values of a target by traversing tree.
 */
public class PathSums {
	public int findTotalWays(Node root, int acc, int target) {
		if (root == null) return 0;
		
		int ways = 0;
		acc = acc + root.data;

		if (target == acc)
			ways++;

		ways += findTotalWays(root.right, acc, target);
		ways += findTotalWays(root.left, acc, target);
		return ways;
	}
	
	public int traverse(Node root, int target) {
		if(root == null) return 0;
		
		int countFromCurrent = findTotalWays(root, 0, target);
		int countFromLeft = traverse(root.left, target);
		int countFromRight = traverse(root.right, target);
		
		return countFromCurrent + countFromLeft + countFromRight;
	}
	
	public static void main(String[] args) {
		Node root = new Node(-3);

		root.left = new Node(1);
		root.right = new Node(3);

		root.right.left = new Node(5);
		
		PathSums s = new PathSums();
		int result = s.traverse(root, 6);
		System.out.println(result);
	}
}