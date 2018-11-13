package com.fatihkabakci.stackandqueue;

/**
 * 
 * @author fkabakci
 *
 * Design a stack that you could find out minimum values
 * 
 * Note: push(), pop() and min() should be O(1)
 */
public class MinStack extends Stack<Integer> {
	
	// stack that just holds minimum ones
	Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(Integer data) {
		super.push(data);
		
		if(minStack.peek() == null)
			minStack.push(data);
		
		else if(minStack.peek() > data)
			minStack.push(data);
	}
	
	public Integer pop() {
		if(super.peek() != null && minStack.peek() != null) {
				if(minStack.peek() == super.peek())
					minStack.pop();
		}
		return super.pop();
	}
	
	public Integer peek() {
		return super.peek();
	}
	
	public boolean isEmpty() {
		return super.isEmpty();
	}
	
	public Integer getMin() {
		return minStack.peek();
	}
	
	public static void main(String[] args) {
		MinStack s = new MinStack();		
		
		System.out.println(s.getMin());
		s.push(1);
		System.out.println(s.getMin());
		s.push(2);
		System.out.println(s.getMin());
		s.push(0);
		System.out.println(s.getMin());
		s.push(-1);
		System.out.println(s.getMin());
		s.push(3);
		System.out.println(s.getMin());
		s.push(4);
		System.out.println(s.getMin());

		s.pop();
		System.out.println(s.getMin());
		s.pop();
		System.out.println(s.getMin());
		s.pop();
		System.out.println(s.getMin());
		s.pop();
		System.out.println(s.getMin());
		s.pop();
		System.out.println(s.getMin());
		s.pop();
		System.out.println(s.getMin());
	}
}