package com.fatihkabakci.stackandqueue;
/**
 * 
 * @author fkabakci
 *
 * LIFO - Last In First Out
 */
public class StackArrayImpl {
	
	int[] arr;
	int capacity = 0;
	int length = 0;
	
	public StackArrayImpl() {
		this(10);
	}
	
	public StackArrayImpl(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
	}
	
	public void push(int data) {
		if(capacity <= length + 1) {
			int[] arr2 = new int[capacity];
			System.arraycopy(arr, 0, arr2, 0, length);
			arr = new int[capacity * 2];
			System.arraycopy(arr2, 0, arr, 0, length);
		}
		
		for(int i = length - 1; i >= 0; i--) {
			arr[i + 1] = arr[i];
		}
		arr[0] = data;
		length++;
	}
	
	public int pop() {
		if(isEmpty())
			return -1;
		
		int data = arr[0];
		for(int i = 0; i < length; i++) {
			arr[i] = arr[i + 1];
		}
		length--;
		return data;
	}
	
	public int peek() {
		if(isEmpty())
			return -1;
		
		return arr[0];
	}
	
	public boolean isEmpty() {
		if(length == 0)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		StackArrayImpl s = new StackArrayImpl();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(9);
		s.push(10);

		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}