package com.fatihkabakci.linkedlist;

/**
 * 
 * @author fkabakci
 * Given a forwarded linked list, add up digits and return as a new linked list.
 * 
 * 617 + 295
 * 
 * 912
 */
public class SumListsForwardDigits {
	
	public static LinkedList reverse(Node n) {
		if(n == null) {
			return new LinkedList();
		}
		
		LinkedList l = reverse(n.next);	
		l.push(n.data);
		return l;
	}
	
	public static LinkedList sum(LinkedList l1, LinkedList l2) {
		l1 = reverse(l1.head);
		l2 = reverse(l2.head);
		
		LinkedList l3 =  SumListsReverseDigits.sum(l1, l2);
		
		return reverse(l3.head);
		}


	public static void main(String[] args) {
		LinkedList first = new LinkedList();
		first.push(6);
		first.push(1);
		first.push(7);
		LinkedList second = new LinkedList();
		second.push(2);
		second.push(9);
		second.push(5);
		LinkedList result = sum(first, second);	
		result.print();
	}
}