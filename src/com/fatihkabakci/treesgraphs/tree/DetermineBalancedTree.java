package com.fatihkabakci.treesgraphs.tree;

/***
 * 
 * @author fkabakci
 * Check if the binary tree is balanced
 * Solution: Calculate each node depth. If the difference is greater than 1,
 * return a marked value. Otherwise return the max one.
 */
public class DetermineBalancedTree {
	
	private int depth(Node root, int depth) {
		if(root == null)
			return depth;
		
		int d1 = depth(root.left, depth + 1);
		int d2 = depth(root.right, depth + 1);
		
        if(Math.abs(d1 - d2) > 1)
            return -1;
        
		return Math.max(d1, d2);
	}
	
    public boolean isBalancedTree(Node root) {    
        return depth(root, 0) > -1 ? true : false;
    }

	public static void main(String[] args) {
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(21);
		root.left.right = new Node(22);
		
		root.left.left.left = new Node(211);
		root.left.left.right = new Node(212);
		
	   /* root.right.left = new Node(31);
		root.right.right = new Node(32);
		
		root.right.right.left = new Node(311);
		root.right.right.right = new Node(312);*/
		
		DetermineBalancedTree bt = new DetermineBalancedTree();
		if(bt.isBalancedTree(root)) {
			System.out.println("Tree is balanced");
		}else {
			System.out.println("Tree is unbalanced");
		}
	}
}
