package com.fatihkabakci.stackandqueue;

/**
 * 
 * @author fkabakci
 * 
 * Queue implementation uses Stack
 *
 */
public class QueueWithStack<T> {
	Stack<T> pusher;
	Stack<T> popper;
	
	public QueueWithStack() {
		pusher = new Stack<T>();
		popper = new Stack<T>();
	}
	
	public void add(T data) {
		pusher.push(data);
	}
	
	private void moveTo(Stack<T> s1, Stack<T> s2) {
		T data = null;
		while((data = s1.pop()) != null)
			s2.push(data);
	}
	
	public T remove() {
		moveTo(pusher, popper);
		T popped = popper.pop();
		moveTo(popper, pusher);
		return popped;
	}
	
	public T peek() {
		moveTo(pusher, popper);
		T result = popper.peek();
		moveTo(popper, pusher);
		return result;
	}
	
	public static void main(String[] args) {
		QueueWithStack<Integer> q = new QueueWithStack<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		System.out.println(q.remove());
		System.out.println(q.remove());
		q.add(6);
		q.add(7);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		
	}
}