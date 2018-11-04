package com.fatihkabakci.string;
public class GenericArrayList<P> {

	private Object[] arr;
	private int capacity;
	private int length;
	
	public GenericArrayList() {
		this(5);
	}
	
	public GenericArrayList(int initialCapacity) {
		capacity = initialCapacity;
		arr = new Object[capacity];
		length = 0;
	}
	
	private void copy() {
		Object[] copyOfArr = new Object[capacity];
		for(int i = 0; i < capacity; i++) {
			copyOfArr[i] = arr[i];
		}
		capacity = capacity * 2;
		arr = new Object[capacity];
		for(int i = 0; i < copyOfArr.length; i++) {
			arr[i] = copyOfArr[i];
		}
	}
	
	public void add(P val) {
		if(length + 1> capacity) {		
			copy();
		}
		arr[length++] = val;
	}
	
	public void insert(int index, P val) {
		if(index < 0) {
			System.err.println("Please provide correct index values !");
			return;
		}
		
		if(length + 1 > capacity) {
			copy();
		}
		
		for(int i = arr.length - 2; i >= index; i--) {
			arr[i + 1] = arr[i];
		}
		arr[index] = val;
		length++;
		
		print();
	}
	
	public void set(int index, P val) {
		if(index < 0 || index > arr.length - 1) {
			return;
		}
		arr[index] = val;
		
		print();
	}
	
	public void remove(int index) {
		if(index < 0 || index > arr.length - 1) {
			return;
		}
		
		for(int i = index + 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}
		length--;
		
		print();
	}
	
	public void print() {
		for(int i = 0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		GenericArrayList<String> l = new GenericArrayList<String>();
		l.add("3");
		l.add("5");
		l.add("7");
		l.add("9");
		l.add("11");	
		l.print();
		l.remove(2);
		l.insert(1, "10");
		l.add("12");
		l.print();
		l.insert(6, "13");
		l.remove(0);
		l.remove(1);
		l.remove(1);

	}
}