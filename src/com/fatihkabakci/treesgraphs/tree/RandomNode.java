package com.fatihkabakci.treesgraphs.tree;

import java.util.Random;

/**
 * 
 * @author fkabakci
 * Get a random node uniformly from a binary tree. Each item's probability should be 1/n.
 * Solution:
 * Hold size information of each node.
 */

public class RandomNode {
	int data;
	int size = 0;
	RandomNode left;
	RandomNode right;
	
	public RandomNode(int data) {
		this.data = data;
		this.size = 1;
	}
	
	public RandomNode getRandomNode() {
		int leftSize = (left != null) ? left.size : 0;
		int index = new Random().nextInt(size);
		if(index == leftSize) {
			return this;
		}else if(index < leftSize) {
			return left.getRandomNode();
		}else {
			return right.getRandomNode();
		}
	}
	
	public RandomNode find(int data) {
		if(this.data == data) {
			return this;
		} else if(this.data < data) {
			return right.find(data);
		}else if(this.data >= data) {
			return left.find(data);
		}
		return null;
	}
	
	public void insert(int data) {
		if(this.data > data) {
			if(left == null) {
				left = new RandomNode(data);
			}else {
				left.insert(data);
			}
		}else {
			if(right == null) {
				right = new RandomNode(data);
			}else {
				right.insert(data);
			}
		}
		size++;
	}
	
	private RandomNode getMostLeftNode(RandomNode root) {
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	public RandomNode delete(int data) {
		if(this.data < data) {
			right.delete(data);
		}else if(this.data > data) {
			left.delete(data);
		}else {
			size--;
			if(left != null && right != null) { // two children
				int min = getMostLeftNode(right).data;
				this.data = min;
				right.delete(min);
				return right;
			}else if(left == null && right != null) { // one child
				return right;
			}else if(right == null && left != null) { // one child
				return left;
			}else { // no child
				return null;
			}
		}
		return this;
	}
	
	public void inorder(RandomNode root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		RandomNode bst = new RandomNode(10);
		
		bst.insert(8);
		bst.insert(15);
		bst.insert(13);
		bst.insert(16);
		bst.insert(6);
		bst.insert(9);
		bst.inorder(bst);
		System.out.println("\n"+ bst.getRandomNode().data);
		System.out.println(bst.size);
		bst = bst.delete(9);
		System.out.println(bst.size);
		bst.inorder(bst);
	}
}