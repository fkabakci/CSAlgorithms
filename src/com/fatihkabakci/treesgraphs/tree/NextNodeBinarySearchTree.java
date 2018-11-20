package com.fatihkabakci.treesgraphs.tree;

/**
 * 
 * @author fkabakci
 * Find out the next node of a given node in a binary search tree (In-order successor)
 * Solution: Next node in a binary search tree is the right-mostleft node !
 * If there is no right node, then look up the parent node until you find the next node which is a parent node.
 * while(bubble up) {
 * 		If the node is left of the parent (parent.left == node.parent). then next node is that node.
 * }
 * 
 */
public class NextNodeBinarySearchTree {

	public Node next(Node node) {
		 if(node.right != null)
			 return mostLeftNode(node.right);
		 else {
			  Node n = node;
			  while(n.parent != null && n.parent.left != n) {
				  n = n.parent;
			  }
			  return n.parent;
		 }
	}
	
	private Node mostLeftNode(Node node) {
		if(node == null)
			return null;
		
		while(node.left != null)
			node = node.left;
		
		return node;
	}
	
	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(5);
		root.left.parent = root;
		root.right = new Node(15);
		root.right.parent = root;

		root.right.left = new Node(12);
		root.right.left.parent = root.right;
		root.right.right = new Node(20);
		root.right.right.parent = root.right;

		NextNodeBinarySearchTree bts = new NextNodeBinarySearchTree();
		Node next = bts.next(root.right.left);
		if(next != null)
			System.out.println(next.data);
		else
			System.out.println("null");
	}
}