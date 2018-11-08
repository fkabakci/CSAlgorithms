package com.fatihkabakci.linkedlist;

/**
 * 
 * @author fkabakci
 * Given a reversed linked list, add up digits and return as a new linked list.
 * 
 * 617 + 295
 * 
 * 912
 */
public class SumListsReverseDigits {

	public static LinkedList sum(LinkedList l1, LinkedList l2) {
		LinkedList r3 = new LinkedList();
		Node r1 = l1.head;
		Node r2 = l2.head;
		int sum = 0;
		boolean isRemainder = false;
		while(r1 != null || r2 != null) {
			int data1  = (r1 == null) ? 0 : r1.data;
			int data2 = (r2 == null) ? 0 : r2.data;
			
			if(isRemainder)
				sum = 1 + data1 + data2;
			else
				sum = r1.data + r2.data;
			
			isRemainder = (sum < 10) ? false : true;			
			r3.push(sum % 10);
			
			if(r1 != null)
				r1 = r1.next;
			if(r2 != null)
				r2 = r2.next;
		}
		
		return r3;
	}

	public static void main(String[] args) {
		LinkedList first = new LinkedList();
		first.push(7);
		first.push(1);
		first.push(6);
		LinkedList second = new LinkedList();
		second.push(5);
		second.push(9);
		second.push(2);
		LinkedList result = sum(first, second);	
		result.print();
	}
}