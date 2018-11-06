package com.fatihkabakci.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author fkabakci
 * Given a linked list, remove duplicates from it.
 * 
 * Input: 1 2 3 4 5 5 2 1 2
 * 
 * Output: 1 2 3 4 5
 */
public class RemoveDuplicatesFromLinkedList {

	// single pointer
	public static LinkedList removeDuplicate(LinkedList l) {
		Node runner = l.head;
		Set<Integer> s = new HashSet<Integer>();
		s.add(runner.data);
		while (runner.next != null) {
			int data = runner.next.data;
			if (s.contains(data)) {
				runner.next = runner.next.next;
			} else {
				s.add(data);
				runner = runner.next;
			}
		}
		return l;
	}
	
	// two pointers
	public static LinkedList removeDuplicates(LinkedList l) {
		Node runner = l.head;
		Node prev = null;
		Set<Integer> s = new HashSet<Integer>();
		while (runner != null) {
			int data = runner.data;
			if (s.contains(data)) {
				prev.next = runner.next;
			} else {
				s.add(data);
				prev = runner;
			}
			runner = runner.next;
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
		head = removeDuplicate(head);
		head.print();
	}
}