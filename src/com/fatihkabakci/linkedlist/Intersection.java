package com.fatihkabakci.linkedlist;

/**
 * 
 * @author fkabakci
 * Given two linked list, return intersection node;
 * 
 */
public class Intersection {

	public static LinkedList insertect(LinkedList l1, LinkedList l2) {
		int s1 = l1.size();
		int s2 = l2.size();

		LinkedList shorter = (s1 < s2) ? l1 : l2;
		LinkedList longer = (s1 < s2) ? l2 : l1;

		Node shorterN = shorter.head;
		Node longerN = longer.head;
		for (int i = 0; i < Math.abs(s2 - s1); i++) {
			longerN = longerN.next;
		}

		while (shorterN != null && longerN != null) {
			if (shorterN == longerN) {
				return new LinkedList(shorterN);
			}
			shorterN = shorterN.next;
			longerN = longerN.next;
		}
		return null;
	}

	public static void main(String[] args) {
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		LinkedList first = new LinkedList();
		first.head = n1;
		first.head.next = n6;
		first.head.next.next = n3;
		first.head.next.next.next = n4;
		
		LinkedList second = new LinkedList();
		second.head = n2;
		second.head.next = n3;
		second.head.next.next = n4;
		
		LinkedList l = insertect(first, second);	
		l.print();
	}
}