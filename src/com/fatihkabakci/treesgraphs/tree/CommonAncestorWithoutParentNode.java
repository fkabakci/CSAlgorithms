package com.fatihkabakci.treesgraphs.tree;

/**
 * 
 * @author fkabakci
 * Given two nodes, find out the first common ancestor of them.
 * 
 * Solution: Assume that there is no parent node that we can use !
 * Look up the depths of each node. Let them be at the same level by moving up the deeper node.
 * To bubble up the tree, each time find out ancestor node of a node by moving up on the tree.
 * Once they are at the same level, start comparing parent nodes. 
 * If there is a match, return it, Otherwise return null.
 * 
 */
public class CommonAncestorWithoutParentNode {
	
	public Node ancestor(Node root, Node child) {
		if(root == null || child == null)
			return null;

		Node subLeft = ancestor(root.left, child);
		Node subRight = ancestor(root.right, child);
		
		if(subLeft != null)
			return subLeft;
		
		else if(subRight != null)
			return subRight;
		
		if(root.left == child || root.right == child)
			return root;
		
		return null;
	}
	
	public Node ancestor(Node root, Node a, Node b) {
		int depthOfA = depth(root, a, 0);
		int depthOfB = depth(root, b, 0);
		
		Node deeper = (depthOfA > depthOfB) ? a : b;
		Node shallower = (depthOfA > depthOfB) ? b : a;
		
		for(int i = 0; i < Math.abs(depthOfA - depthOfB); i++) {
			deeper = ancestor(root, deeper);
		}
		
		while((deeper = ancestor(root, deeper)) != null && 
			  (shallower = ancestor(root, shallower)) != null && deeper != shallower);
		
		return (deeper != null && shallower != null && deeper == shallower) ? deeper : null;
	}
	
	private int depth(Node root, Node node, int depth) {
		if(root == null || node == null)
			return -1;
					
		if(root == node)
			return depth;
		
		int d1 = depth(root.left, node, depth + 1);
		int d2 = depth(root.right, node, depth + 1);
		
		return Math.max(d1, d2);
	}
	
	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(5);
		root.right = new Node(15);
		
		root.left.left = new Node(3);
		root.left.right = new Node(2);

		root.right.left = new Node(12);
		root.right.right = new Node(20);
		
		root.left.right.right = new Node(1);
		root.left.right.left = new Node(0);
		
		root.left.left.left = new Node(6);
		root.left.left.right = new Node(7);
		
		root.left.right.left.right = new Node(33);
		root.left.right.left.left = new Node(44);
		
		CommonAncestorWithoutParentNode tree = new CommonAncestorWithoutParentNode();
		Node ancestor = tree.ancestor(root, root.left.left, root.left.right.right);
		if(ancestor != null)
			System.out.println(ancestor.data);
		else
			System.out.println("null");
	}
}