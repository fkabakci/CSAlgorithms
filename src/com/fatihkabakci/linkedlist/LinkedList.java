package com.fatihkabakci.linkedlist;

public class LinkedList {

	Node head;

	/**
	 * 
	 * @param data
	 * adds last in the linked list
	 */
	public void push(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}

		Node temp = head;
		while (temp.next != null)
			temp = temp.next;

		temp.next = new Node(data);
	}

	/**
	 * 
	 * @return
	 * deletes last one and return it
	 */
	public int pop() {
		if (head == null) {
			return -1;
		}

		Node temp = head;
		while (temp.next.next != null)
			temp = temp.next;

		temp.next = null;

		return temp.data;
	}

	/**
	 * 
	 * @return
	 * gets last one
	 */
	public int getLast() {
		if (head == null) {
			return -1;
		}

		Node temp = head;
		while (temp.next != null)
			temp = temp.next;

		return temp.data;
	}

	public int get(int index) {
		if (head == null) {
			return -1;
		}

		Node temp = head;
		for (int i = 0; i < index; i++)
			if (temp.next != null)
				temp = temp.next;

		return temp.data;
	}

	public int size() {
		if (head == null) {
			return 0;
		}

		int counter = 0;
		Node temp = head;
		while (temp != null) {
			counter++;
			temp = temp.next;
		}

		return counter;
	}

	public Node deleteByIndex(int index) {
		if (head == null)
			return null;

		else if (index < 0 && index > size())
			return null;

		else if (index == 0)
			return head = head.next;

		Node temp = head;
		for (int i = 0; i < index - 1; i++)
			temp = temp.next;
		
		temp.next = temp.next.next;
		return head;
	}
	
	public Node deleteByData(int data) {
		if (head == null)
			return null;
		
		else if(head.data == data)
			return head = head.next;

		Node temp = head;
		while(temp.next != null) {
			if(temp.next.data == data) {
				temp.next = temp.next.next;
				return head;
			}
			temp = temp.next;
		}
		
		
		return head;
	}

	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void print(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.push(1);
		l.push(2);
		l.push(3);
		l.push(4);
		l.push(5);
	//	l.pop();

		l.print();
		l.deleteByIndex(0);
		l.print();
		//l.push(2);
//		System.out.println(l.size());
	}
}
