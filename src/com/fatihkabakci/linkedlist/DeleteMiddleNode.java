package com.fatihkabakci.linkedlist;

/**
 * 
 * @author fkabakci
 * Given a linked list, remove middle node from it.
 * O(n) while fast node goes twice at a time, slow goes one by one. At the end, slow remains in the middle.
 * To edit the connection, use 3rd pointer that is prev. Because in the end, fast is already gone. You have just slow.
 * You cant go back to replace the chain. So, thats why you need prev.
 * 
 * Input: 1 2 3 4 5
 * 
 * Output: 1 2 4 5
 */
public class DeleteMiddleNode {
	public static LinkedList deleteMiddle(LinkedList l) {
		Node runner = l.head;
		
		if(runner == null)
			return null;
		
		if(runner.next == null)
			return null;
		
		Node fast = l.head;
		Node slow = l.head;
		Node prev = null;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		prev.next = slow.next;
		
		return l;
	}

	public static void main(String[] args) {
		LinkedList head = new LinkedList();
		head.push(1);
		head.push(2);
		head.push(3);
		head.push(4);
		head.push(5);
		head = deleteMiddle(head);
		head.print();
	}
}