package com.fatihkabakci.stackandqueue;

/**
 * 
 * @author fkabakci
 * 
 * Sort:
 * Pop each stack element. Always put smallest one as deeply as slot in the temp stack.
 * 
 * 
 * Insertion Sort:
 * Use additional stack. Sort the stack each time you attempt to insert data.
 * When insertion operation comes up, pop the data, then compare them. Put the smaller one back into the stack.
 * Remember always keep the greater value as a max reference.
 *
 */
public class StackSorting {
	Stack<Integer> stack;
	Stack<Integer> temp;
	
	public StackSorting() {
		stack = new Stack<Integer>();
		temp = new Stack<Integer>();
	}
	
	private void moveTo(Stack<Integer> s1, Stack<Integer> s2) {
		Integer data;
		while((data = s1.pop()) != null)
			s2.push(data);
	}
	
	public void push(int data) {
		stack.push(data);
	}
	
	public void sort() {
		while (!stack.isEmpty()) {
			int data = stack.pop();
			while (!temp.isEmpty() && temp.peek() > data) {
				stack.push(temp.pop());
			}
			temp.push(data);
		}
		moveTo(temp, stack);
	}

	public void push(int data, boolean sorted) {
		Integer max = data;
		Integer retr;
		while ((retr = stack.pop()) != null) {
			if (max > retr) {
				temp.push(retr);
			} else {
				temp.push(max);
				max = retr;
			}
		}
		temp.push(max);

		moveTo(temp, stack);
	}
	
	public int pop() {
		return stack.peek() == null ? -1 : stack.pop();
	}

	public static void main(String[] args) {
		StackSorting q = new StackSorting();
		q.push(3);
		q.push(2);
		q.push(1);
		q.push(0);
		q.push(7);
		q.push(6);
		q.push(5);
		q.push(8);
		q.push(4);
		
		q.sort();
		
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
	}
}