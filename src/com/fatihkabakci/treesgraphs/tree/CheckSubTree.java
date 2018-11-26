package com.fatihkabakci.treesgraphs.tree;

/**
 * 
 * @author fkabakci
 * Check if the tree a is a subtree of tree b.
 * Solution: Frequently check two tree values every time traversing the larger tree
 */
public class CheckSubTree {

	private boolean isIdentical(Node tree, Node subTree) {
		if(tree == null && subTree == null)
			return true;
		
		else if(tree == null || subTree == null)
			return false;

		return tree.data == subTree.data && isIdentical(tree.left, subTree.left) && isIdentical(tree.right, subTree.right);
	}
	
	public boolean isSubTree(Node tree, Node subTree) {
		if(tree == null && subTree == null)
			return true;
		
		else if(tree == null || subTree == null)
			return false;
        
        else if(isIdentical(tree, subTree))
            return true; 
		
		return isSubTree(tree.left, subTree) || isSubTree(tree.right, subTree);
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		Node root1 = new Node(3);
		root1.left = n1;
		root1.right = n2;
		
		root1.left.left = n3;
		root1.left.right = n4;
		
		root1.right.right = n5;
		root1.right.left = n6;
		
		Node root2 = n1;
		root2.left = n3;
		root2.right = n4;
		
		System.out.println(new CheckSubTree().isSubTree(root1, root2));
		
	}
}
