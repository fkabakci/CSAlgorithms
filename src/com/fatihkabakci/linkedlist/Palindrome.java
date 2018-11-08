package com.fatihkabakci.linkedlist;

/**
 * 
 * @author fkabakci
 * Given a linked list, and check if it is a palindrome.
 * 
 * 12321
 * 
 * true
 */
public class Palindrome {
	public static LinkedList reverse(Node n) {
		if(n == null) {
			return new LinkedList();
		}
		
		LinkedList l = reverse(n.next);	
		l.push(n.data);
		return l;
	}
	
	public static boolean isPalindrome(LinkedList l) {
		LinkedList r = reverse(l.head);
		
		Node l1 = l.head;
		Node r1 = r.head;
		while(l1 != null && r1 != null) {
			if(l1.data != r1.data)
				return false;
			l1 = l1.next;
			r1 = r1.next;
		}
		return true;
	}

	public static void main(String[] args) {
		LinkedList first = new LinkedList();
		first.push(1);
		first.push(2);
		first.push(3);
		first.push(2);
		first.push(1);
		System.out.println(isPalindrome(first));
	}
}