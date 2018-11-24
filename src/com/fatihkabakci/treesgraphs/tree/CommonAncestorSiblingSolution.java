package com.fatihkabakci.treesgraphs.tree;

/**
* @author fkabakci
* Given two nodes, find out the first common ancestor of them.
* 
* Solution: If node a consist node b, then parent is a.parent
* 		    Otherwise, every time find out a sibling node of node a,
* 			until it consists node b or 
* */
		
public class CommonAncestorSiblingSolution {

	public boolean consist(Node a, Node b) {
		if(a == null || b == null)
			return false;
		
		if(a == b)
			return true;
		
		return consist(a.left, b) || consist(a.right, b);
	}
	
	public Node getSibling(Node node) {
		if(node == null || node.parent == null)
			return null;
		
		return (node.parent.left == node) ? node.parent.right : node.parent.left;
	}
	
	public Node ancestor(Node root, Node a, Node b) {
		if(!consist(root, a) || !consist(root, b))
			return null;
		else if(consist(a, b))
			return a.parent;
		else if(consist(b, a))
			return b.parent;
		
		Node sibling = getSibling(a);
		while(!consist(sibling, b)) {
			sibling = sibling.parent;
			sibling = getSibling(sibling);
		}
		return sibling.parent;
		
		
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
		
		CommonAncestorSiblingSolution tree = new CommonAncestorSiblingSolution();
		Node ancestor = tree.ancestor(root, root.left, root.right.left);
		if(ancestor != null)
			System.out.println(ancestor.data);
		else
			System.out.println("null");
	}

}
