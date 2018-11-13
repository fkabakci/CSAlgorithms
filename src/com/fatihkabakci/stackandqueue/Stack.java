package com.fatihkabakci.stackandqueue;

/**
 * 
 * @author fkabakci
 *
 * LIFO - Last In First Out
 */
public class Stack<T> {
	
	Node<T> head;
	
	public void push(T data) {
		Node<T> newNode = new Node<T>(data);
		
		if(isEmpty()) {
			head = newNode;
		}else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	public T pop() {
		if(isEmpty())
			return null;
		
		T data = head.data;
		head = head.next;
		return data;
	}
	
	public T peek() {
		if(isEmpty())
			return null;
		
		return head.data;
	}
	
	public boolean isEmpty() {
		if(head == null)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);

		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}