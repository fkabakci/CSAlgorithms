package com.fatihkabakci.linkedlist;

/**
 * 
 * @author fkabakci
 * Given a linked list, and a value, all elements less than that given value come first while others come up after.
 * 
 */
public class Partition {

	public static LinkedList partition(LinkedList l, int pivot) {
		LinkedList left = new LinkedList();
		LinkedList right = new LinkedList();
		Node runner = l.head;
		while(runner != null) {
			if(runner.data < pivot)
				left.push(runner.data);
			else
				right.push(runner.data);
			runner = runner.next;
		}
		
		runner = left.head;
		while(runner.next != null) {
			runner = runner.next;
		}
		runner.next = right.head;
		
		return left;
	}

	public static void main(String[] args) {
		LinkedList head = new LinkedList();
		head.push(1);
		head.push(2);
		head.push(3);
		head.push(4);
		head.push(5);
		head.push(6);
		head.push(2);
		head.push(1);
		head.push(4);
		head.print();
		LinkedList l = partition(head, 4);	
		l.print();
	}
}