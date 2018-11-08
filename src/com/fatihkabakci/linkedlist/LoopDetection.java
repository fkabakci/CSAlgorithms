package com.fatihkabakci.linkedlist;

/**
 * 
 * @author fkabakci
 * Given a circular linked list, return beginning of the circular node;
 * 
 * Slow-Fast pointer solution works !
 * Fast goes twice while slow goes one by one. Determine where they collide (they will have to collide at somewhere !)
 * If they collide, get slow node the back to head. Leave the fast where it already is.
 * Now, move slow until matching has occured with fast.
 * Here we go, we found out the beginning of the circular node.
 * 
 */
public class LoopDetection {

	public static Node detectLoop(LinkedList l) {
		Node fast = l.head;
		Node slow = l.head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				break;
		}
		
		if(fast == null || fast.next == null)
			return null;
		
		slow = l.head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
	}

	public static void main(String[] args) {	
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		
		LinkedList l = new LinkedList();
		l.head = n1;
		l.head.next = n2;
		l.head.next.next = n3;
		l.head.next.next.next = n2;
		
		Node n = detectLoop(l);
		System.out.println(n.data);
	}
}