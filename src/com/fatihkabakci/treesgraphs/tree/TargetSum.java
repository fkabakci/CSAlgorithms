package com.fatihkabakci.treesgraphs.tree;

/**
 * 
 * @author fkabakci
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
 * adding up all the values along the path equals the given sum
 */
public class TargetSum {

	public boolean hasPathSum(Node root, int acc, int sum) {
		if(root == null)
			return false;
		
		acc += root.data;
		
		if(root.left == null && root.right == null) {
			if(acc == sum)
				return true;
			else
				return false;
		}
		return hasPathSum(root.left, acc, sum) || hasPathSum(root.right, acc, sum);
    }

	public static void main(String[] args) {
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.right.left = new Node(4);
		root.right.right = new Node(5);
		
		TargetSum t = new TargetSum();
		boolean result = t.hasPathSum(root, 0, 4);
		System.out.println(result);
	}
}
