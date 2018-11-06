package com.fatihkabakci.linkedlist;

/**
 * 
 * @author fkabakci
 * Given a linked list, remove duplicates from it.
 * 
 * Input: 1 2 3 4 5 5 2 1 2
 * 
 * Output: 1 2 3 4 5
 */
public class RemoveDuplicatesFromLinkedListOn2 {

	public static LinkedList removeDuplicates(LinkedList l) {
		Node current = l.head;
		while(current != null) {
			int data = current.data;
			Node runner = current;
			while (runner.next != null) {
				if(runner.next.data == data)
					runner.next = runner.next.next;
				else
					runner = runner.next;
			}
			current = current.next;
		}
		return l;
	}

	public static void main(String[] args) {
		LinkedList head = new LinkedList();
		head.push(1);
		head.push(2);
		head.push(2);
		head.push(3);
		head.push(4);
		head.push(4);
		head.push(5);
		head.push(1);
		head.push(2);
		head.push(3);
		head.push(6);
		head.print();
		head = removeDuplicates(head);
		head.print();
	}
}