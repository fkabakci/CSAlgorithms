package com.fatihkabakci.linkedlist;

/**
 * 
 * @author fkabakci
 * Given a linked list, gets last nth nodes
 * 
 * Input: 1 2 3 4 5, 2 
 * 
 * Output: 4 5
 */
public class ReturnLastNthNode {

	public static Node getLastNthNode(LinkedList l, int index) {
		Node p = l.head;
		Node q = l.head;
		
		for (int i = 0; i < index && p.next != null; i++) {
			p = p.next;
		}
		
		while(p != null) {
			p = p.next;
			q = q.next;
		}

		return q;
	}

	public static void main(String[] args) {
		LinkedList head = new LinkedList();
		head.push(1);
		head.push(2);
		head.push(3);
		head.push(4);
		head.push(5);
		head.print();
		Node n = getLastNthNode(head, 1);	
		LinkedList r = new LinkedList();
		r.head = n;
		r.print();
	}
}