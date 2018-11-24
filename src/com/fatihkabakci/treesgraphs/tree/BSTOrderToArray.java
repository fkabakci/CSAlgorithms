package com.fatihkabakci.treesgraphs.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author fkabakci
 * Find out all possible ways to fill up an array in given a binary search tree.
 * Input:
 * 						10
 * 					 8		15
 * 
 * Output: {{10, 8, 15}, {10, 15, 8}}
 */
public class BSTOrderToArray {
	public List<LinkedList<Integer>> getAllSequences(Node root) {
		List<LinkedList<Integer>> all = new ArrayList<LinkedList<Integer>>();
		
		if(root == null) {
			all.add(new LinkedList<Integer>());
			return all;
		}
		
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(root.data);
		
		List<LinkedList<Integer>> left = getAllSequences(root.left);
		List<LinkedList<Integer>> right = getAllSequences(root.right);
		
		for(LinkedList<Integer> l : left) {
			for(LinkedList<Integer> r : right) {
				List<LinkedList<Integer>> subResult = new ArrayList<LinkedList<Integer>>();
				traverse(prefix, l, r, subResult);
				all.addAll(subResult);
			}
		}
		return all;
	}
	
	public void traverse(LinkedList<Integer> prefix, LinkedList<Integer> left, LinkedList<Integer> right, List<LinkedList<Integer>> result) {
		if(left.size() == 0 || right.size() == 0) {
			LinkedList<Integer> resultList = (LinkedList<Integer>) prefix.clone();
			resultList.addAll(left);
			resultList.addAll(right);
			result.add(resultList);
			return;
		}
		
		int leftData = left.removeFirst();
		prefix.addLast(leftData);
		traverse(prefix, left, right, result);
		prefix.removeLast();
		left.addFirst(leftData);
		
		int rightData = right.removeFirst();
		prefix.addLast(rightData);
		traverse(prefix, left, right, result);
		prefix.removeLast();
		right.addFirst(rightData);
		
	}
	
	public int[][] toArray(List<LinkedList<Integer>> ll) {
		int[][] arr = new int[ll.size()][];
		for(int i = 0; i < ll.size(); i++) {
			LinkedList<Integer> l = ll.get(i);
			arr[i] = new int[l.size()];
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = l.get(j);
			}
		}
		return arr;
	}
	
	public void print(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print("{");
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
				if(j < arr[i].length - 1)
					System.out.print(", ");
			}
			System.out.print("}");
			if(i < arr.length - 1)
				System.out.print(",");
		}
	}
	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(8);
		root.right = new Node(15);

	/*	root.right.left = new Node(13);
		root.right.right = new Node(16);
		
		root.left.left = new Node(6);
		root.left.right = new Node(9);*/
		
		BSTOrderToArray bst = new BSTOrderToArray();
		List<LinkedList<Integer>> resultList = bst.getAllSequences(root);
		int[][] arr = bst.toArray(resultList);
		bst.print(arr);
	}
}