package com.fatihkabakci.treesgraphs.tree;

/**
 * 
 * @author fkabakci
 * Practice: Find out sibling of a given node.
 */
public class SiblingOfNode {
	
	public Node sibling(Node me) {
		if(me == null || me.parent == null)
			return null;
		
		Node parent = me.parent;
		return parent.left == me ? parent.right : parent.left;
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(5);
		root.left.parent = root;
		root.right = new Node(15);
		root.right.parent = root;
		
		root.left.left = new Node(3);
		root.left.left.parent = root.left;
		root.left.right = new Node(2);
		root.left.right.parent = root.left;

		root.right.left = new Node(12);
		root.right.left.parent = root.right;
		root.right.right = new Node(20);
		root.right.right.parent = root.right;
		
		root.left.right.right = new Node(1);
		root.left.right.right.parent = root.left.right;
		root.left.right.left = new Node(0);
		root.left.right.left.parent = root.left.right;
		
		SiblingOfNode tree = new SiblingOfNode();
		Node ancestor = tree.sibling(root.left);
		if(ancestor != null)
			System.out.println(ancestor.data);
		else
			System.out.println("null");
	}
}
