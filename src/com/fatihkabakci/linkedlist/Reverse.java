package com.fatihkabakci.linkedlist;

public class Reverse {

	public static Node reverse(Node head) {
		Node prev = null;
		Node current = head;
		Node next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return head = prev;
	}
	
	public static void print(Node head) {
		Node runner = head;
		while(runner != null) {
			System.out.print(runner.data + " ");
			runner = runner.next;
		}
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		Node r = reverse(n1);
		print(r);
	}
}