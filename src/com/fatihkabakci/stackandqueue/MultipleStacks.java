package com.fatihkabakci.stackandqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author fkabakci
 *
 * Multiple stacks - if stack exceeds the capacity, create a new one. If stack is at the bottom is popped, then upper stacks
 * have to be shifted to bottom. See popAt(index) method.
 */
public class MultipleStacks<T> {
	// how many items each stack can hold
	int capacity = 5;
	List<Stack<T>> listOfStacks = new ArrayList<Stack<T>>(3);
	
	
	public void push(T data) {
		for(int i = 0; i < listOfStacks.size(); i++) {
			if(listOfStacks.get(i).size() + 1 <= capacity) {
				listOfStacks.get(i).push(data);
				System.out.println(data + " is added into stack no: " + i);
				return;
			}
		}
		
		System.out.println("Stack is exceeded. New stack is being created.");
		Stack<T> newStack = new Stack<T>();
		newStack.push(data);
		listOfStacks.add(newStack);
		System.out.println(data + " is added into stack no: " + (listOfStacks.size() - 1));
		
	}
	
	public T pop() {
		for(int i = listOfStacks.size() - 1; i >= 0; i--) {
			if(listOfStacks.get(i).peek() != null) {
				System.out.println("data is popped from stack no: " + i);
				return listOfStacks.get(i).pop();
			}else
				listOfStacks.remove(i);
		}
		return null;
	}
	
	public T popAt(int index) {
		if(index > -1 && index < listOfStacks.size()) {
			T popped = listOfStacks.get(index).pop();
			System.out.println("POP:" + popped);
			List<List<T>> temp = new ArrayList<List<T>>();
			
			for(int i = index + 1; i < listOfStacks.size(); i++) {
				List<T> sub = new ArrayList<T>();
				while(listOfStacks.get(i).peek() != null)
					sub.add(listOfStacks.get(i).pop());
				temp.add(sub);
			}
			
			for(int i = 0; i < temp.size() ; i++) {
				for(int j = temp.get(i).size() - 1; j >= 0; j--) {
					push(temp.get(i).get(j));
				}
			}
			return popped;
		}
		return null;
	}
	
	public T peek() {
		for(int i = listOfStacks.size() - 1; i >= 0; i--) {
			if(listOfStacks.get(i).peek() != null) 
				return listOfStacks.get(i).peek();
		}
		return null;
	}
	
	public boolean isEmpty() {
		int i = listOfStacks.size() - 1;
		while(i >= 0) {
			if(!listOfStacks.get(i).isEmpty())
				return false;
			else
				i--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		MultipleStacks<Integer> s = new MultipleStacks<Integer>();
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
		
		s.push(11);
		s.push(12);
		s.push(13);
		s.push(14);
		s.push(15);
		
		s.popAt(0);
		s.popAt(1);
		s.popAt(0);
		s.popAt(0);
		s.popAt(0);
		s.popAt(0);
		s.popAt(0);
		s.popAt(0);
		s.popAt(0);
		s.popAt(0);
		s.popAt(0);
		s.popAt(0);
		s.popAt(0);
		s.popAt(0);
		s.popAt(0);
		s.popAt(0);
		s.popAt(0);
	}
}