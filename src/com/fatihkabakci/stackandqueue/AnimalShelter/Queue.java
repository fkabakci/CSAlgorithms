package com.fatihkabakci.stackandqueue.AnimalShelter;

import com.fatihkabakci.stackandqueue.Node;

/**
 * 
 * @author fkabakci
 *
 * FIFO - First In First Out
 */
public class Queue<T> {
	Node<T> head;
	Node<T> tail;
	
	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		
		if(tail == null) {
			tail = newNode;
			head = tail;
		}else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void addLast(T data) {
		add(data);
	}
	
	public void addFirst(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.next = head;
		head = newNode;
	}
	
	public T getFirst() {
		return peek();
	}
	
	public T getLast() {
		return (tail == null) ? null : tail.data;
		
	}
	
	// fix this ! use doubly node - prev
	public T removeLast() {
		if(head == null)
			return null;
		
		if(head.next == null) {
			T last = head.data;
			head = head.next;
			return last;
		}
		
		Node<T> runner = head;
		while(runner.next.next != null)
			runner = runner.next;

		T last = runner.next.data;
		runner.next = null;
		tail = runner;
		return last;
	}
	
	public T remove() {
		if(head == null)
			return null;
		
		T data = head.data;
		head = head.next;
		return data;
	}
	
	public T peek() {
		return (head == null) ? null : head.data;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		System.out.println(q.removeLast());
		System.out.println(q.removeLast());
		System.out.println(q.removeLast());
		System.out.println(q.removeLast());
		System.out.println(q.removeLast());
		System.out.println(q.removeLast());
	}
}