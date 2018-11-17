package com.fatihkabakci.stackandqueue;

/**
 * 
 * @author fkabakci
 *
 * FIFO - First In First Out
 */
public class Queue<T> {
	Node<T> head;
	Node<T> tail;
	
	public void enqueue(T data) {
		Node<T> newNode = new Node<T>(data);
		
		if(tail == null) {
			tail = newNode;
			head = tail;
		}else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public T dequeue() {
		if(head == null)
			return null;
		
		T data = head.data;
		head = head.next;
		return data;
	}
	
	public T peek() {
		if(head == null)
			return null;
		
		return head.data;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}