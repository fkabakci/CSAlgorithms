package com.fatihkabakci.treesgraphs.tree;

/**
 * 
 * @author fkabakci
 * Given two nodes, find out the first common ancestor of them.
 * 
 * Solution: Assume that there is a parent node that is being kept.
 * Look up the depths of each node. Let them be at the same level by moving up the deeper node.
 * Use parent node to bubble up in the tree. Start comparing parent nodes. 
 * If there is a match, return it, Otherwise return null.
 */
public class CommonAncestor {

	private int depth(Node node) {
		Node r = node;
		
		int distance = 0;
		while(r.parent != null) {
			distance++;
			r = r.parent;
		}
		
		return distance;
	}
	public Node ancestor(Node a, Node b) {
		if(a == null || b == null)
			return null;
		
		int depthOfA = depth(a);
		int depthOfB = depth(b);
		
		Node deeper = (depthOfA > depthOfB) ? a : b;
		Node shallower = (depthOfA > depthOfB) ? b : a;
		
		for(int i = 0; i < Math.abs(depthOfA - depthOfB); i++)
			deeper = deeper.parent;
		
		while((deeper.parent != null && shallower.parent != null) && (deeper.parent != shallower.parent)) {
			deeper = deeper.parent;
			shallower = shallower.parent;
		}
		
		return ((deeper.parent != null && shallower.parent != null) && deeper.parent == shallower.parent) ? deeper.parent : null;
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
		
		CommonAncestor tree = new CommonAncestor();
		Node ancestor = tree.ancestor(root.left.right.right, root.left.right);
		if(ancestor != null)
			System.out.println(ancestor.data);
		else
			System.out.println("null");
	}
}
