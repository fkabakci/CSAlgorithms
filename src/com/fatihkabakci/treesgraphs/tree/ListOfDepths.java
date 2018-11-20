package com.fatihkabakci.treesgraphs.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author fkabakci
 * Save items at each level into a linked list and traverse them at the end.
 */
public class ListOfDepths {
	
	List<LinkedList<Integer>> level;
	
	public ListOfDepths() {
		level = new ArrayList<LinkedList<Integer>>();
	}
	
	private void traverseBT(Node root, int depth) {
		if(root == null)
			return;
		
		if(depth >= level.size())
			level.add(new LinkedList<Integer>());
		
		LinkedList<Integer> list = level.get(depth);
		list.add(root.data);
		
		traverseBT(root.left, depth + 1);
		traverseBT(root.right, depth + 1);
	}
	
	public void listOfDepths(Node root) {
		traverseBT(root, 0);
		
		for(int i = 0; i < level.size(); i++) {
			Iterator<Integer> it = level.get(i).iterator();
			System.out.format("Level %d: ", i);
			while(it.hasNext()) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(21);
		root.left.right = new Node(22);
		
		root.left.left.left = new Node(211);
		root.left.left.right = new Node(212);
		
		root.right.left = new Node(31);
		root.right.right = new Node(32);
		
		root.right.right.left = new Node(311);
		root.right.right.right = new Node(312);
		
		ListOfDepths bt = new ListOfDepths();
		bt.listOfDepths(root);
	}
}
