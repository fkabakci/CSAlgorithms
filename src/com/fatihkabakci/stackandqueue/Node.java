package com.fatihkabakci.stackandqueue;

public class Node<T> {
	T data;
	Node<T> next;
	
	public Node(T data) {
		this.data = data;
	}
	
	public Node(Node<T> node) {
		this.data = node.data;
		this.next = node.next;
	}
}
